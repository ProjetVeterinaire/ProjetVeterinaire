package src.fr.eni.ProjetVeterinaire.ihm.ecranPersonnel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.fr.eni.ProjetVeterinaire.bo.Personnel;

public class DataModelPersonnel extends AbstractTableModel {
	private List<Personnel> vListePersonnel;
	public DataModelPersonnel(List<Personnel> aListPersonnel) {
		vListePersonnel= aListPersonnel;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return vListePersonnel.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		//TODO
		Object vRet = null;
		switch(col){
			case 0 : 
				vRet=vListePersonnel.get(row).getvNom();
				break;
			case 1 : 
				vRet=vListePersonnel.get(row).getvMotDePasse();
				break;
			case 2 : 
				vRet=vListePersonnel.get(row).getvRole();
				break;
		}
		return vRet;
	}

	
}
