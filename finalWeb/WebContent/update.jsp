<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>update</title>
    <style>
    *{
        margin: 0;
        padding: 0;
    }
    body{
        background-image:url(./images/register.jpg);
        /* background-position: no-repeat; */
        background-size: cover;
    }
    .container{
        border-radius: 8px;
        width: 600px;
        margin: 0 auto;
        margin-top: 200px;
        height: 500px;
        background-color:rgba(255, 255, 255, 0.5);
    }
    .container p {
        padding-top: 20px;
        margin-left: 50px;
    }
    .inpt{
        border-radius: 5px;
        margin-left: 130px;
        color:cadetblue;
        cursor: pointer;
        width: 70px;
        height: 30px;
    }
    </style>
</head>
<body>
	<jsp:useBean id="con" scope="page" class="model.Connect"/>
	<%
	ResultSet rs = null;
    request.setCharacterEncoding("UTF-8");
    String id=request.getParameter("id");
    String sql="select * from student where idcard='";
    sql+=id+"';";
    System.out.println(sql);
    if(id!=null){
    	rs=con.search(sql);
        rs.first();
    }
    String name = rs.getString(2);
    String gender = rs.getString(3);
    String clas = rs.getString(4);
    String homePlace = rs.getString(5);
    String phone = rs.getString(6);
    String qq = rs.getString(7);
%>
    <div class="container">
        <form action="HelloForm3" Method="Post" autocomplete="off">
            <h1 style="text-align: center">更&nbsp;改&nbsp;界&nbsp;面</h1>
            <p>学号：<input type="text" name="idcard" value="<%=id %>"></p>
            <P> <span style="color: red">*</span> 姓名：<input type="text" value="<%=name %>" name="name" required></P>
            <p>性别：<input type="text" name="gender" value="<%=gender %>"></p>
            <P> <span style="color: red">*</span> 班级：<input type="text" value="<%=clas %>" required name="cls"></P>
            <p>所在地：<input type="text" name="homeplace" value="<%=homePlace %>"></p>
            <P> <span style="color: red">*</span> 电话：<input value="<%=phone %>" type="text" name="phone" required></P>
            <P> <span style="color: red">*</span> QQ：<input value="<%=qq %>" type="number" name="qq" required></P>
            <p><input class="inpt" type="submit"><input class="inpt" type="reset"></p>
        </form>
    </div>
    
</body>
</html>