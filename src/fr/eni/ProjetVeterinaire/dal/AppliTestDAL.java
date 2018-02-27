package src.fr.eni.ProjetVeterinaire.dal;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import src.fr.eni.ProjetVeterinaire.bo.Personnel;



public class AppliTestDAL {

	public static void main(String[] args) throws DALException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {

//		PersonnelDAO personnelDAO = DAOFactory.getPersonnelDAO();

//		ConnexionDAOJdbcImpl vC = new ConnexionDAOJdbcImpl();
//		PersonnelDAO vC = new ConnexionDAOJdbcImpl();
		PersonnelDAO vC = DAOFactory.getPersonnelDAO();

		Personnel vPersonnel = vC.selectConnexion("Marc", "motdepasse");

		System.out.println(vPersonnel.toString());
	}

}
