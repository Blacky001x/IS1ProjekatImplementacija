package service;

import java.util.List;

import model.Genres;
import model.Movie;

public interface MovieService {
	
	List<Movie> getMovies();
	List<Movie> findMoviesByGenre(List<Genres> genres);

}
