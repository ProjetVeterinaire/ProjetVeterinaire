package src.fr.eni.ProjetVeterinaire.ihm.login;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class EcranLogin extends JFrame{

	public EcranLogin(){
	    JFrame fenetre = new JFrame();
	    
	    //D�finit un ti	tre pour notre fen�tre
	    fenetre.setTitle("Connexion");
	    //D�finit sa taille
	    fenetre.setSize(500, 350);
	    //Nous demandons maintenant � notre objet de se positionner au centre
	    fenetre.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	//Set la frame visible    
	fenetre.setVisible(true);
	
	Image icone = Toolkit.getDefaultToolkit().getImage("./ressources/Images/ico_veto.png"); 
	fenetre.setIconImage(icone);
	}
}
