package exceptions;

public class NotRegisteredException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String message;

	public NotRegisteredException(String message) {
		super(message);
		this.message = message;
	}

	public NotRegisteredException() {
		super();
	}

	public String getMessage() {
		return message;
	}

}
