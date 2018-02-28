/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.controllers;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class EcranAddClient {

	public EcranAddClient(){
			
			JFrame AddClient = new JFrame();
			
			//Définit un titre pour la fenetre
			AddClient.setTitle("Ajouter un client");
		    //Définit sa taille
			AddClient.setSize(350, 215);
		    //Place la fenetre au cntre de l'écran
			AddClient.setLocationRelativeTo(null);
		    //Termine proprement le processus lorsqu'on clique sur la croix rouge
			AddClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
			
			
			
			
			//Set la frame visible   
			AddClient.setLayout(null); 
			AddClient.setVisible(true);
			
			//Donne à la fenetre l'icone de l'application
			Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
			AddClient.setIconImage(icone);
	}
}
