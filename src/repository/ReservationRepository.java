package repository;

import java.util.List;

import model.Reservation;
import model.Showtime;
import model.User;

public interface ReservationRepository {
	
	Reservation add(User user, Showtime showtime);
	List<Reservation> getReservations();

}
