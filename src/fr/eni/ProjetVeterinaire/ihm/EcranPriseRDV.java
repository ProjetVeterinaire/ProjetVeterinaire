/*
 * Auteur : Gauthier LEFEVRE 
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
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Label;

public class EcranPriseRDV {
	private JTable TabRDV;

	public EcranPriseRDV(){
		
		JFrame PriseRDV = new JFrame();
		
		//Définit un titre pour la fenetre
		PriseRDV.setTitle("Prise de rendez-vous");
	    //Définit sa taille
		PriseRDV.setSize(750, 550);
	    //Place la fenetre au cntre de l'écran
		PriseRDV.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		PriseRDV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		PriseRDV.getContentPane().setLayout(null); 
		
		JPanel panelClient = new JPanel();
		panelClient.setBorder(new TitledBorder(null, "Pour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelClient.setBounds(10, 36, 221, 133);
		PriseRDV.getContentPane().add(panelClient);
		panelClient.setLayout(null);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(31, 27, 66, 14);
		panelClient.add(lblClient);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(31, 72, 46, 14);
		panelClient.add(lblAnimal);
		
		JButton btnPlusClient = new JButton(new ImageIcon("./ressources/images/BTN_Plus_mini.png"));
		btnPlusClient.setBounds(162, 41, 35, 35);
		panelClient.add(btnPlusClient);
		
		JButton btnPlusAnimal = new JButton(new ImageIcon("./ressources/images/BTN_Plus_mini.png"));
		btnPlusAnimal.setBounds(162, 87, 35, 35);
		panelClient.add(btnPlusAnimal);
		
		Choice choiceClient = new Choice();
		choiceClient.setBounds(31, 47, 125, 20);
		choiceClient.add("Bob Marley");choiceClient.add("Bob Dylan");choiceClient.add("Bob Sinclar");
		panelClient.add(choiceClient);
		
		Choice choiceAnimal = new Choice();
		choiceAnimal.setBounds(31, 92, 125, 20);
		choiceAnimal.add("Cheshire");choiceAnimal.add("Gizmo");choiceAnimal.add("Chien");
		panelClient.add(choiceAnimal);
		
		JPanel panelVeto = new JPanel();
		panelVeto.setBorder(new TitledBorder(null, "Par", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelVeto.setBounds(255, 36, 221, 133);
		PriseRDV.getContentPane().add(panelVeto);
		panelVeto.setLayout(null);
		
		JLabel lblVetrinaire = new JLabel("Vétérinaire");
		lblVetrinaire.setBounds(45, 49, 133, 14);
		panelVeto.add(lblVetrinaire);
		
		Choice choiceVeterinaire = new Choice();
		choiceVeterinaire.setBounds(45, 69, 133, 20);
		choiceVeterinaire.add("JJ Goldman");choiceVeterinaire.add("P Bruel");
		panelVeto.add(choiceVeterinaire);
		
		JPanel panelRDV = new JPanel();
		panelRDV.setBorder(new TitledBorder(null, "Quand", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelRDV.setBounds(503, 36, 221, 133);
		PriseRDV.getContentPane().add(panelRDV);
		panelRDV.setLayout(null);
		
		Choice choiceHeure = new Choice();
		choiceHeure.setBounds(39, 87, 49, 20);
		choiceHeure.add("9");choiceHeure.add("10");choiceHeure.add("11");choiceHeure.add("14");choiceHeure.add("15");choiceHeure.add("16");choiceHeure.add("17");
		panelRDV.add(choiceHeure);
		
		Choice choiceMinutes = new Choice();
		choiceMinutes.setBounds(109, 87, 49, 20);
		choiceMinutes.add("00");choiceMinutes.add("15");choiceMinutes.add("30");choiceMinutes.add("45");
		panelRDV.add(choiceMinutes);
		
		Label labelH = new Label("h");
		labelH.setBounds(94, 85, 20, 22);
		panelRDV.add(labelH);
		
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setBounds(39, 67, 46, 14);
		panelRDV.add(lblHeure);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(39, 13, 46, 14);
		panelRDV.add(lblDate);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Aujourd'hui");
		p.put("text.month", "Mois");
		p.put("text.year", "Année");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(30, 30, 150, 25);
		panelRDV.add(datePicker);
		
		
		String data[][]={ 	{"9h00","Bob Marley","Cheshire","Chat"},    
     			{"9h15","Bob Dylan","Gizmo","Chat"},    
     			{"9h30","Bob Sinclar","Rouquin","Chat"}};    
		String column[]={"Heure","Nom du client","Animal","Race"}; 
		TabRDV = new JTable(data,column);
		TabRDV.setShowHorizontalLines(false);
		TabRDV.setBounds(10, 209, 714, 224);
		JScrollPane sp=new JScrollPane(TabRDV);
		sp.setBounds(10, 209, 714, 224);
		PriseRDV.getContentPane().add(sp);

		
		JButton btnValider = new JButton(new ImageIcon("./ressources/images/BTN_Valider.png"));
		btnValider.setBounds(617, 444, 50, 51);
		PriseRDV.getContentPane().add(btnValider);
		
		JButton btnSupprimer = new JButton(new ImageIcon("./ressources/images/BTN_Supprimer_petit.png"));
		btnSupprimer.setBounds(557, 444, 50, 51);
		PriseRDV.getContentPane().add(btnSupprimer);
		PriseRDV.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		PriseRDV.setIconImage(icone);
	}
}
