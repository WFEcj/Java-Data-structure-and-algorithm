package examStudent;

public class Student {
	private String admin;
	private String password;
	Student(String admin,String password){
		this.admin=admin;
		this.password=password;
	}
	public String getName() {
		return this.admin;
	}
	public String getPassword() {
		return this.password;
	}
}
