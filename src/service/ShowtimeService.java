package service;

import java.util.List;

import model.Movie;
import model.Showtime;

public interface ShowtimeService {

	void add(Movie movie, Showtime showtime);
	List<Showtime> findShowtimesByMovie(Movie movie);
	
}
