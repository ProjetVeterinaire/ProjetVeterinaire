package src.fr.eni.ProjetVeterinaire.dal.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.bo.Rdv;
import src.fr.eni.ProjetVeterinaire.dal.ClientDAO;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.RendezVousDAO;

/**
 * Author : Ronan GODICHEAU-TORNIER(07/03/2018)
 * **/
public class RendezVousDAOJdbcImpl implements RendezVousDAO{
	
	//requete sql de selection de la connexion
	private static final String sqlSelectAll = "Select * from Agendas";
	private static final String sqlInsert ="insert into Agendas(CodeVeto,DateRdv,CodeAnimal) values(?, CAST(? AS smalldatetime)  ,?);";

	
	public ArrayList<Rdv> SelectAll() throws DALException {
			Connection cnx = null;
			Statement rqt = null;
			ResultSet rs = null; 
			Rdv rdv = null; 
			ArrayList<Rdv> vListeRdv = new ArrayList<Rdv>();
			try {
				cnx = JDBCTools.getConnection();
				rqt=cnx.createStatement();
				rs = rqt.executeQuery(sqlSelectAll);
			
				while(rs.next()){
					rdv = new Rdv(rs.getInt("CodeVeto"),
							rs.getDate("DateRdv"),
							rs.getInt("CodeAnimal")
							);
					vListeRdv.add(rdv);
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
			return vListeRdv;
		}
	public void Ajouter(Rdv aRdv)throws DALException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs;
		
		
		try {
			cnx = JDBCTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsert);
			rqt.setInt(1, aRdv.getvCodeVeterinaire());
			rqt.setString(2, (aRdv.getvDate()+":00"));
			rqt.setInt(3, aRdv.getvCodeAnimal());

			
			//2007-05-08 12:35:29
			int nbRows = rqt.executeUpdate();

		
		}catch(SQLException e){
			throw new DALException("ajout failed - veterinaire =" + aRdv.getvCodeVeterinaire() , e);
			
		} 	
	}
	
	
}

	 


