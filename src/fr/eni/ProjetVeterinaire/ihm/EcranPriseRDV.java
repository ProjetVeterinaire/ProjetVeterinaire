/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class EcranPriseRDV {

	public EcranPriseRDV(){
		
		JFrame PriseRDV = new JFrame();
		
		//Définit un titre pour la fenetre
		PriseRDV.setTitle("Prise de rendez-vous");
	    //Définit sa taille
		PriseRDV.setSize(750, 500);
	    //Place la fenetre au cntre de l'écran
		PriseRDV.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		PriseRDV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		PriseRDV.setLayout(null); 
		PriseRDV.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		PriseRDV.setIconImage(icone);
	}
}
