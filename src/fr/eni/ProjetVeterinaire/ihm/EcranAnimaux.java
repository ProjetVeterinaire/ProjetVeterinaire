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
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Label;

public class EcranAnimaux {
	private JTextField TFClient;
	private JTextField TFNomAnimal;
	private JTextField TFCouleur;
	private JTextField TFTatouage;

	public EcranAnimaux(){
		
		JFrame Animaux = new JFrame();
		
		//Définit un titre pour la fenetre
		Animaux.setTitle("Animaux");
	    //Définit sa taille
		Animaux.setSize(450, 325);
	    //Place la fenetre au cntre de l'écran
		Animaux.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		Animaux.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		Animaux.getContentPane().setLayout(null); 
		
		JPanel panelBTN = new JPanel();
		panelBTN.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBTN.setBounds(10, 11, 414, 51);
		Animaux.getContentPane().add(panelBTN);
		panelBTN.setLayout(null);
		
		JButton btnAnnuler = new JButton(new ImageIcon("./ressources/images/BTN_Annuler.png"));
		btnAnnuler.setBounds(364, 0, 50, 51);
		panelBTN.add(btnAnnuler);
		
		JButton btnValider = new JButton(new ImageIcon("./ressources/images/BTN_Valider.png"));
		btnValider.setBounds(304, 0, 50, 51);
		panelBTN.add(btnValider);
		
		JPanel panelClient = new JPanel();
		panelClient.setBorder(new TitledBorder(null, "Client : ", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelClient.setBounds(10, 73, 414, 51);
		Animaux.getContentPane().add(panelClient);
		panelClient.setLayout(null);
		
		TFClient = new JTextField();
		TFClient.setText("Nom client ici");
		TFClient.setBounds(30, 21, 360, 20);
		TFClient.setEditable(false);
		panelClient.add(TFClient);
		TFClient.setColumns(10);
		
		JLabel lblCode = new JLabel("Code :");
		lblCode.setBounds(10, 135, 60, 14);
		Animaux.getContentPane().add(lblCode);
		
		JLabel lblCodeAnimal = new JLabel("8888");
		lblCodeAnimal.setBounds(84, 132, 75, 14);
		Animaux.getContentPane().add(lblCodeAnimal);
		
		JLabel lblNomAnimal = new JLabel("Nom :");
		lblNomAnimal.setBounds(10, 153, 70, 14);
		Animaux.getContentPane().add(lblNomAnimal);
		
		JLabel lblCouleur = new JLabel("Couleur :");
		lblCouleur.setBounds(10, 178, 70, 14);
		Animaux.getContentPane().add(lblCouleur);
		
		JLabel lblEspece = new JLabel("Espèce :");
		lblEspece.setBounds(10, 203, 70, 14);
		Animaux.getContentPane().add(lblEspece);
		
		JLabel lblTatouage = new JLabel("Tatouage");
		lblTatouage.setBounds(10, 231, 70, 14);
		Animaux.getContentPane().add(lblTatouage);
		
		TFNomAnimal = new JTextField();
		TFNomAnimal.setBounds(84, 150, 201, 20);
		Animaux.getContentPane().add(TFNomAnimal);
		TFNomAnimal.setColumns(10);
		
		TFCouleur = new JTextField();
		TFCouleur.setBounds(84, 175, 201, 20);
		Animaux.getContentPane().add(TFCouleur);
		TFCouleur.setColumns(10);
		
		Choice choiceSexe = new Choice();
		choiceSexe.setBounds(315, 147, 109, 20);
		choiceSexe.add("Femelle");choiceSexe.add("Mâle");
		Animaux.getContentPane().add(choiceSexe);
		
		TFTatouage = new JTextField();
		TFTatouage.setBounds(84, 228, 201, 20);
		Animaux.getContentPane().add(TFTatouage);
		TFTatouage.setColumns(10);
		
		Choice choiceEspece = new Choice();
		choiceEspece.setBounds(84, 198, 109, 20);
		choiceEspece.add("Chien");choiceEspece.add("Chat");choiceEspece.add("Rat");choiceEspece.add("Lapin");choiceEspece.add("Diplodocus");
		Animaux.getContentPane().add(choiceEspece);
		
		Choice choiceRace = new Choice();
		choiceRace.setBounds(315, 198, 109, 20);
		choiceRace.add("Siamois");choiceRace.add("Saint-Bernard");choiceRace.add("Main Coon");
		Animaux.getContentPane().add(choiceRace);
		
		Label lblRace = new Label("Race :");
		lblRace.setBounds(222, 198, 62, 22);
		Animaux.getContentPane().add(lblRace);
		Animaux.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		Animaux.setIconImage(icone);
	}
}
