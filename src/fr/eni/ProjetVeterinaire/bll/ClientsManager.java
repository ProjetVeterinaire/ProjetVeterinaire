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
	
	public int Ajouter(Client aClient)throws BLLException{
		int code;
		try{
			 code = daoClient.Ajouter(aClient);
		}catch(DALException e){
			throw new BLLException("Echec de l'ajout du client ");
		}
		return code;
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
	
	public List<Client> SelectByNom(String NomClient) throws DALException{
		List<Client> clientByNom =null;
		try{
			clientByNom =daoClient.SelectByNom(NomClient);
		}catch(DALException e){
			e.printStackTrace();
			throw new DALException("Probleme lors de la recherche par nom du client");
		}
		
		return clientByNom;
		
	}
	
	public Client SelectClientById(int CodeClient) throws DALException{
		Client clientById =null;
		try{
			clientById =daoClient.SelectClientById(CodeClient);
		}catch(DALException e){
			e.printStackTrace();
			throw new DALException("");
		}
		
		return clientById;
		
	}
	
	
}
