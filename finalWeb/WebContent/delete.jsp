<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="deleteBean" scope="page" class="model.Connect"/>
<%
        request.setCharacterEncoding("UTF-8");
        String id=request.getParameter("id");
        String sql="delete from student where idcard='";
        sql+=id+"';";
        System.out.println(sql);
        if(id!=null){
            deleteBean.update(sql);
        }
    %>
    <jsp:forward page="loginSuccess.jsp"></jsp:forward>
</body>
</html>