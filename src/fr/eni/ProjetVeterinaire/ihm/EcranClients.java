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
import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.jdbc.JDBCTools;
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

public class EcranClients extends JFrame{
	
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
	private JTextField vTFNumTel;
	private JTextField vTFAssurance;
	private JTextField vTFEmail;
	private JTextField vTFRemarque;
	private JTextField vTFArchive;
	private JTable TabAnimauxClient;
	private EcranClients ecranClients; 
	

	public EcranClients(){
		ecranClients=this;
		

		
		//Définit un titre pour la fenetre
		this.setTitle("Clients");
	    //Définit sa taille
		this.setSize(950, 550);
	    //Place la fenetre au cntre de l'écran
		this.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//Set la frame visible   
		this.getContentPane().setLayout(null); 
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 914, 77);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel.add(getBtnRechercher());
	
//		panel.add(btnAnnuler);
		
		panel.add(getBtnValider());
		
		panel.add(getBtnAjouterClient());

		panel.add(getBtnSupprimerClient());

		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(54, 153, 70, 14);
		this.getContentPane().add(lblCode);
		
		this.getContentPane().add(getTFCode());
	
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(54, 178, 70, 14);
		this.getContentPane().add(lblNom);
		
		this.getContentPane().add(getTFNom());
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(54, 203, 70, 14);
		this.getContentPane().add(lblPrenom);
		this.getContentPane().add(getTFPrenom());
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(54, 228, 70, 14);
		this.getContentPane().add(lblAdresse);
		this.getContentPane().add(getTFAdresse1());

		this.getContentPane().add(getTFAdresse2());

		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(54, 290, 70, 14);
		this.getContentPane().add(lblCodePostal);
		this.getContentPane().add(getTFCodePostal());
	
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(54, 321, 70, 14);
		this.getContentPane().add(lblVille);
		this.getContentPane().add(getTFVille());
		
		JLabel lblNumTel = new JLabel("Tél.");
		lblNumTel.setBounds(54, 352, 110, 14);
		this.getContentPane().add(lblNumTel);
		this.getContentPane().add(getTFNumTel());
		
		JLabel lblAssurance = new JLabel("Assurance ");
		lblAssurance.setBounds(54, 377, 70, 14);
		this.getContentPane().add(lblAssurance);
		this.getContentPane().add(getTFAssurance());
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(54, 415, 70, 14);
		this.getContentPane().add(lblEmail);
		this.getContentPane().add(getTFEmail());
		
		JLabel lblRemarque = new JLabel("Remarque ");
		lblRemarque.setBounds(54, 450, 70, 14);
		this.getContentPane().add(lblRemarque);
		this.getContentPane().add(getTFRemarque());
		this.setVisible(true);
		
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
		this.getContentPane().add(sp);
		
		JButton btnEditerAnimal = new JButton(new ImageIcon("./ressources/images/BTN_Editer_petit.png"));
		btnEditerAnimal.setBounds(751, 352, 50, 52);
		this.getContentPane().add(btnEditerAnimal);
		
		JButton btnSupprimerAnimal = new JButton(new ImageIcon("./ressources/images/BTN_Supprimer_petit.png"));
		btnSupprimerAnimal.setBounds(691, 352, 50, 52);
		this.getContentPane().add(btnSupprimerAnimal);
		
		JButton btnAjouterAnimal = new JButton(new ImageIcon("./ressources/images/BTN_Ajouter_petit.png"));
		btnAjouterAnimal.setBounds(631, 352, 50, 52);
		this.getContentPane().add(btnAjouterAnimal);
		
		
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		this.setIconImage(icone);
	}
	
	private JButton getBtnRechercher(){
		if (btnRechercher == null){
			btnRechercher = new JButton (new ImageIcon("./ressources/images/BTN_Recherche.png"));
			btnRechercher.setBounds(10, 0, 75, 77);
			btnRechercher.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e){
					 new EcranResultRecherche();
				}
			});
		}
		
		
		return btnRechercher;
	}
	
