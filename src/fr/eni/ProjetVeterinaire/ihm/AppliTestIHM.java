/*
 * Auteur : Gauthier LEFEVRE 
 * ENI
 * Projet client - serveur JAVA  / Groupe 3
 * 
 */

package src.fr.eni.ProjetVeterinaire.ihm;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AppliTestIHM implements ActionListener{

	private JButton btnConnexion;
	
	public void ActionListener(JButton btnConnexion){
	this.btnConnexion=btnConnexion;

	}
	
	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		JOptionPane.showMessageDialog(
			    btnConnexion, "Eggs are not supposed to be green.");
		
	}
	
	
	/*btnConnexion.addActionListener(new ActionListener(){  
		public void actionPerformed(ActionEvent e){  
			TFNom.setText("TEST BTN");  
		        }  
		    });  */
}
