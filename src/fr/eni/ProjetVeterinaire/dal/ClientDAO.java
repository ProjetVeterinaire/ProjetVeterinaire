package src.fr.eni.ProjetVeterinaire.dal;

import java.util.List;

import src.fr.eni.ProjetVeterinaire.bo.Client;

public interface ClientDAO {


	//Selectionner tous les personnels
	
	
	/*String vNomClient, String vPrenomClient, String vAdresse1, String vAdresse2,
			String vCode_postal, String vVille, String vNumTel, String vAssurance, String vEmail, String vRemarque*/
	public void Ajouter(Client aClient)throws DALException;
	
	public List<Client> SelectAll() throws DALException;
	
	public void Archiver(int CodeClient) throws DALException;
	
	public void Update(Client aClient) throws DALException;

	public List<Client> SelectByNom(String NomClient) throws DALException;

	public Client SelectClientById(int CodeClient) throws DALException;
}
