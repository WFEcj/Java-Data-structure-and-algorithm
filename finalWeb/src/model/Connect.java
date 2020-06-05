package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;



public class Connect {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rst = null;
	private Map<String,String> slogin = new HashMap<>();
	private Map<String,String> admin = new HashMap<>();
	//private Map<String,Student> studentInfo = new HashMap<>();
	private String judge; // root--管理员用户 student--学生用户
	private final static Connect INSTANCE = new Connect();
	public Connect() {}
	public static Connect getInstance(){
		return INSTANCE;
	}
	{
		try{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
			String user = "admin";
			String password = "12345678";
			conn = DriverManager.getConnection(url,user,password);
			String sql = "select * from slogin";
			String sql2 = "select * from admin";
			//String sql3 = "select * from student";
			try {
				stmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rst = stmt.executeQuery(sql);
				while(rst.next()) {
					slogin.put(rst.getString(1),rst.getString(2));
				}
				rst = stmt.executeQuery(sql2);
				while(rst.next()) {
					admin.put(rst.getString(1),rst.getString(2));
				}
//				rst = stmt.executeQuery(sql3);
////				while(rst.next()) {
////					studentInfo.put(rst.getString(1), new Student(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7)));
////				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Map<String,String> getSlogin() {
		return slogin;
	}
	public Map<String,String> getAdmin() {
		return admin;
	}
//	public Map<String,Student> getStudentInfo() {
//		return studentInfo;
//	}
	//public void update(String s,)
	public boolean getAdmin(String user,String password) {
		String realPass = this.admin.get(user);
		return realPass==null ? false : realPass.equals(password);
	}
	public boolean getStudentAdmin(String user,String password) {
		String realPass = this.slogin.get(user);
		return realPass == null ? false : realPass.equals(password);
	}
	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	public ResultSet search(String sql) {
		ResultSet rt = null;
		try {
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rt=stmt.executeQuery(sql);
//			while(rst.next()) {
//				studentInfo.put(rst.getString(1), new Student(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7)));
//			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return rt;
	}
	public boolean update(String sql) {
		boolean flag=false;
		try {
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.execute(sql);
			flag=true;
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return flag;
	}
	public boolean insert(Student s) {
		boolean flag = false;
		try {
			String sql = "insert into student values( " + "\"" +s.getIdcard() + "\"" + "," + "\"" + s.getName() + "\"" + "," + "\"" + s.getGender() + "\"" + ",";
			sql += "\"" + s.getCls() + "\"" + "," + "\"" + s.getHomeplace() + "\"" + "," + "\"" + s.getPhone() + "\"" + "," + "\"" + s.getQq() + "\"" + ")";
			System.out.println(sql);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.execute(sql);
			flag=true;
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return flag;
	}
}
