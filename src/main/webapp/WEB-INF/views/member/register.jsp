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
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />
  </head>
  <body>

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
    <div style="margin-top: 80px;"></div>
    
    
    
    <main class="container">
      <form method="post" class="col-4" id="form-register"
      style="position: absolute !important; top: 50% !important; transform: translate(0, -50%)">
        <div class="mb-3">
          <label for="name" class="form-label">이름</label>
          <input type="text" name="username" class="form-control" id="name" aria-describedby="id">
        </div>
        <div class="mb-3">
          <label for="id" class="form-label">아이디</label>
          <input type="text" name="userid" class="form-control" id="id" aria-describedby="id">
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">비밀번호</label>
          <input type="password" name="userpwd" class="form-control" id="password">
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">비밀번호 확인</label>
          <input type="password" class="form-control" id="password-chk">
        </div>
        <div class="mb-3">
          <label for="email" class="form-label">이메일</label>
          <input type="email" name="email" class="form-control" id="email" aria-describedby="id">
        </div>
        <div class="mb-3">
          <label for="age" class="form-label">나이</label>
          <input type="number" name="age" class="form-control" id="age" aria-describedby="age">
        </div>
        <div class="mb-3">
          <label for="gender" class="form-label">성별</label>
          <select class="form-select" name="gender" id="gender">
          	<option value="0">남자</option>
          	<option value="1">여자</option>
          </select>
        </div>
        <div class="btn btn-primary" onclick="regist();">회원가입</div>
      </form>
    </main>

    <footer
      class="navbar navbar-expand-lg navbar-light bg-light container justify-content-end fixed-bottom rounded-3"
    >
      <div class="row">
        <ul class="navbar-nav">
          <li><a href="#" class="nav-link text-secondary">카페소개</a></li>
          <li><a href="#" class="nav-link text-secondary">개인정보처리방침</a></li>
          <li><a href="#" class="nav-link text-secondary">이용약관</a></li>
          <li><a href="#" class="nav-link text-secondary">오시는길</a></li>
          <li><label class="nav-link text-secondary">&copy; SSAFY Corp.</label></li>
        </ul>
      </div>
    </footer>

    <script type="text/javascript" src="/assets/js/register.js"></script>
  </body>
</html>
