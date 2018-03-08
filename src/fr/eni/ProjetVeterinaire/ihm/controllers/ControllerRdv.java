package src.fr.eni.ProjetVeterinaire.ihm.controllers;

import java.util.List;

import src.fr.eni.ProjetVeterinaire.bll.AnimauxManager;
import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bll.PersonnelManager;
import src.fr.eni.ProjetVeterinaire.bll.RdvManager;
import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Race;
import src.fr.eni.ProjetVeterinaire.bo.Rdv;
import src.fr.eni.ProjetVeterinaire.dal.DALException;

public class ControllerRdv {

	private static ControllerRdv instance;
	private RdvManager vRdvManager;
	
	//constructeurs
	private ControllerRdv() throws BLLException{
		vRdvManager = RdvManager.getInstance();
	}
	
	public static ControllerRdv getInstance() throws BLLException{
		if ( ControllerRdv.instance == null){
			ControllerRdv.instance = new ControllerRdv();
		}
		return ControllerRdv.instance;
	}

	
	//methode de selection de tous les rdv
	public List<Rdv> selectAll() throws BLLException, DALException{
		vRdvManager = RdvManager.getInstance();
		List<Rdv> vRdv = RdvManager.SelectAll();

		return vRdv;
		
	}
	
	//Ajouter un rdv
	public void ajouter(Rdv aRdv) throws BLLException, DALException{
		vRdvManager = RdvManager.getInstance();
		vRdvManager.Ajouter(aRdv);
		
	}

	public void Supprimer(Rdv aRdv) throws BLLException, DALException{
		vRdvManager = RdvManager.getInstance();
		vRdvManager.Supprimer(aRdv);
	}

} 
