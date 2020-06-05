// AccountNotExistException.java
package login;

public class AccountNotExistException extends Exception { // 继承Exception类
	public AccountNotExistException() {
	}

	public AccountNotExistException(String message) {
		super(message);
	}
}