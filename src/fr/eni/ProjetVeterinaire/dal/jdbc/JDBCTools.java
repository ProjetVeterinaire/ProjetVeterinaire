package src.fr.eni.ProjetVeterinaire.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import src.fr.eni.ProjetVeterinaire.dal.Settings;


public class JDBCTools {

	
	private static  String urldb;
	private static String userdb;
	private static String passworddb;
	
	static {
		
		try {
			Class.forName(Settings.getProperty("driverDB"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		passworddb = Settings.getProperty("passworddb");
		System.out.println("urldb="+urldb+";userdb="+userdb+";passworddb="+passworddb);
	}
	
	
	
	public static Connection getConnection() throws SQLException{
		//Connection connection = DriverManager.getConnection(urldb);
		Connection connection = DriverManager.getConnection(urldb, userdb, passworddb);
		
		return connection;
	}
	


}


