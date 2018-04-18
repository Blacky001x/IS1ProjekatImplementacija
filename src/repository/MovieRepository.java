package repository;

import java.util.List;

import model.Genres;
import model.Movie;

public interface MovieRepository {
	
	List<Movie> getMovies();
	List<Movie> findMoviesByGenre(List<Genres> genres);

}
