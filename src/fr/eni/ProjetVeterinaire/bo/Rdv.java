package src.fr.eni.ProjetVeterinaire.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Rdv {
	private int vCodeVeterinaire;
	private int vCodeAnimal;
	private Date vDate;
	private SimpleDateFormat vSimpleDateFormat;
	private String vDateStr;
	
	public  Rdv(int aCodeVeterinaire,Date aDate, int aCodeAnimal){
		super();
		this.vCodeVeterinaire= aCodeVeterinaire;
		this.vCodeAnimal=aCodeAnimal;
		this.vDate=aDate;
		this.vSimpleDateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm");
		this.vDateStr = vSimpleDateFormat.format(vDate);


	}

	public int getHeure() {
		return Integer.valueOf(vDateStr.split("(?!^)")[11]+vDateStr.split("(?!^)")[12]);

	}

	public int getMinutes() {
		return Integer.valueOf(vDateStr.split("(?!^)")[14]+vDateStr.split("(?!^)")[15]);
	}

	public int getvCodeVeterinaire() {
		return vCodeVeterinaire;
	}

	public int getvCodeAnimal() {
		return vCodeAnimal;
	}

	public String getvDate() {
		return vDateStr;
	}

	
}

