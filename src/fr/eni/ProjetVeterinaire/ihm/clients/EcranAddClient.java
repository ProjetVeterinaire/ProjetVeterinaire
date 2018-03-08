/*
 * Auteur : Gauthier LEFEVRE /Florian Chevalier
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.clients;

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
	private JTextField vTFCode;
	private JTextField vTFNom;
	private JTextField vTFPrenom;	
	private JTextField vTFAdresse1;
	private JTextField vTFAdresse2;
	private JTextField vTFCodePostal;
	private JTextField vTFVille;
	private JTextField vTFNumTel;
	private JTextField vTFAssurance;
	private JTextField vTFEmail;
	private JTextArea vTARemarque;
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
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

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
			
			JLabel lblNom = new JLabel("Nom : ");
			lblNom.setBounds(10, 98, 94, 14);
			getContentPane().add(lblNom);
			getContentPane().add(getTFNom());
			
			JLabel lblPrenom = new JLabel("Prénom :");
			lblPrenom.setBounds(10, 123, 94, 14);
			getContentPane().add(lblPrenom);
			getContentPane().add(getTFPrenom());
			
			JLabel lblAdresse = new JLabel("Adresse :");
			lblAdresse.setBounds(10, 148, 94, 14);
			getContentPane().add(lblAdresse);
			getContentPane().add(getTFAdresse1());
			getContentPane().add(getTFAdresse2());
			
			JLabel lblCodePostal = new JLabel("Code Postal :");
			lblCodePostal.setBounds(10, 209, 94, 14);
			getContentPane().add(lblCodePostal);
			getContentPane().add(getTFCodePostal());

			JLabel lblVille = new JLabel("Ville :");
			lblVille.setBounds(10, 233, 94, 14);
			getContentPane().add(lblVille);
			getContentPane().add(getTFVille());
			
			JLabel lblNumTel = new JLabel("N° Téléphone :");
			lblNumTel.setBounds(10, 258, 94, 14);
			getContentPane().add(lblNumTel);
			getContentPane().add(getTFNumTel());
			
			JLabel lblAssurance = new JLabel("Assurance :");
			lblAssurance.setBounds(10, 283, 94, 14);
			getContentPane().add(lblAssurance);
			getContentPane().add(getTFAssurance());

			JLabel lblEmail = new JLabel("Email :");
			lblEmail.setBounds(10, 308, 94, 14);
			getContentPane().add(lblEmail);
			getContentPane().add(getTFEmail());

			JLabel lblRemarque = new JLabel("Remarque :");
			lblRemarque.setBounds(10, 333, 72, 14);
			getContentPane().add(lblRemarque);
			getContentPane().add(getTARemarque());
			
			panel.add(getBtnValider());
			
			panel.add(getBtnAnnuler());		
	}
	
	private JButton getBtnValider(){
		if(btnValider==null){
		   btnValider = new JButton(new ImageIcon("./ressources/images/BTN_Valider.png"));
		   btnValider.setBounds(154, 0, 50, 51);
		   btnValider.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				   Client aClient = new Client(0, getTFNom().getText(), getTFPrenom().getText(), getTFAdresse1().getText(), getTFAdresse2().getText(), getTFCodePostal().getText(), getTFVille().getText(), getTFNumTel().getText(), getTFAssurance().getText(), getTFEmail().getText(),getTARemarque().getText(), Boolean.valueOf(getTFArchive().getText()));
				   try {
					ControllerClient vControllerClient = ControllerClient.getInstance();
					vControllerClient.Ajouter(aClient);
					setVisible(false);
				} catch (BLLException | DALException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
  
			   }finally{
				   JDBCTools.closeConnection();
			   }
			   }
		   });
		}
		return btnValider;
	}
	
	private JButton getBtnAnnuler(){
		if(btnAnnuler==null){
		   btnAnnuler = new JButton(new ImageIcon("./ressources/images/BTN_Annuler.png"));
		   btnAnnuler.setBounds(214, 0, 50, 51);
		   btnAnnuler.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				   
				   setVisible(false);
			   }
		   });
		}
		return btnAnnuler;
	}
	
	public JTextField getTFCode(){
		if(vTFCode==null){
		   vTFCode = new JTextField();
		   vTFCode.setColumns(10);
		}
		return vTFCode;
	}
	
	public JTextField getTFNom(){
		if(vTFNom==null){
		   vTFNom = new JTextField();
		   vTFNom.setBounds(114, 95, 122, 20);
		   vTFNom.setColumns(10);
		}
		return vTFNom;
	}
	
	public JTextField getTFPrenom(){
		if(vTFPrenom==null){
		   vTFPrenom = new JTextField();
		   vTFPrenom.setBounds(114, 120, 122, 20);
		   vTFPrenom.setColumns(10);
		}
		return vTFPrenom;
	}
	public JTextField getTFAdresse1(){
		if(vTFAdresse1==null){
		   vTFAdresse1 = new JTextField();
		   vTFAdresse1.setBounds(114, 145, 122, 20);
		   vTFAdresse1.setColumns(10);
		}
		return vTFAdresse1;
	}
	public JTextField getTFAdresse2(){
		if(vTFAdresse2==null){
		   vTFAdresse2 = new JTextField();
		   vTFAdresse2.setBounds(114, 175, 122, 20);
		   vTFAdresse2.setColumns(10);
		}
		return vTFAdresse2;
	}
	public JTextField getTFCodePostal(){
		if(vTFCodePostal==null){
		   vTFCodePostal = new JTextField();
		   vTFCodePostal.setBounds(114, 206, 122, 20);
		   vTFCodePostal.setColumns(10);
		}
		return vTFCodePostal;
	}
	public JTextField getTFVille(){
		if(vTFVille==null){
		   vTFVille = new JTextField();
		   vTFVille.setBounds(114, 230, 122, 20);
		   vTFVille.setColumns(10);
		}
		return vTFVille;
	}
	public JTextField getTFNumTel(){
		if(vTFNumTel==null){
		   vTFNumTel = new JTextField();
		   vTFNumTel.setBounds(114, 255, 122, 20);
		   vTFNumTel.setColumns(10);
		}
		return vTFNumTel;
	}
	public JTextField getTFAssurance(){
		if(vTFAssurance==null){
		   vTFAssurance = new JTextField();
		   vTFAssurance.setBounds(114, 280, 122, 20);
		   vTFAssurance.setColumns(10);
		}
		return vTFAssurance;
	}
	public JTextField getTFEmail(){
		if(vTFEmail==null){
		   vTFEmail = new JTextField();
		   vTFEmail.setBounds(114, 305, 122, 20);
		   vTFEmail.setColumns(10);
		}
		return vTFEmail;
	}
	public JTextField getTFArchive(){
		if(vTFArchive==null){
		   vTFArchive = new JTextField();
		   vTFArchive.setColumns(10);
		}
		return vTFArchive;
	}

	public JTextArea getTARemarque(){
		if(vTARemarque== null){
		   vTARemarque = new JTextArea();
		   vTARemarque.setBounds(114, 328, 152, 150);
			
		}
		return vTARemarque;
	}
	
	
}


