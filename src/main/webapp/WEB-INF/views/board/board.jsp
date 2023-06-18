<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />
</head>
<body>
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
		<div class="container">
			<a class="navbar-brand text-primary fw-bold" href="/">
				공유 게시판 </a>
		</div>
	</nav>
	<div style="margin-top: 80px;"></div>
	<div class="col-lg-8 col-md-10 col-sm-12 container flex-column">
		<div class="row align-self-center mb-2">
            <div class="col-md-2 text-start">
              <div type="button" class="btn btn-primary" style="margin: 0 auto !important;" id="write">글 작성</div>
            </div>
            <div class="col-md-7 offset-3">
              <form class="d-flex" id="form-search" action="">
                <input type="hidden" name="action" value="list"/>
                <input type="hidden" name="pgno" value="1"/>
                <select
                  name="key"
                  id="key"
                  class="form-select form-select-sm ms-5 me-1 w-50"
                  aria-label="검색조건"
                >
                  <option selected>검색조건</option>
                  <option value="article_no">글번호</option>
                  <option value="subject">제목</option>
                  <option value="user_id">작성자</option>
                </select>
                <div class="input-group input-group-sm">
                  <input type="text" name="word" id="word" class="form-control" placeholder="검색어..." />
                  <button id="btn-search" class="btn btn-dark" type="button">검색</button>
                </div>
              </form>
            </div>
          </div>
	</div>
	
	<div class="container d-flex flex-column">
		<table class="table">
			<thead>
				<tr class="text-center">
					<th scope="col" class="col-md-2">글 번호</th>
					<th scope="col" class="col-md-2">작성자</th>
					<th scope="col" class="col-md-5">내용</th>
					<th scope="col" class="col-md-1">조회수</th>
					<th scope="col" class="col-md-2">작성일자</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach var="article" items="${articles}">
					<tr class="text-center">
						<th scope="row">${article.articleNo}</th>
						<td>${article.userId}</td>
						<td class="text-start"><a href="${root}/board/view?articleNo=${article.articleNo}"
							class="article-title link-dark" data-no="${article.articleNo}"
							style="text-decoration: none">
								${article.subject} </a></td>
						<td>${article.hit}</td>
						<td>${article.registerTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- <div type="button" class="btn btn-primary"
			style="margin: 0 auto !important;" id="write">글 작성</div> -->
	</div>
	<div class="row">${navigation.navigator}</div>
	

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script src="/assets/js/board.js"></script>
</body>
</html>
