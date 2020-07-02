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
<title>Hackers registration</title>
</head>
<body>
<div class="container">
	<div class="header">
		<div class="row">
			<div class="col-4">
				<h3>회원가입</h3>
			</div>
			<div class="col-8 text-right">
				<p class="text-muted mt-2" style="margin-bottom: 0px;">게시판에 글을 작성하기 위해서는 회원가입이 필요합니다.</p>
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
						<h4>회원 정보 입력란</h4>
					</div>
					<div class="card-body">
						<form id="ip-form" method="POST" action="register.jsp" >
							<div class="form-group">
								<label>별명</label>
								<input class="form-control" type="text" name="username" placeholder="별명을 입력하세요. (한글 사용 가능)" >
							</div>
							<div class="form-group">
								<label>아이디</label>
								<input class="form-control" type="text" name="userid" placeholder="아이디를 입력하세요. (영어 또는 영어+숫자 혼합)" >
							</div>
							<div class="form-group">
								<label>이메일</label>
								<input class="form-control" type="text" name="useremail" placeholder="이메일 주소를 입력하세요." >
							</div>
							<div class="form-group">
								<label>비밀번호</label>
								<input class="form-control" type="password" id="password-1" name="userpassword" placeholder="비밀번호에는 영어, 숫자, 특수문자가 각각 하나 이상 포함되어 있어야 합니다." >
							</div>
							<div class="form-group">
								<label>비밀번호 확인</label>
								<input class="form-control" type="password" id="password-2" placeholder="위에서 입력한 비밀번호를 한 번 더 입력하세요." >
							</div>
							<div class="mt-5 text-right">
								<button class="btn btn-danger btn-lg" type="button" onclick="checkforms()">제출</button>
							</div>
						</form>
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
<script type="text/javascript">
 // 여기에 정규식 사용해서 검사하는 것도 추가할 것
 // 조건 1. 아이디는 영어 또는 영어+숫자로 구성되어야 함
 // 조건 2. 비밀번호는 4자리 이상, 영어+숫자+특수문자 모두 하나씩 포함되어 있어야 함
 // 조건 3. 이메일 주소는 %@%.% 형식이 되어야 함
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
			alert("입력받은 두 비밀번호가 일치하지 않습니다.");
			return;
		}

		if (confirm("확인 버튼을 누르시면 회원가입이 완료됩니다.")) {
			document.querySelector("#ip-form").submit();
		}
	}
</script>
</body>
</html>