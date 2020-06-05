package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloForm2")
public class HttpServletSample2 extends HttpServlet {
	private static final long serialVersionUID = 2L;
	//1--教师用户  2--学生用户
	public Connect dao;
	public HttpServletSample2() {
        super();
        // TODO Auto-generated constructor stub
        //this.jurisdiction = 0;
        dao = Connect.getInstance();
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String idcard = request.getParameter("idcard");
		if(dao.getSlogin().get(idcard) == null) {
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String cls = request.getParameter("cls");
			String password = request.getParameter("password");
			String homeplace = request.getParameter("homeplace");
			String phone = request.getParameter("phone");
			String qq = request.getParameter("qq");
			dao.insert(new Student(idcard,name,gender,cls,homeplace,phone,qq));
			Map<String,String> slogin = dao.getSlogin();
			slogin.put(idcard, password);
			dao.update("insert into slogin values(" + "\"" + idcard + "\"" + "," + "\"" + password + "\"" + ")");
			System.out.println();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"UTF-8\">\r\n" + 
					"<title>Insert title here</title>\r\n" + 
					"	<style>\r\n" + 
					"        *{\r\n" + 
					"            margin: 0;\r\n" + 
					"            padding: 0;\r\n" + 
					"        }\r\n" + 
					"        body{\r\n" + 
					"            background-color:gainsboro;\r\n" + 
					"        }\r\n" + 
					"        .container{\r\n" + 
					"            margin-top: 100px;\r\n" + 
					"            text-align: center;\r\n" + 
					"        }\r\n" + 
					"    </style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<div class=\"container\">\r\n" + 
					"        <img src=\"./images/zccg.png\" alt=\"\">\r\n" + 
					"    </div>\r\n" + 
					"</body>\r\n" + 
					"</html>");
		} else {
			response.getWriter().println("<script>alert('学号已存在')</script>");
			response.getWriter().println("<script>window.location.href='./register.jsp'</script>");
		}
		
    }
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	String name = request.getParameter("cname");
    	String sql = "select * from student where class= " + "\"" + name +"\"";
    	System.out.println(sql);
    	ResultSet rs = dao.search(sql);
    	String res = "";
    	try {
    		while(rs.next()) {
        		res += "<tr>" +"<td align='center'>"+rs.getString(1)+"</td>" + "<td align='center'>"+rs.getString(2)+"</td>"
        				+"<td align='center'>"+rs.getString(3)+"</td>" + "<td align='center'>"+rs.getString(4)+"</td>"
        				+"<td align='center'>"+rs.getString(5)+"</td>" + "<td align='center'>"+rs.getString(6)+"</td>" +
        				"<td align='center'>"+rs.getString(7)+"</td>" + "</tr>";
        	}
    	}catch(Exception e) {
    		
    	}
    	out.print("<div><table border='0' class='tabulation'>"
    			+ "<tr>"
    			+ "<TH width='100'>idcard"
    			+ "<TH width='100'>name"
    			+ "<TH width='100'>gender"
    			+ "<TH width='100'>class"
    			+ "<TH width='100'>homeplace"
    			+ "<TH width='100'>phone"
    			+ "<TH width='100'>qq"
    			+ "</tr>"
    			+ res +"</table>"+"</div>");
    	System.out.println("请求来了！");
    }
}
