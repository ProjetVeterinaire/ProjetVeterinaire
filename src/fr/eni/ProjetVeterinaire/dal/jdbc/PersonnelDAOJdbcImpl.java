package src.fr.eni.ProjetVeterinaire.dal.jdbc;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.dal.ConnexionDAO;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.PersonnelDAO;

/**
 * Author : Ronan GODICHEAU (28/02/2018)
 * **/
public class PersonnelDAOJdbcImpl implements PersonnelDAO{
	
	//requete sql de selection de la connexion
	private static final String sqlSelectAll = "Select * from Personnels";
	private static final String sqlReinitialiser ="update Personnels set MotPasse=('abc123456') where Nom=?";
	private static final String sqlAjouter ="insert into Personnels (Nom, MotPasse, Role) values (?,?,?)";
	
	public ArrayList<Personnel> selectAll() throws DALException {
			Connection cnx = null;
			Statement rqt = null;
			ResultSet rs = null; 
			Personnel personnel = null; 
			ArrayList<Personnel> vListePersonnels = new ArrayList<Personnel>();
			try {
				cnx = JDBCTools.getConnection();
				rqt=cnx.createStatement();
				rs = rqt.executeQuery(sqlSelectAll);
			
				while(rs.next()){
					personnel = new Personnel(rs.getInt("CodePers"),
							rs.getString("Nom"),
							rs.getString("MotPasse"),
							rs.getString("Role"),
							rs.getBoolean("Archive")
							);
					vListePersonnels.add(personnel);
					}
				}
	
			catch (SQLException e) {
				throw new DALException("selectAll failed :" , e);
			} finally {
				try {
					if (rs != null){
						rs.close();
					}
					if (rqt != null){
						rqt.close();
					}
					if(cnx!=null){
						cnx.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	
			}
			return vListePersonnels;
		}
	public int reinitialiser(String aNom) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		int rs;
		Personnel personnel = null;
		
		try {
			cnx = JDBCTools.getConnection();
			rqt = cnx.prepareStatement(sqlReinitialiser);
			rqt.setString(1, aNom);
			

			rs = rqt.executeUpdate();
			
		}catch(SQLException e){
			throw new DALException("reinitialisation failed - login =" + aNom , e);
			
		} 	
		return  rs;
		
	}
	
	public int ajouter(Personnel personnel) throws DALException{
		Connection cnx = null;
		PreparedStatement rqt = null;
	
		try {
			cnx = JDBCTools.getConnection();
			rqt=cnx.prepareStatement(sqlAjouter);
			rqt.setString(1, personnel.getvNom());
			rqt.setString(2, personnel.getvMotDePasse());
			rqt.setString(3, personnel.getvRole());
			
			int nbRows = rqt.executeUpdate();
					if(nbRows == 1){
						ResultSet rs = rqt.getGeneratedKeys();
						if(rs.next()){
							personnel.setvCodePers(rs.getInt(1));
						}

					}
			return personnel.getvCodePers();
			
		}catch(SQLException e){
			throw new DALException("Insert personnel failed - " + personnel, e);
			
		}
		finally {
			try {
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed - ", e);
			}

		}
	}

}
