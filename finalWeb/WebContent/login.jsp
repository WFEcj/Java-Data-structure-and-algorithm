<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background:url('./images/login.jpg') no-repeat;
            position: absolute; 
        }
        .container{
            animation: log ease 0.3s;
            position: relative;
            left: 850px;
            top: 200px;
            border-radius: 8px;
            width: 400px;
            height: 250px;
            background-color:rgba(255, 255, 255, 0.5);
            text-align: center;
        }
        @keyframes log
        {
            from{left: 0;}
            to{left: 850px;}
        }
        p{
            width: 400px;
            height: 30px;
            line-height: 30px;
            padding-top: 30px;
        }
        p .inpt{
            -webkit-appearance:none;
            font-size: 0.9em;
            outline: 0ch;
            border-radius:4px;
            border:1px solid #c8cccf;
            color:#6a6f77;
            margin-right: 30px;
        }
        p .inpt:hover{
            color: #6a6fff;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
    	<form action="HelloForm" method="post">
	        <p>账&nbsp;&nbsp;&nbsp;号：<input type="text" name="username" required autocomplete="off" /></p>
	        <p>密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" required autocomplete="off" /></p>
	        <p><input class="inpt" type="submit" value="登录"""><input class="inpt" type="button" value="注册" onclick="register()"></p>
    	</form>
    </div>
    <div id="container">123123</div>
    <script>
        function register () {
            window.open("./register.jsp")
        }
        function getResult() {
        	var username = document.getElementById("username").value;
        	var password = document.getElementById("password").value;
        	console.log(username + "--" + password);
        	var xmlhttp = null;
        	try{
        		xmlhttp = new XMLHttpRequest();
        	} catch(e){}
        	xmlhttp.open("Post","HelloForm",true);
        	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        	xmlhttp.send("username="+username+"&"+"password=" + password);
        	xmlhttp.onreadystatechange = function() {
        		if(xmlhttp.readyState == 4) {
        			if(xmlhttp.status == 200) {
        				xmlhttp.responseText;
        			}
        		}
        	}
        }
    </script>
</body>
</html>