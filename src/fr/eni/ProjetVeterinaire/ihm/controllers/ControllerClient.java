package src.fr.eni.ProjetVeterinaire.ihm.controllers;

import java.util.List;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bll.ClientsManager;
import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.ihm.EcranClients;

public class ControllerClient {

	private static ControllerClient instance;
	private ClientsManager vClientsManager;
	private EcranClients fenetre;
	
	
	//constructeurs
	private ControllerClient() throws BLLException{
		vClientsManager = ClientsManager.getInstance();
	}
	
	public static ControllerClient getInstance() throws BLLException{
		if ( ControllerClient.instance == null){
			ControllerClient.instance = new ControllerClient();
		}
		return ControllerClient.instance;
	}
	
	//Methode de sélection de tout les clients
	public List<Client> selectAll() throws BLLException, DALException{
		vClientsManager = ClientsManager.getInstance();
		
		List<Client> vClient = vClientsManager.SelectAll();
		
		return vClient;
		
	}
	
	public void Ajouter(Client aClient) throws BLLException, DALException{
		vClientsManager = ClientsManager.getInstance();
		vClientsManager.Ajouter(aClient);
		
	}
	public void Archiver(int CodeClient) throws BLLException, DALException{
		vClientsManager = ClientsManager.getInstance();
		vClientsManager.Archiver(CodeClient);
		
	}
	public void Update(Client aClient) throws BLLException, DALException{
		vClientsManager = ClientsManager.getInstance();
		vClientsManager.Update(aClient);
		
	}
	
	
	
	
}
