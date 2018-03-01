package src.fr.eni.ProjetVeterinaire.bll;

import fr.eni.ResaConcert.bll.BLLException;
import fr.eni.ResaConcert.bll.ClientManager;

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
