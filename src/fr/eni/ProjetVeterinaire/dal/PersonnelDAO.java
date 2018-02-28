package src.fr.eni.ProjetVeterinaire.dal;

import java.util.ArrayList;
import java.util.List;


import src.fr.eni.ProjetVeterinaire.bo.Personnel;

public interface PersonnelDAO {


	//Selectionner tous les personnels
	public  ArrayList<Personnel> selectAll() throws DALException;	
	
	public int reinitialiser(String aNom)throws DALException;
}
