package repository;

import java.util.List;

import model.Movie;
import model.Showtime;

public interface ShowtimeRepository {

	void add(Movie movie, Showtime showtime);
	List<Showtime> findShowtimesByMovie(Movie movie);
	
}
