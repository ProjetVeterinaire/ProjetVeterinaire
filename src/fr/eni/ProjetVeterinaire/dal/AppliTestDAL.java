package src.fr.eni.ProjetVeterinaire.dal;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;

import src.fr.eni.ProjetVeterinaire.bo.Personnel;



public class AppliTestDAL {

	public static void main(String[] args) throws ParseException, NoSuchAlgorithmException, UnsupportedEncodingException, DALException {

		ConnexionDAO vC = DAOFactory.getConnexionDAO();
		PersonnelDAO vP = DAOFactory.getPersonnelDAO();

			//Récupération d'une personne
			Personnel vPersonnel = vC.selectConnexion("0", "0");
			
			//Affichage
			System.out.println("----Affichage du Veterinaire exporté de la base : ----");
			System.out.println(vPersonnel.toString());

			ArrayList<Personnel> vListePersonnels = vP.selectAll();

			System.out.println(vListePersonnels);
		
	}

}
