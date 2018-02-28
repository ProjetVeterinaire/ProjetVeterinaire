/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class EcranDossierMedical {

	public EcranDossierMedical(){
		
		JFrame DossierMedical = new JFrame();
		
		//Définit un titre pour la fenetre
		DossierMedical.setTitle("Dossier médical");
	    //Définit sa taille
		DossierMedical.setSize(350, 215);
	    //Place la fenetre au cntre de l'écran
		DossierMedical.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		DossierMedical.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		DossierMedical.setLayout(null); 
		DossierMedical.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		DossierMedical.setIconImage(icone);
	}
}
