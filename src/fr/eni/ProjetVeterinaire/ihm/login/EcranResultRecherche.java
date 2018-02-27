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

public class EcranResultRecherche {

	public EcranResultRecherche(){
		
		JFrame ResultRecherche = new JFrame();
		
		//Définit un titre pour la fenetre
		ResultRecherche.setTitle("Resultat de la recherche");
	    //Définit sa taille
		ResultRecherche.setSize(350, 215);
	    //Place la fenetre au cntre de l'écran
		ResultRecherche.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		ResultRecherche.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		ResultRecherche.setLayout(null); 
		ResultRecherche.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		ResultRecherche.setIconImage(icone);
	}
}
