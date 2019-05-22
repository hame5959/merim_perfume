<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<%@include file="api/daumapi.jsp"%>

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
$(function() {
	/** 회원가입 이벤트 처리 **/
	member_register_validation();
});

$(document).on('DOMNodeInserted','.error',function(e){
    $(e.target).css('color','gold');
 })

function member_register_validation() {
	$('#member_register_form').validate({
		rules : {
			m_id : {
				required : true,
				minlength : 1,
				maxlength : 20,
				remote : {
					url: "idCheckDupl",
					type: "GET",
					data: {
						m_id : function() {
						 return $("#m_id").val();
						}
					}
				}
			},
			m_password : {
				required : true,
				minlength : 1,
				maxlength : 20
			},
			m_name : {
				required : true,
				minlength : 2,
				maxlength : 10
			},
			m_contact : {
				required : true,
				digits : "digits",
				minlength : 10
				
			},
			m_email : {
				required : true,
				email : "email"
			},
			m_address : {
				required : true
			}
			
			
			
		},
		messages : {
			m_id : {
				required : "아이디를 입력하세요.",
				remote : "중복된 아이디입니다."
			},
			m_password : {
				required : "패스워드를 입력하세요."
			},
			m_name : {
				required : "이름을 입력하세요."
			},
			m_contact : {
				required : " - 없이 숫자만 입력하세요."
			},
			m_email : {
				required : "이메일을 입력하세요."
			},
			m_address : {
				required : "주소를 검색해주세요."
			}
			
			
			
			
		},
		submitHandler : function(e) {
			member_insert_action();
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
				<h1>Register</h1>
				<nav class="d-flex align-items-center justify-content-start">
					<a href="1index">Home<i class="fa fa-caret-right"
						aria-hidden="true"></i></a><a href="register">Register</a>
				</nav>
			</div>
		</div>
	</div>
</section>
	<!-- End Banner Area -->

	<!-- Start My Account -->
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="register-form">
					<h3 class="billing-title text-center">Register</h3>
					<p class="text-center mt-40 mb-30">Create your very own account
					</p>
					<form id="member_register_form" name="f" method="post">
					
						<input id="m_id" name="m_id" type="text" placeholder="아이디*"
							onfocus="this.placeholder='ID*'"
							onblur="this.placeholder = '아이디*'" required
							class="common-input mt-20">
						
							<input name="m_password"
							type="password" placeholder="비밀번호*"
							onfocus="this.placeholder='Password*'"
							onblur="this.placeholder = '비밀번호*'" required
							class="common-input mt-20">
							<input name="m_name"
							type="text" placeholder="이름*" onfocus="this.placeholder='Name*'"
							onblur="this.placeholder = '이름*'" required
							class="common-input mt-20">
							<input name="m_contact"
							type="text" placeholder="연락처*"
							onfocus="this.placeholder=' - 없이 숫자만 입력'"
							onblur="this.placeholder = '연락처*'" required
							class="common-input mt-20">
							<input name="m_email"
							type="text" placeholder="이메일*"
							onfocus="this.placeholder='E-mail*'"
							onblur="this.placeholder = '이메일*'" required
							class="common-input mt-20">
							
							
							
							<div class="input-group">
      <input name="m_address_pre" id="m_address_pre" type="text" placeholder="주소*"
							onfocus="this.placeholder='Address*'"
							onblur="this.placeholder = '주소*'" class="common-input mt-20" readonly="readonly">
							<span>
							<input id="m_address"
							name="m_address" type="hidden">
							</span>
      <span class="input-btn">
        <input type="button" onclick="findzipcode()" class="view-btn color-3 mt-20 w-20" value="주소 검색">
      </span>
      
    </div>
							
						
								
							
						
						
						<input name="m_address_detail" id="m_address_detail" type="text" placeholder="상세주소*"
							onfocus="this.placeholder='Address Detail*'"
							onblur="this.placeholder = '상세주소*'" required
							class="common-input mt-20">
							
						<button id="registerB" class="view-btn color-2 mt-20 w-100"
							type="submit">
							<span>Register</span>
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