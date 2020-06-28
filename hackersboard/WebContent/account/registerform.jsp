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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="header">
		</div>
		<div class="body">
			<div id="body-header" class="row">
				<div class="col-2">
					<h3>회원가입</h3>
				</div>
				<div class="col-10">
					<p>게시판에 글을 작성하기 위해서는 회원가입이 필요합니다.</p>
				</div>
			</div>
			<div id="body-main" class="row">
				<div class="col-12">
					<form id="ip-form" method="POST" action="register.jsp" >
						<div class="form-group">
							<label>별명</label>
							<input type="text" name="username" placeholder="별명을 입력하세요." >
						</div>
						<div class="form-group">
							<label>아이디</label>
							<input type="text" name="userid" placeholder="아이디를 입력하세요." >
						</div>
						<div class="form-group">
							<label>이메일</label>
							<input type="text" name="useremail" placeholder="이메일 주소를 입력하세요." >
						</div>
						<div class="form-group">
							<label>비밀번호</label>
							<input type="password" id="password-1" name="userpassword" placeholder="비밀번호를 입력하세요." >
						</div>
						<div class="form-group">
							<label>비밀번호 확인</label>
							<input type="password" id="password-2" placeholder="비밀번호를 입력하세요." >
						</div>
						<div>
							<button type="button" onclick="checkforms()">제출</button>
						</div>
					</form>
				</div>
			</div>
			<div id="body-footer">
			</div>
		</div>
		<div class="footer"></div>
	</div>
<script type="text/javascript">
	function checkforms() {
		var inputs = document.querySelectorAll(".form-group input");
		for (var i = 0; i < inputs.length; i++) {
			if (!inputs[i].value) {
				alert("빈 칸을 빠짐없이 채워주셔야 합니다.");
				inputs[i].focus();
				return;
			}
		}
		
		var pwd1 = document.querySelector("#password-1").value;
		var pwd2 = document.querySelector("#password-2").value;
		
		if (pwd1 != pwd2) {
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}

		if (confirm("확인 버튼을 누르시면 회원가입이 완료됩니다.")) {
			document.querySelector("#ip-form").submit();
		}
	}
</script>
</body>
</html>