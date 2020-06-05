package login;

import java.util.Scanner;

public class LoginMain {
	public static void main(String[] args) {
		Validate test = new Validate();
		System.out.println("请输入用户名：");
		Scanner inAccount = new Scanner(System.in);
		test.setAccount(inAccount.nextLine()); // 为用户名变量赋值
		System.out.println("请输入密码：");
		Scanner inPassword = new Scanner(System.in);
		test.setPassword(inPassword.nextLine()); // 为密码变量赋值
		try {
			test.login(test.getAccount(), test.getPassword()); // 调用方法进行验证
			System.out.println("登录成功！");
		} catch (PasswordIncorrectException e) { // 捕获密码不正确异常
			System.out.println("捕捉密码不正确异常\n" + e);
		} catch (AccountNotExistException e) { // 捕获用户名不存在异常
			System.out.println("捕捉账户不正确异常：\n" + e);
		}
	}
}
