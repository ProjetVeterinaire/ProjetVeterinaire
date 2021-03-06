/*
 * Auteur : Gauthier LEFEVRE /Ronan GODICHEAU-TORNIER
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm.ecranPersonnel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.jdbc.JDBCTools;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerPersonnel;

public class EcranGestionPersonnel extends JFrame{
	private JButton btn_ajouter;
	private JButton btn_reinitialiser;
	private JButton btn_supprimer;
	private JPanel userList;
	private JPanel panelBTN;
	private ButtonGroup groupRadio;
	private JLabel vLabelNomPersonneli;
	private JLabel vLabelRolei;
	private JLabel vLabelPasswordi;
	private JRadioButton vRadioSelecti;
	private TablePersonnel vTablePersonnel;
	private JScrollPane vJScrollPane;
	private EcranGestionPersonnel vEcranGestionPersonnel;

	public EcranGestionPersonnel(Personnel aPersonnel) throws BLLException{
		vEcranGestionPersonnel=this;
		JPanel vPanel = new JPanel();
		setContentPane(vPanel);
		//Définit un titre pour la fenetre
		this.setTitle("Gestion du personnel");
	    //Définit sa taille
		this.setSize(700, 500);
	    //Place la fenetre au cntre de l'écran
		this.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    
		
		
		//Second panel avec la liste des utilisateur
		JPanel userList = new JPanel();
		userList.setBounds(25, 145, 640, 275);
		userList.setBorder(BorderFactory.createLineBorder(Color.black));
		userList.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		
		
		


		vPanel.add(getPanelBTN());
		vJScrollPane = new JScrollPane(getvTablePersonnel());
		vPanel.add(vJScrollPane);
        
		this.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		this.setIconImage(icone);
	}
	
	public TablePersonnel getvTablePersonnel() throws BLLException {
		if(vTablePersonnel==null){
			vTablePersonnel=new TablePersonnel();
			vTablePersonnel.setFillsViewportHeight(true);
			vTablePersonnel.setPreferredScrollableViewportSize(new Dimension(400,200));
			vTablePersonnel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		}
		return vTablePersonnel;
	}
	
	public JPanel getPanelBTN(){
		if (panelBTN == null){
			panelBTN = new JPanel();	//Creer le premier panel pour stocker les "boutons"
			panelBTN.setBounds(25, 25, 640, 95); //Le dimensionne
			panelBTN.setBorder(BorderFactory.createLineBorder(Color.black));
			
			
			panelBTN.add(getBtn_Ajouter());panelBTN.add(getBtn_Archiver());panelBTN.add(getBtn_Reinitialiser());		

    	}
    	return panelBTN;
	}
	public JButton getBtn_Ajouter(){
    	if (btn_ajouter == null){
    		btn_ajouter=new JButton(new ImageIcon("./ressources/images/BTN_Ajouter.png"));
    		btn_ajouter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new EcranAddPersonnel(vEcranGestionPersonnel);
				}
			});
    	}
    	return btn_ajouter;
    }
	public JButton getBtn_Archiver(){
    	if (btn_supprimer == null){
    		btn_supprimer=new JButton(new ImageIcon("./ressources/images/BTN_Supprimer.png"));
    		btn_supprimer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						ControllerPersonnel vControllerPersonnel = ControllerPersonnel.getInstance();
						vControllerPersonnel.archiver(getvTablePersonnel().getValueAt(getvTablePersonnel().getSelectedRow(), 0).toString());
						JDBCTools.closeConnection();
						vEcranGestionPersonnel.getvTablePersonnel().setModel(new DataModelPersonnel(vControllerPersonnel.selectAll()));
						
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JDBCTools.closeConnection();
				}
			});
    	}
    	return btn_supprimer;
    }
	public void modifierMotDePasseTable(String aValue, int row, int column) throws BLLException{
		getvTablePersonnel().setValueAt(aValue, row, column);
	}
	public JButton getBtn_Reinitialiser(){
    	if (btn_reinitialiser == null){
    		btn_reinitialiser=new JButton(new ImageIcon("./ressources/images/BTN_Reinitialiser.png"));
    		btn_reinitialiser.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						ControllerPersonnel vControllerPersonnel = ControllerPersonnel.getInstance();
						new EcranReinitialiserMotDePasse(getvTablePersonnel().getValueAt(getvTablePersonnel().getSelectedRow(), 0).toString(),vEcranGestionPersonnel);
						
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
    	}
    	return btn_reinitialiser;
    }
}
