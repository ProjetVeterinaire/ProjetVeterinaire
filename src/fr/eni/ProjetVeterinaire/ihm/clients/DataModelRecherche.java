package src.fr.eni.ProjetVeterinaire.ihm.clients;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;

public class DataModelRecherche extends AbstractTableModel {
	private List<Client> vListeClient;
	public DataModelRecherche(List<Client> aListClient) {
		vListeClient= aListClient;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
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
				vRet=vListeClient.get(row);
				break;
			case 1 : 
				vRet=vListeClient.get(row).getvPrenomClient();
				break;
			case 2 : 
				vRet=vListeClient.get(row).getvCode_postal();
				break;
			case 3 : 
				vRet=vListeClient.get(row).getvVille();
				break;
				
		}
		return vRet;
	}

	
}
