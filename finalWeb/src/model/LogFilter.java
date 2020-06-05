package model;

import javax.servlet.*;

import java.io.PrintWriter;

//实现 Filter 类
public class LogFilter implements Filter  {
	
	Connect dao;
	
    public void  init(FilterConfig config) throws ServletException {
        // 获取初始化参数
        dao = Connect.getInstance();
    }
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {

        // 输出站点名称
        if("root".equals(dao.getJudge())){
            // 把请求传回过滤链
        	chain.doFilter(request, response);
        	
        }else{
            //设置返回内容类型
        	response.setContentType("text/html;charset=UTF-8");

            //在页面输出响应信息
            PrintWriter out = response.getWriter();
//            out.print("<b>学生无权访问，请求被拦截，不能访问web资源</b>");
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
            		"            background-image:url(./images/qxbz.png);\r\n" + 
            		"            background-position: no-repeat;\r\n" + 
            		"            background-size: cover;\r\n" + 
            		"            position: relative;\r\n" + 
            		"        }\r\n" + 
            		"\r\n" + 
            		"        /* .container{\r\n" + 
            		"            text-align: center;\r\n" + 
            		"            margin-top: 250px;\r\n" + 
            		"        } */\r\n" + 
            		"        /* form{\r\n" + 
            		"            /* float: left; */\r\n" + 
            		"            /* margin-left: 250px;\r\n" + 
            		"        } */\r\n" + 
            		"        /* input{\r\n" + 
            		"            border-radius: 5px;\r\n" + 
            		"            background-color:cadetblue;\r\n" + 
            		"            outline: 0;\r\n" + 
            		"            width: 150px;\r\n" + 
            		"            height: 100px;\r\n" + 
            		"            margin-left: 150px;\r\n" + 
            		"            cursor: pointer;\r\n" + 
            		"            font-size: 18px;\r\n" + 
            		"        } */\r\n" + 
            		"        @keyframes mymove\r\n" + 
            		"        {\r\n" + 
            		"        0%   {width:0px;}\r\n" + 
            		"        100% {width:800px;}\r\n" + 
            		"        }\r\n" + 
            		"        @keyframes transparency\r\n" + 
            		"        {\r\n" + 
            		"            0%{opacity: 0;}\r\n" + 
            		"            25%{opacity: 0;}\r\n" + 
            		"            50%{opacity: 0;}\r\n" + 
            		"            75%{opacity: 0;}\r\n" + 
            		"            100%{opacity: 1;}\r\n" + 
            		"        }\r\n" + 
            		"        .issue{\r\n" + 
            		"            animation: mymove ease-in-out 0.5s;\r\n" + 
            		"            animation-delay: 0.1s;\r\n" + 
            		"            margin: 0 auto;\r\n" + 
            		"            margin-top: 100px;\r\n" + 
            		"            width: 800px;\r\n" + 
            		"            height: 400px;\r\n" + 
            		"            background-color: rgba(255, 255, 255, 0.5);\r\n" + 
            		"            border-radius: 20px;\r\n" + 
            		"            text-align: center;\r\n" + 
            		"            /* top:800px; */\r\n" + 
            		"            position: relative;\r\n" + 
            		"        }\r\n" + 
            		"        .issue h1{\r\n" + 
            		"            animation: transparency ease-out 0.8s;\r\n" + 
            		"            /* opacity: 0; */\r\n" + 
            		"            position: absolute;\r\n" + 
            		"            top: 150px;\r\n" + 
            		"            left: 200px;\r\n" + 
            		"            \r\n" + 
            		"        } \r\n" + 
            		"        /* img{\r\n" + 
            		"            margin-top: 30px;\r\n" + 
            		"            animation: mymove ease-in-out 1s;\r\n" + 
            		"        } */\r\n" + 
            		"    </style>\r\n" + 
            		"</head>\r\n" + 
            		"<body>\r\n" + 
            		"	<!-- <div class=\"container\">\r\n" + 
            		"        <form action=\"search.jsp\">\r\n" + 
            		"            <input type=\"submit\">\r\n" + 
            		"        </form>\r\n" + 
            		"        <form action=\"update.jsp\">\r\n" + 
            		"            <input type=\"submit\">\r\n" + 
            		"        </form>\r\n" + 
            		"        <form action=\"delete.jsp\">\r\n" + 
            		"            <input type=\"submit\">\r\n" + 
            		"        </form>\r\n" + 
            		"    </div> -->\r\n" + 
            		"    <div class=\"issue\">\r\n" + 
            		"        <h1><em>权限不足！！请继续努力</em></h1>\r\n" + 
            		"    </div>\r\n" + 
            		"</body>\r\n" + 
            		"</html>");
        }
        // 把请求传回过滤链
        //chain.doFilter(request,response);
    }
    public void destroy( ){
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}