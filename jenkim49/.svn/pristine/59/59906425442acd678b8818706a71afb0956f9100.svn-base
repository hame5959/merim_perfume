<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

%>
    <!DOCTYPE html>
    <html lang="zxx" class="no-js">
    <head>
    <script src="js/vendor/jquery-2.2.4.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
            <script src="js/vendor/bootstrap.min.js"></script>
            <script src="js/jquery.ajaxchimp.min.js"></script>
            <script src="js/jquery.nice-select.min.js"></script>
            <script src="js/jquery.sticky.js"></script>
            <script src="js/ion.rangeSlider.js"></script>
            <script src="js/jquery.magnific-popup.min.js"></script>
            <script src="js/owl.carousel.min.js"></script>            
            <script src="js/main.js"></script>
            <script src="js/member.js"></script>
            <script src="js/accord.js"></script>
            <script src="js/survey.js"></script>
            <script src="https://code.jquery.com/jquery-1.11.1.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
            <script src="js/messages_ko.js"></script>
<script type="text/javascript">
$(function() {
	/** 향 등록 유효성 검사 처리 **/
	accord_insert_validation();
});

$(document).on('DOMNodeInserted','.error',function(e){
    $(e.target).css('color','red');
 })

function accord_insert_validation() {
	$('#acd_form').validate({
		rules : {
			acd_name : {
				required : true,
				minlength : 1,
				maxlength : 20
				
			},
			acd_des : {
				required : true,
				minlength : 1
			},
			acd_img : {
				required: true
			}
		},
		submitHandler : function(e) {
			if(confirm("입력하신 향을 등록하시겠습니까?")){
				accord_insert_action();
			}
			
			
		}
	});
}
           
           
           


      
</script>
    
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
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
            <jsp:include page="header.jsp"/>
            <!-- End Header Area -->

            <!-- Start Banner Area -->
            <section class="banner-area organic-breadcrumb">
	<div class="container">
		<div class="breadcrumb-banner d-flex flex-wrap align-items-center">
			<div class="col-first">
				<h1>Accord Register</h1>
				<nav class="d-flex align-items-center justify-content-start">
					<a href="1index">Home
					<i class="fa fa-caret-right"
						aria-hidden="true"></i></a>
						<a href="admin">Admin
						<i class="fa fa-caret-right"
						aria-hidden="true"></i></a><a href="accord_insert_form">Accord Register</a>
				</nav>
			</div>
		</div>
	</div>
</section>
            <!-- End Banner Area -->

		<!-- Start Admin Button -->
		<div class="container">
				<div class="col-md-12">
					<div align="left">
						<h3 class="billing-title text-center">Admin Page</h3>
						<p class="text-center mt-80 mb-40"></p>
						<form id="acd_form" class="form-horizontal" name="f" method="post">
					<div class="form-group">
    					<label for="acd_name" class="col-lg-2 control-label">향 이름</label>
    						<div class="col-lg-10">
    					<input name="acd_name" type="text" class="form-control" id="acd_name" placeholder="Accord Name" required="required">
    						</div>
    				</div>
    				<div class="form-group">
    					<label for="acd_des" class="col-lg-2 control-label">향 설명</label>
    					<div class="col-lg-10">
    					<input name="acd_des" type="text" class="form-control" id="acd_des" placeholder="Accord Description" required="required">
    					</div>
    					</div>
    					<div class="form-group">
    					<label for="acd_img" class="col-lg-2 control-label">향 이미지</label>
    					<div class="col-lg-10">
    					<input name="acd_img" type="file" class="form-control" id="acd_img" placeholder="Accord Image" required="required">
    					</div>
    					</div>
    				
    				<div class="form-group" align="right">
    					<button onclick="accord_insert_validation()" class="view-btn color-2 mt-20 w-40"><span>향 등록</span></button>
    					<a class="view-btn color-2 mt-20 w-20" href="admin"><span>뒤로</span></a>
    				
    				</div>
    					
    					
    					
    					
    					
					
						
						
							
					
				</form>
					</div>
				</div>
			</div>
			<div id="list">
			
			</div>
		<!-- End Admin Button -->
		
<br>
<br>
<br>

            <!-- start footer Area -->      
            <jsp:include page="footer.jsp"/>
            <!-- End footer Area -->        

           
        </body>
    </html>