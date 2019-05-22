/*
 * member.js
 */

function member_insert_form() {
	document.f.action = "member_insert_form";
	document.f.submit();
}

function member_insert_action() {
	var a = document.getElementById("m_address_pre").value;
	if(a==""){
		alert("주소를 검색해주세요.");
		return;
	}
    var b = document.getElementById("m_address_detail").value;
    
    document.getElementById("m_address").value = a +" "+ b;
	document.f.action = "member_insert_action";
	document.f.method = "POST";
	document.f.submit();
}

function member_update_form() {
	document.f.action = "member_update_form";
	document.f.submit();
}

function member_update_action() {
	if(confirm("회원정보를 수정하시겠습니까?")){
		document.f.action = "member_update_action";
		document.f.method = "POST";
		document.f.submit();
	}
}

function member_delete_action() {
	if (confirm("정말로 회원을 탈퇴하시겠습니까?")) {
		document.f.action = "member_delete_action";
		document.f.method = "POST";
		document.f.submit();
		alert('이용해주셔서 감사합니다.');
	}
}

function member_login_action() {
	document.f.action = "member_login_action";
	document.f.method = "POST";
	document.f.submit();
}

function member_logout_action() {
	document.f.action = "member_logout_action";
	document.f.method = "POST";
	document.f.submit();
}

function member_find_password(){
	document.f.action = "member_find_password";
	document.f.method = "POST";
	document.f.submit();
}
