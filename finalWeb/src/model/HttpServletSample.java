package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloForm")
public class HttpServletSample extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//1--教师用户  2--学生用户
	public Connect dao;
	public HttpServletSample() {
        super();
        // TODO Auto-generated constructor stub
        //this.jurisdiction = 0;
        dao = Connect.getInstance();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String judge = request.getParameter("number");
		dao.setJudge(judge);
		response.sendRedirect("login.jsp");
		
    }
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//out.println(this.jurisdiction);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "--" + password);
		if(dao.getJudge().equals("root")) {
			boolean flag = dao.getAdmin(username, password);
			if(flag) {
				//out.println("登录成功");
				response.sendRedirect("loginSuccess.jsp");
			} else{
				response.getWriter().println("<script>alert('账号或密码错误')</script>");
				response.getWriter().println("<script>window.location.href='./login.jsp'</script>");
			}
		} else {
			boolean flag = dao.getStudentAdmin(username, password);
			if(flag) {
				//out.println("登录成功");
				response.sendRedirect("loginSuccess.jsp");
			} else{
				response.getWriter().println("<script>alert('账号或密码错误')</script>");
				response.getWriter().println("<script>window.location.href='./login.jsp'</script>");
			}
		}
    }
}
