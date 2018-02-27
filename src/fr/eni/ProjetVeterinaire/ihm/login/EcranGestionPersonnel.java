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

public class EcranGestionPersonnel {

	public EcranGestionPersonnel(){
		
		JFrame GPersonnel = new JFrame();
		
		//Définit un titre pour la fenetre
		GPersonnel.setTitle("Gestion du personnel");
	    //Définit sa taille
		GPersonnel.setSize(350, 215);
	    //Place la fenetre au cntre de l'écran
		GPersonnel.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		GPersonnel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		GPersonnel.setLayout(null); 
		GPersonnel.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		GPersonnel.setIconImage(icone);
	}
}
