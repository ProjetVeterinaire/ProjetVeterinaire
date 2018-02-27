/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.login;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EcranLogin extends JFrame{

	public EcranLogin(){
	    JFrame fenetre = new JFrame();
	    
	    //D�finit un ti	tre pour notre fen�tre
	    fenetre.setTitle("Connexion");
	    //D�finit sa taille
	    fenetre.setSize(400, 300);
	    //Nous demandons maintenant � notre objet de se positionner au centre
	    fenetre.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    //Définis, creer, donne les paramètres de position, et insère le label "Nom" à la fenetre
	    JLabel lblNom,lblPassword;  
	    lblNom=new JLabel("Nom :");  
	    lblNom.setBounds(75,75, 100,30);
	    fenetre.add(lblNom);
	    
	    //Définis, creer, donne les paramètres, et insère la zone de texte "Nom" à la fenetre
	    JTextField TFNom,TFPassword; 
	    TFNom=new JTextField("");  
	    TFNom.setBounds(200,75, 150,30);
	    fenetre.add(TFNom);
	    
	    
	    //Creer, donne les paramètres de position, et insère le label "Password" à la fenetre 
	    lblPassword=new JLabel("Mot de passe :");  
	    lblPassword.setBounds(75,125, 100,30);
	    fenetre.add(lblPassword);
	    
	    //Creer, donne les paramètres, et insère la zone de texte "Password" à la fenetre
	    TFPassword=new JTextField("");  
	    TFPassword.setBounds(200,125, 150,30);
	    fenetre.add(TFPassword);
	    
	    
	    JButton btnConnexion=new JButton("Valider");  
	    btnConnexion.setBounds(255,200,95,30);  
	    fenetre.add(btnConnexion);
	    
	    
	fenetre.setLayout(null);
	//Set la frame visible    
	fenetre.setVisible(true);
	
	//Donne à la fenetre l'icone de l'application
	Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
	fenetre.setIconImage(icone);
	}
}
