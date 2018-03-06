package src.fr.eni.ProjetVeterinaire.bll;
/*
 * Auteur : Ronan GODICHEAU-TORNIER 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

import java.util.ArrayList;
import java.util.List;

import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.DAOFactory;
import src.fr.eni.ProjetVeterinaire.dal.PersonnelDAO;

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
	public List<Personnel> selectAll() throws BLLException{
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
	
	
	
	//Retourne tous les personnels sans rendez vous et non archivés
	public ArrayList<Personnel> selectAllSansRDV() throws BLLException{
			ArrayList<Personnel> personnel = null;
			try{
				personnel = daoPersonnel.selectAllSansRdv();
			}catch(DALException e){
				e.printStackTrace();
				throw new BLLException("Probleme lors du select all sans rdvs du personnel");
			}
			return personnel;
		}
	
	
	
	/*Supprimer : Archivage de l’employé. Les données archivées ne sont plus visibles dans l’application. Attention, l’archivage d’un
	 *  vétérinaire n’est possible que si celui-ci n’est attaché à aucun rendez-vous à venir.*/
	public void archiver(String aNom) throws DALException{
		daoPersonnel.archiver(aNom);
	}
	
	
	/*Réinitialiser : Ouvre une boîte de dialogue qui permet de 
	 * réinitialiser le mot de passe de l’employé sélectionné.*/
	public void reinitialiser(String aNom,String aNouveauMotDePasse) throws DALException{
		daoPersonnel.reinitialiser(aNom, aNouveauMotDePasse);
	}


	//Retourne tous les veterinaires
	public ArrayList<Personnel> selectVeterinaires() throws BLLException{
		ArrayList<Personnel> personnel = null;
		try{
			personnel = daoPersonnel.selectVeterinaires();
		}catch(DALException e){
			e.printStackTrace();
			throw new BLLException("Probleme lors du select all des veterinaires		");
		}
		return personnel;
	}
}
