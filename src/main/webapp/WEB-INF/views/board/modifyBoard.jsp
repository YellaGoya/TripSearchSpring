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

	<form method="post" id="board-write" action="modify">
		<input type="hidden" name="articleNo" value="${article.articleNo}">
	    <div class="mb-0">제목</div>
	    <div class="form-floating">
	      <textarea name="subject"
	        class="form-control"
	        placeholder="Leave a comment here"
	        id="subject"
	      >${article.subject}</textarea>
	    </div>
	    <div class="mb-0 mt-3">글 내용</div>
	    <div class="form-floating">
	      <textarea name="content"
	        class="form-control"
	        placeholder="Leave a comment here"
	        id="content"
	        style="height: 500px; margin-bottom: 20px !important;"
	      >${article.content}</textarea>
	    </div>
		<div><input type="submit" class="btn btn-primary" style="margin: 0 auto !important;" value="글 수정"></div>
	    <!-- <div type="button" class="btn btn-primary" style="margin: 0 auto !important;" id="write">글 작성</div> -->
	</form>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
