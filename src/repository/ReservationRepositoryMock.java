package repository;

import java.util.ArrayList;
import java.util.List;

import model.Reservation;
import model.Showtime;
import model.User;

public class ReservationRepositoryMock implements ReservationRepository {
	
	private static List<Reservation> reservations;
	
	static {
		reservations = new ArrayList<>();
		System.out.println("Reservations created. Number of reservations: " + reservations.size());
	}
	
	public Reservation add(User user, Showtime showtime) {
		Reservation reservation = new Reservation();
		reservation = user.addReservation(reservation);
		reservation = showtime.addReservation(reservation);
		reservations.add(reservation);
		System.out.println("Reservation added. Number of reservations: " + reservations.size());
		
		return reservation;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}

}
