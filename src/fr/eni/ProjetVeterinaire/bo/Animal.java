package src.fr.eni.ProjetVeterinaire.bo;

public class Animal {

	private int vCodeAnimal;
	private String vNomAnimal;
	private String vSexe;
	private String vCouleur;
	private String vRace;
	private String vEspece;
	private int vCodeClient;
	private String vTatouage;
	private String vAntecedents;
	private boolean vArchive;
	
	public Animal(int vCodeAnimal, String vNomAnimal, String vSexe, String vCouleur, String vRace, String vEspece,
			int vCodeClient, String vTatouage, String vAntecedents, boolean vArchive) {
		super();
		this.vCodeAnimal = vCodeAnimal;
		this.vNomAnimal = vNomAnimal;
		this.vSexe = vSexe;
		this.vCouleur = vCouleur;
		this.vRace = vRace;
		this.vEspece = vEspece;
		this.vCodeClient = vCodeClient;
		this.vTatouage = vTatouage;
		this.vAntecedents = vAntecedents;
		this.vArchive = vArchive;
	}

	public int getvCodeAnimal() {
		return vCodeAnimal;
	}

	public void setvCodeAnimal(int vCodeAnimal) {
		this.vCodeAnimal = vCodeAnimal;
	}

	public String getvNomAnimal() {
		return vNomAnimal;
	}

	public void setvNomAnimal(String vNomAnimal) {
		this.vNomAnimal = vNomAnimal;
	}

	public String getvSexe() {
		return vSexe;
	}

	public void setvSexe(String vSexe) {
		this.vSexe = vSexe;
	}

	public String getvCouleur() {
		return vCouleur;
	}

	public void setvCouleur(String vCouleur) {
		this.vCouleur = vCouleur;
	}

	public String getvRace() {
		return vRace;
	}

	public void setvRace(String vRace) {
		this.vRace = vRace;
	}

	public String getvEspece() {
		return vEspece;
	}

	public void setvEspece(String vEspece) {
		this.vEspece = vEspece;
	}

	public int getvCodeClient() {
		return vCodeClient;
	}

	public void setvCodeClient(int vCodeClient) {
		this.vCodeClient = vCodeClient;
	}

	public String getvTatouage() {
		return vTatouage;
	}

	public void setvTatouage(String vTatouage) {
		this.vTatouage = vTatouage;
	}

	public String getvAntecedents() {
		return vAntecedents;
	}

	public void setvAntecedents(String vAntecedents) {
		this.vAntecedents = vAntecedents;
	}

	public boolean isvArchive() {
		return vArchive;
	}

	public void setvArchive(boolean vArchive) {
		this.vArchive = vArchive;
	}
	
	
	
	
}
