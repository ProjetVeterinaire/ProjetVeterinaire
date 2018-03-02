/*
 * Auteur : Ronan GODICHEAU-TORNIER
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.ecranPersonnel;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bll.PersonnelManager;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.jdbc.JDBCTools;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerPersonnel;

public class EcranReinitialiserMotDePasse extends JDialog{
	private JTextField vTFNouveauMotPasse;
	private JComboBox vComboBox;
	private JButton btn_reinitialiser;
	private String vNomPersonnel;
	private EcranGestionPersonnel  vEcranGestionPersonnel;
	private EcranReinitialiserMotDePasse vEcranReinitialiserMotDePasse;
	
	public EcranReinitialiserMotDePasse(String nomPersonnel,EcranGestionPersonnel aEcranGestionPersonnel) throws BLLException{
			vEcranReinitialiserMotDePasse = this;
			vNomPersonnel=nomPersonnel;
			vEcranGestionPersonnel=aEcranGestionPersonnel;
			//Définit un titre pour la fenetre
			this.setTitle("Reinitialiser le mot de passe d'un personnel");
		    //Définit sa taille
			this.setSize(350, 150);
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
			
			
	
		
						
			
			
			JLabel vLabelMotPasse = new JLabel("Nouveau Mot de Passe :");
			this.add(vLabelMotPasse);
			this.add(getTFMotPasse());
			this.add(getBtn_Reinitialiser());
			//Set la frame visible   
			
			this.setVisible(true);
			

	}
	public JTextField getTFMotPasse(){
		if (vTFNouveauMotPasse == null){
			vTFNouveauMotPasse = new JTextField();	
    	}
    	return vTFNouveauMotPasse;
	}
	public JButton getBtn_Reinitialiser(){
    	if (btn_reinitialiser == null){
    		btn_reinitialiser = new JButton("Reinitialiser");
    		btn_reinitialiser.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						ControllerPersonnel vControllerPersonnel = ControllerPersonnel.getInstance();
						try {
							vControllerPersonnel.reinitialiser(vNomPersonnel,getTFMotPasse().getText());
							JDBCTools.closeConnection();
							vEcranGestionPersonnel.getvTablePersonnel().setModel(new DataModelPersonnel(vControllerPersonnel.selectAll()));
							vEcranReinitialiserMotDePasse.setVisible(false);
						} catch (DALException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JDBCTools.closeConnection();

				}
			});
    	}
    	return btn_reinitialiser;
    }
	public JComboBox<String> getComboBoxPersonnels(){
		if (vComboBox == null){
			vComboBox = new JComboBox<String>();	
    	}
    	return vComboBox;
	}

}
