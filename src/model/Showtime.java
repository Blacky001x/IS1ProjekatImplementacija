package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SHOWTIME database table.
 * 
 */
@Entity
@NamedQuery(name="Showtime.findAll", query="SELECT s FROM Showtime s")
public class Showtime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	private Movie movie;

	@OneToMany(mappedBy="showtime")
	private List<Reservation> reservations = new ArrayList<>();
	
	public Showtime() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return date.toString();
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setShowtime(this);
		
		return reservation;
	}
	
	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setShowtime(null);
		
		return reservation;
	}

}