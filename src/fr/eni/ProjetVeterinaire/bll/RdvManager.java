package src.fr.eni.ProjetVeterinaire.bll;

import java.util.List;

import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.bo.Race;
import src.fr.eni.ProjetVeterinaire.bo.Rdv;

/**
 * Author : Florian CHEVALIER (02/03/2018)
 * **/

import src.fr.eni.ProjetVeterinaire.dal.AnimauxDAO;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.DAOFactory;
import src.fr.eni.ProjetVeterinaire.dal.RendezVousDAO;

public class RdvManager {

	private static RendezVousDAO daoRdv;
	
	private static RdvManager instance;
	
	public static RdvManager getInstance() throws BLLException {
        if (null == instance) { // Premier appel
                if (null == instance) {
                    instance = new RdvManager();
                }
        }
        return instance;
    }
	
	public RdvManager() throws BLLException{
		daoRdv = DAOFactory.getRendezVousDAO();
	}


	
	public static List<Rdv> SelectAll() throws DALException{
		List<Rdv> rendezvous = null;
		try{
			rendezvous = daoRdv.SelectAll();
		}catch(DALException e){
			e.printStackTrace();
			throw new DALException("Probleme lors du select all des rdv");
		}
		
		return rendezvous;
	}

	public void Ajouter(Rdv aRdv)throws BLLException{
		try{
			daoRdv.Ajouter(aRdv);
		}catch(DALException e){
			throw new BLLException("Echec de l'ajout du Rdv ");
		}
	}
	
	public void Supprimer(Rdv aRdv)throws BLLException{
		try{
			daoRdv.Supprimer(aRdv);	
		}catch(DALException e){
			throw new BLLException("Echec de la suppression du Rdv ");		
		}
	}
}
