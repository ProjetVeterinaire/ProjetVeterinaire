package src.fr.eni.ProjetVeterinaire.dal;

import java.util.ArrayList;
import java.util.List;


import src.fr.eni.ProjetVeterinaire.bo.Personnel;

public interface PersonnelDAO {


	//Selectionner tous les personnels
	public  ArrayList<Personnel> selectAll() throws DALException;	
		
	public int ajouter(Personnel personnel) throws DALException;
	
	public void archiver(String aNom) throws DALException;
	
	public  ArrayList<Personnel> selectAllSansRdv() throws DALException;	

	public int reinitialiser(String aNom, String aNouveauMotDePasse) throws DALException; 

	public ArrayList<Personnel> selectVeterinaires() throws DALException;

}
