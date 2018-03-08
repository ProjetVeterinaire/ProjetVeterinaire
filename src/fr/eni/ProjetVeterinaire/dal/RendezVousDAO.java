package src.fr.eni.ProjetVeterinaire.dal;

import java.util.List;

import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.bo.Rdv;

public interface RendezVousDAO {


	
	public void Ajouter(Rdv aRdv)throws DALException;
	
	public List<Rdv> SelectAll() throws DALException;
	
	public void Supprimer(Rdv aRdv) throws DALException;

}
