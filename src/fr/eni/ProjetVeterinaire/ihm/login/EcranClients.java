/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.login;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class EcranClients {

	public EcranClients(){
		
		JFrame Clients = new JFrame();
		
		//Définit un titre pour la fenetre
		Clients.setTitle("Clients");
	    //Définit sa taille
		Clients.setSize(350, 215);
	    //Place la fenetre au cntre de l'écran
		Clients.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		Clients.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		Clients.setLayout(null); 
		Clients.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		Clients.setIconImage(icone);
	}
}
