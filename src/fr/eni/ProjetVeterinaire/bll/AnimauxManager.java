package src.fr.eni.ProjetVeterinaire.bll;

import java.util.List;

import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.bo.Race;

/**
 * Author : Florian CHEVALIER (02/03/2018)
 * **/

import src.fr.eni.ProjetVeterinaire.dal.AnimauxDAO;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.DAOFactory;

public class AnimauxManager {

	private static AnimauxDAO daoAnimaux;
	
	private static AnimauxManager instance;
	
	public static AnimauxManager getInstance() throws BLLException {
        if (null == instance) { // Premier appel
                if (null == instance) {
                    instance = new AnimauxManager();
                }
        }
        return instance;
    }
	
	public AnimauxManager() throws BLLException{
		daoAnimaux = DAOFactory.getAnimauxDAO();
	}
	public void Archiver(int CodeAnimal) throws DALException{
		daoAnimaux.Archiver(CodeAnimal);
	}
	public void Update(Animal aAnimal) throws DALException{
		daoAnimaux.Update(aAnimal);
	}
	
	public static List<Animal> SelectAll() throws DALException{
		List<Animal> animal = null;
		try{
			animal = daoAnimaux.SelectAll();
		}catch(DALException e){
			e.printStackTrace();
			throw new DALException("Probleme lors du select all d'animaux");
		}
		
		return animal;
	}
	public static List<Race> SelectRaces() throws DALException{
		List<Race> races = null;
		try{
			races = daoAnimaux.SelectRaces();
		}catch(DALException e){
			e.printStackTrace();
			throw new DALException("Probleme lors du select des races d'animaux");
		}
		
		return races;
	}
	public void Ajouter(Animal aAnimal)throws BLLException{
		try{
			 daoAnimaux.Ajouter(aAnimal);
		}catch(DALException e){
			throw new BLLException("Echec de l'ajout de l'animal ");
		}
	}
	public static List<Animal> SelectByIdClient(int aIdClient) throws DALException{
		List<Animal> animal = null;
		try{
			animal = daoAnimaux.SelectByIdClient(aIdClient);
		}catch(DALException e){
			e.printStackTrace();
			throw new DALException("Probleme lors du select par Id Client d'animaux");
		}
		
		return animal;
	}
}
