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
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class EcranClients {
	private JTextField TFAdresse1;
	private JTextField TFAdresse2;
	private JTextField TFPrenom;
	private JTextField TFNom;
	private JTextField TFCode;
	private JTextField TFCodePostal;
	private JTextField TFVille;
	private JTable TabAnimauxClient;

	public EcranClients(){
		
		JFrame Clients = new JFrame();
		
		//Définit un titre pour la fenetre
		Clients.setTitle("Clients");
	    //Définit sa taille
		Clients.setSize(950, 470);
	    //Place la fenetre au cntre de l'écran
		Clients.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		Clients.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		Clients.getContentPane().setLayout(null); 
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 914, 77);
		Clients.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnRecherche = new JButton(new ImageIcon("./ressources/images/BTN_Recherche.png"));
		
		btnRecherche.setBounds(10, 0, 75, 77);
		panel.add(btnRecherche);
		
		JButton btnAnnuler = new JButton(new ImageIcon("./ressources/images/BTN_Annuler2.png"));
		btnAnnuler.setBounds(779, 0, 75, 77);
		panel.add(btnAnnuler);
		
		JButton btnValider = new JButton(new ImageIcon("./ressources/images/BTN_Valider2.png"));
		btnValider.setBounds(703, 0, 75, 77);
		panel.add(btnValider);
		
		JButton btnAjouter = new JButton(new ImageIcon("./ressources/images/BTN_Ajouter.png"));
		btnAjouter.setBounds(356, 0, 75, 77);
		panel.add(btnAjouter);
		
		JButton btnSupprimer = new JButton(new ImageIcon("./ressources/images/BTN_Supprimer.png"));
		btnSupprimer.setBounds(433, 0, 75, 77);
		panel.add(btnSupprimer);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(54, 153, 70, 14);
		Clients.getContentPane().add(lblCode);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(54, 178, 70, 14);
		Clients.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(54, 203, 70, 14);
		Clients.getContentPane().add(lblPrenom);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(54, 228, 70, 14);
		Clients.getContentPane().add(lblAdresse);
		
		TFAdresse1 = new JTextField();
		TFAdresse1.setBounds(166, 225, 86, 20);
		Clients.getContentPane().add(TFAdresse1);
		TFAdresse1.setColumns(10);
		
		TFAdresse2 = new JTextField();
		TFAdresse2.setText("");
		TFAdresse2.setBounds(166, 256, 86, 20);
		Clients.getContentPane().add(TFAdresse2);
		TFAdresse2.setColumns(10);
		
		TFPrenom = new JTextField();
		TFPrenom.setBounds(166, 200, 86, 20);
		Clients.getContentPane().add(TFPrenom);
		TFPrenom.setColumns(10);
		
		TFNom = new JTextField();
		TFNom.setText("");
		TFNom.setBounds(166, 175, 86, 20);
		Clients.getContentPane().add(TFNom);
		TFNom.setColumns(10);
		
		TFCode = new JTextField();
		TFCode.setBounds(166, 150, 86, 20);
		Clients.getContentPane().add(TFCode);
		TFCode.setColumns(10);
		
		TFCodePostal = new JTextField();
		TFCodePostal.setBounds(166, 287, 86, 20);
		Clients.getContentPane().add(TFCodePostal);
		TFCodePostal.setColumns(10);
		
		TFVille = new JTextField();
		TFVille.setBounds(166, 318, 86, 20);
		Clients.getContentPane().add(TFVille);
		TFVille.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(54, 321, 70, 14);
		Clients.getContentPane().add(lblVille);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(54, 290, 70, 14);
		Clients.getContentPane().add(lblCodePostal);
		
		String data[][]={ 	{"101","Cheshire","Femelle","Tigré gris","Europeene","Chat",""},    
                 			{"102","Gizmo","Male","Tigré Noir","Europeene","Chat",""},    
                 			{"101","Rouquin","Male","Tigré Roux","Europeene","Chat",""}};    
		String column[]={"Numéro","Nom","Sexe","Couleur","Race","Espece","Tatouage"}; 
		TabAnimauxClient = new JTable(data,column);
		TabAnimauxClient.setCellSelectionEnabled(true);
		TabAnimauxClient.setShowVerticalLines(false);
		TabAnimauxClient.setColumnSelectionAllowed(true);
		TabAnimauxClient.setBounds(350, 148, 490, 190);
		
		JScrollPane sp=new JScrollPane(TabAnimauxClient);
		sp.setBounds(350, 148, 490, 190);
		Clients.getContentPane().add(sp);
		
		JButton btnEditer = new JButton(new ImageIcon("./ressources/images/BTN_Editer_petit.png"));
		btnEditer.setBounds(751, 352, 50, 52);
		Clients.getContentPane().add(btnEditer);
		
		JButton btnSupprimerAnimal = new JButton(new ImageIcon("./ressources/images/BTN_Supprimer_petit.png"));
		btnSupprimerAnimal.setBounds(691, 352, 50, 52);
		Clients.getContentPane().add(btnSupprimerAnimal);
		
		JButton btnAjouterAnimal = new JButton(new ImageIcon("./ressources/images/BTN_Ajouter_petit.png"));
		btnAjouterAnimal.setBounds(631, 352, 50, 52);
		Clients.getContentPane().add(btnAjouterAnimal);
		Clients.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		Clients.setIconImage(icone);
	}
}
