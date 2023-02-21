package exceptions;

public class IDIsAlreadyPresentException extends RuntimeException {

	/**
	 * The serial version of the exception
	 */
	private static final long serialVersionUID = 1L;
	
	public IDIsAlreadyPresentException(String ErrorMessage) {
		super(ErrorMessage);
	}

}
