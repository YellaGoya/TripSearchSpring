<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SSAFY BOOK CAFE</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />

<style>
#login {
	display: block;
}

#logout {
	display: block;
}

body::-webkit-scrollbar {
	display: none;
}
</style>

</head>
<body>
	<script src="/assets/js/getData.js"></script>
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
		<div class="container">
			<a class="navbar-brand text-primary fw-bold" href="/"> Enjoy Trip
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-lg-0"></ul>
				${loginUser.userName}
				<!-- 로그인 전 -->
				<c:if test="${empty userinfo}">
					<ul class="navbar-nav mb-2 me-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="user/login" id="login">로그인</a></li>
					</ul>
					<ul class="navbar-nav mb-2 me-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="user/register" id="register">회원가입</a></li>
					</ul>
				</c:if>

				<!-- 로그인 후 -->
				<c:if test="${not empty userinfo}">
					<ul class="navbar-nav mb-2 me-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="user/logout" id="logout"
							style="cursor: pointer !important;">로그아웃</a></li>
					</ul>

					<ul class="navbar-nav mb-2 me-2 mb-lg-0">
						<li class="nav-item dropdown" id="mypage"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								내정보 </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="manageinfo.jsp">조회 /
										관리</a></li>
								<li><a class="dropdown-item" href="#"
									data-bs-toggle="modal" data-bs-target="#pollModal">나의 여행 계획</a></li>
							</ul></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								커뮤니케이션 </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="#">공지사항</a></li>
								<li><a class="dropdown-item"
									href="board/list?pgno=1&key=&word=">공유 게시판</a></li>
								<li><a class="dropdown-item" href="./hotplace.jsp">핫
										플레이스</a></li>
								<li><a class="dropdown-item" href="#">여행 뉴스</a></li>
							</ul></li>
					</ul>
				</c:if>

			</div>
		</div>
	</nav>
	<!-- 상단 navbar end -->
	<!-- 중앙 content start -->
	<div class="container">
		<div style="height: 70px"></div>
		<div class="row">
			<!-- 지역 메뉴 end -->
			<!-- 설문조사 start -->
			<!-- 설문조사 end -->
		</div>
		<!-- 중앙 center content end -->
		<div class="col-md-12">
			<div class="alert alert-primary mt-3 text-center fw-bold"
				role="alert">전국 관광지 정보</div>
			<!-- 관광지 검색 start -->
			<form class="d-flex my-3" onsubmit="return false;" role="search">
				<select id="search-sido" class="form-select me-2"
					onchange="getGugun()">
					<option value="-1" selected hidden></option>
					<option value="0" id="s-0">지역</option>
					<option value="1" id="s-1">서울</option>
					<option value="2" id="s-2">인천</option>
					<option value="3" id="s-3">대전</option>
					<option value="4" id="s-4">대구</option>
					<option value="5" id="s-5">광주</option>
					<option value="6" id="s-6">부산</option>
					<option value="7" id="s-7">울산</option>
					<option value="8" id="s-8">세종</option>
					<option value="31" id="s-31">경기</option>
					<option value="32" id="s-32">강원</option>
					<option value="33" id="s-33">충북</option>
					<option value="34" id="s-34">충남</option>
					<option value="35" id="s-35">경북</option>
					<option value="36" id="s-36">경남</option>
					<option value="37" id="s-37">전북</option>
					<option value="38" id="s-38">전남</option>
					<option value="39" id="s-39">제주</option>
				</select> <select id="search-gugun" class="form-select me-2">
					<option value="-1" selected hidden></option>
					<option value="0" id="g-0">시/군/구</option>
					<c:forEach var="gugun" items="${guguns}">
						<option value="${gugun.code}" id="g-${gugun.code}">${gugun.name}</option>
					</c:forEach>
				</select> <select id="search-content-id" class="form-select me-2"
					onchange="getList()">
					<option value="-1" selected hidden></option>
					<option value="0" id="c-0">관광지 유형</option>
					<option value="12" id="c-12">관광지</option>
					<option value="14" id="c-14">문화시설</option>
					<option value="15" id="c-15">축제공연행사</option>
					<option value="25" id="c-25">여행코스</option>
					<option value="28" id="c-28">레포츠</option>
					<option value="32" id="c-32">숙박</option>
					<option value="38" id="c-38">쇼핑</option>
					<option value="39" id="c-39">음식점</option>
				</select> <select id="search-sort-type" class="form-select me-2"
					onchange="getSort()">
					<option value="0" selected>정렬</option>
					<option value="1">관광지 명</option>
					<option value="2">주소</option>
				</select>
				<div style="width: 300px"></div>
				<input id="search-keyword" class="form-control me-2" type="search"
					placeholder="검색어" aria-label="검색어" />

				<button id="btn-search" class="btn btn-outline-success"
					type="button">검색</button>
			</form>
			<!-- kakao map start -->
			<div id="map" class="mt-3 rounded-2"
				style="width: 100%; height: 400px"></div>
			<!-- kakao map end -->
			<div class="row">
				<table class="table table-striped" id="areaList"
					style="display: none;">
					<thead>
						<tr>
							<th style="width: 10%">대표이미지</th>
							<th style="width: 30%">관광지명</th>
							<th style="width: 46%">주소</th>
							<th style="width: 10%">위도</th>
							<th style="width: 10%">경도</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="area" items="${areas}">
							<tr onclick="moveCenter(${area.latitude}, ${area.longitude});">
								<th><img src="${area.image}" width="100px"></th>
								<td>${area.title}</td>
								<td>${area.addr}</td>
								<td>${area.latitude}</td>
								<td>${area.longitude}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- 관광지 검색 end -->
		</div>
	</div>
	<!-- 중앙 content end -->

	<!-- 하단 footer start -->
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
	<!-- 하단 footer end -->

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d474d18bec1622644d9b1266e170855f&libraries=services,clusterer,drawing"></script>
	<script>
		var url = new URL(window.location.href);
		var sidoCode = (url.searchParams.get('sidoCode'));
		var gugunCode = (url.searchParams.get('gugunCode'));
		var contentTypeId = (url.searchParams.get('cateCode'));
		
		if(sidoCode != null)
			document.getElementById("s-" + sidoCode).selected=true;
		else
			document.getElementById("s-0").selected=true;
		
		if(gugunCode != null)
			document.getElementById("g-" + gugunCode).selected=true;
		else
			document.getElementById("g-0").selected=true;
		
		if(contentTypeId != null)
			document.getElementById("c-" + contentTypeId).selected=true;
		else
			document.getElementById("c-0").selected=true;
			
	    if(`${areas}` != ``){
		    document.getElementById("areaList").style.display = 'block';
		    var positions; // marker 배열.
		    makeList();
		    function makeList() {
		        positions = [];
		        var arr = new Array();
		        <c:forEach items = "${areas}" var="area">
		            arr.push({image:"${area.image}"
		                , title : "${area.title}"
		                , addr : "${area.addr}"
		                , latitude : "${area.latitude}"
		                , longitude : "${area.longitude}"
		            });
		        </c:forEach>
		        for(let i = 0; i < arr.length; i++)
		            {
		                let markerInfo = {
		                    title: arr[i].title,
		                    latlng: new kakao.maps.LatLng(arr[i].latitude, arr[i].longitude)
		                };
		                positions.push(markerInfo);
		            }
		        }
		      
		    var mapContainer = document.getElementById("map"), // 지도를 표시할 div
		    mapOption = {
		        center: positions[0].latlng, // 지도의 중심좌표
		        level: 5, // 지도의 확대 레벨
		    };
		      
		      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		    var map = new kakao.maps.Map(mapContainer, mapOption);
		      
		    displayMarker();
		
		    function displayMarker() {
		        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
		        for (var i = 0; i < positions.length; i++) {
		            var imageSize = new kakao.maps.Size(24, 35); 
		            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
		            var marker = new kakao.maps.Marker({
		                map: map, // 마커를 표시할 지도
		                position: positions[i].latlng, // 마커를 표시할 위치
		                title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
	                    image : markerImage // 마커 이미지 
	                });
		        }
		    }
	    }
	
	    function moveCenter(lat, lng) {
	        map.setCenter(new kakao.maps.LatLng(lat, lng));
	    }
    </script>
</body>
</html>
