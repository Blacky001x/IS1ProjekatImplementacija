package service;

import exceptions.CommentException;
import model.Movie;
import model.User;
import repository.CommentRepository;

public class CommentServiceImpl implements CommentService {

	private CommentRepository repository;
	
	
	public CommentServiceImpl(CommentRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public void addNewComment(Movie movie, User user, String text) throws CommentException {
	
		boolean isSuccessful = repository.addNewComment(movie, user, text);
		if (!isSuccessful) {
			throw new CommentException();
		}
		
	}

}
