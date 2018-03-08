package src.fr.eni.ProjetVeterinaire.ihm.reservations;

import java.util.List;

import javax.swing.JTable;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.bo.Rdv;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.jdbc.JDBCTools;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerPersonnel;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerRdv;
import src.fr.eni.ProjetVeterinaire.ihm.ecranPersonnel.DataModelPersonnel;

public class TableRdv extends JTable {
	DataModelRdv vDataModelRdv;
	ControllerRdv vControllerRdv;
    List<Rdv> vListeRdvs ; 
	public TableRdv() throws BLLException, DALException {
		JDBCTools.closeConnection();
		vControllerRdv = ControllerRdv.getInstance();
		vListeRdvs= vControllerRdv.selectAll();
		JDBCTools.closeConnection();
		vDataModelRdv = new DataModelRdv(vListeRdvs);
		this.setModel(vDataModelRdv);
	}

}
