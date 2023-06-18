<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>사용자 정보 관리 사이트</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />
<style>
nav {
	background: url("/assets/img/login_logo_bg.png");
	background-size: cover;
}
</style>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<div class="container">
			<a class="navbar-brand text-primary fw-bold" href="index.jsp"
				style="font-size: 150px !important; color: aliceblue !important">
				Enjoy Trip </a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
	</nav>
	<div style="margin-top: 80px"></div>

	<main class="container"
		style="position: relative !important; height: calc(100vh - 56px) !important">
		<div class="col-4"
			style="position: absolute !important; top: 50% !important; transform: translate(0, -50%)">
			<form method="post" id="form-login" action="">
				<div class="mb-3">
					<label for="id" class="form-label">아이디</label> <input type="text"
						name="userid" class="form-control" id="userid"
						aria-describedby="userid" />
				</div>
				<div class="mb-3">
					<label for="password" class="form-label">비밀번호</label> <input
						type="password" name="userpwd" class="form-control" id="userpwd" />
				</div>

				<div class="mb-3">
					<span type="submit" class="btn btn-primary" onclick="login();">로그인</span>
					<span class="btn" style="float:right;" onclick="location.href='register'">회원가입</span>
					<span class="btn" style="float:right;" onclick="location.href='find'">비밀번호 찾기</span>
				</div>
			</form>
		</div>
		<div>
			<div class="text-danger mb-2">${msg}</div>
		</div>
	</main>

	<footer
		class="navbar navbar-expand-lg navbar-light bg-light container justify-content-end fixed-bottom rounded-3">
		<div class="row">
			<ul class="navbar-nav">
				<li><a href="#" class="nav-link text-secondary">카페소개</a></li>
				<li><a href="#" class="nav-link text-secondary">개인정보처리방침</a></li>
				<li><a href="#" class="nav-link text-secondary">이용약관</a></li>
				<li><a href="#" class="nav-link text-secondary">오시는길</a></li>
				<li><label class="nav-link text-secondary">&copy; SSAFY
						Corp.</label></li>
			</ul>
		</div>
	</footer>

	<script type="text/javascript" src="/assets/js/login.js"></script>
</body>
</html>
