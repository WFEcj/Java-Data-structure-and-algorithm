// Validate.java
package login;

public class Validate {
	private String account, password; // 定义用户名和密码

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login(String account, String password) // 验证用户名或密码是否正确
			throws AccountNotExistException, PasswordIncorrectException {
		if (!validateAccout(account)) {
			throw new AccountNotExistException("账号不存在");
		}
		if (!validatePassword(account, password)) {
			throw new PasswordIncorrectException("密码不正确");
		}
	}

	// 验证账号是否存在
	private boolean validateAccout(String account) {
		if (account.equals("aaa")) {
			return true;
		}
		return false;
	}

	// 验证密码是否正确
	private boolean validatePassword(String account, String password) {
		if (account.equals("aaa") && password.equals("111")) {
			return true;
		}
		return false;
	}
}
