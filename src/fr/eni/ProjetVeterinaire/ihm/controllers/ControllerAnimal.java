package src.fr.eni.ProjetVeterinaire.ihm.controllers;

import java.util.List;

import src.fr.eni.ProjetVeterinaire.bll.AnimauxManager;
import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bll.PersonnelManager;
import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Race;
import src.fr.eni.ProjetVeterinaire.dal.DALException;

public class ControllerAnimal {

	private static ControllerAnimal instance;
	private AnimauxManager vAnimauxManager;
	
	//constructeurs
	private ControllerAnimal() throws BLLException{
		vAnimauxManager = AnimauxManager.getInstance();
	}
	
	public static ControllerAnimal getInstance() throws BLLException{
		if ( ControllerAnimal.instance == null){
			ControllerAnimal.instance = new ControllerAnimal();
		}
		return ControllerAnimal.instance;
	}

	
	//methode de selection de tous les animaux
	public List<Animal> selectAll() throws BLLException, DALException{
		vAnimauxManager = AnimauxManager.getInstance();

		List<Animal> vAnimal = AnimauxManager.SelectAll();

		return vAnimal;
		
	}
	//methode de selection de toutes les races d'animaux
	public List<Race> selectRaces() throws BLLException, DALException{
		vAnimauxManager = AnimauxManager.getInstance();

		List<Race> vRaces = AnimauxManager.SelectRaces();

		return vRaces;
	}
	
	public void ajouter(Animal aAnimal) throws BLLException, DALException{
		vAnimauxManager = AnimauxManager.getInstance();
		vAnimauxManager.Ajouter(aAnimal);
		
	}
	public void archiver(int aCodeAnimal) throws DALException, BLLException{
		vAnimauxManager = AnimauxManager.getInstance();
		vAnimauxManager.Archiver(aCodeAnimal);
	}
	public void update(Animal aAnimal) throws BLLException, DALException{
		vAnimauxManager = AnimauxManager.getInstance();
		vAnimauxManager.Update(aAnimal);
		
	}
} 
