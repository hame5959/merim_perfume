<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<script type="text/javascript">
	
</script>

<script src="js/member.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
<script src="js/messages_ko.js"></script>
<script type="text/javascript">
	$(function() {
		/** 로그인 이벤트 처리 **/
		member_login_validation();
	});
	
	$(document).on('DOMNodeInserted','.error',function(e){
	    $(e.target).css('color','red');
	 })

	function member_login_validation() {
		$('#member_login_form').validate({
			rules : {
				m_id : {
					required : true,
					minlength : 1,
					maxlength : 20
				},
				m_password : {
					required : true,
					minlength : 1,
					maxlength : 20
				}
			},
			messages : {
				m_id : {
					required : "아이디를 입력하세요.",
				},
				m_password : {
					required : "패스워드를 입력하세요.",
				}
			},
			submitHandler : function(e) {
				var m_id = $('#m_id').val();
				var m_password = $('#m_password').val();
				var params = "m_id="+m_id+"&m_password="+m_password;
				$.ajax({
					url: "idpwCheck",
					method: 'GET',
					data: params,
					dataType: "text",
					success: function(textData){
						if(textData=="true"){
							member_login_action();
						} else {
							alert("ID 또는 Password가 일치하지 않습니다.");
						}
					}
				});
			}
		});
	}
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
				<h1>Login</h1>
				<nav class="d-flex align-items-center justify-content-start">
					<a href="1index">Home<i class="fa fa-caret-right"
						aria-hidden="true"></i></a><a href="login">Login</a>
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
					<h3 class="billing-title text-center">Login</h3>
					<p class="text-center mt-80 mb-40">Welcome back! Sign in to
						your account</p>
					<form id="member_login_form" name="f" method="post">
						<input id="m_id" name="m_id" type="text" placeholder="ID*"
							onfocus="this.placeholder='아이디'" onblur="this.placeholder = 'ID*'"
							required class="common-input mt-20"> 
							<input id="m_password"
							name="m_password" type="password" placeholder="Password*"
							onfocus="this.placeholder='비밀번호'"
							onblur="this.placeholder = 'Password*'" required
							class="common-input mt-20">
						<button id="loginB" type="submit"
							class="view-btn color-2 mt-20 w-100">
							<span>Login</span>
						</button>
						<div 
							class="mt-20 d-flex align-items-center justify-content-between">
							
							<a href="member_find_password">Lost your password?</a>
						</div>
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