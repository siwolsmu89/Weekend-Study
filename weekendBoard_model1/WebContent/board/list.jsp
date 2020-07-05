<%@page import="we.m1.board.util.StringUtil"%>
<%@page import="we.m1.board.vo.Board"%>
<%@page import="java.util.List"%>
<%@page import="we.m1.board.dao.BoardDao"%>
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
<title>Board List</title>
<style>
	.pagination .page-link {
	    color: red;
	    background-color: white !Important;
	}
	.pagination > .active > a {
	    color: white;
	    background-color: red !Important;
	    border: solid 1px red !Important;
	}
</style>
</head>
<body>
<%
	int pageNo = request.getParameter("pageNo") != null ? Integer.parseInt(request.getParameter("pageNo")) : 1;
	BoardDao boardDao = new BoardDao();
	
	int rowsPerPage = 20;
	int begin = (pageNo - 1) * rowsPerPage + 1;
	int end = pageNo * rowsPerPage;
	
	List<Board> boards = boardDao.getBoardsByRange(begin, end);
			
%>
<div class="container">
	<div class="header">
		<div class="row">
			<div class="col-4">
				<h3>게시판 목록</h3>
			</div>
			<div class="col-8 text-right">
				<p class="text-muted mt-2" style="margin-bottom: 0px;">자유게시판에서 다른 사람들과 자유롭게 소통해보세요.</p>
			</div>
		</div>
		
		<div class="row">
			<div class="col-12 mb-5" style="background-color: red; height: 2px;"></div>
		</div>
	</div>
	
	<div class="body">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<colgroup>
						<col width="10%">
						<col width="45%">
						<col width="15%">
						<col width="15%">
						<col width="15%">
					</colgroup>
					<thead>
						<tr class="text-center" style="background-color: #fff1e6;">
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>조회수</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
					<%
						if (boards.isEmpty()) {
					%>
						<tr class="text-center">
							<td colspan="6">입력된 게시글이 없습니다.</td>
						</tr>
					<%
						} else {
							for (Board board : boards) {
					%>	
						<tr class="text-center">
							<td><%=board.getNo() %></td>
							<td class="text-left">
								<a href="#" style="text-decoration: none; color: black;"><%=StringUtil.nullValueBlank(board.getTitleHeader()) %> <%=board.getTitle() %></a>
							</td>
							<td><%=board.getUserName() %></td>
							<td><%=board.getViewCount() %></td>
							<td><%=board.getRegDate() %></td>
						</tr>
					<%
							}
						}
					%>	
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
			<%
				int pagesPerBlock = 5;
				int thisBlock = (int) Math.ceil((double) pageNo / pagesPerBlock);
				
				int beginPageNo = (thisBlock - 1) * pagesPerBlock + 1;
				int endPageNo = thisBlock * pagesPerBlock;
			%>
				<ul class="pagination justify-content-center" style="margin: 20px 0">
			<%
				for (int i = beginPageNo ; i<= endPageNo; i++) {
					String active = pageNo == i ? "active" : "";
			%>
					<li class="page-item <%=active %>">
						<a class="page-link" href="list.jsp?pageNo=<%=i %>"><%=i %></a>
					</li>
			<%
				}
			%>		
				</ul>
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