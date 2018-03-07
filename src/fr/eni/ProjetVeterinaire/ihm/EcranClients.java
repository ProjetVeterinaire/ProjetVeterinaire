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

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerClient;

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
import javax.swing.JTextArea;

public class EcranClients {
	
	private JButton btnRechercher;
	private JButton btnAjouterClient;
	private JButton btnAjouterAnimal;
	private JButton btnSupprimerClient;
	private JButton btnSupprimerAnimal;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JButton btnEditerAnimal;
	private JTextField vTFAdresse1;
	private JTextField vTFAdresse2;
	private JTextField vTFPrenom;
	private JTextField vTFNom;
	private JTextField vTFCode;
	private JTextField vTFCodePostal;
	private JTextField vTFVille;
	private JTextField vTFAssurance;
	private JTextField vTFEmail;
	private JTextField vTFRemarque;
	private JTextField vTFArchive;
	private JTable TabAnimauxClient;
	private JTextField TFTelephone;
	private JTextField TFAssurance;
	private JTextField TFEmail;
	private JTextArea TXTARemarque;

	public EcranClients(){
		
		JFrame Clients = new JFrame();
		
		//Définit un titre pour la fenetre
		Clients.setTitle("Clients");
	    //Définit sa taille
		Clients.setSize(950, 550);
	    //Place la fenetre au cntre de l'écran
		Clients.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		Clients.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
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

		vTFAdresse1 = new JTextField();
		vTFAdresse1.setBounds(166, 225, 86, 20);
		Clients.getContentPane().add(vTFAdresse1);
		vTFAdresse1.setColumns(10);
		
		vTFAdresse2 = new JTextField();
		vTFAdresse2.setText("");
		vTFAdresse2.setBounds(166, 256, 86, 20);
		Clients.getContentPane().add(vTFAdresse2);
		vTFAdresse2.setColumns(10);
		
		vTFPrenom = new JTextField();
		vTFPrenom.setBounds(166, 200, 86, 20);
		Clients.getContentPane().add(vTFPrenom);
		vTFPrenom.setColumns(10);
		
		
		
		vTFNom.setBounds(166, 175, 86, 20);
		Clients.getContentPane().add(vTFNom);
				
		vTFCode.setBounds(166, 150, 86, 20);
		Clients.getContentPane().add(vTFCode);
		
		
		vTFCodePostal = new JTextField();
		vTFCodePostal.setBounds(166, 287, 86, 20);
		Clients.getContentPane().add(vTFCodePostal);
		vTFCodePostal.setColumns(10);
		
		vTFVille = new JTextField();
		vTFVille.setBounds(166, 318, 86, 20);
		Clients.getContentPane().add(vTFVille);
		vTFVille.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(54, 321, 70, 14);
		Clients.getContentPane().add(lblVille);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(54, 290, 70, 14);
		Clients.getContentPane().add(lblCodePostal);
		
		JLabel lblNumTel = new JLabel("Numéro de téléphone");
		lblNumTel.setBounds(54, 352, 110, 14);
		Clients.getContentPane().add(lblNumTel);
		JLabel lblAssurance = new JLabel("Assurance ");
		lblAssurance.setBounds(54, 377, 70, 14);
		Clients.getContentPane().add(lblAssurance);
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(54, 415, 70, 14);
		Clients.getContentPane().add(lblEmail);
		JLabel lblRemarque = new JLabel("Remarque ");
		lblRemarque.setBounds(54, 450, 70, 14);
		Clients.getContentPane().add(lblRemarque);
		
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
		
		JButton btnEditerAnimal = new JButton(new ImageIcon("./ressources/images/BTN_Editer_petit.png"));
		btnEditerAnimal.setBounds(751, 352, 50, 52);
		Clients.getContentPane().add(btnEditerAnimal);
		
		JButton btnSupprimerAnimal = new JButton(new ImageIcon("./ressources/images/BTN_Supprimer_petit.png"));
		btnSupprimerAnimal.setBounds(691, 352, 50, 52);
		Clients.getContentPane().add(btnSupprimerAnimal);
		
		JButton btnAjouterAnimal = new JButton(new ImageIcon("./ressources/images/BTN_Ajouter_petit.png"));
		btnAjouterAnimal.setBounds(631, 352, 50, 52);
		Clients.getContentPane().add(btnAjouterAnimal);
		
		TFTelephone = new JTextField();
		TFTelephone.setColumns(10);
		TFTelephone.setBounds(166, 349, 86, 20);
		Clients.getContentPane().add(TFTelephone);
		
		TFAssurance = new JTextField();
		TFAssurance.setColumns(10);
		TFAssurance.setBounds(166, 377, 86, 20);
		Clients.getContentPane().add(TFAssurance);
		
		TFEmail = new JTextField();
		TFEmail.setColumns(10);
		TFEmail.setBounds(166, 408, 86, 20);
		Clients.getContentPane().add(TFEmail);
		
		
		TXTARemarque.setBounds(166, 439, 193, 55);
		Clients.getContentPane().add(TXTARemarque);
		Clients.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		Clients.setIconImage(icone);
	}
	
	private JButton getBtnRechercher(){
		if (btnRechercher == null){
			btnRechercher = new JButton (new ImageIcon("./ressources/images/BTN_Recherche.png"));
			btnRechercher.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e){
					try{
						ControllerClient vControllerClient = ControllerClient.getInstance();
						vControllerClient.selectByNom(getTFNom().getText());
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					catch(DALException e1){
						e1.printStackTrace();
					}
						
					
				}
			});
		}
		
		
		return btnRechercher;
	}
	
	public JTextField getTFCode(){
		if (vTFCode== null){
			vTFCode= new JTextField();
			vTFCode.setColumns(10);
		}
		return vTFCode;
	}
	
	public JTextField getTFNom(){
		if (vTFNom== null){
			vTFNom = new JTextField();
			vTFNom.setColumns(10);
		}
		return vTFNom;
	}
}
