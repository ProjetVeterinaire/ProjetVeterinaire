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

public class EcranAgenda {

	public EcranAgenda(){
		
		JFrame Agenda = new JFrame();
		
		//Définit un titre pour la fenetre
		Agenda.setTitle("Agenda");
	    //Définit sa taille
		Agenda.setSize(600, 450);
	    //Place la fenetre au cntre de l'écran
		Agenda.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		Agenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		JPanel panelAgendaDe = new JPanel();
		panelAgendaDe.setBorder(new TitledBorder(null, "De", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAgendaDe.setBounds(10, 36, 221, 133);
		Agenda.getContentPane().add(panelAgendaDe);
		panelAgendaDe.setLayout(null);
		
		
		//Set la frame visible   
		Agenda.setLayout(null); 
		Agenda.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		Agenda.setIconImage(icone);
	}
}
