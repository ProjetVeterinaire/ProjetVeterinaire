package src.fr.eni.ProjetVeterinaire.dal.jdbc;
/*
 * Auteur : Ronan GODICHEAU-TORNIER 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.dal.ConnexionDAO;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.PersonnelDAO;

/**
 * Author : Ronan GODICHEAU (28/02/2018)
 * **/
public class PersonnelDAOJdbcImpl implements PersonnelDAO{
	
	//requete sql de selection de la connexion
	private static final String sqlSelectAll = "Select * from Personnels where Archive='0'";
	private static final String sqlReinitialiser ="update Personnels set MotPasse=? where Nom=?";
	private static final String sqlAjouter ="insert into Personnels (Nom, MotPasse, Role,Archive) values (?,?,?,0)";
	private static final String sqlArchiver ="update Personnels set Archive='1' where nom = ?";
	private static final String sqlSelectAllSansRdv = "Select * from Personnels where Archive=0 and CodePers not in(Select CodeVeto from Agendas a join Personnels p on a.CodeVeto=p.CodePers); ";
	private static final String sqlSelectVeterinaires = "Select * from Personnels where Role='Vet'";
	private static final String sqlSelectById = "Select * from Personnels where CodePers = ?; ";

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
	public int reinitialiser(String aNom, String aNouveauMotDePasse) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		int rs;
		Personnel personnel = null;
		
		try {
			cnx = JDBCTools.getConnection();
			rqt = cnx.prepareStatement(sqlReinitialiser);
			rqt.setString(1, aNouveauMotDePasse);
			rqt.setString(2, aNom);
			

			rs = rqt.executeUpdate();
			
		}catch(SQLException e){
			throw new DALException("reinitialisation failed - nom =" + aNom , e);
			
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
			
			rqt.executeUpdate();
					
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
	
	public void archiver(String aNom) throws DALException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		try{
		cnx = JDBCTools.getConnection();
		rqt=cnx.prepareStatement(sqlArchiver);
		rqt.setString(1, aNom);
		rqt.executeUpdate();
		}catch(SQLException e){
			throw new DALException("archivage failed - login ="+  aNom , e);
		}
	}
	public ArrayList<Personnel> selectAllSansRdv() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null; 
		Personnel personnel = null; 
		ArrayList<Personnel> vListePersonnels = new ArrayList<Personnel>();
		try {
			cnx = JDBCTools.getConnection();
			rqt=cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAllSansRdv);
		
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
	
	public ArrayList<Personnel> selectVeterinaires() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null; 
		Personnel personnel = null; 
		ArrayList<Personnel> vListePersonnels = new ArrayList<Personnel>();
		try {
			cnx = JDBCTools.getConnection();
			rqt=cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectVeterinaires);
		
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
	public Personnel selectById(int aIdPersonnel) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null; 
		Personnel vPersonnel = null;
		try {
			cnx = JDBCTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectById);
			rqt.setInt(1, aIdPersonnel);
			rs = rqt.executeQuery();

			if(rs.next()){
				vPersonnel = new Personnel(rs.getInt("CodePers"),
						rs.getString("Nom"),
						rs.getString("MotPasse"),
						rs.getString("Role"),
						rs.getBoolean("Archive")
						);					
				}
			}

		catch (SQLException e) {
			throw new DALException("selectById failed :" , e);
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
		return vPersonnel;
	}

}
