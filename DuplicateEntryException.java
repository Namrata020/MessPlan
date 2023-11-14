package custom_exceptions;

public class DuplicateEntryException extends Exception {
	public DuplicateEntryException(String errMsg){
		super(errMsg);
	}
}
