package src.fr.eni.ProjetVeterinaire.bll;

import src.fr.eni.ProjetVeterinaire.dal.*;
import src.fr.eni.ProjetVeterinaire.bo.*;

public class LoginManager {
	
	private static ConnexionDAO daoConnexion;
	
	private static LoginManager instance;
	
	//Retourne l'instance du manager
	public static LoginManager getInstance() throws BLLException {
        if (null == instance) { // Premier appel
                if (null == instance) {
                    instance = new LoginManager();
                }
        }
        return instance;
    }
	
	public LoginManager() throws BLLException{
		daoConnexion = DAOFactory.getConnexionDAO();
	}
	
	//Retourne la connexion	
	public Personnel selectConnexion(String aNom, String aMotDePasse) throws BLLException{
		Personnel personnel = null;
		try{
			personnel = daoConnexion.selectConnexion(aNom, aMotDePasse);
		}catch(DALException e){
			e.printStackTrace();
			throw new BLLException("Erreur de connexion");
		}
		return personnel;
	}
	

}
