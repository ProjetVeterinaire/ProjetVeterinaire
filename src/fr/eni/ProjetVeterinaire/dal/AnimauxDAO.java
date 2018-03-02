package src.fr.eni.ProjetVeterinaire.dal;

import java.util.List;

import src.fr.eni.ProjetVeterinaire.bo.Animal;

public interface AnimauxDAO {
	
	public void Ajouter(Animal aAnimal) throws DALException;
	
	public List<Animal> SelectAll() throws DALException;
	
	public void Archiver(int CodeAnimal) throws DALException;
	
	public void Update(Animal animal) throws DALException;
}
