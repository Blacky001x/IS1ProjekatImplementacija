package service;

import exceptions.CommentException;
import model.Movie;
import model.User;

public interface CommentService {
	
	void addNewComment(Movie movie, User user, String text) throws CommentException;

}
