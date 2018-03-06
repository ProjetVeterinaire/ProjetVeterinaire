/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class EcranDossierMedical {
	private JButton btnValider;
	private JButton btnAnnuler;
	private JTable TabHistorique;

	public EcranDossierMedical(){
		
		JFrame DossierMedical = new JFrame();
		
		//Définit un titre pour la fenetre
		DossierMedical.setTitle("Dossier médical");
	    //Définit sa taille
		DossierMedical.setSize(800, 550);
	    //Place la fenetre au cntre de l'écran
		DossierMedical.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		DossierMedical.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		DossierMedical.getContentPane().setLayout(null); 
		JPanel panelBTN = new JPanel();
		panelBTN.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBTN.setBounds(10, 10, 764, 51);
		DossierMedical.getContentPane().add(panelBTN);
		panelBTN.setLayout(null);
		
		btnValider = new JButton(new ImageIcon("./ressources/images/BTN_Valider.png"));
		btnValider.setBounds(640,0,50,51);
		panelBTN.add(btnValider);
		
		btnAnnuler = new JButton(new ImageIcon("./ressources/images/BTN_Annuler.png"));
		btnAnnuler.setBounds(700,0,50,51);
		panelBTN.add(btnAnnuler);
		
		JPanel panelClient = new JPanel();
		panelClient.setBorder(new TitledBorder(null, "Client : ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelClient.setBounds(10, 96, 434, 77);
		DossierMedical.getContentPane().add(panelClient);
		panelClient.setLayout(null);
		
		JLabel lblClient = new JLabel("Nom - Prenom du client");
		lblClient.setBounds(26, 23, 245, 14);
		panelClient.add(lblClient);
		
		JLabel lblantecedent = new JLabel("Antécédent / Consultations ");
		lblantecedent.setBounds(279, 184, 322, 14);
		DossierMedical.getContentPane().add(lblantecedent);
		
		JLabel lblAnimal = new JLabel("Animal : ");
		lblAnimal.setBounds(25, 243, 46, 14);
		DossierMedical.getContentPane().add(lblAnimal);
		
		JLabel lblCodeAnimal = new JLabel("7777");
		lblCodeAnimal.setBounds(101, 243, 94, 14);
		DossierMedical.getContentPane().add(lblCodeAnimal);
		
		JLabel lblNomAnimal = new JLabel("Rodolph");
		lblNomAnimal.setBounds(101, 271, 94, 14);
		DossierMedical.getContentPane().add(lblNomAnimal);
		
		JLabel lblCouleur = new JLabel("Rouge");
		lblCouleur.setBounds(101, 296, 94, 14);
		DossierMedical.getContentPane().add(lblCouleur);
		
		JLabel lblSexe = new JLabel("Femelle");
		lblSexe.setBounds(223, 296, 94, 14);
		DossierMedical.getContentPane().add(lblSexe);
		
		JLabel lblRace = new JLabel("Poisson rouge");
		lblRace.setBounds(101, 321, 168, 14);
		DossierMedical.getContentPane().add(lblRace);
		
		JLabel lblTattoo = new JLabel("Tatoué");
		lblTattoo.setBounds(101, 346, 94, 14);
		DossierMedical.getContentPane().add(lblTattoo);
		
		JTextArea TXTAHistorique = new JTextArea();
		TXTAHistorique.setBounds(278, 209, 496, 251);
		DossierMedical.getContentPane().add(TXTAHistorique);
		
		
		
		//Set la frame visible   
		DossierMedical.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		DossierMedical.setIconImage(icone);
	}
}
