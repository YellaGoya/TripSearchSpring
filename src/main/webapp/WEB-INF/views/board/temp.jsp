<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 페이지만의 내용 --%>
	<div class="container p-4">

		<h2>게시글 상세 정보</h2>
		<a class="btn btn-danger"
			href="delete?articleno=${article.articleNo}">삭제</a>
		<a class="btn"
			href="modify?articleno=${article.articleNo}">수정</a>
		
		<table class="table table-striped">
			<tr>
				<td>고유번호</td>
				<td>${article.articleNo}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${article.subject}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${article.content}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${article.hit}</td>
			</tr>
			<tr>
				<td>등록날짜</td>
				<td>${article.registerTime}</td>
			</tr>
		</table>

	</div>
</body>
</html>