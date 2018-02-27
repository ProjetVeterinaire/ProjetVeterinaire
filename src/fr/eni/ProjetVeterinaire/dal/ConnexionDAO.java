package src.fr.eni.ProjetVeterinaire.dal;

import java.util.List;


import src.fr.eni.ProjetVeterinaire.bo.Personnel;

public interface ConnexionDAO {


	//Selectionner un personnel par son nom et son mot de passe
	public  Personnel selectConnexion(String aNom, String aMotDePasse) throws DALException;
	


}
