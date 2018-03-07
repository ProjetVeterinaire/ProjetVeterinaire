package src.fr.eni.ProjetVeterinaire.dal;

import java.util.ArrayList;
import java.util.List;

import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Race;

public interface AnimauxDAO {
	
	public void Ajouter(Animal aAnimal) throws DALException;
	
	public List<Animal> SelectAll() throws DALException;
	
	public void Archiver(int CodeAnimal) throws DALException;
	
	public void Update(Animal animal) throws DALException;
	
	public ArrayList<Race> SelectRaces()throws DALException;
	
	public List<Animal> SelectByIdClient(int aIdClient) throws DALException;
	
	public Animal SelectById(int aIdAnimal) throws DALException;
}
