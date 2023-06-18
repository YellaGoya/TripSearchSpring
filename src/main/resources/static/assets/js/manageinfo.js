function modify() {
	// 문서에서 id로 input data 가져오기
	if (!document.querySelector("#id").value
			|| !document.querySelector("#password").value
			|| !document.querySelector("#name").value
			|| !document.querySelector("#email").value) {
		alert("빈칸없이 입력해주세요!!");
		return;
	} else {
		let form = document.querySelector("#form-modify-remove");
		form.setAttribute("action", "MemberController?action=modify");
		form.submit();
	}

}

function remove() {
	// 문서에서 id로 input data 가져오기
	if (!document.querySelector("#id").value
			|| !document.querySelector("#password").value
			|| !document.querySelector("#name").value
			|| !document.querySelector("#email").value) {
		alert("빈칸없이 입력해주세요!!");
		return;
	} else {
		let form = document.querySelector("#form-modify-remove");
		form.setAttribute("action", "MemberController?action=remove");
		form.submit();
	}

}