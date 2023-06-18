function getGugun() {
	var sidoCode = document.getElementById("search-sido").value;

	location.href = "./getGugun?sidoCode=" + sidoCode;
}

function getList() {
	var url = new URL(window.location.href);
	var sidoCode = (url.searchParams.get('sidoCode'));
	if (sidoCode == null)
		alert("관광 도시를 선택하세요");
	else {
		var gugunCode = document.getElementById("search-gugun").value;
		var contentTypeId = document.getElementById("search-content-id").value;

		location.href = "./byCategory?sidoCode=" + sidoCode + "&gugunCode="
				+ gugunCode + "&cateCode=" + contentTypeId;
	}
}

function getSort() {
	var url = new URL(window.location.href);
	var sidoCode = (url.searchParams.get('sidoCode'));
	if (sidoCode == null)
		sidoCode = 0;
	var gugunCode = (url.searchParams.get('gugunCode'));
	if (gugunCode == null)
		gugunCode = 0;
	var contentTypeId = (url.searchParams.get('cateCode'));
	if (contentTypeId == null)
		alert("정렬 가능한 결과가 없음");
	else {
		var sortType = document.getElementById("search-sort-type").value;

		location.href = "./getSort?sidoCode=" + sidoCode + "&gugunCode="
				+ gugunCode + "&cateCode=" + contentTypeId + "&sortType="
				+ sortType;
	}
}