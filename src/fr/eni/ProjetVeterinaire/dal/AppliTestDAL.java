package src.fr.eni.ProjetVeterinaire.dal;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;



public class AppliTestDAL {

	public static void main(String[] args) throws DALException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {

		PersonnelDAO personnelDAO = DAOFactory.getPersonnelDAO();

//
//
//
//			personnelDAO.selectConnexion(, aMotDePasse);
//			List<Client> clients = clientDAO.selectAll();
//			System.out.println("Selection de tous les clients  : " + clients.toString() );
//			Client client = clientDAO.selectById(1);
//			System.out.println("Selection du client  : " + client.toString() );
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
//
//			java.util.Date utilDate = simpleDateFormat.parse("2018/12/31");
//			java.sql.Date vdate = new java.sql.Date(utilDate.getTime());
//			
//			
//			
//			Spectacle vSpectacle = spectacleDAO.selectById(1);
//			System.out.println("Premier Spectacle : " + vSpectacle.toString() );
//						
//			Reservation vReservation = new Reservation( 1, 1, 3,vdate);
////			Reservation vReservation2 = new Reservation( 1, 1, 2,vdate);
//
//			reservationDAO.insert(vReservation);
////			reservationDAO.insert(vReservation2);
//			
//			List<Reservation> vReservationsRecupereesviaIDClient = reservationDAO.selectByClient(1);
//			System.out.println("\n\n");
//			System.out.println("Les reservations recuperees via idclient sont : "+vReservationsRecupereesviaIDClient.get(0)+vReservationsRecupereesviaIDClient.get(1));
//	
//			Client vClientasupprimmerdelabase =clientDAO.selectById(2);
//			System.out.println(vClientasupprimmerdelabase);
//			clientDAO.delete(2);
//			Client vClientnormalementsupprimedelabase =clientDAO.selectById(2);
//			System.out.println(vClientnormalementsupprimedelabase);
	}

}
