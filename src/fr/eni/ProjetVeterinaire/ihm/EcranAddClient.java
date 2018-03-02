/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class EcranAddClient {
	private JTextField TFCode;
	private JTextField TFAdresse1;
	private JTextField TFNom;
	private JTextField TFPrenom;
	private JTextField TFAdresse2;
	private JTextField TFCodePostal;
	private JTextField TFVille;

	public EcranAddClient(EcranClients aEcranClients){
		
		
			
			JFrame AddClient = new JFrame();
			
			//Définit un titre pour la fenetre
			AddClient.setTitle("Ajouter un client");
		    //Définit sa taille
			AddClient.setSize(300, 380);
		    //Place la fenetre au cntre de l'écran
			AddClient.setLocationRelativeTo(null);
		    //Termine proprement le processus lorsqu'on clique sur la croix rouge
			AddClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			AddClient.setResizable(false);//Bloque le redimensionnement de la page
			AddClient.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
					FormSpecs.UNRELATED_GAP_COLSPEC,
					ColumnSpec.decode("98px"),
					ColumnSpec.decode("56px"),
					ColumnSpec.decode("310px:grow"),},
				new RowSpec[] {
					FormSpecs.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("70px"),
					RowSpec.decode("47px"),
					RowSpec.decode("22px"),
					RowSpec.decode("9px"),
					RowSpec.decode("22px"),
					RowSpec.decode("9px"),
					RowSpec.decode("23px"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					RowSpec.decode("max(14dlu;default)"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,
					FormSpecs.RELATED_GAP_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,
					FormSpecs.RELATED_GAP_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,}));
		    
			JPanel panelControleAjoutClient = new JPanel();
			panelControleAjoutClient.setBounds(10,10, 270,70);
			panelControleAjoutClient.setBorder(BorderFactory.createLineBorder(Color.black));//donne les bordurs au panel
			
			
			//Creer les boutons et les ajoute au panel
			JButton btn_Valider=new JButton(new ImageIcon("./ressources/images/BTN_Valider.png"));
			JButton btn_Annuler=new JButton(new ImageIcon("./ressources/images/BTN_Annuler.png"));
			panelControleAjoutClient.add(btn_Valider);panelControleAjoutClient.add(btn_Annuler);
			
			  
			AddClient.getContentPane().add(panelControleAjoutClient, "1, 2, 3, 1, left, fill");
			
			JLabel lblCode = new JLabel("Code");
			AddClient.getContentPane().add(lblCode, "2, 4, right, center");
			
			TFCode = new JTextField();
			AddClient.getContentPane().add(TFCode, "4, 4, left, top");
			TFCode.setColumns(10);
			
			JLabel lblNom = new JLabel("Nom");
			AddClient.getContentPane().add(lblNom, "2, 6, right, top");
			
			TFNom = new JTextField();
			AddClient.getContentPane().add(TFNom, "4, 6, left, default");
			TFNom.setColumns(10);
			
			JLabel lblPrenom = new JLabel("Prenom");
			AddClient.getContentPane().add(lblPrenom, "2, 8, right, top");
			
			TFPrenom = new JTextField();
			AddClient.getContentPane().add(TFPrenom, "4, 8, left, default");
			TFPrenom.setColumns(10);
			
			JLabel lblAdresse = new JLabel("Adresse");
			AddClient.getContentPane().add(lblAdresse, "2, 10, right, default");
			
			TFAdresse1 = new JTextField();
			AddClient.getContentPane().add(TFAdresse1, "4, 10, left, default");
			TFAdresse1.setColumns(10);
			
			TFAdresse2 = new JTextField();
			AddClient.getContentPane().add(TFAdresse2, "4, 12, left, fill");
			TFAdresse2.setColumns(10);
			
			JLabel lblCodePostal = new JLabel("Code Postal");
			AddClient.getContentPane().add(lblCodePostal, "2, 14, right, default");
			
			TFCodePostal = new JTextField();
			AddClient.getContentPane().add(TFCodePostal, "4, 14, left, default");
			TFCodePostal.setColumns(10);
			
			JLabel lblVille = new JLabel("Ville");
			AddClient.getContentPane().add(lblVille, "2, 16, right, default");
			
			TFVille = new JTextField();
			AddClient.getContentPane().add(TFVille, "4, 16, left, default");
			TFVille.setColumns(10);
			AddClient.setVisible(true);
			
			//Donne à la fenetre l'icone de l'application
			Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
			AddClient.setIconImage(icone);
	}
}
