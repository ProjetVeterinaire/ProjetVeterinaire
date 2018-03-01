package src.fr.eni.ProjetVeterinaire.dal;

import src.fr.eni.ProjetVeterinaire.bo.Animal;

import java.util.ArrayList;

public class AnimauxDAO {
	
	public void Ajouter(Animal aAnimal) throws DALException;
	
	public ArrayList<Animal> SelectAll() throws DALException;
	
}
