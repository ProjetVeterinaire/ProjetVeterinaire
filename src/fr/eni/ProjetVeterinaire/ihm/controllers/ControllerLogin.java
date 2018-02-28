package src.fr.eni.ProjetVeterinaire.ihm.controllers;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bll.LoginManager;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.ihm.EcranLogin;

public class ControllerLogin {

	private static ControllerLogin instance;
	private LoginManager personnel;
	private EcranLogin fenetre;
	
	//constructeurs
	private ControllerLogin() throws BLLException{
		personnel = LoginManager.getInstance();
	}
	
	public static ControllerLogin getInstance() throws BLLException{
		if ( ControllerLogin.instance == null){
			ControllerLogin.instance = new ControllerLogin();
		}
		return ControllerLogin.instance;
	}
	
	
	//methode de lancement de l'application
	public void startApp() throws BLLException{
		fenetre = new EcranLogin();
		fenetre.setVisible(true);
	}
	
	//methode de selection de la connexion
	public Personnel selectConnexion(String aNom, String aPassword) throws BLLException{
		
		LoginManager vLoginManager = new LoginManager(); 

		Personnel vPersonnel = vLoginManager.selectConnexion("0", "0");

		return vPersonnel;
	}
} 
