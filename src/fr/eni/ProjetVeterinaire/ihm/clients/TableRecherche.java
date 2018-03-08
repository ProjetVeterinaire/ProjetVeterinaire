package src.fr.eni.ProjetVeterinaire.ihm.clients;

import java.util.List;

import javax.swing.JTable;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.jdbc.JDBCTools;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerAnimal;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerClient;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerPersonnel;

public class TableRecherche extends JTable {
	DataModelRecherche vDataModelRecherche;
	ControllerClient vControllerClient;
    List<Client> vListeClients ; 
	public TableRecherche() throws BLLException, DALException {
	// TODO Auto-generated constructor stub
		vControllerClient = ControllerClient.getInstance();
		vListeClients= vControllerClient.selectAll();
		JDBCTools.closeConnection();
		vDataModelRecherche = new DataModelRecherche(vListeClients);
		this.setModel(vDataModelRecherche);
	}

}
