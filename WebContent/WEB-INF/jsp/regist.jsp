<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <style type="text/css">
	    	span{
	    		color:red;
	    	}
    </style>
  </head>
  
  <body>
  	<form:form modelAttribute="user" action="regist.form">
    用户名：<input type="text" value="${user.name }" name="name"><span><form:errors path="name"></form:errors> </span><br>
    密码：<input type="password" value="${user.password }" name="password"/><span><form:errors path="password"></form:errors> </span><br>
    	<input type="submit" value="注册"/>
    </form:form>
  </body>
</html>
