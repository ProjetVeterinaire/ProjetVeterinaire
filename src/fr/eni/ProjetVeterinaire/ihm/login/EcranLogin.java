/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.login;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EcranLogin extends JFrame{

	public EcranLogin(){
	    JFrame fenetre = new JFrame();
	    
	    //Définit un titre pour la fenetre
	    fenetre.setTitle("Connexion");
	    //Définit sa taille
	    fenetre.setSize(350, 215);
	    //Place la fenetre au cntre de l'écran
	    fenetre.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    //Définis, creer, donne les paramètres de position, et insère le label "Nom" à la fenetre
	    JLabel lblNom,lblPassword;  
	    lblNom=new JLabel("Nom :");  
	    lblNom.setBounds(50,35, 50,30);
	    fenetre.add(lblNom);
	    
	    //Définis, creer, donne les paramètres, et insère la zone de texte "Nom" à la fenetre
	    JTextField TFNom,TFPassword; 
	    TFNom=new JTextField("");  
	    TFNom.setBounds(150,35, 150,30);
	    fenetre.add(TFNom);
	    	    
	    //Creer, donne les paramètres de position, et insère le label "Password" à la fenetre 
	    lblPassword=new JLabel("Mot de passe :");  
	    lblPassword.setBounds(50,75, 100,30);
	    fenetre.add(lblPassword);
	    
	    //Creer, donne les paramètres, et insère la zone de texte "Password" à la fenetre
	    TFPassword=new JTextField("");  
	    TFPassword.setBounds(150,75, 150,30);
	    fenetre.add(TFPassword);
	    
	    //Définis, creer, donne les paramètres et insère le bouton de validation de connexion
	    JButton btnConnexion=new JButton("Valider");  
	    btnConnexion.setBounds(180,120,95,30);  
	    fenetre.add(btnConnexion);
	    
	    ActionListener actionListener = new AppliTestIHM();
	    btnConnexion.addActionListener(actionListener);
	    
	    //Set la frame visible   
		fenetre.setLayout(null); 
		fenetre.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		fenetre.setIconImage(icone);
	}
}
