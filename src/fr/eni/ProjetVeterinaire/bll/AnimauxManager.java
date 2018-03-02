package src.fr.eni.ProjetVeterinaire.bll;

/**
 * Author : Florian CHEVALIER (02/03/2018)
 * **/

import src.fr.eni.ProjetVeterinaire.dal.AnimauxDAO;
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
}
