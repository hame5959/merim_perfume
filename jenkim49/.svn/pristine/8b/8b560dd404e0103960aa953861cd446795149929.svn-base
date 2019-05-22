<%@page import="jenkim49.accord.Accord"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Accord> accordList = (List<Accord>)request.getAttribute("accordList");
	String m_id=(String)session.getAttribute("sMemberId");
	boolean isLogin=false;
	if(m_id!=null){
		isLogin=true;
	}
	String MSG = (String)request.getAttribute("MSG");
	String URL = (String)request.getAttribute("URL");
%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
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
<!-- CSS ============================================= -->
<link rel="stylesheet" href="css/linearicons.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href="css/ion.rangeSlider.css" />
<link rel="stylesheet" href="css/ion.rangeSlider.skinFlat.css" />
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">

<!-- JavaScript ============================================= -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">
// multiple checks
$(document.sm1).ready(function() {
    $('input[type="checkbox"][name="part1_gender"]').click(function(){
        if ($(this).prop('checked') && $('input[type="checkbox"][name="part1_gender"]:checked').size()>1) {
        	$('input[type="checkbox"][name="part1_gender"]:checked').prop('checked', false);
        	alert('2개 이상 선택할 수 없습니다.');
        } 
    });
});
$(document.sm2).ready(function() {
    $('input[type="checkbox"][name="part2_age"]').click(function(){
        if ($(this).prop('checked') && $('input[type="checkbox"][name="part2_age"]:checked').size()>1) {
        	$('input[type="checkbox"][name="part2_age"]:checked').prop('checked', false);
        	alert('2개 이상 선택할 수 없습니다.');
        }
    });
});
$(document.sm4).ready(function() {
    $('input[type="checkbox"][name="part3_preference"]').click(function(){
        if ($(this).prop('checked') && $('input[type="checkbox"][name="part3_preference"]:checked').size()>1) {
        	$('input[type="checkbox"][name="part3_preference"]:checked').prop('checked', false);
        	alert('2개 이상 선택할 수 없습니다.');
        }
    });
});
$(document.sm5).ready(function() {
    $('input[type="checkbox"][name="part4_accord[]"]').click(function(){
        if ($(this).prop('checked') && $('input[type="checkbox"][name="part4_accord[]"]:checked').size()>3) {
        	$('input[type="checkbox"][name="part4_accord[]"]:checked').prop('checked', false);
        	alert('4개 이상 선택할 수 없습니다.');
        }
    });
});

function surveyResultInsert() {
	var part1_gender = $('input[type="checkbox"][name="part1_gender"]:checked').size();
	var part2_age = $('input[type="checkbox"][name="part2_age"]:checked').size();
	var part3_preference = $('input[type="checkbox"][name="part3_preference"]:checked').size();
	var part4_accord = $('input[type="checkbox"][name="part4_accord[]"]:checked').size();
	if(part1_gender==0){
		alert("성별을 선택해 주세요");
	} else if(part2_age==0){
		alert("나이를 선택해 주세요");
	} else if(part3_preference==0) {
		alert("선호하는 이미지를 선택해 주세요");
	} else if(part4_accord >= 0 && part4_accord < 3) {
		alert("좋아하는 향을 3가지 이상 선택해 주세요");
	} else {
		var totalCount = 0;
    	var accordArray = new Array();
    	$('input:checkbox[name="part4_accord[]"]').each(function(){
    		if(this.checked){
    			accordArray[totalCount]=this.value;
    			totalCount++;
    		}
    	});
    	if (confirm("Do you want to submit?")) {
    		 $.ajax({
    			 url : 'survey_insert_action',
     			type : 'POST',
     			dataType : 'text',
     			data : {
     				s_fav1 : accordArray[0],
     				s_fav2 : accordArray[1],
     				s_fav3 : accordArray[2],
     				s_age : $('input:checkbox[name="part2_age"]:checked').val(),
     				s_gender : $('input:checkbox[name="part1_gender"]:checked').val(),
     			},
     			success : function(data) {
     				alert("참여해주셔서 감사합니다");
     				document.sm1.action = "1survey_confirmation";
					document.sm1.submit();
     			}
    	    })
    	}
	}
}
</script>

