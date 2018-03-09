package src.fr.eni.ProjetVeterinaire.ihm.reservations;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.fr.eni.ProjetVeterinaire.bll.AnimauxManager;
import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.bo.Rdv;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.jdbc.JDBCTools;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerAnimal;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerPersonnel;

public class DataModelRdv extends AbstractTableModel {
	private List<Rdv> vListeRdv;
	public DataModelRdv(List<Rdv> aListRdv) {
		vListeRdv= aListRdv;
	}
	@Override
	public int getColumnCount() {
		return 4;
	}

	
	@Override
	public int getRowCount() {
		return vListeRdv.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		

		Object vRet = null;
		Animal vAnimal = null;
		Personnel vPersonnel = null;
		try {
			JDBCTools.closeConnection();
			ControllerAnimal vControllerAnimal =ControllerAnimal.getInstance();
			vAnimal = vControllerAnimal.selectId(vListeRdv.get(row).getvCodeAnimal());
			JDBCTools.closeConnection();
			ControllerPersonnel vControllerPersonnel = ControllerPersonnel.getInstance();
			vPersonnel = vControllerPersonnel.selectById(vListeRdv.get(row).getvCodeVeterinaire());
			JDBCTools.closeConnection();

		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(col){
			case 0 : 
				vRet =vListeRdv.get(row);
				break;
			case 1: 
				vRet= vPersonnel.getvNom();
				break;
			case 2: 
				vRet= vAnimal.getvNomAnimal();
				break;
			case 3 : 
				vRet= vAnimal.getvRace();
				break;
		}
		return vRet;
	}

	
}
