package exceptions;

public class CommentException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CommentException() {
		
	}
	
	public CommentException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return "Doslo je do greske: " + message;
	}
	
}
