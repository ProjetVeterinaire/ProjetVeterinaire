package src.fr.eni.ProjetVeterinaire.dal;


public class DAOFactory {
	
	public static PersonnelDAO getPersonnelDAO()  {
		PersonnelDAO personnelDAO=null;
		try {
			personnelDAO=(PersonnelDAO ) Class.forName("src.fr.eni.ProjetVeterinaire.dal.jdbc.ConnexionDAOJdbcImpl").newInstance();
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
	
	

}
