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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class EcranCliniqueVeterinaire {
	
	public EcranCliniqueVeterinaire(){
		
		JFrame Clinique = new JFrame();
		
		//Définit un titre pour la fenetre
		Clinique.setTitle("Clinique vétérinaire");
	    //Définit sa taille
		Clinique.setSize(750, 500);
	    //Place la fenetre au cntre de l'écran
		Clinique.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		Clinique.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		JMenuBar menubar=new JMenuBar();//Creer un nouveau JMenuBar nommé "menubar"
		JMenu menuFichier,menuGestionRDV,menuAgenda,menuGestionPerso; // Définis toutes les sections du menubar
		JMenuItem i1, i2, i3, i4;//Définis les options des sections menubar

		menuFichier = new JMenu("Fichier");//section Fichier du menu
		i1=new JMenuItem("Déconnexion");  //1ere option de la section Fichier
        i2=new JMenuItem("Fermer");		 //2eme option de la section Fichier 
        //Ajoute au menu menuFichier les options 1 et 2 (Déconnexion et Fermer)
        menuFichier.add(i1);	
        menuFichier.add(i2);

        //Pareil pour la seconde section de menu et les deux boutons menu
        menuGestionRDV = new JMenu("Gestion des rendez-vous");
        i3=new JMenuItem("Prise de rendez-vous");
        i4=new JMenuItem("Gestion des clients");
        menuGestionRDV.add(i3);
        menuGestionRDV.add(i4);
        
        menuAgenda= new JMenu("Agenda");
        menuGestionPerso=new JMenu("Gestion du personnel");
        
        //Ajoute au menubar global les sections menu menuFichier et menuGestionRDV
        menubar.add(menuFichier);menubar.add(menuGestionRDV);menubar.add(menuAgenda);menubar.add(menuGestionPerso);
        
		
        
        
		//Set la frame visible avec ces modules
		Clinique.setJMenuBar(menubar);
        Clinique.setLayout(null); 
		Clinique.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		Clinique.setIconImage(icone);
	}
}
