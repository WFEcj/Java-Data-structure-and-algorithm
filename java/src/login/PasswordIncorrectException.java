// PasswordIncorrectException.java
package login;

public class PasswordIncorrectException extends Exception {
	public PasswordIncorrectException() {
	}

	public PasswordIncorrectException(String message) {
		super(message);
	}
}
