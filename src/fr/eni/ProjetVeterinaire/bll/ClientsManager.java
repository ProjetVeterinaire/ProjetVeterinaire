package src.fr.eni.ProjetVeterinaire.bll;

import java.util.List;

import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.dal.ClientDAO;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.DAOFactory;


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
	
	public List<Client> SelectAll() throws DALException{
		List<Client> client = null;
		try{
			client = daoClient.SelectAll();
		}catch(DALException e){
			e.printStackTrace();
			throw new DALException("Probleme lors du select all du clients");
		}
		
		return client;
	}
	
	public void Archiver(int CodeClient) throws DALException{
		daoClient.Archiver(CodeClient);
	}

	public void Update(Client aClient) throws DALException{
		daoClient.Update(aClient);
	}
}
