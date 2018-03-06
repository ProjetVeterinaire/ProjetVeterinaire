/*
 * Auteur : Gauthier LEFEVRE - Ronan GODICHEAU-TORNIER
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.DateLabelFormatter;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Label;

public class EcranPriseRDV extends JFrame{
	
	//JTable
	private JTable vTabRDV;
	
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

	//Choices
	private Choice vChoiceVeterinaire;
	private Choice vChoiceClient;
	private Choice vChoiceAnimal;
	private Choice vChoiceHeure;
	private Choice vChoiceMinutes;
	
	//UtilDateModel
	private UtilDateModel vModel;
	
	//JDatePanel
	private JDatePanelImpl vDatePanel;
	
	//JDatePicker
	private JDatePickerImpl vDatePicker; 
	
	//JScrollPane
	private JScrollPane vScrollPane;
	
	
	public EcranPriseRDV(){
		
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


	private JPanel getvPanelClient() {
		if(vPanelClient==null){
			vPanelClient = new JPanel();
			vPanelClient.setBorder(new TitledBorder(null, "Pour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			vPanelClient.setBounds(10, 36, 221, 133);
			vPanelClient.add(getvLblClient());
			vPanelClient.add(getvLblAnimal());
			vPanelClient.add(getvBtnPlusClient());
			vPanelClient.add(getvBtnPlusAnimal());
			vPanelClient.add(getvChoiceClient());
			vPanelClient.add(getvChoiceAnimal());
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
	private Choice getvChoiceClient() {
		if(vChoiceClient==null){
			vChoiceClient = new Choice();
			vChoiceClient.setBounds(31, 47, 125, 20);
			vChoiceClient.add("Bob Marley");
		}
		return vChoiceClient;
	}
	private Choice getvChoiceAnimal() {
		if(vChoiceAnimal==null){
			vChoiceAnimal= new Choice();
			vChoiceAnimal.setBounds(31, 92, 125, 20);
			vChoiceAnimal.add("Cheshire");
		}
		return vChoiceAnimal;
	}
	private JButton getvBtnPlusClient() {
		if(vBtnPlusClient==null){
			vBtnPlusClient = new JButton(new ImageIcon("./ressources/images/BTN_Plus_mini.png"));
			vBtnPlusClient.setBounds(162, 41, 35, 35);
		}
		return vBtnPlusClient;
	}

	private JButton getvBtnPlusAnimal() {
		if(vBtnPlusAnimal==null){
			vBtnPlusAnimal = new JButton(new ImageIcon("./ressources/images/BTN_Plus_mini.png"));
			vBtnPlusAnimal.setBounds(162, 87, 35, 35);
		}
		return vBtnPlusAnimal;
	}

	private JPanel getvPanelVeto() {
		if(vPanelVeto==null){
			vPanelVeto = new JPanel();
			vPanelVeto.setBorder(new TitledBorder(null, "Par", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			vPanelVeto.setBounds(255, 36, 221, 133);
			vPanelVeto.add(getvLblVeterinaire());
			vPanelVeto.add(getvChoiceVeterinaire());
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
	private Choice getvChoiceVeterinaire() {
		if(vChoiceVeterinaire==null){
			vChoiceVeterinaire = new Choice();
			vChoiceVeterinaire.setBounds(45, 69, 133, 20);
			vChoiceVeterinaire.add("JJ Goldman");
		}
		return vChoiceVeterinaire;
	}
	private JPanel getvPanelRDV() {
		if(vPanelRDV==null){
			vPanelRDV= new JPanel();
			vPanelRDV.setBorder(new TitledBorder(null, "Quand", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			vPanelRDV.setBounds(503, 36, 221, 133);
			vPanelRDV.add(getvChoiceHeure());
			vPanelRDV.add(getvChoiceMinutes());
			vPanelRDV.add(getvLblH());
			vPanelRDV.add(getvLblHeure());			
			vPanelRDV.add(getvLblDate());
			vPanelRDV.add(getvDatePicker());
			vPanelRDV.setLayout(null);
		}
		return vPanelRDV;
	}	
	private Choice getvChoiceHeure() {
		if(vChoiceHeure==null){
			vChoiceHeure = new Choice();
			vChoiceHeure.setBounds(39, 87, 49, 20);
			vChoiceHeure.add("9");vChoiceHeure.add("10");vChoiceHeure.add("11");vChoiceHeure.add("14");vChoiceHeure.add("15");vChoiceHeure.add("16");vChoiceHeure.add("17");
		}
		return vChoiceHeure;
	}	
	private Choice getvChoiceMinutes() {
		if(vChoiceMinutes==null){
			vChoiceMinutes = new Choice();
			vChoiceMinutes.setBounds(109, 87, 49, 20);
			vChoiceMinutes.add("00");vChoiceMinutes.add("15");vChoiceMinutes.add("30");vChoiceMinutes.add("45");
		}
		return vChoiceMinutes;
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
	private JScrollPane getvScrollPane() {
		if(vScrollPane==null){
			vScrollPane=new JScrollPane(getvTable());
			vScrollPane.setBounds(10, 209, 714, 224);
		}
		return vScrollPane;
	}
	private JTable getvTable() {
		if(vTabRDV==null){
			String data[][]={ 	{"9h00","Bob Marley","Cheshire","Chat"},    
	     			{"9h15","Bob Dylan","Gizmo","Chat"},    
	     			{"9h30","Bob Sinclar","Rouquin","Chat"}};    
			String column[]={"Heure","Nom du client","Animal","Race"}; 
			vTabRDV = new JTable(data,column);
			vTabRDV.setShowHorizontalLines(false);
			vTabRDV.setBounds(10, 209, 714, 224);
		}
		return vTabRDV;
	}
	private JButton getvBtnValider() {
		if(vBtnValider==null){
			vBtnValider = new JButton(new ImageIcon("./ressources/images/BTN_Valider.png"));
			vBtnValider.setBounds(617, 444, 50, 51);
		}
		return vBtnValider;
	}
	private JButton getvBtnSupprimer() {
		if(vBtnSupprimer==null){
			vBtnSupprimer= new JButton(new ImageIcon("./ressources/images/BTN_Supprimer_petit.png"));
			vBtnSupprimer.setBounds(557, 444, 50, 51);
		}
		return vBtnSupprimer;
	}
}
