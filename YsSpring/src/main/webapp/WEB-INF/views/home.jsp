<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
<h1>이게될까요 ?</h1>
	<c:choose>
		<c:when test="${empty id}">
			<a href="${pageContext.request.contextPath }/users/signup_form.do">회원가입</a>
			<a href="${pageContext.request.contextPath }/users/loginform.do ">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath }/users/private/info.do">${id} 님 로그인 중</a>
			<a href="${pageContext.request.contextPath }/users/logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>