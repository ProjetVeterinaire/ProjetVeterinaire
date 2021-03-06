package src.fr.eni.ProjetVeterinaire.bll;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.dal.DAOFactory;
import src.fr.eni.ProjetVeterinaire.dal.ConnexionDAO;

//Test de la couche BLL
public class AppliTestBLL {

	public static void main(String[] args) throws BLLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
		
		LoginManager vLoginManager = new LoginManager(); 

		Personnel vPersonnel = vLoginManager.selectConnexion("0", "0");

		System.out.println(vPersonnel.toString());
		
	}

}
