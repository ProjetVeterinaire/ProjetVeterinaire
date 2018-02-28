package src.fr.eni.ProjetVeterinaire.bo;
/**
 * Author : Ronan GODICHEAU (26/02/2018)
 * **/
public class Personnel {

	private int vCodePers;
	private String vNom;
	private String vMotDePasse;
	private String vRole;
	private boolean vArchive;
	//constructeur
	public Personnel(int vCodePers, String vNom, String vMotDePasse, String vRole, boolean vArchive) {
		super();
		this.vCodePers = vCodePers;
		this.vNom = vNom;
		this.vMotDePasse = vMotDePasse;
		this.vRole = vRole;
		this.vArchive = vArchive;
	}
	//getters & setters
	public String getvNom() {
		return vNom;
	}
	public void setvNom(String vNom) {
		this.vNom = vNom;
	}
	public String getvMotDePasse() {
		return vMotDePasse;
	}
	public void setvMotDePasse(String vMotDePasse) {
		this.vMotDePasse = vMotDePasse;
	}
	public String getvRole() {
		return vRole;
	}
	public void setvRole(String vRole) {
		this.vRole = vRole;
	}
	public boolean isvArchive() {
		return vArchive;
	}
	public void setvArchive(boolean vArchive) {
		this.vArchive = vArchive;
	}
	public int getvCodePers() {
		return vCodePers;
	}
	public void setvCodePers(int vCodePers){
		this.vCodePers = vCodePers;
	}
	
	@Override
	public String toString() {
		return "Personnel [Nom=" + getvNom() + ", Mot De Passe=" + getvMotDePasse() + ", Role="
				+ getvRole() + ", Archive=" + isvArchive() + ", Code Personnel=" + getvCodePers() + "]";
	}
	
}
