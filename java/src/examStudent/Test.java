package examStudent;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		ExamMachine exam = new ExamMachine();
		Scanner in = new Scanner(System.in);
		System.out.println("欢迎来到开始系统！");
		System.out.println("请输入您的名称");
		String admin = in.nextLine();
		System.out.println("请输入您的密码：");
		String password = in.nextLine();
		Student s = new Student(admin,password);
		if(exam.login(s)) {
			String[] answer = exam.work();
			System.out.println("老师正在阅卷，请耐心等待....");
			Thread.sleep(5000);
			Teacher t = new Teacher();
			System.out.println(t.score(answer, exam.getAnswer()));
		}
		else {
			System.out.print("您的用户名或密码错误！");
		}
	}
}
