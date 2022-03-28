package exceptions;

public class UserNotFoundExceptions extends Exception {

	@Override
	public String getMessage() {
		return "No User Found!!";
	}
}
