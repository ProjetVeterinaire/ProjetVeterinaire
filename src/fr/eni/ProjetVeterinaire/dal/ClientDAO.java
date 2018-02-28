package src.fr.eni.ProjetVeterinaire.dal;

import java.util.ArrayList;
import java.util.List;

import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;

public interface ClientDAO {


	//Selectionner tous les personnels
	
	
	/*String vNomClient, String vPrenomClient, String vAdresse1, String vAdresse2,
			String vCode_postal, String vVille, String vNumTel, String vAssurance, String vEmail, String vRemarque*/
	public int Ajouter(Client aClient)throws DALException;
	
	public ArrayList<Client> SelectAll() throws DALException;

}
