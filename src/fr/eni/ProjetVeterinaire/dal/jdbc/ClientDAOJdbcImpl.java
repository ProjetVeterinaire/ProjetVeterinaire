package src.fr.eni.ProjetVeterinaire.dal.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.dal.ClientDAO;
import src.fr.eni.ProjetVeterinaire.dal.DALException;

/**
 * Author : Florian CHEVALIER (02/03/2018)
 * **/
public class ClientDAOJdbcImpl implements ClientDAO{
	
	//requete sql de selection de la connexion
	private static final String sqlSelectAll = "Select * from Clients";
	private static final String sqlInsert ="insert into Clients(NomClient,PrenomClient,Adresse1,Adresse2,CodePostal,Ville,NumTel,Assurance,Email,Remarque,Archive) values(?,?,?,?,?,?,?,?,?,?,0);";
	private static final String sqlArchiver="update Clients set Archive=1 where CodeClient=?";
	private static final String sqlUpdate="update Clients set NomClient=?,PrenomClient=?,Adresse1=?,Adresse2=?,CodePostal=?,Ville=?,NumTel=?,Assurance=?,Email=?,Remarque=?,Archive=? where CodeClient=?";
	
	public ArrayList<Client> SelectAll() throws DALException {
			Connection cnx = null;
			Statement rqt = null;
			ResultSet rs = null; 
			Client client = null; 
			ArrayList<Client> vListeClients = new ArrayList<Client>();
			try {
				cnx = JDBCTools.getConnection();
				rqt=cnx.createStatement();
				rs = rqt.executeQuery(sqlSelectAll);
			
				while(rs.next()){
					client = new Client(rs.getInt("CodeClient"),
							rs.getString("NomClient"),
							rs.getString("PrenomClient"),
							rs.getString("Adresse1"),
							rs.getString("Adresse2"),
							rs.getString("CodePostal"),
							rs.getString("Ville"),
							rs.getString("NumTel"),
							rs.getString("Assurance"),
							rs.getString("Email"),
							rs.getString("Remarque"),
							rs.getBoolean("Archive")
							);
					vListeClients.add(client);
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
			return vListeClients;
		}
	
	
	public void Ajouter(Client aClient) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs;
		
		
		try {
			cnx = JDBCTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsert);
			rqt.setString(1, aClient.getvNomClient());
			rqt.setString(2, aClient.getvPrenomClient());
			rqt.setString(3, aClient.getvAdresse1());
			rqt.setString(4, aClient.getvAdresse2());
			rqt.setString(5, aClient.getvCode_postal());
			rqt.setString(6, aClient.getvVille());
			rqt.setString(7, aClient.getvNumTel());
			rqt.setString(8, aClient.getvAssurance());
			rqt.setString(9, aClient.getvEmail());
			rqt.setString(10, aClient.getvRemarque());
			

			int nbRows = rqt.executeUpdate();
			if(nbRows == 1){
				rs = rqt.getGeneratedKeys();
				if(rs.next()){
					aClient.setvCodeClient(rs.getInt(1));
				}
		}
		}catch(SQLException e){
			throw new DALException("ajout failed - nom =" + aClient.getvCodeClient() , e);
			
		} 	
		
		
	}
	
	public void Archiver(int CodeClient) throws DALException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		try{
			cnx = JDBCTools.getConnection();
			rqt=cnx.prepareStatement(sqlArchiver);
			rqt.setInt(1, CodeClient);
			rqt.executeUpdate();
			}catch(SQLException e){
				throw new DALException("archivage failed - Client ="+  CodeClient , e);
			}
		}
		
	public void Update(Client aClient) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try{
		cnx=JDBCTools.getConnection();
		rqt=cnx.prepareStatement(sqlUpdate);
		rqt.setString(1, aClient.getvNomClient());
		rqt.setString(2, aClient.getvPrenomClient());
		rqt.setString(3, aClient.getvAdresse1());
		rqt.setString(4, aClient.getvAdresse2());
		rqt.setString(5, aClient.getvCode_postal());
		rqt.setString(6, aClient.getvVille());
		rqt.setString(7, aClient.getvNumTel());
		rqt.setString(8, aClient.getvAssurance());
		rqt.setString(9, aClient.getvEmail());
		rqt.setString(10, aClient.getvRemarque());
		rqt.setBoolean(11, aClient.isvArchive());
		rqt.setInt(12, aClient.getvCodeClient());
		rqt.executeUpdate();
		}catch(SQLException e){
			throw new DALException("Update Failed - Client" + aClient.getvCodeClient());
		}
	}
	 

}
