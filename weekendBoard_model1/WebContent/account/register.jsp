<%@page import="we.m1.board.dao.UserDao"%>
<%@page import="we.m1.board.vo.User"%>
<%@page import="we.m1.board.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	User user = new User();
	String name = StringUtil.nullValueBlank(request.getParameter("username"));
	String id = StringUtil.nullValueBlank(request.getParameter("userid"));
	String email = StringUtil.nullValueBlank(request.getParameter("useremail"));
	String password = StringUtil.nullValueBlank(request.getParameter("userpassword"));
	
	user.setName(name);
	user.setId(id);
	user.setEmail(email);
	user.setPassword(password);
	
	UserDao ud = new UserDao();
	ud.insertUser(user);
	
	User newUser = ud.getUserById(id);
	session.setAttribute("newUserId", id);
	session.setAttribute("user", newUser);
	
	response.sendRedirect("complete.jsp");
	
%>