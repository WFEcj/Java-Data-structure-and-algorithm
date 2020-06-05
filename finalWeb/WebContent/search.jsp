<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Page Title</title>
    <style>
    * {
        box-sizing:border-box;
    }
    div.search {
        padding:10px 0;
        position:relative;
        width:500px;
        margin:0 auto;
    }
    input,button {
        border:none;
        outline:none;
    }
    input {
        width:100%;
        height:42px;
        padding-left:13px;
    }
    button {
        height:42px;
        width:42px;
        cursor:pointer;
        position:absolute;
    }     
    .bar input {
        border:2px solid #78c98a;
        border-radius:5px;
        background:transparent;
        top:0;
        right:0;
    }
    .bar button {
        background:#78c98a;
        border-radius:0 5px 5px 0;
        width:60px;
        top:10px;
        right:0;
    }
    .bar button:before {
        content:"搜索";
        font-size:13px;
        color:#F9F0DA;
    }
    #container{
        margin-top: 50px;
        text-align: center;
        border:2px solid #78c98a;
        width:700px;
        height:600px;
        margin-left:450px;
        border-radius:10px;
    }
    table
        {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
        }
        table td, table th
        {
            border: 1px solid #cad9ea;
            color: #666;
            height: 30px;
        }
        table thead th
        {
            background-color: #CCE8EB;
            width: 100px;
        }
        table tr:nth-child(odd)
        {
            background: #fff;
        }
        table tr:nth-child(even)
        {
            background: #F5FAFA;
        }
    </style>
</head>
<body>
    <div class="search bar">
        <input placeholder="请输入您想查找的班级。。" id="cname" type="text" autocomplete="off">
        <button type="submit" onclick="getResult()"></button>
    </div>
    <div id="container">目前尚未搜索到结果。。。
    </div>
    <script>
    function getResult() {
    	var name = document.getElementById("cname").value;
    	var xmlhttp = null;
    	try{
    		xmlhttp = new XMLHttpRequest();
    	} catch(e){}
    	xmlhttp.open("Post","HelloForm2",true);
    	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    	xmlhttp.send("cname="+name);
    	xmlhttp.onreadystatechange = function() {
    		if(xmlhttp.readyState == 4) {
    			if(xmlhttp.status == 200) {
    				document.getElementById("container").innerHTML=xmlhttp.responseText;
    			}
    		}
    		
    	}
    }
    
    </script>
</body>
</html>