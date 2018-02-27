/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.login;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EcranLogin extends JFrame{

	public EcranLogin(){
	    JFrame Login = new JFrame();
	    
	    //Définit un titre pour la fenetre
	    Login.setTitle("Connexion");
	    //Définit sa taille
	    Login.setSize(350, 215);
	    //Place la fenetre au cntre de l'écran
	    Login.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
	    Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    //Définis, creer, donne les paramètres de position, et insère le label "Nom" à la fenetre
	    JLabel lblNom,lblPassword;  
	    lblNom=new JLabel("Nom :");  
	    lblNom.setBounds(50,35, 50,30);
	    Login.add(lblNom);
	    
	    //Définis, creer, donne les paramètres, et insère la zone de texte "Nom" à la fenetre
	    JTextField TFNom,TFPassword; 
	    TFNom=new JTextField("");  
	    TFNom.setBounds(150,35, 150,30);
	    Login.add(TFNom);
	    	    
	    //Creer, donne les paramètres de position, et insère le label "Password" à la fenetre 
	    lblPassword=new JLabel("Mot de passe :");  
	    lblPassword.setBounds(50,75, 100,30);
	    Login.add(lblPassword);
	    
	    //Creer, donne les paramètres, et insère la zone de texte "Password" à la fenetre
	    TFPassword=new JTextField("");  
	    TFPassword.setBounds(150,75, 150,30);
	    Login.add(TFPassword);
	    
	    //Définis, creer, donne les paramètres et insère le bouton de validation de connexion
	    JButton btnConnexion=new JButton("Valider");  
	    btnConnexion.setBounds(180,120,95,30);  
	    Login.add(btnConnexion);
	    
	    
	    //Creer le Listener ("On click" du bouton) pour btnConnexion
	    btnConnexion.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    		TFNom.setText("FELICITATIONS !");//pour du test
	    		TFPassword.setText("Tu as remplis les cases !"); //pour du test 
	    		
	    		EcranGestionPersonnel CliniqueVeto = new EcranGestionPersonnel();//lance la page "d'accueil"
	    	}  
	    });  
	    
	    //ActionListener actionListener = new AppliTestIHM();
	    //btnConnexion.addActionListener(actionListener);
	    
	    //Set la frame visible   
	    Login.setLayout(null); 
	    Login.setVisible(true);
	    Login.setResizable(false);

		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		Login.setIconImage(icone);
	}
}
