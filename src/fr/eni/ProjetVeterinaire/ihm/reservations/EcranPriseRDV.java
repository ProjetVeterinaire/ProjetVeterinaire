/*
 * Auteur : Gauthier LEFEVRE - Ronan GODICHEAU-TORNIER
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.reservations;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import src.fr.eni.ProjetVeterinaire.bll.AnimauxManager;
import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bll.ClientsManager;
import src.fr.eni.ProjetVeterinaire.bll.PersonnelManager;
import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Client;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.bo.Rdv;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.jdbc.JDBCTools;
import src.fr.eni.ProjetVeterinaire.ihm.EcranAnimaux;
import src.fr.eni.ProjetVeterinaire.ihm.clients.EcranClients;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerLogin;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerRdv;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.DateLabelFormatter;
import src.fr.eni.ProjetVeterinaire.ihm.ecranPersonnel.TablePersonnel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Label;

public class EcranPriseRDV extends JFrame{
	
	//JTable
	private TableRdv vTabRDV;
	
	//EcranPriseRDV
	private EcranPriseRDV vEcranPriseRDV; 
	
	//JPanels
	private JPanel vPanelClient;
	private JPanel vPanelRDV;
	private JPanel vPanelVeto;
	
	//JLabels 
	private JLabel vLblClient;
	private JLabel vLblAnimal;
	private JLabel vLblVeterinaire;
	private JLabel vLblH;
	private JLabel vLblHeure;
	private JLabel vLblDate;
	
	//JButtons
	private JButton vBtnPlusClient;
	private JButton vBtnPlusAnimal;
	private JButton vBtnValider;
	private JButton vBtnSupprimer;

	//JComboBoxs
	private JComboBox<Personnel> vJComboBoxVeterinaire;
	private JComboBox<Client> vJComboBoxClient;
	private JComboBox<Animal> vJComboBoxAnimal;
	private JComboBox<Integer> vJComboBoxHeure;
	private JComboBox<Integer> vJComboBoxMinutes;
	
	//UtilDateModel
	private UtilDateModel vModel;
	
	//JDatePanel
	private JDatePanelImpl vDatePanel;
	
	//JDatePicker
	private JDatePickerImpl vDatePicker; 
	
	//JScrollPane
	private JScrollPane vScrollPane;
	
	
	public EcranPriseRDV() throws BLLException, DALException{
		
		vEcranPriseRDV =this;
		
		//Définit un titre pour la fenetre
		this.setTitle("Prise de rendez-vous");
	    //Définit sa taille
		this.setSize(750, 550);
	    //Place la fenetre au cntre de l'écran
		this.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		this.getContentPane().setLayout(null); 

		this.getContentPane().add(getvPanelClient());
		
		this.getContentPane().add(getvPanelVeto());
		
		this.getContentPane().add(getvPanelRDV());

		this.getContentPane().add(getvScrollPane());

		
	
		this.getContentPane().add(getvBtnValider());
		
		
		this.getContentPane().add(getvBtnSupprimer());
		
		this.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		this.setIconImage(icone);
	}


	private JPanel getvPanelClient() throws BLLException, DALException {
		if(vPanelClient==null){
			vPanelClient = new JPanel();
			vPanelClient.setBorder(new TitledBorder(null, "Pour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			vPanelClient.setBounds(10, 36, 221, 133);
			vPanelClient.add(getvLblClient());
			vPanelClient.add(getvLblAnimal());
			vPanelClient.add(getvBtnPlusClient());
			vPanelClient.add(getvBtnPlusAnimal());
			vPanelClient.add(getvJComboBoxClient());
			vPanelClient.add(getvJComboBoxAnimal());
			vPanelClient.setLayout(null);

		}
		return vPanelClient;
	}
	
	private JLabel getvLblClient() {
		if(vLblClient==null){
			vLblClient= new JLabel("Client");
			vLblClient.setBounds(31, 27, 66, 14);
		}
		return vLblClient;
	}
	private JLabel getvLblAnimal() {
		if(vLblAnimal==null){
			vLblAnimal = new JLabel("Animal");
			vLblAnimal.setBounds(31, 72, 46, 14);
		}
		return vLblClient;
	}
	private JComboBox<Client> getvJComboBoxClient() throws BLLException, DALException {
		if(vJComboBoxClient==null){
			
			vJComboBoxClient = new JComboBox();
			vJComboBoxClient.setBounds(31, 47, 125, 20);
			ClientsManager vClientManager = new ClientsManager();
			List<Client> vListeClients = vClientManager.SelectAll();
			for(Client vClient : vListeClients){
				vJComboBoxClient.addItem(vClient);
			}
			vJComboBoxClient.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						AnimauxManager vAnimauxManager = new AnimauxManager();
						Client vClient =(Client)vJComboBoxClient.getSelectedItem();
						List<Animal> vListeAnimaux = vAnimauxManager.SelectByIdClient(vClient.getvCodeClient());
						vJComboBoxAnimal.removeAllItems();
						for(Animal vAnimal : vListeAnimaux){
							vJComboBoxAnimal.addItem(vAnimal);
						}
					} catch (DALException | BLLException e1) {
						
						e1.printStackTrace();
					}
					finally{
						JDBCTools.closeConnection();
					}
				}
			});
		}
		return vJComboBoxClient;
	}
	private JComboBox getvJComboBoxAnimal() throws BLLException, DALException {
		if(vJComboBoxAnimal==null){
			vJComboBoxAnimal= new JComboBox();
			vJComboBoxAnimal.setBounds(31, 92, 125, 20);
			AnimauxManager vAnimauxManager = new AnimauxManager();
			Client vClient =(Client)vJComboBoxClient.getSelectedItem();
			List<Animal> vListeAnimaux = vAnimauxManager.SelectByIdClient(vClient.getvCodeClient());
			JDBCTools.closeConnection();
			for(Animal vAnimal : vListeAnimaux){
				vJComboBoxAnimal.addItem(vAnimal);
			}
		}
		return vJComboBoxAnimal;
	}
	private JButton getvBtnPlusClient() {
		if(vBtnPlusClient==null){
			vBtnPlusClient = new JButton(new ImageIcon("./ressources/images/BTN_Plus_mini.png"));
			vBtnPlusClient.setBounds(162, 41, 35, 35);
			vBtnPlusClient.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						EcranClients vEcranClients = new EcranClients();
					} catch (BLLException | DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return vBtnPlusClient;
	}

	private JButton getvBtnPlusAnimal() {
		if(vBtnPlusAnimal==null){
			vBtnPlusAnimal = new JButton(new ImageIcon("./ressources/images/BTN_Plus_mini.png"));
			vBtnPlusAnimal.setBounds(162, 87, 35, 35);
			vBtnPlusAnimal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						EcranAnimaux vEcranAnimaux = new EcranAnimaux();
					} catch (BLLException | DALException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return vBtnPlusAnimal;
	}

	private JPanel getvPanelVeto() throws BLLException {
		if(vPanelVeto==null){
			vPanelVeto = new JPanel();
			vPanelVeto.setBorder(new TitledBorder(null, "Par", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			vPanelVeto.setBounds(255, 36, 221, 133);
			vPanelVeto.add(getvLblVeterinaire());
			vPanelVeto.add(getvJComboBoxVeterinaire());
			vPanelVeto.setLayout(null);
		}
		return vPanelVeto;
	}
	private JLabel getvLblVeterinaire() {
		if(vLblVeterinaire==null){
			vLblVeterinaire= new JLabel("Vétérinaire");
			vLblVeterinaire.setBounds(45, 49, 133, 14);
		}
		return vLblVeterinaire;
	}
	private JComboBox getvJComboBoxVeterinaire() throws BLLException {
		if(vJComboBoxVeterinaire==null){
			vJComboBoxVeterinaire = new JComboBox();
			vJComboBoxVeterinaire.setBounds(45, 69, 133, 20);
			PersonnelManager vPersonnelManager = new PersonnelManager();
			Client vClient =(Client)vJComboBoxClient.getSelectedItem();
			List<Personnel> vListeVeterinaires = vPersonnelManager.selectVeterinaires();
			JDBCTools.closeConnection();
			for(Personnel vVeterinaire : vListeVeterinaires){
				vJComboBoxVeterinaire.addItem(vVeterinaire);
			}
		}
		return vJComboBoxVeterinaire;
	}
	private JPanel getvPanelRDV() {
		if(vPanelRDV==null){
			vPanelRDV= new JPanel();
			vPanelRDV.setBorder(new TitledBorder(null, "Quand", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			vPanelRDV.setBounds(503, 36, 221, 133);
			vPanelRDV.add(getvJComboBoxHeure());
			vPanelRDV.add(getvJComboBoxMinutes());
			vPanelRDV.add(getvLblH());
			vPanelRDV.add(getvLblHeure());			
			vPanelRDV.add(getvLblDate());
			vPanelRDV.add(getvDatePicker());
			vPanelRDV.setLayout(null);
		}
		return vPanelRDV;
	}	
	private JComboBox getvJComboBoxHeure() {
		if(vJComboBoxHeure==null){
			vJComboBoxHeure = new JComboBox();
			vJComboBoxHeure.setBounds(39, 87, 49, 20);
			for(int i = 9;i<18;i++){
				vJComboBoxHeure.addItem(i);
			}
			
		}
		return vJComboBoxHeure;
	}	
	private JComboBox getvJComboBoxMinutes() {
		if(vJComboBoxMinutes==null){
			vJComboBoxMinutes = new JComboBox();
			vJComboBoxMinutes.setBounds(109, 87, 49, 20);
			for(int i = 0;i<46;i+=15){
				vJComboBoxMinutes.addItem(i);
			}
		}
		return vJComboBoxMinutes;
	}
	private JLabel getvLblH() {
		if(vLblH==null){
			vLblH= new JLabel("h");
			vLblH.setBounds(94, 85, 20, 22);
		}
		return vLblH;
	}
	private JLabel getvLblHeure() {
		if(vLblHeure==null){
			vLblHeure = new JLabel("Heure");
			vLblHeure.setBounds(39, 67, 46, 14);
		}
		return vLblHeure;
	}
	private JLabel getvLblDate() {
		if(vLblDate==null){
			vLblDate = new JLabel("Date");
			vLblDate.setBounds(39, 13, 46, 14);
		}
		return vLblDate;
	}
	private JDatePanelImpl getvDatePanel() {
		if(vDatePanel==null){
			vModel = new UtilDateModel();
			Properties p = new Properties();
			p.put("text.today", "Aujourd'hui");
			p.put("text.month", "Mois");
			p.put("text.year", "Année");
			vDatePanel = new JDatePanelImpl(vModel, p);
		}
		return vDatePanel;
	}
	private JDatePickerImpl getvDatePicker() {
		if(vDatePicker==null){
			vDatePicker = new JDatePickerImpl(getvDatePanel(), new DateLabelFormatter());
			vDatePicker.setBounds(30, 30, 150, 25);
		}
		return vDatePicker;
	}
	private JScrollPane getvScrollPane() throws BLLException, DALException {
		if(vScrollPane==null){
			vScrollPane=new JScrollPane(getvTable());
			vScrollPane.setBounds(10, 209, 714, 224);
		}
		return vScrollPane;
	}
	private JTable getvTable() throws BLLException, DALException {
		if(vTabRDV==null){
			vTabRDV=new TableRdv();
			vTabRDV.setFillsViewportHeight(true);
			vTabRDV.setPreferredScrollableViewportSize(new Dimension(400,200));
			vTabRDV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			vTabRDV.setBounds(10, 209, 714, 224);
		}
		return vTabRDV;
	}
	private JButton getvBtnValider() {
		if(vBtnValider==null){
			vBtnValider = new JButton(new ImageIcon("./ressources/images/BTN_Valider.png"));
			vBtnValider.setBounds(617, 444, 50, 51);
			vBtnValider.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Personnel vVetoSelected  = (Personnel)getvJComboBoxVeterinaire().getSelectedItem();
						Animal vAnimalSelected = (Animal)getvJComboBoxAnimal().getSelectedItem();
						String vHeure = getvJComboBoxHeure().getSelectedItem().toString();
						String vMinutes = getvJComboBoxMinutes().getSelectedItem().toString();
						String vPickedDate = getvDatePicker().getJFormattedTextField().getText();
						String[] vTableauString =  vPickedDate.split(" / ");
						String vDateChaine = vTableauString[1]+"/"+vTableauString[0]+"/"+vTableauString[2]+" "+vHeure+":"+vMinutes;
						Date vDate = new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(vDateChaine);
						Rdv vRdvAjouter = new Rdv(vVetoSelected.getvCodePers(),vDate,vAnimalSelected.getvCodeAnimal());
						ControllerRdv vControllerRdv = ControllerRdv.getInstance();
						vControllerRdv.ajouter(vRdvAjouter);
						
					} catch (BLLException | DALException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					finally{
						JDBCTools.closeConnection();
						JDBCTools.closeConnection();
						
					}

				}
			});
		}
		return vBtnValider;
	}
	private JButton getvBtnSupprimer() {
		if(vBtnSupprimer==null){
			vBtnSupprimer= new JButton(new ImageIcon("./ressources/images/BTN_Supprimer_petit.png"));
			vBtnSupprimer.setBounds(557, 444, 50, 51);
//			vBtnSupprimer.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent e){
//					try{
//						ControllerRdv vControllerRdv = ControllerRdv.getInstance();
//						vControllerRdv.Supprimer(getvTable().getValueAt(getvTable().getSelectedRow(), 0));
//					}
//				}
//			});
		}
		return vBtnSupprimer;
	}
}
