function find() {
	// 문서에서 id로 input data 가져오기
	if (!document.querySelector("#name").value) {
		alert("이름 입력!!");
		return;
	} else if (!document.querySelector("#id").value) {
		alert("아이디 입력!!");
		return;
	} else if (!document.querySelector("#email").value) {
		alert("이메일 입력!!");
		return;
	} else {
		let form = document.querySelector("#form-find");
		form.submit();
	}

}

