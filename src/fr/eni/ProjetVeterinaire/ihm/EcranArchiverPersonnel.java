/*
 * Auteur : Ronan GODICHEAU-TORNIER
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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bll.PersonnelManager;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerPersonnel;

public class EcranArchiverPersonnel extends JDialog{
	private JTextField vTFNom;
	private JTextField vTFPrenom;
	private JComboBox vComboBox;
	private JPasswordField vPasswordField;
	private JButton btn_archiver;


	public EcranArchiverPersonnel() throws BLLException{
			
			
			//Définit un titre pour la fenetre
			this.setTitle("Archiver un personnel");
		    //Définit sa taille
			this.setSize(350, 100);
		    //Place la fenetre au cntre de l'écran
			this.setLocationRelativeTo(null);
		    //Termine proprement le processus lorsqu'on clique sur la croix rouge
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//Set en fenetre modale
			this.setModalityType(ModalityType.DOCUMENT_MODAL);
			//Donne à la fenetre l'icone de l'application
			Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
			this.setIconImage(icone);
			//Layout
			getContentPane().setLayout(
				    new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)
				);
			
			
			PersonnelManager vPersonnelManager = PersonnelManager.getInstance();
			ArrayList<Personnel> vListePersonnel = vPersonnelManager.selectAllSansRDV();
			for(Personnel vPersonneli : vListePersonnel){
				getComboBoxPersonnels().addItem(vPersonneli.getvNom());
			}
						
			
			this.add(getComboBoxPersonnels());
			this.add(getBtn_Archiver());
			//Set la frame visible   
			
			this.setVisible(true);
			

	}
	public JButton getBtn_Archiver(){
    	if (btn_archiver == null){
    		btn_archiver = new JButton("Archiver");
    		btn_archiver.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						ControllerPersonnel vControllerPersonnel = ControllerPersonnel.getInstance();
						try {
							vControllerPersonnel.archiver(getComboBoxPersonnels().getSelectedItem().toString());
						} catch (DALException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
    	}
    	return btn_archiver;
    }
	public JComboBox<String> getComboBoxPersonnels(){
		if (vComboBox == null){
			vComboBox = new JComboBox<String>();	
    	}
    	return vComboBox;
	}

}
