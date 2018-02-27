/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.login;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EcranGestionPersonnel {

	public EcranGestionPersonnel(){
		
		JFrame GPersonnel = new JFrame();
		
		//Définit un titre pour la fenetre
		GPersonnel.setTitle("Gestion du personnel");
	    //Définit sa taille
		GPersonnel.setSize(700, 500);
	    //Place la fenetre au cntre de l'écran
		GPersonnel.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		GPersonnel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		JPanel panelBTN = new JPanel();	//Creer le premier panel pour stocker les "boutons"
		panelBTN.setBounds(25, 25, 640, 75); //Le dimensionne
		//panelBTN.setBackground(Color.green);//Couleur pour distinguer
		panelBTN.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//Second panel avec la liste des utilisateur
		JPanel userList = new JPanel();
		userList.setBounds(25, 125, 640, 300);
		userList.setBorder(BorderFactory.createLineBorder(Color.black));
		userList.setLayout(new GridLayout(9,3));
		
		//Set la frame visible   
		GPersonnel.add(panelBTN);
		GPersonnel.add(userList);
		GPersonnel.setLayout(null); 
		GPersonnel.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		GPersonnel.setIconImage(icone);
	}
}
