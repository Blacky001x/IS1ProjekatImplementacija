package repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import model.Genres;
import model.Movie;
import model.Showtime;

public class MovieRepositoryMock implements MovieRepository {
	
	private static List<Movie> movies;

	static {
		movies = new ArrayList<>();
		
		Movie m1 = new Movie();
		m1.setName("Putnik");
		m1.setDescription("Ovaj intenzivni, inteligentni akcioni triler na velike ekrane donosi pravu filmsku poslasticu za sve ljubitelje kvalitetne kombinacije misterije, napetosti i akcije. Napeta filmska priča o biznismenu koji je uhvaćen u kriminalnim radnjama, jednog naizgled običnog dana, kada se vraćao kući sa posla.");
		m1.setGenre(Genres.AKCIONI);
		
		Movie m2 = new Movie();
		m2.setName("Gordosti i predrasude");
		m2.setDescription("Gordost i predrasuda je britanski romantični film režisera Džoa Rajta, baziran na romanu Džejn Ostin istog naslova.");
		m2.setGenre(Genres.ROMANTIKA);
		
		Movie m3 = new Movie();
		m3.setName("Mrtav ladan");
		m3.setDescription("Mrtav ’ladan je domaća filmska komedija iz 2002. godine, scenariste i režisera Milorada Milinkovića. Glavne uloge tumače Nenad Jezdić, Srđan Todorović, Mihajlo Bata Paskaljević i Nikola Đuričko.");
		m3.setGenre(Genres.KOMEDIJA);
		
		
		
		try {
			ShowtimeRepositoryMock repo = new ShowtimeRepositoryMock();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			Showtime showtime1 = new Showtime();
			Date date = sdf.parse("2018-05-05");
			showtime1.setDate(date);
			
			Showtime showtime2 = new Showtime();
			date = sdf.parse("2018-05-06");
			showtime2.setDate(date);
			
			Showtime showtime3 = new Showtime();
			date = sdf.parse("2018-06-06");
			showtime3.setDate(date);
			
			repo.add(m1, showtime1);
			repo.add(m2, showtime2);
			repo.add(m2, showtime3);
			
			
		} catch (ParseException e) {
			System.out.println("DESILA SE GRESKA: " + e.getMessage());
			e.printStackTrace();
		}
		
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
	}

	/**
	 * Finds all the movies with specific type of genre(s)
	 * @param genres list of genres used in filtering
	 * @return Movies list of filtered movies that genre is one of 'genres'
	 */
	public List<Movie> findMoviesByGenre(List<Genres> genres) {
		
		return movies.stream()
				.filter(movie -> genres.contains(movie.getGenre()))
				.collect(Collectors.toList());
		
	}
	
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	

}
