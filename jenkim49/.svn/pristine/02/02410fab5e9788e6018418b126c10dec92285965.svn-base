<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<HashMap> jumundetailList=
(ArrayList<HashMap>)request.getAttribute("jd_list_jno");


String ERROR_MSG=(String)request.getAttribute("ERROR_MSG");


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
<%
if(ERROR_MSG!=null){
	out.println("alert('"+ERROR_MSG+"')");	
}
%>


           
           
           


      
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
				<h1>Order List Detail</h1>
				<nav class="d-flex align-items-center justify-content-start">
					<a href="1index">Home<i class="fa fa-caret-right"
						aria-hidden="true"></i></a><a href="jd_list_jno">Order List Detail</a>
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
						<h3 class="billing-title text-center">Order Detail</h3>
						<p class="text-center mt-80 mb-40"></p>
						<table class="table table-striped">
							<thead>
							<th>주문상세번호</th>
							<th>상품 이미지</th>
							<th>상품 수량</th>
							<th>상품 가격</th>
							<th>주문번호</th>
							<th>상품명</th>
							</thead>
							<tbody>
							<%for(HashMap jd: jumundetailList){ %>
							<tr>
							<td><%= jd.get("jd_no") %></td>
							<td><img src="img/product/<%= jd.get("p_image") %>" alt="No image" style="width: 100px"></img></td>
							<td><%= jd.get("jd_item_qty") %></td>
							<td><%= jd.get("jd_items_price") %></td>
							<td><%= jd.get("j_no") %></td>
							<td><%= jd.get("p_name") %></td>
							</tr>
							<%} %>
							</tbody>
						</table>
						
					
    				
    				<div class="form-group" align="left">
    					<a class="view-btn color-2 mt-20 w-20" onclick="history.back(-1)"><span>뒤로</span></a>
    				
    				</div>
    					
    					
    					
    					
    					
					
						
						
							
					
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