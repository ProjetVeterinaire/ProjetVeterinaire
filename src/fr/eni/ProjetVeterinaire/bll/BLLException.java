package src.fr.eni.ProjetVeterinaire.bll;

public class BLLException extends Exception {
	public BLLException() {
		super();
	}
	
	public BLLException(String message) {
		super(message);
	}
	
	public BLLException(String message, Throwable exception) {
		super(message, exception);
	}

	@Override
	public String getMessage() {
		//TEST 45 78254485454
		return "BLL - " + super.getMessage();
	}
	
	
}
