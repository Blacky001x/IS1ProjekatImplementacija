package service;

import java.util.List;

import model.Reservation;
import model.Showtime;
import model.User;

public interface ReservationService {
	
	Reservation add(User user, Showtime showtime);
	List<Reservation> getReservations();

}
