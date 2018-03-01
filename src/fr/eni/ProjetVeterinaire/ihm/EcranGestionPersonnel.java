/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bo.Personnel;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerLogin;
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
	public EcranGestionPersonnel(Personnel aPersonnel) throws BLLException{
		
		
		//Définit un titre pour la fenetre
		this.setTitle("Gestion du personnel");
	    //Définit sa taille
		this.setSize(700, 500);
	    //Place la fenetre au cntre de l'écran
		this.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
		
		
		//Second panel avec la liste des utilisateur
		JPanel userList = new JPanel();
		userList.setBounds(25, 145, 640, 275);
		userList.setBorder(BorderFactory.createLineBorder(Color.black));
		userList.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		
		
		
        ButtonGroup groupRadio = new ButtonGroup();  
        
        ControllerPersonnel vControllerPersonnel = ControllerPersonnel.getInstance();
        ArrayList<Personnel> vListePersonnels = vControllerPersonnel.selectAll(); 
        for(int i =0; i<vListePersonnels.size();i++){
        	Personnel vPersonneli = vListePersonnels.get(i);
        	if(!vPersonneli.isvArchive()){
        		vLabelNomPersonneli=new JLabel(vPersonneli.getvNom());
            	vLabelRolei=new JLabel(vPersonneli.getvRole());
            	vLabelPasswordi=new JLabel(vPersonneli.getvMotDePasse());
            	vRadioSelecti=new JRadioButton();
            	

            	gbc.gridy=i;
            	gbc.gridx=0;
            	userList.add(vLabelNomPersonneli,gbc);
            	gbc.gridx=1;
        		gbc.insets = new Insets(0,150,0,0);
        		userList.add(vLabelRolei,gbc);
            	gbc.gridx=2;
        		gbc.insets = new Insets(0,20,0,0);
        		userList.add(vLabelPasswordi,gbc);
            	gbc.gridx=3;
        		gbc.insets = new Insets(0,10,0,0);
        		groupRadio.add(vRadioSelecti);
        		userList.add(vRadioSelecti,gbc);

        	}
        }

		//Set la frame visible   
        this.add(getPanelBTN());
		this.add(userList);
		this.setLayout(null); 
		this.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		this.setIconImage(icone);
	}
	
	
	public JPanel getPanelBTN(){
		if (panelBTN == null){
			panelBTN = new JPanel();	//Creer le premier panel pour stocker les "boutons"
			panelBTN.setBounds(25, 25, 640, 95); //Le dimensionne
			panelBTN.setBorder(BorderFactory.createLineBorder(Color.black));
			
			
			panelBTN.add(getBtn_Ajouter());panelBTN.add(getBtn_Supprimer());panelBTN.add(getBtn_Reinitialiser());		

    	}
    	return panelBTN;
	}
	public JButton getBtn_Ajouter(){
    	if (btn_ajouter == null){
    		btn_ajouter=new JButton(new ImageIcon("./ressources/images/BTN_Ajouter.png"));
    		btn_ajouter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new EcranAddPersonnel();
					setVisible(false);
				}
			});
    	}
    	return btn_ajouter;
    }
	public JButton getBtn_Supprimer(){
    	if (btn_supprimer == null){
    		btn_supprimer=new JButton(new ImageIcon("./ressources/images/BTN_Supprimer.png"));
    		btn_supprimer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
    	}
    	return btn_supprimer;
    }
	public JButton getBtn_Reinitialiser(){
    	if (btn_reinitialiser == null){
    		btn_reinitialiser=new JButton(new ImageIcon("./ressources/images/BTN_Reinitialiser.png"));
    		btn_reinitialiser.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
    	}
    	return btn_reinitialiser;
    }
}
