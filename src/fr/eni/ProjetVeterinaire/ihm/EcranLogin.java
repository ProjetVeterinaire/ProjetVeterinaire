/*
 * Auteur : Gauthier LEFEVRE /Ronan GODICHEAU-TORNIER
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
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerLogin;

public class EcranLogin extends JFrame{
	
	private JButton btnConnexion;
	private JTextField vTFNom;
	private JPasswordField vTFPassword;
	private JLabel vErrorMessage;
	public EcranLogin(){
	    
	    //Définit un titre pour la fenetre
	    this.setTitle("Connexion");
	    //Définit sa taille
	    this.setSize(350, 215);
	    //Place la fenetre au cntre de l'écran
	    this.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    //Définis, creer, donne les paramètres de position, et insère le label "Nom" à la fenetre
	    JLabel lblNom,lblPassword;  
	    lblNom=new JLabel("Nom :");  
	    lblNom.setBounds(50,35, 50,30);
	    this.add(lblNom);
	    
	    //Définis, creer, donne les paramètres, et insère la zone de texte "Nom" à la fenetre
	    this.add(getTFNom());
	    	    
	    //Creer, donne les paramètres de position, et insère le label "Password" à la fenetre 
	    lblPassword=new JLabel("Mot de passe :");  
	    lblPassword.setBounds(50,75, 100,30);
	    this.add(lblPassword);
	    
	    //Creer, donne les paramètres, et insère la zone de texte "Password" à la fenetre
	    this.add(getTFPassword());
	    
	    //Définis, creer, donne les paramètres et insère le bouton de validation de connexion
	     

	     
	    this.add(getBtnConnexion());
	    vErrorMessage=new JLabel("");
	    vErrorMessage.setBounds(50,150,180,30);

	    this.add(vErrorMessage);

	    //Set la frame visible   
	    this.setLayout(null); 
	    this.setVisible(true);
	    this.setResizable(false);

		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		this.setIconImage(icone);
	}
	public JButton getBtnConnexion(){
    	if (btnConnexion == null){
    		btnConnexion = new JButton("Valider");
    		btnConnexion.setBounds(180,120,95,30); 
    		//Creer le Listener ("On click" du bouton) pour btnConnexion
    		btnConnexion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Personnel vPersonnel = ControllerLogin.getInstance().selectConnexion(getTFNom().getText(),String.valueOf(getTFPassword().getPassword()));
						if(vPersonnel!=null){
							EcranGestionPersonnel CliniqueVeto = new EcranGestionPersonnel(vPersonnel);
						    setVisible(false);
						}else{
							vErrorMessage.setForeground(Color.red);
							vErrorMessage.setText("Couple Login/Mdp invalide");
						}
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			});
    	}
    	return btnConnexion;
    }
	
	
	public JTextField getTFNom(){
    	if (vTFNom == null){
    		vTFNom = new JTextField("");  
    	    vTFNom.setBounds(150,35, 150,30);
    	}
    	return vTFNom;
    }
	public JPasswordField getTFPassword(){
    	if (vTFPassword == null){
    		vTFPassword = new JPasswordField("");  
    		vTFPassword.setBounds(150,75, 150,30);
    	}
    	return vTFPassword;
    }

}


	

	
