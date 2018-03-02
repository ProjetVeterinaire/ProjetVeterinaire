package src.fr.eni.ProjetVeterinaire.ihm.ecranPersonnel;

import java.util.List;

import javax.swing.JTable;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerPersonnel;

public class TablePersonnel extends JTable {
	DataModelPersonnel vDataModelPersonnel;
	ControllerPersonnel vControllerPersonnel;
    List<Personnel> vListePersonnels ; 
	public TablePersonnel() throws BLLException {
	// TODO Auto-generated constructor stub
		vControllerPersonnel = ControllerPersonnel.getInstance();
		vListePersonnels= vControllerPersonnel.selectAll();
		vDataModelPersonnel = new DataModelPersonnel(vListePersonnels);
		this.setModel(vDataModelPersonnel);
	}

}
