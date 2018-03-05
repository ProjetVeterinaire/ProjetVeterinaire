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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import src.fr.eni.ProjetVeterinaire.ihm.controllers.DateLabelFormatter;

import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTable;

public class EcranAgenda {
	private JTable TabAgenda;
	private JButton btnDocMedic;

	public EcranAgenda(){
		
		JFrame Agenda = new JFrame();
		
		//Définit un titre pour la fenetre
		Agenda.setTitle("Agenda");
	    //Définit sa taille
		Agenda.setSize(800, 580);
	    //Place la fenetre au cntre de l'écran
		Agenda.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		Agenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		JPanel panelAgendaDe = new JPanel();
		panelAgendaDe.setBorder(new TitledBorder(null, "De", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAgendaDe.setBounds(15, 20, 750, 70);
		Agenda.getContentPane().add(panelAgendaDe);
		panelAgendaDe.setLayout(null);
		
		JLabel lblVeterinaire = new JLabel("Vétérinaire :");
		lblVeterinaire.setBounds(34, 26, 76, 14);
		panelAgendaDe.add(lblVeterinaire);
		
		Choice choiceVeto = new Choice();
		choiceVeto.setBounds(116, 20, 120, 20);
		choiceVeto.add("Papy Grenier");choiceVeto.add("Jack Sparrow");choiceVeto.add("Henri Potdebeurre");
		panelAgendaDe.add(choiceVeto);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Aujourd'hui");
		p.put("text.month", "Mois");
		p.put("text.year", "Année");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(350, 20, 150, 25);
		panelAgendaDe.add(datePicker);
		
		String data[][]={ 	{"9h00","Bob Marley","Cheshire","Chat"},    
     			{"9h15","Bob Dylan","Gizmo","Chat"},    
     			{"9h30","Bob Sinclar","Rouquin","Chat"}};    
		String column[]={"Heure","Nom du client","Animal","Race"}; 
		TabAgenda = new JTable(data,column);
		TabAgenda.setShowHorizontalLines(false);
		TabAgenda.setBounds(15, 125, 750, 311);
		JScrollPane sp=new JScrollPane(TabAgenda);
		sp.setBounds(15, 125, 750, 311);
		Agenda.getContentPane().add(sp);
		
		btnDocMedic = new JButton(new ImageIcon("./ressources/images/BTN_dossier50x45.png"));
		btnDocMedic.setBounds(670,449,50,45);
		Agenda.getContentPane().add(btnDocMedic);
		
		JLabel lblDocMedical = new JLabel("Dossier Médical");
		lblDocMedical.setBounds(654, 495, 96, 14);
		Agenda.getContentPane().add(lblDocMedical);
		
		//Set la frame visible   
		Agenda.getContentPane().setLayout(null); 
		Agenda.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		Agenda.setIconImage(icone);
	}
}
