<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h1>회원가입 페이지</h1>
	<form action="signup.do" method="post" name="myForm">
		<div class="form-group">
			<label for="id">아이디</label>
			<input class="form-control" type="text" name="id" id="id" />
		</div>
		<div class="form-group">
			<label for="pwd">비밀번호</label>
			<input class="form-control" type="password" name="pwd" id="pwd" />
		</div>
		<div class="form-group">
			<label for="pwd2">비밀번호</label>
			<input class="form-control" type="password" name="pwd2" id="pwd2" />
		</div>
		<div class="form-group">
			<label for="email">이메일</label>
			<input class="form-control" type="text" name="email" id="email"/> 
		</div>				
		<button class="btn btn-primary" type="submit">가입</button>
		<button class="btn btn-danger" type="reset">취소</button>
	</form>
</div>
</body>
</html>