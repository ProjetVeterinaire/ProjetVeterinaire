package src.fr.eni.ProjetVeterinaire.ihm.controllers;

import java.util.List;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bll.PersonnelManager;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.ihm.ecranPersonnel.EcranGestionPersonnel;

public class ControllerPersonnel {

	private static ControllerPersonnel instance;
	private PersonnelManager vPersonnelManager;
	private EcranGestionPersonnel fenetre;
	
	//constructeurs
	private ControllerPersonnel() throws BLLException{
		vPersonnelManager = PersonnelManager.getInstance();
	}
	
	public static ControllerPersonnel getInstance() throws BLLException{
		if ( ControllerPersonnel.instance == null){
			ControllerPersonnel.instance = new ControllerPersonnel();
		}
		return ControllerPersonnel.instance;
	}

	
	//methode de selection de tous les personnels
	public List<Personnel> selectAll() throws BLLException{
		vPersonnelManager = PersonnelManager.getInstance();

		List<Personnel> vPersonnel = vPersonnelManager.selectAll();

		return vPersonnel;
		
	}
	public void ajouter(String aNom, String aPrenom, String aMotPasse,String aRole) throws BLLException, DALException{
		vPersonnelManager = PersonnelManager.getInstance();
		vPersonnelManager.ajouter(aNom,aPrenom,aMotPasse,aRole);
		
	}
	public void archiver(String aNom) throws DALException, BLLException{
		vPersonnelManager = PersonnelManager.getInstance();
		vPersonnelManager.archiver(aNom);

	}
	public void reinitialiser(String aNom, String aMotPasse) throws BLLException, DALException{
		vPersonnelManager = PersonnelManager.getInstance();
		vPersonnelManager.reinitialiser(aNom,aMotPasse);
		
	}
} 
