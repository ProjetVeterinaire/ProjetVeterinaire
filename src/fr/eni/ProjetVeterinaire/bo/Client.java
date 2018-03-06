package src.fr.eni.ProjetVeterinaire.bo;

/**
 * Author : Ronan GODICHEAU (26/02/2018)
 * **/
public class Client {
	private int vCodeClient;
	private String vNomClient;
	private String vPrenomClient;
	private String vAdresse1;
	private String vAdresse2;
	private String vCode_postal;
	private String vVille;
	private String vNumTel;
	private String vAssurance;
	private String vEmail;
	private String vRemarque;
	private boolean vArchive;
	
	public Client(int vCodeClient, String vNomClient, String vPrenomClient, String vAdresse1, String vAdresse2,
			String vCode_postal, String vVille, String vNumTel, String vAssurance, String vEmail, String vRemarque,
			boolean vArchive) {
		super();
		this.vCodeClient = vCodeClient;
		this.vNomClient = vNomClient;
		this.vPrenomClient = vPrenomClient;
		this.vAdresse1 = vAdresse1;
		this.vAdresse2 = vAdresse2;
		this.vCode_postal = vCode_postal;
		this.vVille = vVille;
		this.vNumTel = vNumTel;
		this.vAssurance = vAssurance;
		this.vEmail = vEmail;
		this.vRemarque = vRemarque;
		this.vArchive = vArchive;
	}
	

	public void setvCodeClient(int aCode) {
		this.vCodeClient= aCode;
	}
	public int getvCodeClient() {
		return vCodeClient;
	}

	public String getvNomClient() {
		return vNomClient;
	}

	public void setvNomClient(String vNomClient) {
		this.vNomClient = vNomClient;
	}

	public String getvPrenomClient() {
		return vPrenomClient;
	}

	public void setvPrenomClient(String vPrenomClient) {
		this.vPrenomClient = vPrenomClient;
	}

	public String getvAdresse1() {
		return vAdresse1;
	}

	public void setvAdresse1(String vAdresse1) {
		this.vAdresse1 = vAdresse1;
	}

	public String getvAdresse2() {
		return vAdresse2;
	}

	public void setvAdresse2(String vAdresse2) {
		this.vAdresse2 = vAdresse2;
	}

	public String getvCode_postal() {
		return vCode_postal;
	}

	public void setvCode_postal(String vCode_postal) {
		this.vCode_postal = vCode_postal;
	}

	public String getvVille() {
		return vVille;
	}

	public void setvVille(String vVille) {
		this.vVille = vVille;
	}

	public String getvNumTel() {
		return vNumTel;
	}

	public void setvNumTel(String vNumTel) {
		this.vNumTel = vNumTel;
	}

	public String getvAssurance() {
		return vAssurance;
	}

	public void setvAssurance(String vAssurance) {
		this.vAssurance = vAssurance;
	}

	public String getvEmail() {
		return vEmail;
	}

	public void setvEmail(String vEmail) {
		this.vEmail = vEmail;
	}

	public String getvRemarque() {
		return vRemarque;
	}

	public void setvRemarque(String vRemarque) {
		this.vRemarque = vRemarque;
	}

	public boolean isvArchive() {
		return vArchive;
	}

	public void setvArchive(boolean vArchive) {
		this.vArchive = vArchive;
	}

	public String toString(){
		return getvNomClient();
	}




}