</head>
<body>

	<!-- include_common_top.jsp start-->
	<jsp:include page="1include_common_header.jsp"/>			
	<!-- include_common_top.jsp end-->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center">
				<div class="col-first">
					<h1>Survey</h1>
					<nav class="d-flex align-items-center justify-content-start">
						<a href="1index">Home<i class="fa fa-caret-right" aria-hidden="true"></i></a> 
						<a href="1survey">Customer Survey</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->
	<!-- Start Billing Details Form -->
	<div class="container" align="center">
		<div class="col-lg-4 col-md-6" align="center">
			<div class="order-wrapper mt-50">
				<h3 class="billing-title mb-10">Perfume Survey</h3>
				<form name="sm0">
				<input type="hidden" id="m_id" name="m_id" value="${m_id }">
				</form>
				<form name="sm1">
				<h3>Part 1</h3>
				<!-- PART1 GENDER -->
				<h6>성별을 선택해 주세요</h6>
				<br>
				<ul class="row trial-product">
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
						<div class="radio-option">
							<input type="checkbox" value="F" name="part1_gender" id="part1_gender">
								<div class="inner"></div>
						</div>
					</span> 
						<span class="product-title">
								<p class="mb0">FEMALE</p>
						</span>
					</label>
					</li>
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
						<div class="radio-option">
							<input type="checkbox" value="M" name="part1_gender" id="part1_gender">
								<div class="inner"></div>
						</div>
					</span> 
						<span class="product-title">
								<p class="mb0">MALE</p>
						</span>
					</label>
					</li>
				</ul>
				</form>
				<hr>
				<h3>Part 2</h3>
				<!-- PART2 AGE -->
				<form name="sm2">
				<h6>나이를 선택해 주세요</h6>
				<br>
				<ul class="row trial-product">
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
					<div class="radio-option">
						<input type="checkbox" value="10대" name="part2_age" id="part2_age">
							<div class="inner"></div>
					</div></span> 
						<span class="product-title">
								<p class="mb0">10대</p>
						</span>
					</label>
					</li>
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
					<div class="radio-option">
						<input type="checkbox" value="20대전반" name="part2_age" id="part2_age">
							<div class="inner"></div>
					</div></span> 
					 	<span class="product-title">
								<p class="mb0">20대 전반 (20~24) </p>
						</span>
					</label>
					</li>
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
					<div class="radio-option">
						<input type="checkbox" value="20대후반" name="part2_age" id="part2_age">
							<div class="inner"></div>
					</div></span> 
						<span class="product-title">
								<p class="mb0">20대 후반 (25~29)</p>
						</span>
					</label>
					</li>
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
					<div class="radio-option">
						<input type="checkbox" value="30대전반" name="part2_age" id="part2_age">
							<div class="inner"></div>
					</div></span> 
					 	<span class="product-title">
								<p class="mb0">30대 전반 (30~34)</p>
						</span>
					</label>
					</li>
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
					<div class="radio-option">
						<input type="checkbox" value="30대후반" name="part2_age" id="part2_age">
							<div class="inner"></div>
					</div></span> 
						 <span class="product-title">
								<p class="mb0">30대 후반 (35~39)</p>
						</span>
					</label>
					</li>
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
					<div class="radio-option">
						<input type="checkbox" value="40대이상" name="part2_age" id="part2_age">
							<div class="inner"></div>
					</div></span>  
						<span class="product-title">
								<p class="mb0">40대 이상</p>
						</span>
					</label>
					</li>
				</ul>
				</form>
				<!-- part3 -->
				<hr>
				<form name="sm4">
				<h3>Part 3</h3>
				<h6>다음 네 가지 예시 중 가장 마음에 드는 향을 골리주세요</h6>
				<br>
				<ul class="row trial-product">
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
					<div class="radio-option">
						<input type="checkbox" value="floral_fruity" name="part3_preference" id="part3_preference">
						<div class="inner"></div>
					</div>
					</span> 
						 <span class="product-title">
								<img alt="" src="./img/survey/floral_fruity.jpg">
								<p class="mb0">달콤하고 스윗한</p>
								<p class="payment-info">꽃향기, 과일향들로 특히 여성들에게 인기있는 계열</p>
						</span>
					</label>
					</li>
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
					<div class="radio-option">
						<input type="checkbox" value="floral_fruity" name="part3_preference" id="part3_preference">
						<div class="inner"></div>
					</div>
					</span> 
						 <span class="product-title">
								<img alt="" src="./img/survey/citrus_fresh.jpg">
								<p class="mb0">상큼하고 프레쉬한</p>
								<p class="payment-info">오렌지, 베르가못 등의 상큼한 top 노트 유니섹스 계열</p>
						</span>
					</label>
					</li>
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
					<div class="radio-option">
						<input type="checkbox" value="woody_oriental" name="part3_preference" id="part3_preference">
						<div class="inner"></div>
					</div>
					</span> 
						 <span class="product-title">
								<img alt="" src="./img/survey/woody_oriental.jpg">
								<p class="mb0">우디, 오리엔탈</p>
								<p class="payment-info">독특함, 이국적이며 고혹적인 매력의 유니섹스 계열</p>
						</span>
					</label>
					</li>
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
					<div class="radio-option">
						<input type="checkbox" value="mascu_line" name="part3_preference" id="part3_preference">
						<div class="inner"></div>
					</div>
					</span> 
						 <span class="product-title">
								<img alt="" src="./img/survey/mascu-line.jpg">
								<p class="mb0">남성적인 매력</p>
								<p class="payment-info">프레시, 마린, 스파이시 등 다양한 남성적인 느낌의 계열</p>
						</span>
					</label></li>
				</ul>
				</form>
				<!-- part4 -->
				<hr>
				<form name="sm5">
				<h3>Part 4</h3>
				<h6>좋아하는 어코드 3가지를 선택해 주세요</h6>
				<br>
				<ul class="row trial-product">
				<% for(Accord accord:accordList) { %>
					<li class="col-xs-12 col-sm-6">
					<label> 
					<span class="check-area">
					<div class="radio-option">
						<input type="checkbox" value="<%=accord.getAcd_name() %>" name="part4_accord[]" id="part4_accord[]">
						<div class="inner"></div>
					</div>
					</span> 
						 <span class="product-title">
								<img width="50px" height="50px" alt="" src="./img/survey/<%=accord.getAcd_img() %>">
								<p class="mb0"><%=accord.getAcd_name() %></p>
								<p class="payment-info"><%=accord.getAcd_des() %></p>
						</span>
					</label>
					</li>
				<% } %>
				</ul>
				</form>
				<button class="view-btn color-2 w-100 mt-20" onclick="surveyResultInsert();"><span>Submit</span></button>
			</div>
		</div>
	</div>
	<!-- include_common_top.jsp start-->
	<jsp:include page="1include_common_footer.jsp"/>			
	<!-- include_common_top.jsp end-->


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
	<script src="js/main.js"></script>
</body>
</html>