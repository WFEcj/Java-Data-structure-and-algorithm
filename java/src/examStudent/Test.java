package examStudent;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		ExamMachine exam = new ExamMachine();
		Scanner in = new Scanner(System.in);
		System.out.println("��ӭ������ʼϵͳ��");
		System.out.println("��������������");
		String admin = in.nextLine();
		System.out.println("�������������룺");
		String password = in.nextLine();
		Student s = new Student(admin,password);
		if(exam.login(s)) {
			String[] answer = exam.work();
			System.out.println("��ʦ�����ľ������ĵȴ�....");
			Thread.sleep(5000);
			Teacher t = new Teacher();
			System.out.println(t.score(answer, exam.getAnswer()));
		}
		else {
			System.out.print("�����û������������");
		}
	}
}
