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

public class EcranAddClient extends JFrame{
	
	private JButton btnValider;
	private JButton btnAnnuler;
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
	private JTextField vTFRemarque;
	private JTextField vTFArchive;
	
	private JLabel vErrorMessage;
	private EcranAddClient ecranAddClient;
	
	public EcranAddClient(EcranClients aEcranClients){
		ecranAddClient=this;
		
			
			JFrame AddClient = new JFrame();
			
			//Définit un titre pour la fenetre
			this.setTitle("Ajouter un client");
		    //Définit sa taille
			this.setSize(300, 380);
		    //Place la fenetre au cntre de l'écran
			this.setLocationRelativeTo(null);
		    //Termine proprement le processus lorsqu'on clique sur la croix rouge
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);//Bloque le redimensionnement de la page
			this.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
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
			panelControleAjoutClient.add(getBtnValider());
			panelControleAjoutClient.add(getBtnAnnuler());
			
			//ajouteles boutons au panel
			
		
//			JButton btn_Valider=new JButton(new ImageIcon("./ressources/images/BTN_Valider.png"));
//			JButton btn_Annuler=new JButton(new ImageIcon("./ressources/images/BTN_Annuler.png"));
			
			
			  
			this.getContentPane().add(panelControleAjoutClient, "1, 2, 3, 1, left, fill");
			
			JLabel lblCode = new JLabel("Code");
			this.getContentPane().add(lblCode, "2, 4, right, center");
			this.getContentPane().add(getTFCode(), "4, 4, left, top");

			JLabel lblNom = new JLabel("Nom");
			this.getContentPane().add(lblNom, "2, 6, right, top");	
			this.getContentPane().add(getTFNom(), "4, 6, left, default");
					
			JLabel lblPrenom = new JLabel("Prenom");
			this.getContentPane().add(lblPrenom, "2, 8, right, top");
			this.getContentPane().add(getTFPrenom(), "4, 8, left, default");
			
			JLabel lblAdresse = new JLabel("Adresse");
			this.getContentPane().add(lblAdresse, "2, 10, right, default");	
			this.getContentPane().add(getTFAdresse1(), "4, 10, left, default");
			this.getContentPane().add(getTFAdresse2(), "4, 12, left, fill");
			
			JLabel lblCodePostal = new JLabel("Code Postal");
			this.getContentPane().add(lblCodePostal, "2, 14, right, default");
			this.getContentPane().add(getTFCodePostal(), "4, 14, left, default");
			
			JLabel lblVille = new JLabel("Ville");
			this.getContentPane().add(lblVille, "2, 16, right, default");
			this.getContentPane().add(getTFVille(), "4, 16, left, default");
			
			JLabel lblNumTel = new JLabel("Numéro de téléphone");
			this.getContentPane().add(lblNumTel, "2, 18, right, default");
			this.getContentPane().add(getTFNumTel(), "4, 18, left, default");
			
			JLabel lblAssurance = new JLabel("Numéro de téléphone");
			this.getContentPane().add(lblAssurance, "2, 20, right, default");
			this.getContentPane().add(getTFAssurance(), "4, 20, left, default");
			
			JLabel lblEmail = new JLabel("Numéro de téléphone");
			this.getContentPane().add(lblEmail, "2, 22, right, default");
			this.getContentPane().add(getTFEmail(), "4, 22, left, default");
			
			JLabel lblRemarque = new JLabel("Numéro de téléphone");
			this.getContentPane().add(lblRemarque, "2, 24, right, default");
			this.getContentPane().add(getTFRemarque(), "4, 24, left, default");
			
			this.setVisible(true);
			
			
			
			//Donne à la fenetre l'icone de l'application
			Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
			this.setIconImage(icone);
	}
	
	public JButton getBtnValider(){
		if (btnValider == null){
			btnValider = new JButton (new ImageIcon("./ressources/images/BTN_Valider.png"));
			//Creer le listener ("On click du bouton") pour btnValider
			btnValider.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e){
					try{
						
						Client aClient = new Client(0,getTFNom().getText(), getTFPrenom().getText(), getTFAdresse1().getText(), getTFAdresse2().getText(), getTFCodePostal().getText(), getTFVille().getText(), getTFNumTel().getText(),getTFAssurance().getText(), getTFEmail().getText(), getTFRemarque().getText(), false); 
						if(aClient.getvNomClient()!=null || aClient.getvPrenomClient()!=null){
							ControllerClient.getInstance().Ajouter(aClient);
							
						}else{
							vErrorMessage.setForeground(Color.red);
							vErrorMessage.setText("Nom et/ou Prenom du client non renseigné");
						}
						
						
					}catch(BLLException e1){
						e1.printStackTrace();
					} catch (DALException e1) {
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
	
	public JButton getBtnAnnuler(){
		if (btnAnnuler == null){
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e){
					getTFNom().setText("");
					getTFPrenom().setText("");
					getTFAdresse1().setText("");
					getTFAdresse2().setText("");
					getTFCodePostal().setText("");
					getTFVille().setText("");
					getTFNumTel().setText("");
					getTFAssurance().setText("");
					getTFEmail().setText("");
					getTFRemarque().setText("");
					
				}
			});
		}
		return btnAnnuler;
	}
	
	public JTextField getTFCode(){
		if (vTFCode== null){
			vTFCode= new JTextField();
			vTFCode.setColumns(10);;	
			
    	}
    	return vTFCode;
	}
	
	public JTextField getTFNom(){
		if (vTFNom== null){
			vTFNom= new JTextField();
			vTFNom.setColumns(10);;	
			
    	}
    	return vTFNom;
	}
	
	public JTextField getTFPrenom(){
		if (vTFPrenom== null){
			vTFPrenom= new JTextField();
			vTFPrenom.setColumns(10);;	
			
    	}
    	return vTFPrenom;
	}
	
	public JTextField getTFAdresse1(){
		if (vTFAdresse1== null){
			vTFAdresse1= new JTextField();
			vTFAdresse1.setColumns(10);;	
			
    	}
    	return vTFAdresse1;
	}
	
	public JTextField getTFAdresse2(){
		if (vTFAdresse2== null){
			vTFAdresse2= new JTextField();
			vTFAdresse2.setColumns(10);;	
			
    	}
    	return vTFAdresse2;
	}
	
	public JTextField getTFCodePostal(){
		if (vTFCodePostal== null){
			vTFCodePostal= new JTextField();
			vTFCodePostal.setColumns(10);;	
			
    	}
    	return vTFCodePostal;
	}
	
	public JTextField getTFVille(){
		if (vTFVille== null){
			vTFVille= new JTextField();
			vTFVille.setColumns(10);;	
			
    	}
    	return vTFVille;
	}
	
	public JTextField getTFNumTel(){
		if (vTFNumTel== null){
			vTFNumTel= new JTextField();
			vTFNumTel.setColumns(10);
		}
		return vTFNumTel;
	}
	
	public JTextField getTFAssurance(){
		if (vTFAssurance== null){
			vTFAssurance= new JTextField();
			vTFAssurance.setColumns(10);
		}
		return vTFAssurance;
	}
	
	public JTextField getTFEmail(){
		if (vTFEmail== null){
			vTFEmail= new JTextField();
			vTFEmail.setColumns(10);
		}
		return vTFEmail;
	}
	
	public JTextField getTFRemarque(){
		if (vTFRemarque== null){
			vTFRemarque= new JTextField();
			vTFRemarque.setColumns(10);
		}
		return vTFRemarque;
	}
	
}

