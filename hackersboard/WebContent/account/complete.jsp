<%@page import="com.hackers.board.util.StringUtil"%>
<%@page import="com.hackers.board.vo.User"%>
<%@page import="com.hackers.board.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Registration Complete</title>
</head>
<body>
<div class="container">
	<%
		UserDao userDao = new UserDao();
		String userId = StringUtil.nullValueBlank((String) session.getAttribute("newUserId"));
		User user = userDao.getUserById(userId);
	%>	
	<div class="header">
		<div class="row">
			<div class="col-4">
				<h3>가입완료</h3>
			</div>
			<div class="col-8 text-right">
				<p class="text-muted mt-2" style="margin-bottom: 0px;">자유게시판 서비스 가입을 환영합니다.</p>
			</div>
		</div>
		
		<div class="row">
			<div class="col-12 mb-5" style="background-color: red; height: 2px;"></div>
		</div>
	</div>
	
	<div class="body">
		<div id="main-content" class="row justify-content-center">
			<div class="col-8">
				<div class="card">
					<div class="card-header text-center" style="background-color: PeachPuff">
						<h4><%=user.getName() %>님, 회원 정보를 확인하세요.</h4>
					</div>
					<div class="card-body">
						<div>
							<p>회원 번호 : <%=user.getNo() %></p>
							<p>회원 별명 : <%=user.getName() %></p>
							<p>아  이  디 : <%=user.getId() %></p>
							<p>가입 메일 : <%=user.getEmail() %></p>
						</div>
					</div>
					<div class="card-footer" style="background-color: #fff1e6;">
						<div class="text-center">
							<a class="btn btn-danger btn-lg" href="../board/list.jsp">게시판으로</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="footer">
		<div class="row">
			<div class="col-12 mt-5 mb-2" style="background-color: red; height: 2px;"></div>
		</div>
		
		<div class="row">
			<div class="col-6">
				<p>주말스터디 미니프로젝트 : 게시판 만들기</p>
			</div>
			<div class="col-6 text-right">
				<p>만든이 : 민석</p>
			</div>
		</div>
	</div>
</div>
</body>
</html>