package src.fr.eni.ProjetVeterinaire.dal.jdbc;

/**
 * Author : Florian CHEVALIER (02/03/2018)
 * **/

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.fr.eni.ProjetVeterinaire.bo.*;
import src.fr.eni.ProjetVeterinaire.dal.*;

public class AnimauxDAOJdbcImpl implements AnimauxDAO{
	private static final String sqlSelectAll = "select * from Animaux";
	private static final String sqlAjouter ="insert into Animaux(NomAnimal,Sexe,Couleur,Race,Espece,CodeClient,Tatouage,Antecedents,Archive) values(?,?,?,?,?,?,?,?,0);";
	private static final String sqlArchiver="update Animaux set Archive=1 where CodeAnimal=?";
	private static final String sqlUpdate ="update Animaux set NomAnimal=?,Sexe=?,Couleur=?,Race=?,Espece=?,CodeClient=?,Tatouage=?,Antecedents=?,Archive=? where CodeAnimal=?";
	
	public ArrayList<Animal> SelectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null; 
		Animal animal = null; 
		ArrayList<Animal> vListeAnimaux = new ArrayList<Animal>();
		try {
			cnx = JDBCTools.getConnection();
			rqt=cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAll);
		
			while(rs.next()){
				animal = new Animal(rs.getInt("CodeAnimal"),
						rs.getString("NomAnimal"),
						rs.getString("Sexe"),
						rs.getString("Couleur"),
						rs.getString("Race"),
						rs.getString("Espece"),
						rs.getInt("CodeClient"),
						rs.getString("Tatoutage"),
						rs.getString("Antecedents"),
						rs.getBoolean("Archive")
						);
				vListeAnimaux.add(animal);
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
		return vListeAnimaux;
	}


	
	public void Ajouter(Animal aAnimal) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs;
		Personnel personnel = null;
		
		try {
			cnx = JDBCTools.getConnection();
			rqt = cnx.prepareStatement(sqlAjouter);
			rqt.setString(1, aAnimal.getvNomAnimal());
			rqt.setString(2, aAnimal.getvSexe());
			rqt.setString(3, aAnimal.getvCouleur());
			rqt.setString(4, aAnimal.getvRace());
			rqt.setString(5, aAnimal.getvEspece());
			rqt.setInt(6, aAnimal.getvCodeClient());
			rqt.setString(7, aAnimal.getvTatouage());
			rqt.setString(8, aAnimal.getvAntecedents());
			
			
			

			int nbRows = rqt.executeUpdate();
			if(nbRows == 1){
				rs = rqt.getGeneratedKeys();
				if(rs.next()){
					aAnimal.setvCodeAnimal(rs.getInt(1));
				}
		}
		}catch(SQLException e){
			throw new DALException("ajout failed - animal =" + aAnimal.getvCodeClient() , e);
			
		} 	
		
		
	}
	
	public void Archiver(int CodeAnimal) throws DALException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		try{
			cnx = JDBCTools.getConnection();
			rqt=cnx.prepareStatement(sqlArchiver);
			rqt.setInt(1, CodeAnimal);
			rqt.executeUpdate();
			}catch(SQLException e){
				throw new DALException("archivage failed - Client ="+  CodeAnimal , e);
			}
		}


	public void Update(Animal aAnimal) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try{
		cnx=JDBCTools.getConnection();
		rqt=cnx.prepareStatement(sqlUpdate);
		rqt.setString(1, aAnimal.getvNomAnimal());
		rqt.setString(2, aAnimal.getvSexe());
		rqt.setString(3, aAnimal.getvCouleur());
		rqt.setString(4, aAnimal.getvRace());
		rqt.setString(5, aAnimal.getvEspece());
		rqt.setInt(6, aAnimal.getvCodeClient());
		rqt.setString(7, aAnimal.getvTatouage());
		rqt.setString(8, aAnimal.getvAntecedents());
		rqt.setBoolean(9, aAnimal.isvArchive());
		rqt.setInt(10, aAnimal.getvCodeAnimal());
		rqt.executeUpdate();
		}catch(SQLException e){
			throw new DALException("Update Failed - Animal" + aAnimal.getvCodeAnimal());
		}
	}
	
	
	
	}




	
		
		
		
	

