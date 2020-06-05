<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>register</title>
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
    <div class="container">
        <form action="HelloForm2" Method="Get" autocomplete="off">
            <h1 style="text-align: center">注&nbsp;册&nbsp;界&nbsp;面</h1>
            <p>学号：<input type="text" name="idcard"></p>
            <P> <span style="color: red">*</span> 姓名：<input type="text" placeholder="小明" name="name" required></P>
            <p>性别：<input type="text" name="gender"></p>
            <P> <span style="color: red">*</span> 班级：<input type="text" required name="cls"></P>
            <P> <span style="color: red">*</span> 密码：<input type="password" required name="password"></P>
            <p>所在地：<input type="text" name="homeplace"></p>
            <P> <span style="color: red">*</span> 电话：<input type="text" name="phone" required></P>
            <P> <span style="color: red">*</span> QQ：<input type="number" name="qq" required></P>
            <p><input class="inpt" type="submit"><input class="inpt" type="reset"></p>
        </form>
    </div>
</body>
</html>