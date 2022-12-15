package ErrorException;

public class FException extends Exception{

	public FException(String message) {
		super(message);
	}

	public FException(String message, Throwable cause) {
		super(message, cause);
	}
}
