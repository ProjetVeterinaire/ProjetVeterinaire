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

public class EcranAnimaux {

	public EcranAnimaux(){
		
		JFrame Animaux = new JFrame();
		
		//Définit un titre pour la fenetre
		Animaux.setTitle("Animaux");
	    //Définit sa taille
		Animaux.setSize(350, 215);
	    //Place la fenetre au cntre de l'écran
		Animaux.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		Animaux.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		Animaux.setLayout(null); 
		Animaux.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		Animaux.setIconImage(icone);
	}
}
