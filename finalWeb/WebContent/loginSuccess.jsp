<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>学生信息管理</title>
	<script type="text/javascript">
		function MM_jumpMenu(targ,selObj,restore){
			eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
			if(restore)
				selObj.selectedIndex=0;
		}
	</script>
	<style>
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
        input{
        	font-size:1em;
	        height:2em;
	        border-radius:4px;
	        border:1px solid #c8cccf;
	        color:#6a6f77;
	        cursor: pointer;
        }
        .container{
        	text-align:center;
        }
        .f1{
	        position: relative;
	        top: -15px;
	        left: 200px;
	    }
	    .f4{
	    	position: relative;
	        top: 20px;
	        left: -80px;
	    }
	    .f5{
	    	position: relative;
	        top: 20px;
	        left: -50px;
	    }
	    .f6{
	    	position: relative;
	        top: 20px;
	        left: -20px;
	    }
	    .f7{
	    	position: relative;
	        top: 20px;
	        left: 10px;
	    }
	    .f8{
	    	position: relative;
	        top: 20px;
	        left: 5px;
	    }
	    span{
	    	display:block;
	    	text-align:center;
	    }
	    a{
            text-decoration: none;
        }
	</style>
</head>
<body>
	<jsp:useBean id="con" scope="page" class="model.Connect"/>
	<%
		String message=request.getParameter("message");
		if(message!=null){ %>
			<script type="text/javascript">
				alert("<%=message %>");
			</script>
	 <% } %>
	<h1 calss="" size="4px">学生信息如下：</h1>
	<%
		ResultSet rs=null;
		
		String pageName="loginSuccess.jsp";
		int pageSize=7;
		int showPage=1;
		int rowCount=0;
		int pageCount=0;
		int goPage=0;
		rs=con.search("select * from student");
		rs.last();
		rowCount=rs.getRow();
		
		if(rowCount%pageSize==0){
			pageCount=rowCount/pageSize;
		}
		else{
			pageCount=rowCount/pageSize+1;
		}
		String toPage=request.getParameter("toPage");
		
		if(toPage!=null){
			showPage=Integer.parseInt(toPage);
			if(showPage>pageCount){
				showPage=pageCount;
			}
			else if(showPage<=0){
				showPage=1;
			}
		}
		rs.absolute((showPage-1)*pageSize+1);
		out.println("<span>"+"当前第"+showPage+"页一共"+pageCount+"页"+"</span>");
		out.println("<div><table border='2' class='tabulation'>");
		out.print("<tr>");
		out.print("<TH width='100'>"+"idcard");
		out.print("<TH width='100'>"+"name");
		out.print("<TH width='100'>"+"gender");
		out.print("<TH width='100'>"+"class");
		out.print("<TH width='100'>"+"homeplace");
		out.print("<TH width='100'>"+"phone");
		out.print("<TH width='100'>"+"qq");
		out.print("<TH width='100'>"+"操作");
		out.print("<TH width='100'>"+"修改");
		out.print("</tr>");
		for(int i=0;i<pageSize;i++){
			out.print("<tr>");
			out.println("<td align='center'>"+rs.getString(1)+"</td>");
			out.println("<td align='center'>"+rs.getString(2)+"</td>");
			out.println("<td align='center'>"+rs.getString(3)+"</td>");
			out.println("<td align='center'>"+rs.getString(4)+"</td>");
			out.println("<td align='center'>"+rs.getString(5)+"</td>");
			out.println("<td align='center'>"+rs.getString(6)+"</td>");
			out.println("<td align='center'>"+rs.getString(7)+"</td>");
			String delete="<td align='center'><a href='delete.jsp?id=";
			delete+=rs.getString(1);
			delete+="'>删除</a></td>";
			out.println(delete);
			String update="<td align='center'><a href='update.jsp?id=";
			update+=rs.getString(1);
			update+="'>修改</a></td>";
			out.println(update);
			out.print("</tr>");
			if(!rs.next()){
				break;
			}
		}
		out.println("</table></div>");
	%>
	<div class="container">
	<% if(showPage!=1){%>
			<input type="button" class="buttonStyle f4" value="第一页" onClick="location.href='<%=pageName %>?toPage=<%=1 %>'"/>	
			<input type="button" class="buttonStyle f5" value="上一页" onClick="location.href='<%=pageName %>?toPage=<%=showPage-1 %>'"/>	
	 <% }
	   if(showPage!=pageCount){%>
	   		<input calss="f6" type="button" class="buttonStyle f6" value="下一页" onClick="location.href='<%=pageName %>?toPage=<%=showPage+1 %>'"/>
	   		<input calss="f7" type="button" class="buttonStyle f7" value="最后一页" onClick="location.href='<%=pageName %>?toPage=<%=pageCount %>'"/>
	<%   }
	%>&emsp;&emsp;&emsp;&nbsp;到
	
	
	<select class="f8" name="toPage" onchange="MM_jumpMenu('self',this,1)">
		<%
		for(goPage=1;goPage<=pageCount;goPage++){
			if(goPage==showPage){%>
				<option value="<%=pageName %>?toPage=<%=goPage%>" toPage=<%=goPage %> selected><%=goPage %></option>
		 <%}
		 else{%>
				<option value="<%=pageName %>?toPage=<%=goPage%>" toPage=<%=goPage %>><%=goPage %></option>
			<%}
		}
		%>
	</select>
		页
		<form action="search.jsp">
			<input class="f1" type="submit" value="查找">
		</form>
	</div>
</body>
</html>