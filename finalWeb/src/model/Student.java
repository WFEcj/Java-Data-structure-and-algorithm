package model;

public class Student {
	private String idcard;
	private String name;
	private String gender;
	private String cls;
	private String homeplace;
	private String phone;
	private String qq;
	public Student(String idcard,String name,String gender,String cls,String homeplace,String phone,String qq) {
		this.idcard = idcard;
		this.name = name;
		this.gender = gender;
		this.cls = cls;
		this.homeplace = homeplace;
		this.phone = phone;
		this.qq = qq;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public String getHomeplace() {
		return homeplace;
	}
	public void setHomeplace(String homeplace) {
		this.homeplace = homeplace;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
}
