package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloForm3")
public class HttpServletSample3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//1--教师用户  2--学生用户
	public Connect dao;
	public HttpServletSample3() {
        super();
        // TODO Auto-generated constructor stub
        //this.jurisdiction = 0;
        dao = Connect.getInstance();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
    }
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 设置响应内容类型
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String idcard = request.getParameter("idcard");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String cls = request.getParameter("cls");
		String homeplace = request.getParameter("homeplace");
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String sql = "update student set idcard=" + "'" + idcard + "'" + "," + "name=" + "'" + name + "'" +
		"," + "gender=" + "'" + gender + "'" + "," + "class=" + "'" + cls + "'" + "," + "homeplace=" + "'" + homeplace + "'" +
		"," + "phone=" + "'" + phone + "'" + "," + "qq=" + "'" + qq + "'" + "where idcard=" + "'" + idcard + "'";
		System.out.println(sql);
		boolean flag = dao.update(sql);
		if(flag) {
			out.print("<script language=javascript>alert(" + "账号或密码错误" + ")</script>");
		} else {
			out.print("<script language=javascript>alert(" + "修改失败！" + ")</script>");
		}
    }
}