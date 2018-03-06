/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import src.fr.eni.ProjetVeterinaire.bll.BLLException;
import src.fr.eni.ProjetVeterinaire.bo.Animal;
import src.fr.eni.ProjetVeterinaire.bo.Race;
import src.fr.eni.ProjetVeterinaire.dal.DALException;
import src.fr.eni.ProjetVeterinaire.dal.jdbc.JDBCTools;
import src.fr.eni.ProjetVeterinaire.ihm.controllers.ControllerAnimal;

public class EcranAnimaux extends JFrame {
	//JTextFields
	private JTextField vTFClient;
	private JTextField vTFNomAnimal;
	private JTextField vTFCouleur;
	private JTextField vTFTatouage;
	
	
	//Ecran
	private EcranAnimaux vEcranAnimaux;
	
	//JPanels
	private JPanel vPanelBTN;
	private JPanel vPanelClient;
	
	//JButton
	private JButton vBtnAnnuler ;
	private JButton vBtnValider;
	//JLabels
	private JLabel vLblCode;
	private JLabel vLblCodeAnimal;
	private JLabel vLblNomAnimal;
	private JLabel vLblCouleur;
	private JLabel vLblEspece;
	private JLabel vLblTatouage;
	private JLabel vLblRace;
	//Choices
	private Choice vChoiceEspece;
	private Choice vChoiceSexe;
	private Choice vChoiceRace;
	
	public EcranAnimaux() throws BLLException, DALException{
		
		vEcranAnimaux=this;
		//Définit un titre pour la fenetre
		this.setTitle("Animaux");
	    //Définit sa taille
		this.setSize(450, 325);
	    //Place la fenetre au cntre de l'écran
		this.setLocationRelativeTo(null);
	    //Termine proprement le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		//Set la frame visible   
		this.getContentPane().setLayout(null); 
		
		this.getContentPane().add(getvPanelBTN());
		
		this.getContentPane().add(getvPanelClient());
		
		this.getContentPane().add(getvLabelCode());

		this.getContentPane().add(getvLblCodeAnimal());
		
		this.getContentPane().add(getvLblNomAnimal());
		
		this.getContentPane().add(getvLblCouleur());
		
		this.getContentPane().add(getvLblEspece());
		
		this.getContentPane().add(getvLblTatouage());
		
		this.getContentPane().add(getvTextFieldNomAnimal());		

		this.getContentPane().add(getvTextFieldCouleur());
				
		this.getContentPane().add(getvChoiceSexe());
				
		this.getContentPane().add(getvTextFieldTatouage());
				
		this.getContentPane().add(getvChoiceEspece());
		
		this.getContentPane().add(getvChoiceRace());
		
		this.getContentPane().add(getvLblRace());
		
		this.setVisible(true);
		
		//Donne à la fenetre l'icone de l'application
		Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
		this.setIconImage(icone);
	}
	
	
	//GETTERS JBUTTONS
	
