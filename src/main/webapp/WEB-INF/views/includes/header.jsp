<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
	
		<div id="header" class="clearfix">
			<h1>
				<a href="${pageContext.request.contextPath}/main">MySite</a>
			</h1>
			<c:if test="${sessionScope.authUser != null}">
				<ul>
					<li>${sessionScope.authUser.name}님 안녕하세요^^</li>
					<li><a href="${pageContext.request.contextPath}/user/logout" class="btn_s">로그아웃</a></li>
					<li><a href="" class="btn_s">회원정보수정</a></li>
				</ul>
			</c:if>
			<c:if test="${sessionScope.authUser == null}">
				<ul>
					<li><a href="${pageContext.request.contextPath}/user/loginform" class="btn_s">로그인</a></li>
					<li><a href="" class="btn_s">회원가입</a></li>
				</ul>
			</c:if>
		</div>
		<!-- //header -->

		<div id="nav">
			<ul class="clearfix">
				<li><a href="">입사지원서</a></li>
				<li><a href="">게시판</a></li>
				<li><a href="">갤러리</a></li>
				<li><a href="">방명록</a></li>
			</ul>
		</div>
		<!-- //nav -->
	</div>
</body>
</html>