//	private JButton getBtnAjouterAnimal(){
//		if (btnAjouterAnimal== null){
//			btnAnnuler = new JButton(new ImageIcon("./ressources/images/BTN_Annuler2.png"));
//			btnAjouterAnimal.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent e){
//					
//				}
//			});
//		}
//	}
	
	private JButton getBtnAjouterClient(){
		if (btnAjouterClient == null){
			btnAjouterClient = new JButton(new ImageIcon("./ressources/images/BTN_Ajouter.png"));
			btnAjouterClient.setBounds(356, 0, 75, 77);
			btnAjouterClient.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent e) {
					EcranAddClient addClient = new EcranAddClient();
					
						
				}
				
				
				
			});
		}
		return btnAjouterClient;
	}
	
	private JButton getBtnSupprimerClient(){
		if (btnSupprimerClient== null){
			btnSupprimerClient = new JButton(new ImageIcon("./ressources/images/BTN_Supprimer.png"));
			btnSupprimerClient.setBounds(433, 0, 75, 77);
			btnSupprimerClient.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					ControllerClient vControllerClient;
					try {
						vControllerClient = ControllerClient.getInstance();
						vControllerClient.Archiver(Integer.valueOf(getTFCode().getText()));
						
					} catch (BLLException | NumberFormatException | DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnSupprimerClient;
	}
	
	private JButton getBtnValider(){
		if(btnValider== null){
		   btnValider = new JButton(new ImageIcon("./ressources/images/BTN_Valider2.png"));
		   btnValider.setBounds(703, 0, 75, 77);
		   btnValider.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				   Client aClient = new Client(Integer.valueOf(getTFCode().getText()), getTFNom().getText(), getTFPrenom().getText(), getTFAdresse1().getText(), getTFAdresse2().getText(), getTFCodePostal().getText(), getTFVille().getText(), getTFNumTel().getText(), getTFAssurance().getText(), getTFEmail().getText(),getTFRemarque().getText(), Boolean.valueOf(getTFArchive().getText()));
				   try {
					ControllerClient vControllerClient = ControllerClient.getInstance();
					vControllerClient.Update(aClient);
				} catch (BLLException | DALException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				   
			   }
		   });
			

		}
		return btnValider;
	}
	
	private JButton getBtnAnnuler(){
		if(btnAnnuler== null){
		   btnAnnuler = new JButton(new ImageIcon("./ressources/images/BTN_Annuler2.png"));
		   btnAnnuler.setBounds(779, 0, 75, 77);
		   btnAnnuler.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				  
					   try {
						   ControllerClient vControllerClient = ControllerClient.getInstance();
						   Client vClient = vControllerClient.SelectClientById(Integer.valueOf(getTFCode().getText()));
						   
						   getTFNom().setText(vClient.getvNomClient());
						   getTFPrenom().setText(vClient.getvPrenomClient());
						   getTFAdresse1().setText(vClient.getvAdresse1());
						   getTFAdresse2().setText(vClient.getvAdresse2());
						   getTFCodePostal().setText(vClient.getvCode_postal());
						   getTFVille().setText(vClient.getvVille());
						   getTFNumTel().setText(vClient.getvNumTel());
						   getTFAssurance().setText(vClient.getvAssurance());
						   getTFEmail().setText(vClient.getvEmail());
						   getTFRemarque().setText(vClient.getvRemarque());
						   

					   } catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					   
				   
			   }
		   });
		}
		return btnAnnuler;
	}

	
	
	
	public JTextField getTFCode(){
		if (vTFCode== null){
			vTFCode= new JTextField();
			vTFCode.setColumns(10);
			vTFCode.setBounds(166, 150, 86, 20);
			vTFCode.setEditable(false);
			
		}
		return vTFCode;
	}
	
	public JTextField getTFNom(){
		if (vTFNom== null){
			vTFNom = new JTextField();
			vTFNom.setColumns(10);
			vTFNom.setBounds(166, 175, 86, 20);
		}
		return vTFNom;
	}

	
	public JTextField getTFPrenom(){
		if (vTFPrenom== null){
			vTFPrenom = new JTextField();
			vTFPrenom.setColumns(10);
			vTFPrenom.setBounds(166, 200, 86, 20);
		}
		return vTFPrenom;
	}
	
	public JTextField getTFAdresse1(){
		if (vTFAdresse1== null){
			vTFAdresse1 = new JTextField();
			vTFAdresse1.setColumns(10);
			vTFAdresse1.setBounds(166, 225, 86, 20);
		}
		return vTFAdresse1;
	}
	
	public JTextField getTFAdresse2(){
		if (vTFAdresse2== null){
			vTFAdresse2 = new JTextField();
			vTFAdresse2.setColumns(10);
			vTFAdresse2.setBounds(166, 256, 86, 20);
		}
		return vTFAdresse2;
	}
	
	public JTextField getTFCodePostal(){
		if (vTFCodePostal== null){
			vTFCodePostal = new JTextField();
			vTFCodePostal.setColumns(10);
			vTFCodePostal.setBounds(166, 287, 86, 20);
		}
		return vTFCodePostal;
	}
	
	public JTextField getTFVille(){
		if (vTFVille== null){
			vTFVille = new JTextField();
			vTFVille.setColumns(10);
			vTFVille.setBounds(166, 318, 86, 20);
		}
		return vTFVille;
	}
	
	public JTextField getTFNumTel(){
		if (vTFNumTel== null){
			vTFNumTel = new JTextField();
			vTFNumTel.setColumns(10);
			vTFNumTel.setBounds(166, 349, 86, 20);
		}
		return vTFNumTel;
	}
	
	public JTextField getTFAssurance(){
		if (vTFAssurance== null){
			vTFAssurance= new JTextField();
			vTFAssurance.setColumns(10);
			vTFAssurance.setBounds(166, 377, 86, 20);
		}
		return vTFAssurance;
	}
	
	public JTextField getTFEmail(){
		if (vTFEmail== null){
			vTFEmail = new JTextField();
			vTFEmail.setColumns(10);
			vTFEmail.setBounds(166, 408, 86, 20);
		}
		return vTFEmail;
	}
	
	public JTextField getTFRemarque(){
		if (vTFRemarque== null){
			vTFRemarque= new JTextField();
			vTFRemarque.setColumns(10);
			vTFRemarque.setBounds(166, 439, 193, 55);
		}
		return vTFRemarque;
	}
	
	public JTextField getTFArchive(){
		if (vTFArchive== null){
			vTFArchive= new JTextField();
			vTFArchive.setColumns(10);
		}
		return vTFArchive;
	}
	
}
