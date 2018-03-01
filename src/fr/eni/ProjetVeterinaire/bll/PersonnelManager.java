package src.fr.eni.ProjetVeterinaire.bll;

import src.fr.eni.ProjetVeterinaire.dal.*;

import java.util.ArrayList;

import src.fr.eni.ProjetVeterinaire.bo.*;

public class PersonnelManager {
	
	private static PersonnelDAO daoPersonnel;
	
	private static PersonnelManager instance;
	
	//Retourne l'instance du manager
	public static PersonnelManager getInstance() throws BLLException {
        if (null == instance) { // Premier appel
                if (null == instance) {
                    instance = new PersonnelManager();
                }
        }
        return instance;
    }
	
	public PersonnelManager() throws BLLException{
		daoPersonnel = DAOFactory.getPersonnelDAO();
	}
	
	//Retourne tous les personnels
	public ArrayList<Personnel> selectAll() throws BLLException{
		ArrayList<Personnel> personnel = null;
		try{
			personnel = daoPersonnel.selectAll();
		}catch(DALException e){
			e.printStackTrace();
			throw new BLLException("Probleme lors du select all du personnel");
		}
		return personnel;
	}
	
	/*Ajouter : Ouvre une boîte de dialogue qui permet de renseigner le nom,
a	prénom et profil de l’employé et lui affecter un mot de passe.*/
	public void ajouter(String aNom, String aPrenom, String aMotPasse,String aRole) throws DALException{
		String vNomPrenom = aNom +" "+ aPrenom;
		Personnel vPersonnelAAjouter = new Personnel(0,vNomPrenom,aMotPasse,aRole, false);
		daoPersonnel.ajouter(vPersonnelAAjouter);
	}

}