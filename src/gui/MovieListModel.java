package gui;

import java.util.List;

import javax.swing.AbstractListModel;
import repository.MovieRepositoryMock;
import model.Genres;
import model.Movie;

public class MovieListModel extends AbstractListModel<Movie> {
	
	private static final long serialVersionUID = 1L;
	private List<Movie> movies;
	
	public MovieListModel() {
		reset();
	}

	@Override
	public int getSize() {
		return movies.size();
	}

	@Override
	public Movie getElementAt(int index) {
		return movies.get(index);
	}
	
	public void add(Movie movie) {
		movies.add(movie);
	}
	
	public void reset() {
		MovieRepositoryMock repo = new MovieRepositoryMock();
		movies = repo.getMovies();
		fireContentsChanged(movies, 0, movies.size());
	}

	public void filterByGenre(List<Genres> genres) {
		MovieRepositoryMock repo = new MovieRepositoryMock();
		movies = repo.findMoviesByGenre(genres);
		fireContentsChanged(movies, 0, movies.size());
	}
	
}
