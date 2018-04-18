package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Movie;
import model.Showtime;

public class ShowtimeRepositoryMock implements ShowtimeRepository {
	
	private static List<Showtime> showtimes;
	
	static {
		showtimes = new ArrayList<>();
	}
	
	/**
	 * Method that finds all showtimes for a specific movie
	 * @param movie for which we are trying to find showtimes
	 * @return list of showtimes for that specific movies
	 */
	public List<Showtime> findShowtimesByMovie(Movie movie) {
		return showtimes.stream()
				.filter(showtime -> showtime.getMovie().equals(movie))
				.collect(Collectors.toList());
	}
	
	public void add(Movie movie, Showtime showtime) {
		showtime.setMovie(movie);
		showtimes.add(showtime);
		movie.getShowtimes().add(showtime);
	}

}
