package exceptions;

public class IDNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IDNotFoundException(String ErrorMessage) {
		super(ErrorMessage);
	}

}
