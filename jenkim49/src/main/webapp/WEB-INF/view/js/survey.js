/*
 * accord.js
 */

function survey_insert_form() {
	document.f.action = "survey_insert_form";
	document.f.submit();
}

function survey_insert_action() {
	document.f.action = "survey_insert_action";
	document.f.method = "POST";
	document.f.submit();
}

function survey_list() {
	document.f.action = "survey_list";
	document.f.submit();
}

function survey_update_form() {
	document.f.action = "survey_update_form";
	document.f.submit();
}

function survey_update_action() {
	document.f.action = "survey_update_action";
	document.f.method = "POST";
	document.f.submit();
}

function survey_delete_action() {
	if (confirm("이 설문결과를 삭제하시겠습니까?")) {
		document.f.action = "survey_delete_action";
		document.f.method = "POST";
		document.f.submit();
	}
}
