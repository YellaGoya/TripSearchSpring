<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />
  </head>
  <body class="container d-flex flex-column">
    <nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
      <div class="container">
        <a class="navbar-brand text-primary fw-bold" href="/"> Enjoy Trip </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        
      </div>
    </nav>

    <div style="height: 150px !important;"></div>

	
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10 col-sm-12">
				<h2 class="my-3 py-3 shadow-sm bg-light text-center">
					글보기
				</h2>
			</div>
			<div class="col-lg-8 col-md-10 col-sm-12">
				<div class="row my-2">
					<h2 class="text-secondary px-5">${article.subject}</h2>
				</div>
				<div class="row">
					<div class="col-md-8">
						<div class="clearfix align-content-center">
							<img class="avatar me-2 float-md-start bg-light p-2"
								src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg" />
							<p>
								<span class="fw-bold">${article.userId}</span> <br /> <span
									class="text-secondary fw-light"> ${article.registerTime}
									조회 : ${article.hit} </span>
							</p>
						</div>
					</div>
					<!-- <div class="col-md-4 align-self-center text-end">댓글 : 17</div> -->
					<div class="divider mb-3"></div>
					<div class="text-secondary">${article.content}</div>
					<div class="divider mt-3 mb-3"></div>
					<div class="d-flex justify-content-end">
						<button type="button" id="btn-list"
							class="btn btn-outline-primary mb-3">글목록</button>
						<c:if test="${userinfo.userId eq article.userId}">
							<button type="button" id="btn-mv-modify"
								class="btn btn-outline-success mb-3 ms-1">글수정</button>
							<button type="button" id="btn-delete"
								class="btn btn-outline-danger mb-3 ms-1">글삭제</button>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	

	<!-- <form method="post" id="board-write" action="write">
	    <div class="mb-0">제목</div>
	    <div class="form-floating">
	      <textarea name="subject"
	        class="form-control"
	        placeholder="Leave a comment here"
	        id="subject"
	      ></textarea>
	      <label for="subject">제목을 입력해주세요</label>
	    </div>
	    <div class="mb-0 mt-3">글 내용</div>
	    <div class="form-floating">
	      <textarea name="content"
	        class="form-control"
	        placeholder="Leave a comment here"
	        id="content"
	        style="height: 500px; margin-bottom: 20px !important;"
	      ></textarea>
	      <label for="content">내용을 작성해주세요</label>
	    </div>
		<div><input type="submit" class="btn btn-primary" style="margin: 0 auto !important;" value="글 작성"></div>
	    <div type="button" class="btn btn-primary" style="margin: 0 auto !important;" id="write">글 작성</div>
	</form> -->
	<script>
      document.querySelector("#btn-list").addEventListener("click", function () {
        location.href = "list";
      });
      document.querySelector("#btn-mv-modify").addEventListener("click", function () {
        location.href = "modify?articleno=${article.articleNo}";
      });
      document.querySelector("#btn-delete").addEventListener("click", function () {
        location.href = "delete?articleno=${article.articleNo}";
      });
    </script>
	
	
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    <script type="text/javascript" src="/assets/js/writeBoard.js"></script>
  </body>
</html>
