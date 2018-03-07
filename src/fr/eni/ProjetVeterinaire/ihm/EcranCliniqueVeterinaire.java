/*
s * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javafx.geometry.VPos;
import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.jdbc.JDBCTools;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerLogin;
import src.fr.eni.ProjetVeterinaire.ihm.ecranPersonnel.EcranGestionPersonnel;
import src.fr.eni.ProjetVeterinaire.ihm.reservations.EcranPriseRDV;

public class EcranCliniqueVeterinaire  extends JFrame{
	private JMenu menuFichier,menuGestionRDV; // Définis toutes les sections du menubar
	private JButton menuGestionPerso;
	private JButton menuAgenda;
	private JMenuItem JMIFermer, JMIDeco, JMIrdv;//Définis les options des sections menubar
	private JMenuItem JMIGestionCli;
	private Personnel vPersonnel;
	private EcranCliniqueVeterinaire vEcranCliniqueVeterinaire;
	public EcranCliniqueVeterinaire(Personnel aPersonnel){
		
		
		vEcranCliniqueVeterinaire = this;
		//Définit un titre pour la fenetre
		this.setTitle("Clinique vétérinaire");
	    //Définit sa taille
		this.setSize(750, 500);
	    //Place la fenetre au cntre de l'écran
		this.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		vPersonnel=aPersonnel;
		JMenuBar menubar=new JMenuBar();//Creer un nouveau JMenuBar nommé "menubar"
		

		menuFichier = new JMenu("Fichier");//section Fichier du menu
		JMIDeco=new JMenuItem("Déconnexion");  //1ere option de la section Fichier
		JMIDeco.addActionListener(new ActionListener() {
	  	      public void actionPerformed(ActionEvent ev) {
	  	        EcranLogin Login = new EcranLogin();
	  	        setVisible(false);
	  	      }
	  	    });
        JMIFermer=new JMenuItem("Fermer");		 //2eme option de la section Fichier
        JMIFermer.addActionListener(new ActionListener() {
  	      public void actionPerformed(ActionEvent ev) {
  	        System.exit(0);
  	      }
  	    });
        //Ajoute au menu menuFichier les options 1 et 2 (Déconnexion et Fermer)
        menuFichier.add(JMIDeco);	
        menuFichier.add(JMIFermer);

        //Pareil pour la seconde section de menu et les deux boutons menu
        menuGestionRDV = new JMenu("Gestion des rendez-vous");
        JMIrdv=new JMenuItem("Prise de rendez-vous");
        JMIrdv.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ev) {
    	    	try {
					EcranPriseRDV CliniqueVetoPriseRDV = new EcranPriseRDV();
					setVisible(false);
				} catch (BLLException | DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	      }
    	    });
        
        
        JMIGestionCli=new JMenuItem("Gestion des clients");
        JMIGestionCli.addActionListener(new ActionListener() {
  	      public void actionPerformed(ActionEvent ev) {
  	    	EcranClients CliniqueVetoClients = new EcranClients();
			setVisible(false);
  	      }
  	    });
        menuGestionRDV.add(JMIrdv);
        menuGestionRDV.add(JMIGestionCli);
        
        menuAgenda= new JButton("Agenda");
        menuAgenda.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent ev) {
    	    	EcranAgenda CliniqueVetoAgenda = new EcranAgenda();
  			setVisible(false);
    	   }
    	});
        
        menuGestionPerso=new JButton("Gestion du personnel");
        menuGestionPerso.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent ev) {
     	    	try {
					EcranGestionPersonnel CliniqueVetoGestionPerso = new EcranGestionPersonnel(vPersonnel);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     	   }
     	});
        
        //Ajoute au menubar global les sections menu menuFichier et menuGestionRDV
        menubar.add(menuFichier);menubar.add(menuGestionRDV);menubar.add(menuAgenda);menubar.add(menuGestionPerso);
        
		
        
        
		//Set la frame visible avec ces modules
		this.setJMenuBar(menubar);
		this.setLayout(null); 
		setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		this.setIconImage(icone);
	}

	
}
