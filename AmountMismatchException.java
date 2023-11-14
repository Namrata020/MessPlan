package custom_exceptions;

public class AmountMismatchException extends Exception {
	public AmountMismatchException(String msg) {
		super(msg);
	}
}
