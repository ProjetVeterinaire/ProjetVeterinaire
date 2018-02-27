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

public class EcranCliniqueVeterinaire {
	
	public EcranCliniqueVeterinaire(){
		
		JFrame Clinique = new JFrame();
		
		//Définit un titre pour la fenetre
		Clinique.setTitle("Clinique vétérinaire");
	    //Définit sa taille
		Clinique.setSize(350, 215);
	    //Place la fenetre au cntre de l'écran
		Clinique.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		Clinique.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		Clinique.setLayout(null); 
		Clinique.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		Clinique.setIconImage(icone);
	}
}
