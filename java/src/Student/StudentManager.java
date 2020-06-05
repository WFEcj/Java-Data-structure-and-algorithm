package Student;
abstract class Student{
	public String id;
	public String name;
	public String className;
	public abstract void loginIn();
	public abstract void clearOut();
}
class UnderGraduate extends Student{
	private String counsellors;
	public void loginIn() {
		System.out.println("本科生注册成功！");
	}
	public void clearOut() {
		System.out.println("本科生注销成功！");
	}
}
class Graduate extends Student{
	private String instrutor;
	private String research;
	public void loginIn() {
		System.out.println("研究生注册成功！");
	}
	public void clearOut() {
		System.out.println("研究生注销成功！");
	}
}
public class StudentManager {
	public void add(Student s) {
		s.loginIn();
	}
	public void delete(Student s) {
		s.clearOut();
	}
	public static void main(String[] args) {
		StudentManager manager=new StudentManager();
		Student underGraduate=new UnderGraduate();
		Student Graduate=new Graduate();
		manager.add(underGraduate);
		manager.delete(underGraduate);
		manager.add(Graduate);
		manager.delete(Graduate);
	}

}
