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

public class TableClients extends JTable {
	DataModelClient vDataModelClient;
	ControllerAnimal vControllerAnimal;
    List<Animal> vListeAnimaux ; 
	public TableClients() throws BLLException, DALException {
	// TODO Auto-generated constructor stub
		vControllerAnimal = ControllerAnimal.getInstance();
		vListeAnimaux= vControllerAnimal.selectAll();
		JDBCTools.closeConnection();
		vDataModelClient = new DataModelClient(vListeAnimaux);
		this.setModel(vDataModelClient);
	}

}
