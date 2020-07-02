<%@page import="com.hackers.board.util.StringUtil"%>
<%@page import="com.hackers.board.vo.User"%>
<%@page import="com.hackers.board.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<%
		UserDao userDao = new UserDao();
		String userId = StringUtil.nullValueBlank((String) session.getAttribute("newUserId"));
		User user = userDao.getUserById(userId);
		String name = user.getName();
	%>	
	
	<h3><%=name %>님의 가입을 환영합니다.</h3>
	
</div>
</body>
</html>