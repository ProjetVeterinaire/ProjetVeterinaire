/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.clients;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.jdbc.JDBCTools;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerAnimal;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerClient;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerPersonnel;
import src.fr.eni.ProjetVeterinaire.ihm.ecranPersonnel.DataModelPersonnel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class EcranResultRecherche extends JFrame{
	private JTextField TFRecherche;
	private JTable TabRecherche;
	private EcranResultRecherche ecranResultRecherche;
	private JScrollPane vScrollPane;
	private JButton vButtonRecherche;
	private EcranClients vEcranClients;
	public EcranResultRecherche(EcranClients aEcranClients) throws BLLException, DALException{
		
		ecranResultRecherche=this;
		vEcranClients = aEcranClients;
		
		//Définit un titre pour la fenetre
		this.setTitle("Resultat de la recherche");
	    //Définit sa taille
		this.setSize(500, 300);
	    //Place la fenetre au cntre de l'écran
		this.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		this.getContentPane().setLayout(null); 
		
		JPanel panelRecherche = new JPanel();
		panelRecherche.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRecherche.setBounds(10, 11, 464, 51);
		this.getContentPane().add(panelRecherche);
		panelRecherche.setLayout(null);
		
		
		
		panelRecherche.add(getTextField());
		
		JLabel lblRecherche = new JLabel("Recherche :");
		lblRecherche.setBounds(40, 18, 68, 14);
		panelRecherche.add(lblRecherche);

		panelRecherche.add(getvButtonRecherche());

	
		
		
		this.getContentPane().add(getvScrollPane());		
		
		this.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		this.setIconImage(icone);
	}
	private JTextField getTextField(){
		if(TFRecherche==null){
			TFRecherche = new JTextField();
			TFRecherche.setBounds(117, 15, 200, 20);
			TFRecherche.setColumns(10);

		}
		return TFRecherche;
	}
	private JScrollPane getvScrollPane() throws BLLException, DALException {
		if(vScrollPane==null){
			vScrollPane=new JScrollPane(getvTabRecherche());
			vScrollPane.setBounds(10, 75, 464, 175);
		}
		return vScrollPane;
	}
	private JTable getvTabRecherche() throws BLLException, DALException {
		if(TabRecherche==null){
			TabRecherche=new TableRecherche();
			TabRecherche.setCellSelectionEnabled(true);
			TabRecherche.setShowVerticalLines(false);
			TabRecherche.setColumnSelectionAllowed(true);
			TabRecherche.setFillsViewportHeight(true);
			TabRecherche.setPreferredScrollableViewportSize(new Dimension(400,200));
			TabRecherche.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ListSelectionModel vListSelectionModel = TabRecherche.getSelectionModel();
			vListSelectionModel.addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					Client vClient = null;
					try {
						ControllerClient vControllerClient = ControllerClient.getInstance();
						vClient = (Client) getvTabRecherche().getValueAt(getvTabRecherche().getSelectedRow(), 0);
						vEcranClients.getTFCode().setText(String.valueOf(vClient.getvCodeClient()));
						vEcranClients.getTFNom().setText(vClient.getvNomClient());
						vEcranClients.getTFPrenom().setText(vClient.getvPrenomClient());
						vEcranClients.getTFAdresse1().setText(vClient.getvAdresse1());
						vEcranClients.getTFAdresse2().setText(vClient.getvAdresse2());
						vEcranClients.getTFCodePostal().setText(vClient.getvCode_postal());
						vEcranClients.getTFVille().setText(vClient.getvVille());
						vEcranClients.getTFNumTel().setText(vClient.getvNumTel());
						vEcranClients.getTFAssurance().setText(vClient.getvAssurance());
						vEcranClients.getTFEmail().setText(vClient.getvEmail());
						vEcranClients.getTFRemarque().setText(vClient.getvRemarque());
						ControllerAnimal vControllerAnimal = ControllerAnimal.getInstance();
						List<Animal> vListeAnimaux = vControllerAnimal.selectIdClient(vClient.getvCodeClient());
						vEcranClients.getvTabAnimauxClient().setModel(new DataModelClient(vListeAnimaux));

					} catch (BLLException | DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);
				}
			});
		}
		return TabRecherche;
	}
	private JButton getvButtonRecherche(){
		 	if(vButtonRecherche==null)
		 		{
		 		vButtonRecherche= new JButton(new ImageIcon("./ressources/images/BTN_Recherche_petit.png"));
			 	vButtonRecherche.setBounds(375, 0, 50, 51);
			 	
			 	vButtonRecherche.addActionListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent e){
						 try {
							 	ControllerClient vControllerClient = ControllerClient.getInstance();
							 	List<Client> vClient = vControllerClient.selectByNom(getTextField().getText());
							 	JDBCTools.closeConnection();
							 	getvTabRecherche().setModel(new DataModelRecherche(vClient));
						 } catch (BLLException | DALException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		 		}
		 	return vButtonRecherche;
	}
//	private JButton getBtnRechercher(){
//		if (btnRechercher == null){
//			btnRechercher = new JButton (new ImageIcon("./ressources/images/BTN_Recherche.png"));
//			btnRechercher.addActionListener(new ActionListener(){
//				
//				public void actionPerformed(ActionEvent e){
//					try{
//						ControllerClient vControllerClient = ControllerClient.getInstance();
//						vControllerClient.selectByNom(getTFNom().getText());
//					} catch (BLLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					catch(DALException e1){
//						e1.printStackTrace();
//					}
//						
//					
//				}
//			});
//		}
//		
//		
//		return btnRechercher;
//	}
}
