/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.login;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import src.fr.eni.ProjetVeterinaire.bo.Personnel;

public class EcranGestionPersonnel {

	public EcranGestionPersonnel(Personnel aPersonnel){
		
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
		panelBTN.setBounds(25, 25, 640, 95); //Le dimensionne
		panelBTN.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JButton btn_ajouter=new JButton(new ImageIcon("./ressources/images/BTN_Ajouter.png"));
		
		JButton btn_supprimer=new JButton(new ImageIcon("./ressources/images/BTN_Supprimer.png"));
		JButton btn_Reinitialiser=new JButton(new ImageIcon("./ressources/images/BTN_Reinitialiser.png"));
		panelBTN.add(btn_ajouter);panelBTN.add(btn_supprimer);panelBTN.add(btn_Reinitialiser);		

		
		//Second panel avec la liste des utilisateur
		JPanel userList = new JPanel();
		userList.setBounds(25, 145, 640, 275);
		userList.setBorder(BorderFactory.createLineBorder(Color.black));
		userList.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel lblNom = new JLabel("Bob Dylan");
		JLabel lblRole = new JLabel("vet");
		JLabel lblPassword = new JLabel("PASSWORD");
		JRadioButton radioSelect=new JRadioButton();
		
		JLabel lblNom1 = new JLabel("Jhon Lennon");
		JLabel lblRole1 = new JLabel("Sec");
		JLabel lblPassword1 = new JLabel("Motdepasse");
		JRadioButton radioSelect1=new JRadioButton(); 
		
        ButtonGroup groupRadio = new ButtonGroup();  
        
		gbc.gridx=0;
		gbc.gridy=0;
		userList.add(lblNom,gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.insets = new Insets(0,150,0,0);
		userList.add(lblRole,gbc);
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.insets = new Insets(0,20,0,0);
		userList.add(lblPassword,gbc);
		groupRadio.add(radioSelect);
		gbc.gridx=3;
		gbc.gridy=0;
		gbc.insets = new Insets(0,10,0,0);
		userList.add(radioSelect,gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=1;
		userList.add(lblNom1,gbc);
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.insets = new Insets(0,150,0,0);
		userList.add(lblRole1,gbc);
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.insets = new Insets(0,20,0,0);
		userList.add(lblPassword1,gbc);
		groupRadio.add(radioSelect1);
		gbc.gridx=3;
		gbc.gridy=1;
		gbc.insets = new Insets(0,10,0,0);
		userList.add(radioSelect1,gbc);
		
		
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
