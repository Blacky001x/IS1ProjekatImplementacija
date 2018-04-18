package repository;

import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.Movie;
import model.User;

public class CommentRepositoryMock implements CommentRepository {
	
	private static List<Comment> comments;
	
	static {
		comments = new ArrayList<>();
	}
	
	/**
	 * Used to add new comment to database.
	 * @param movie Which movie new comment reffers to
	 * @param user Which user posted the comment
	 * @param text Text of the comment 
	 */
	public boolean addNewComment(Movie movie, User user, String text) {
		Comment comment = new Comment();
		comment.setMovie(movie);
		comment.setUser(user);
		comment.setText(text);
		
		movie.getComments().add(comment);
		user.getComments().add(comment);
		
		comments.add(comment);
		
		return true;
	}

}
