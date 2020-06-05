<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
        *{
            margin: 0;
            padding: 0;
        }
        .container{
            text-align: center;
            margin-top: 250px;
        }
        form{
            float: left;
            margin-left: 250px;
        }
        input{
            border-radius: 5px;
            background-color:cadetblue;
            outline: 0;
            width: 150px;
            height: 100px;
            margin-left: 150px;
            cursor: pointer;
            font-size: 18px;
        }
    </style>
</head>
<body>
	<div class="container">
        <form action="HelloForm" method="Get" autocomplete="off">
            <input type="text" name="number" value="root" hidden>
            <input type="submit" value="管理员登录">
        </form>
        <form action="HelloForm" method="Get" autocomplete="off">
            <input type="text" name="number" value="student" hidden>
            <input type="submit" value="学生登录">
        </form>
    </div>
</body>
</html>