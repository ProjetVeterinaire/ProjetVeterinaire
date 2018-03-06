package src.fr.eni.ProjetVeterinaire.dal;


public class DAOFactory {
	
	public static ConnexionDAO getConnexionDAO()  {
		ConnexionDAO connexionDAO=null;
		try {
			connexionDAO=(ConnexionDAO ) Class.forName("src.fr.eni.ProjetVeterinaire.dal.jdbc.ConnexionDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connexionDAO; 
	}
	public static PersonnelDAO getPersonnelDAO()  {
		PersonnelDAO personnelDAO=null;
		try {
			personnelDAO=(PersonnelDAO ) Class.forName("src.fr.eni.ProjetVeterinaire.dal.jdbc.PersonnelDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personnelDAO; 
	}
	
	public static ClientDAO getClientDAO()  {
		ClientDAO clientDAO=null;
		try {
			clientDAO=(ClientDAO ) Class.forName("src.fr.eni.ProjetVeterinaire.dal.jdbc.ClientDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientDAO; 
	}
	
	public static AnimauxDAO getAnimauxDAO()  {
		AnimauxDAO animauxDAO=null;
		try {
			animauxDAO=(AnimauxDAO ) Class.forName("src.fr.eni.ProjetVeterinaire.dal.jdbc.AnimauxDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return animauxDAO; 
	}
	

}
