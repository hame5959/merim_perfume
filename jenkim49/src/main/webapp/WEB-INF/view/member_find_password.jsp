<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String MSG = (String)request.getAttribute("ERROR_MSG");
	if(MSG != null){
		
	}
%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<script src="https://code.jquery.com/jquery-1.11.1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
	<script src="js/messages_ko.js"></script>
<script type="text/javascript">
$(function() {
	/** 비번 찾기 이벤트 처리 **/
	member_find_password_validation();
});

$(document).on('DOMNodeInserted','.error',function(e){
    $(e.target).css('color','red');
 })

function member_find_password_validation() {
	$('#member_find_password').validate({
		rules : {
			m_id : {
				required : true,
				minlength : 1,
				maxlength : 20
			},
			m_name : {
				required : true,
				minlength : 1,
				maxlength : 20
			}
		},
		messages : {
			m_id : {
				required : "아이디를 입력하세요."
			},
			m_name : {
				required : "이름을 입력하세요."
			}
		},
		submitHandler : function(e) {
			var params = $("#member_find_password").serialize();
			$.ajax({
				url: "member_find_password_action",
				method: 'POST',
				data: params,
				dataType: "text",
				success: function(textData){
					if(textData=="Not Member"){
						alert("등록된 회원이 아닙니다.");
						$('#m_id').select();
					} else if(textData == "Confirm Name"){
						alert("회원이름을 확인하세요.");
						$('#m_name').select();
					} else {
						alert("비밀번호는 " + textData + " 입니다.");
						if(confirm("로그인 화면으로 이동하시겠습니까?")){
							location.href= 'login';
						}
					}
				}
			});
		}
	});
}
/*
	function member_find_password_action() {
		var param = $("#member_find_password").serialize();
		$.ajax({
			url : "member_find_password_action",
			method : "POST",
			data: param,
			dataType : "text",
			success : function(textData) {
				alert("비밀번호는 "+textData+"입니다.");
			}
		});
	}
	*/
</script>
<script src="js/vendor/jquery-2.2.4.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script src="js/vendor/bootstrap.min.js"></script>
<script src="js/jquery.ajaxchimp.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery.sticky.js"></script>
<script src="js/ion.rangeSlider.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>
<script src="js/member.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
	<script src="js/messages_ko.js"></script>
<script type="text/javascript">
	
	
	
</script>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="CodePixar">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Shop</title>

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<!--
            CSS
            ============================================= -->
<link rel="stylesheet" href="css/linearicons.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href="css/ion.rangeSlider.css" />
<link rel="stylesheet" href="css/ion.rangeSlider.skinFlat.css" />
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>

	<!-- Start Header Area -->
	<jsp:include page="header.jsp" />
	<!-- End Header Area -->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
	<div class="container">
		<div class="breadcrumb-banner d-flex flex-wrap align-items-center">
			<div class="col-first">
				<h1>Find My Password</h1>
				<nav class="d-flex align-items-center justify-content-start">
					<a href="1index">Home<i class="fa fa-caret-right"
						aria-hidden="true"></i></a><a href="member_find_password">Find Password</a>
				</nav>
			</div>
		</div>
	</div>
</section>
	<!-- End Banner Area -->

	<!-- Start My Account -->
	<div class="container">
		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8 col-lg-offset-2">
				<div class="login-form">
					<h3 class="billing-title text-center">Find Password</h3>
					<p class="text-center mt-80 mb-40">Don't worry! Enter your information to find your password</p>
					<form id="member_find_password" name="f" method="post">
						<input id="m_id" name="m_id" type="text" placeholder="ID*"
							onfocus="this.placeholder='아이디'" onblur="this.placeholder = 'ID*'"
							required class="common-input mt-20"> 
							<input id="m_name"
							name="m_name" type="text" placeholder="Name*"
							onfocus="this.placeholder='이름'"
							onblur="this.placeholder = 'Name*'" required
							class="common-input mt-20">
						<button id="findB" type="submit"
							class="view-btn color-2 mt-20 w-100">
							<span>Find my password</span>
						</button>
						
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- End My Account -->
	
	<br>
	<br>
	<br>

	<!-- start footer Area -->
	<jsp:include page="footer.jsp" />
	<!-- End footer Area -->

</body>
</html>