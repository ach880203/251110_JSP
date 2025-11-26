
function checkId() {
    var userId = document.getElementById("userId").value;
    
    if (userId.trim() === "") {
        alert("아이디를 입력해주세요.");
        return;
    }
    
    // 아이디 유효성 검사 (영문, 숫자만 허용, 4-12자)
    var idPattern = /^[a-zA-Z0-9]{4,12}$/;
    if (!idPattern.test(userId)) {
        alert("아이디는 영문, 숫자 4-12자로 입력해주세요.");
        return;
    }
    
    // 중복 확인 요청
    window.location.href = "FruitServlet?command=fruit_id_check&userId=" + userId;
}

function useThisId() {
    var userId = document.getElementById("userId").value;
    
    if (userId.trim() === "") {
		alert("아이디를 설정하려면 먼저 중복 확인을 해주세요.");
        return;
    }
    
    // 부모 창의 아이디 입력란에 값 설정
    opener.document.joinForm.userId.value = userId;
    opener.document.joinForm.idChecked.value = "true";
    
    alert("아이디가 설정되었습니다.");
    window.close();
}
