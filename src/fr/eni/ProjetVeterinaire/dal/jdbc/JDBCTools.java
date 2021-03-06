package src.fr.eni.ProjetVeterinaire.dal.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import src.fr.eni.ProjetVeterinaire.dal.Settings;

public class JDBCTools {
	private static String urldb;
	private static String userdb;
	private static String passworddb;

    private static Connection cnx;

    static {
        // Chargement du driver
        try {
            Class.forName(Settings.getProperty("driverDB"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        urldb = Settings.getProperty("urldb");
        userdb = Settings.getProperty("userdb");
        passworddb = Settings.getProperty("passworddb");

    }

    public static Connection getConnection() throws SQLException {

            cnx = DriverManager.getConnection(urldb, userdb, passworddb);

        return cnx;
    }

    public static void closeConnection(){
        if(cnx!=null){
            try {
                cnx.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            cnx=null;
        }
    }



}
