package src.fr.eni.ProjetVeterinaire.bll;

import java.util.ArrayList;

import src.fr.eni.ProjetVeterinaire.bo.*;
import src.fr.eni.ProjetVeterinaire.dal.*;


public class ClientsManager {
	
	private static ClientDAO daoClient;
	
	private static ClientsManager instance;
	
	public static ClientsManager getInstance() throws BLLException {
        if (null == instance) { // Premier appel
                if (null == instance) {
                    instance = new ClientsManager();
                }
        }
        return instance;
    }
	
	public ClientsManager() throws BLLException{
		daoClient = DAOFactory.getClientDAO();
	}
	
	public void Ajouter(Client aClient)throws BLLException{
		try{
			 daoClient.Ajouter(aClient);
		}catch(DALException e){
			throw new BLLException("Echec de l'ajout du client ");
		}
	}
	
	public ArrayList<Client> SelectAll() throws BLLException{
		ArrayList<Client> client = null;
		try{
			client = daoClient.SelectAll();
		}catch(DALException e){
			e.printStackTrace();
			throw new BLLException("Probleme lors du select all du clients");
		}
		
		return client;
	}
}