	public JButton getvBtnAnnuler(){
    	if ( vBtnAnnuler== null){
    		vBtnAnnuler = new JButton(new ImageIcon("./ressources/images/BTN_Annuler.png"));
    		vBtnAnnuler.setBounds(364, 0, 50, 51);
    		vBtnAnnuler.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					vEcranAnimaux.setVisible(false);
				}
			});
    	}
    	return vBtnAnnuler;
    }
	public JButton getvBtnAjouter(){
    	if ( vBtnValider== null){
    		vBtnValider = new JButton(new ImageIcon("./ressources/images/BTN_Valider.png"));
    		vBtnValider.setBounds(304, 0, 50, 51);
    		vBtnValider.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ControllerAnimal vControllerAnimal;
					Animal vAnimal = null;
					try {
						vAnimal = new Animal(0,getvTextFieldNomAnimal().getText(),getvChoiceSexe().getSelectedItem(),getvTextFieldCouleur().getText(),getvChoiceRace().getSelectedItem(),getvChoiceEspece().getSelectedItem(), 1, getvTextFieldTatouage().getText(),"",false );
					} catch (BLLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (DALException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						vControllerAnimal = ControllerAnimal.getInstance();
						vControllerAnimal.ajouter(vAnimal);
					} catch (BLLException | DALException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JDBCTools.closeConnection();
				}
			});
    	}
    	return vBtnValider;
    }
	
	//GETTERS JPANELS
	public JPanel getvPanelBTN(){
    	if (vPanelBTN== null){
    		vPanelBTN = new JPanel();
    		vPanelBTN.setBorder(new LineBorder(new Color(0, 0, 0)));
    		vPanelBTN.setBounds(10, 11, 414, 51);
    		vPanelBTN.setLayout(null);
    		vPanelBTN.add(getvBtnAnnuler());
    		vPanelBTN.add(getvBtnAjouter());
    	}
    	return vPanelBTN;
    }
	public JPanel getvPanelClient(){
    	if ( vPanelClient== null){
    		vPanelClient = new JPanel();
    		vPanelClient.setBorder(new TitledBorder(null, "Client : ", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
    		vPanelClient.setBounds(10, 73, 414, 51);
    		vPanelClient.setLayout(null);
    		vPanelClient.add(getvTextFieldClient());

    	}
    	return vPanelClient;
    }
	
	//GETTERS JTEXTFIELDS

	public JTextField getvTextFieldClient(){
    	if ( vTFClient== null){
    		vTFClient = new JTextField();
    		vTFClient.setText("1");
    		vTFClient.setBounds(30, 21, 360, 20);
    		vTFClient.setEditable(false);
    		vTFClient.setColumns(10);

    	}
    	return vTFClient;
    }
	public JTextField getvTextFieldNomAnimal(){
    	if ( vTFNomAnimal== null){
    		vTFNomAnimal = new JTextField();
    		vTFNomAnimal.setBounds(84, 150, 201, 20);
    		vTFNomAnimal.setColumns(10);
    	}
    	return vTFNomAnimal;
    }
	public JTextField getvTextFieldCouleur(){
    	if ( vTFCouleur== null){
    		vTFCouleur = new JTextField();
    		vTFCouleur.setBounds(84, 175, 201, 20);
    		vTFCouleur.setColumns(10);
    	}
    	return vTFCouleur;
    }
	
	public JTextField getvTextFieldTatouage(){
    	if ( vTFTatouage== null){
    		vTFTatouage = new JTextField();
    		vTFTatouage.setBounds(84, 228, 201, 20);
    		vTFTatouage.setColumns(10);
    	}
    	return vTFTatouage;
    }
	
	
	//GETTERS JLABELS

	public JLabel getvLabelCode(){
		if(vLblCode==null){
			vLblCode = new JLabel("Code :");
			vLblCode.setBounds(10, 135, 60, 14);
		}
		return vLblCode;
	}
	public JLabel getvLblCodeAnimal(){
		if(vLblCodeAnimal==null){
			vLblCodeAnimal = new JLabel("");
			vLblCodeAnimal.setBounds(84, 132, 75, 14);
		}
		return vLblCodeAnimal;
	}
	public JLabel getvLblNomAnimal(){
		if(vLblNomAnimal==null){
			vLblNomAnimal = new JLabel("Nom :");
			vLblNomAnimal.setBounds(10, 153, 70, 14);
		}
		return vLblNomAnimal;
	}
	public JLabel getvLblCouleur(){
		if(vLblCouleur==null){
			vLblCouleur = new JLabel("Couleur :");
			vLblCouleur.setBounds(10, 178, 70, 14);
			
		}
		return vLblCouleur;
	}
	public JLabel getvLblEspece(){
		if(vLblEspece==null){
			vLblEspece = new JLabel("Espèce :");
			vLblEspece.setBounds(10, 203, 70, 14);
		}
		return vLblEspece;
	}
	public JLabel getvLblTatouage(){
		if(vLblTatouage==null){
			vLblTatouage = new JLabel("Tatouage");
			vLblTatouage.setBounds(10, 231, 70, 14);
		}
		return vLblTatouage;
	}
	public JLabel getvLblRace(){
		if(vLblRace==null){
			vLblRace = new JLabel("Race :");
			vLblRace.setBounds(222, 198, 62, 22);
		}
		return vLblRace;
	}
	//GETTERS CHOICES

	public Choice getvChoiceEspece() throws BLLException, DALException{
		if(vChoiceEspece==null){
			ControllerAnimal vControllerAnimal = ControllerAnimal.getInstance();
			List<Race> vListeRaces =vControllerAnimal.selectRaces();
			JDBCTools.closeConnection();
			vChoiceEspece = new Choice();
			vChoiceEspece.setBounds(84, 198, 109, 20);
			for(Race vRace : vListeRaces){
				vChoiceEspece.add(vRace.getvEspece().toString());
			}
			
		}
		return vChoiceEspece;
	}
	
	public Choice getvChoiceSexe(){
		if(vChoiceSexe==null){
			vChoiceSexe = new Choice();
			vChoiceSexe.setBounds(315, 147, 109, 20);
			vChoiceSexe.add("Femelle");vChoiceSexe.add("Mâle");
		}
		return vChoiceSexe;
	}
	public Choice getvChoiceRace() throws BLLException, DALException{
		if(vChoiceRace==null){
			vChoiceRace = new Choice();
			vChoiceRace.setBounds(315, 198, 109, 20);
			ControllerAnimal vControllerAnimal = ControllerAnimal.getInstance();
			List<Race> vListeRaces =vControllerAnimal.selectRaces();
			JDBCTools.closeConnection();
			for(Race vRace : vListeRaces){
				vChoiceRace.add(vRace.getvRace().toString());
			}
		}
		return vChoiceRace;
	}
	
}
