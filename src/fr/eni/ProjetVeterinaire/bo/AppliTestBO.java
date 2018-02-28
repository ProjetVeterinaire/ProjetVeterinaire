package src.fr.eni.ProjetVeterinaire.bo;
/**
 * Author : Ronan GODICHEAU (26/02/2018)
 * **/
public class AppliTestBO {

	public static void main(String[] args) {
		/*----Test du Personnel------*/
		Personnel vPersonnel = new Personnel(0123, "Jade Orl�cha", "Fd454q2d1sdD","Veterinaire",false);
		System.out.println("-------------Apr�s Cr�ation du personnel------------");
		System.out.println("\n"+vPersonnel.toString()+"\n");

		
		/*----Test du client------*/
		Client vClient = new Client(0, "Ramel", "Mika", "19, rue des abysses", "", "42190", "Laba","0665044064","FrigAssur","carantrod�bar@gmail.com","",false );
		System.out.println("-------------Apr�s Cr�ation du client------------");
		System.out.println("\n"+vClient.toString());
		System.out.println("\n-------------Apr�s modifications(adresse2+telephone)------------");
		vClient.setvAdresse2("12, rue du march�");
		vClient.setvNumTel("0656564545");
		System.out.println("\n"+vClient.toString());
	}

}
