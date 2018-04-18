package repository;

import model.Movie;
import model.User;

public interface CommentRepository {
	
	boolean addNewComment(Movie movie, User user, String text);

}
