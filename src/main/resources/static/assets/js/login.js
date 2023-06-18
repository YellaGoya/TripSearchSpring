function login() {
	// 문서에서 id로 input data 가져오기
	if (!document.querySelector("#userid").value) {
		alert("아이디 입력!!");
		return;
	} else if (!document.querySelector("#userpwd").value) {
		alert("비밀번호 입력!!");
		return;
	} else {
		let form = document.querySelector("#form-login");
		form.setAttribute("action", "login");
		form.submit();
	}

}

