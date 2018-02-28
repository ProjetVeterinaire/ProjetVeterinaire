package src.fr.eni.ProjetVeterinaire.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.dal.ConnexionDAO;
import src.fr.eni.ProjetVeterinaire.dal.DALException;

/**
 * Author : Ronan GODICHEAU (26/02/2018)
 * **/
public class ConnexionDAOJdbcImpl implements ConnexionDAO{
	
	//requete sql de selection de la connexion
	private static final String sqlSelectConnexion = "Select * from Personnels where MotPasse=? and Nom=?";

	
	public Personnel selectConnexion(String aNom,String aMotPasse) throws DALException {
			Connection cnx = null;
			PreparedStatement rqt = null;
			ResultSet rs = null;
			Personnel personnel = null; 
			try {
				cnx = JDBCTools.getConnection();
				rqt = cnx.prepareStatement(sqlSelectConnexion);
				rqt.setString(1, aMotPasse);
				rqt.setString(2, aNom);

				rs = rqt.executeQuery();
				if (rs.next()){
					personnel = new Personnel(rs.getInt("CodePers"),
							rs.getString("Nom"),
							rs.getString("MotPasse"),
							rs.getString("Role"),
							rs.getBoolean("Archive")
							);
					
					}
				}
	
			catch (SQLException e) {
				throw new DALException("selectById failed - login = " + aNom , e);
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
			return personnel;
		}
}
