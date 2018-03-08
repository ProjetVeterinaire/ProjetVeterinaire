package src.fr.eni.ProjetVeterinaire.ihm.clients;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;

public class DataModelClient extends AbstractTableModel {
	private List<Animal> vListeClient;
	public DataModelClient(List<Animal> aListClient) {
		vListeClient= aListClient;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return vListeClient.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		//TODO
		Object vRet = null;
		switch(col){
			case 0 : 
				vRet=vListeClient.get(row).getvCodeAnimal();
				break;
			case 1 : 
				vRet=vListeClient.get(row).getvNomAnimal();
				break;
			case 2 : 
				vRet=vListeClient.get(row).getvSexe();
				break;
			case 3 : 
				vRet=vListeClient.get(row).getvCouleur();
				break;
			case 4 : 
				vRet=vListeClient.get(row).getvRace();
				break;
			case 5 : 
				vRet=vListeClient.get(row).getvEspece();
				break;
			case 6 : 
				vRet=vListeClient.get(row).getvTatouage();
				break;
				
		}
		return vRet;
	}

	
}
