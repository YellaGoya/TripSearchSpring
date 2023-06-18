function regist() {
	// 문서에서 id 로 input data 가져오기
	let id = document.getElementById("id").value;
	let password = document.getElementById("password").value;
	let password_chk = document.getElementById("password-chk").value;
	let name = document.getElementById("name").value;
	let email = document.getElementById("email").value;

	// 입력값 검증
	if (!(id && password && name && email)) {
		alert("빈칸이 없도록 입력해주세요.");
		return;
	} else if (password != password_chk) {
		alert("비밀번호가 일치하지 않습니다.");
		return;
	} else {
		let form = document.querySelector("#form-register");
		form.setAttribute("action", "register");
		form.submit();
	}
}