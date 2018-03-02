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
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;

public class EcranResultRecherche {
	private JTextField TFRecherche;
	private JTable TabRecherche;

	public EcranResultRecherche(){
		
		JFrame ResultRecherche = new JFrame();
		
		//Définit un titre pour la fenetre
		ResultRecherche.setTitle("Resultat de la recherche");
	    //Définit sa taille
		ResultRecherche.setSize(500, 300);
	    //Place la fenetre au cntre de l'écran
		ResultRecherche.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		ResultRecherche.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
		
		//Set la frame visible   
		ResultRecherche.getContentPane().setLayout(null); 
		
		JPanel panelRecherche = new JPanel();
		panelRecherche.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelRecherche.setBounds(10, 11, 464, 51);
		ResultRecherche.getContentPane().add(panelRecherche);
		panelRecherche.setLayout(null);
		
		JButton btnRecherche = new JButton(new ImageIcon("./ressources/images/BTN_Recherche_petit.png"));
		btnRecherche.setBounds(375, 0, 50, 51);
		panelRecherche.add(btnRecherche);
		
		TFRecherche = new JTextField();
		TFRecherche.setBounds(117, 15, 200, 20);
		panelRecherche.add(TFRecherche);
		TFRecherche.setColumns(10);
		
		JLabel lblRecherche = new JLabel("Recherche :");
		lblRecherche.setBounds(40, 18, 68, 14);
		panelRecherche.add(lblRecherche);
		
		
		
		String data[][]={ 	{"Marley","Bob","12345","Marseille"},    
     			{"Dylan","Bob","67891","Paris"},    
     			{"Sinclar","Bob","34567","Nantes"}};    
		String column[]={"Nom","Prenom","Code Postal","Ville"}; 

		
		TabRecherche = new JTable(data,column);
		TabRecherche.setCellSelectionEnabled(true);
		TabRecherche.setShowVerticalLines(false);
		TabRecherche.setColumnSelectionAllowed(true);
		
		JScrollPane sp=new JScrollPane(TabRecherche);
		sp.setBounds(10, 75, 464, 175);
		ResultRecherche.getContentPane().add(sp);		
		
		ResultRecherche.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		ResultRecherche.setIconImage(icone);
	}
}
