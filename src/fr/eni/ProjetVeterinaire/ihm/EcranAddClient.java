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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.jdbc.JDBCTools;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerClient;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

public class EcranAddClient extends JFrame{
	
	private JButton btnValider;
	private JButton btnAnnuler;
	private JLabel vErrorMessage;
	private EcranAddClient ecranAddClient;
	private JTextField vTFAdresse1;
	private JTextField vTFPrenom;
	private JTextField vTFNom;
	private JTextField vTFCode;
	private JTextField vTFAdresse2;
	private JTextField vTFCodePostal;
	private JTextField vTFVille;
	private JTextField vTFNumTel;
	private JTextField vTFAssurance;
	private JTextField vTFEmail;
	private JTextField vTFArchive;
	
	public EcranAddClient(){
		ecranAddClient=this;
		
			
			JFrame AddClient = new JFrame();
			
			//Définit un titre pour la fenetre
			this.setTitle("Ajouter un client");
		    //Définit sa taille
			this.setSize(300, 550);
		    //Place la fenetre au cntre de l'écran
			this.setLocationRelativeTo(null);
		    //Termine proprement le processus lorsqu'on clique sur la croix rouge
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			
			
			
			this.setVisible(true);
			getContentPane().setLayout(null);
			//Donne à la fenetre l'icone de l'application
			Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
			this.setIconImage(icone);
			
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(10, 11, 264, 51);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JButton btnValider = new JButton(new ImageIcon("./ressources/images/BTN_Valider.png"));
			btnValider.setBounds(154, 0, 50, 51);
			panel.add(btnValider);
			
			JButton btnAnnuler = new JButton(new ImageIcon("./ressources/images/BTN_Annuler.png"));
			btnAnnuler.setBounds(214, 0, 50, 51);
			panel.add(btnAnnuler);
			
			JLabel lblCode = new JLabel("Code :");
			lblCode.setBounds(10, 73, 94, 14);
			getContentPane().add(lblCode);
			
			JLabel lblNom = new JLabel("Nom : ");
			lblNom.setBounds(10, 98, 94, 14);
			getContentPane().add(lblNom);
			
			JLabel lblPrenom = new JLabel("Prénom :");
			lblPrenom.setBounds(10, 123, 94, 14);
			getContentPane().add(lblPrenom);
			
			JLabel lblAdresse = new JLabel("Adresse :");
			lblAdresse.setBounds(10, 148, 94, 14);
			getContentPane().add(lblAdresse);
			
			

			vTFCode = new JTextField();
			vTFCode.setBounds(114, 70, 122, 20);
			getContentPane().add(vTFCode);
			vTFCode.setColumns(10);
			
			vTFPrenom = new JTextField();
			vTFPrenom.setBounds(114, 120, 122, 20);
			getContentPane().add(vTFPrenom);
			vTFPrenom.setColumns(10);
			
			vTFNom = new JTextField();
			vTFNom.setBounds(114, 95, 122, 20);
			getContentPane().add(vTFNom);
			vTFNom.setColumns(10);

			vTFAdresse1 = new JTextField();
			vTFAdresse1.setBounds(114, 145, 122, 20);
			getContentPane().add(vTFAdresse1);
			vTFAdresse1.setColumns(10);
			
			vTFAdresse2 = new JTextField();
			vTFAdresse2.setBounds(114, 175, 122, 20);
			getContentPane().add(vTFAdresse2);
			vTFAdresse2.setColumns(10);
			
			JLabel lblCodePostal = new JLabel("Code Postal :");
			lblCodePostal.setBounds(10, 209, 94, 14);
			getContentPane().add(lblCodePostal);
			
			JLabel lblVille = new JLabel("Ville :");
			lblVille.setBounds(10, 233, 94, 14);
			getContentPane().add(lblVille);
			
			JLabel lblNumTel = new JLabel("N° Téléphone :");
			lblNumTel.setBounds(10, 258, 94, 14);
			getContentPane().add(lblNumTel);
			
			JLabel lblAssurance = new JLabel("Assurance :");
			lblAssurance.setBounds(10, 283, 94, 14);
			getContentPane().add(lblAssurance);
			
			JLabel lblEmail = new JLabel("Email :");
			lblEmail.setBounds(10, 308, 94, 14);
			getContentPane().add(lblEmail);
			
			JLabel lblRemarque = new JLabel("Remarque");
			lblRemarque.setBounds(10, 333, 72, 14);
			getContentPane().add(lblRemarque);
			
			vTFCodePostal = new JTextField();
			vTFCodePostal.setBounds(114, 206, 122, 20);
			getContentPane().add(vTFCodePostal);
			vTFCodePostal.setColumns(10);
			
			vTFVille = new JTextField();
			vTFVille.setBounds(114, 230, 122, 20);
			getContentPane().add(vTFVille);
			vTFVille.setColumns(10);
			
			vTFNumTel = new JTextField();
			vTFNumTel.setBounds(114, 255, 122, 20);
			getContentPane().add(vTFNumTel);
			vTFNumTel.setColumns(10);
			
			vTFAssurance = new JTextField();
			vTFAssurance.setBounds(114, 280, 122, 20);
			getContentPane().add(vTFAssurance);
			vTFAssurance.setColumns(10);
			
			vTFEmail = new JTextField();
			vTFEmail.setBounds(114, 305, 122, 20);
			getContentPane().add(vTFEmail);
			vTFEmail.setColumns(10);
			
			JTextArea vTFRemarque = new JTextArea();
			vTFRemarque.setBounds(92, 328, 182, 172);
			getContentPane().add(vTFRemarque);
			
			vTFArchive = new JTextField();
			
			
			
	}
}


