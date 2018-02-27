package src.fr.eni.ProjetVeterinaire.bll;

import src.fr.eni.ProjetVeterinaire.dal.*;
import src.fr.eni.ProjetVeterinaire.bo.*;

public class LoginManager {
	
	private static PersonnelDAO daoPersonnel;
	
	public LoginManager() throws BLLException{
		daoPersonnel = DAOFactory.getPersonnelDAO();
	}
		
	public Personnel selectConnexion(String aNom, String aMotDePasse) throws BLLException{
		Personnel personnel = null;
		try{
			personnel = daoPersonnel.selectConnexion(aNom, aMotDePasse);
		}catch(DALException e){
			e.printStackTrace();
			throw new BLLException("Erreur de connexion");
		}
		return personnel;
	}
	

}
