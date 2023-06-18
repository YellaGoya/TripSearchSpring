document.getElementById("write").addEventListener("click",()=>{
	// 문서에서 id 로 input data 가져오기
	let title = document.getElementById("subject").value;
	let content = document.getElementById("content").value;
	
	console.log(subject);
	console.log(content);

	// 입력값 검증
	if (!(title && content)) {
		alert("빈칸이 없도록 입력해주세요.");
		return;
	} else {
		let form = document.querySelector("#board-write");
		form.submit();
	}
});