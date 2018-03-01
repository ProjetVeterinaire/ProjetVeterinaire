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
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerPersonnel;

public class EcranAddPersonnel extends JDialog{
	private JTextField vTFNom;
	private JTextField vTFPrenom;
	private JComboBox vComboBox;
	private JPasswordField vPasswordField;
	private JButton btn_ajouter;


	public EcranAddPersonnel(){
			
			
			//Définit un titre pour la fenetre
			this.setTitle("Ajouter un personnel");
		    //Définit sa taille
			this.setSize(350, 215);
		    //Place la fenetre au cntre de l'écran
			this.setLocationRelativeTo(null);
		    //Termine proprement le processus lorsqu'on clique sur la croix rouge
			this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
			//Set en fenetre modale
			this.setModalityType(ModalityType.DOCUMENT_MODAL);
			//Donne à la fenetre l'icone de l'application
			Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
			this.setIconImage(icone);
			//Layout 
			
			getContentPane().setLayout(
				    new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)
				);
			//Ajout des composants de la fenetre
			JLabel vNom = new JLabel("Entrez le nom :");
			JLabel vPrenom = new JLabel("Entrez le prénom :");
			JLabel vMotPasse = new JLabel("Entrez le mot de passe :");
			JLabel vChoixRole = new JLabel("Choisissez votre role :");
		
			getComboBoxRole().addItem("Sec");
			getComboBoxRole().addItem("Adm");
			getComboBoxRole().addItem("Vet");
			
			this.add(vNom);
			this.add(getTextFieldNom());
			this.add(vPrenom);
			this.add(getTextFieldPrenom());
			this.add(vMotPasse);
			this.add(getPasswordField());
			this.add(vChoixRole);
			this.add(getComboBoxRole());
			this.add(getBtn_Ajouter());
			//Set la frame visible   
			
			this.setVisible(true);
			

	}
	public JButton getBtn_Ajouter(){
    	if (btn_ajouter == null){
    		btn_ajouter = new JButton("Ajouter");
    		btn_ajouter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						ControllerPersonnel vControllerPersonnel = ControllerPersonnel.getInstance();
						try {
							vControllerPersonnel.ajouter(getTextFieldNom().getText(), getTextFieldPrenom().getText(), String.valueOf(getPasswordField().getPassword()), getComboBoxRole().getSelectedItem().toString());
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
    	return btn_ajouter;
    }
	public JComboBox<String> getComboBoxRole(){
		if (vComboBox == null){
			vComboBox = new JComboBox<String>();	
    	}
    	return vComboBox;
	}
	public JTextField getTextFieldPrenom(){
		if (vTFPrenom == null){
			vTFPrenom = new JTextField();	
    	}
    	return vTFPrenom;
	}
	public JTextField getTextFieldNom(){
		if (vTFNom == null){
			vTFNom = new JTextField();	
    	}
    	return vTFNom;
	}
	public JPasswordField getPasswordField(){
		if (vPasswordField == null){
			vPasswordField = new JPasswordField();	
		}
    	return vPasswordField;
	}
}
