package src.fr.eni.ProjetVeterinaire.bo;

public class Race {

	private String vRace;
	private String vEspece;
	
	public Race(String vRace, String vEspece) {
		super();
		this.vRace = vRace;
		this.vEspece = vEspece;
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
	
}
