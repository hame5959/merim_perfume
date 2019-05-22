
<%@page import="jenkim49.product.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
	int currentPage = (int)request.getAttribute("currentPage");
	int count = (int)request.getAttribute("count");
	int pageSize = (int)request.getAttribute("pageSize");
	int totalProductCount = (int)request.getAttribute("totalProductCount");
	int totalProductCountMen = (int)request.getAttribute("totalProductCountMen");
	int totalProductCountWomen = (int)request.getAttribute("totalProductCountWomen");
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
<link rel="stylesheet" href="css/nouislider.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">


<!-- JavaScript ============================================= -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="./resources/js/jquery.twbsPagination.js"></script>
<script src="./resources/js/jquery.twbsPagination.min.js"></script>
<script type="text/javascript">
/********************************************************************************************************************
 * pagination */
var PagingHelper = {      
		 'data' : { 
             currentPage :${currentPage}     // 현재페이지 
            ,pageSize : 5       // 페이지 사이즈 (화면 출력 페이지 수) 
            ,maxListCount : ${pageSize}  // (보여질)최대 리스트 수 (한페이지 출력될 항목 갯수)
            ,startnum : 1       // 시작 글번호
            ,lastnum : 10       // 마지막 글번호
            ,totalCnt : ${count}       // 전체 글의 갯수.
            ,totalPageCnt : ${count} / ${pageSize}   // 전체 페이지 수       
         },
        'setOption' : function(opt){
            if( typeof opt != 'object' ) return;
            for (key in opt ) {
                if(key in this.data) {
                    this.data[key] = opt[key]; //data에 입력받은 설정값 할당.
                } 
            }
        },
  'pagingHtml' : function(pTotalCnt){
            
            var _ = this; 
            
            _.data['totalCnt'] = pTotalCnt?pTotalCnt:_.data['totalCnt'];        
            
            if (_.data['totalCnt'] == 0) {
                return "";
            }
            //총페이지수 구하기 : 페이지 출력 범위 (1|2|3|4|5)
            _.data.totalPageCnt = Math.ceil(_.data.totalCnt / _.data.maxListCount);             
            
            //현재 블럭 구하기 
            var n_block = Math.ceil(_.data.currentPage / _.data.pageSize); 
                    
            //페이징의 시작페이지와 끝페이지 구하기
            var s_page = (n_block - 1) * _.data.pageSize + 1; // 현재블럭의 시작 페이지
            var e_page = n_block * _.data.pageSize; // 현재블럭의 끝 페이지
                
            var sb='';
            var sbTemp =''; 
              
            // 블럭의 페이지 목록 및 현재페이지 강조
            for (var j = s_page; j <= e_page; j++) {                
                if (j > _.data.totalPageCnt ) break;                         
                if(j == _.data.currentPage) {
                	//<a href="#" class="active">1</a>
                	sbTemp += "<a class='active'>"+j+"</a>";
                } else {
                    sbTemp += "<a href='1category_all_price_asc?pageNum="+j+"'>"+j+"</a>";        
                } 
            }            

            // 이전페이지 버튼
            sb = "";
            if(_.data.currentPage > s_page || _.data.totalCnt > _.data.maxListCount && s_page > 1){
                sb += "<a class='first' href='1category_all_price_asc?pageNum=1'><i class='fa fa-long-arrow-left' aria-hidden='true'></i></a >";
                sb += "<a class='previous' href='1category_all_price_asc?pageNum=" + (_.data.currentPage - 1) + "'><i class='fa fa-long-arrow-left' aria-hidden='true'></i></a>";    
            }
            
            // 현재블럭의 페이지 목록
            sb += sbTemp 
            
            // 다음페이지 버튼
            if(_.data.currentPage < _.data.totalPageCnt ){
                sb += "<a class='previous' href='1category_all_price_asc?pageNum=" + (_.data.currentPage + 1) + "'><i class='fa fa-long-arrow-right' aria-hidden='true'></i></a>";
                sb += "<a class='first' href='1category_all_price_asc?pageNum="+ (_.data.totalPageCnt) +"'><i class='fa fa-long-arrow-right' aria-hidden='true'></i></a>";           
            }
            sb += "";
                           
            return sb;
        },
        'setStartnumEndnum' : function() {
            // 시작 글번호
            this.data.startnum = (this.data.currentPage -1) * this.data.maxListCount + 1;

            // 마지막 글번호
            var tmp = this.data.currentPage * this.data.maxListCount;
            this.data.lastnum = (tmp > this.data.totalCnt?this.data.totalCnt:tmp);
        }
    }   
    $(document).ready(function() {
        $(".pagination").append(PagingHelper.pagingHtml(${count}));  
    });      
/********************************************************************************************************************
  * item sorting */
	function sort() {
		var selectValue = document.getElementById('sorting').value;
		if (selectValue == "NameASC") {
			$.ajax({
				url : '1category_all_name_asc',
				data : {
					'pageNum' : ${currentPage}
			},
				type : 'POST',
				cache : false, 
				success : function(data){
					document.sm1.action = "1category_all_name_asc";
					document.sm1.submit();
				} 
			});
			e.preventDefault();
		} else if (selectValue == "NameDESC") {
			$.ajax({
				url : '1category_all_name_desc',
				data : {
					'pageNum' : ${currentPage}
			},
				type : 'POST',
				cache : false,  
				success : function(data){
					document.sm1.action = "1category_all_name_desc";
					document.sm1.submit();
				} 
			});
			e.preventDefault();
		} else if (selectValue == "PriceASC") {
			$.ajax({
				url : '1category_all_price_asc',
				data : {
					'pageNum' : ${currentPage}
			},
				type : 'POST',
				cache : false,  
				success : function(data){
					document.sm1.action = "1category_all_price_asc";
					document.sm1.submit();
				} 
			});
			e.preventDefault();
		} else if (selectValue == "PriceDESC") {
			$.ajax({
				url : '1category_all_price_desc',
				data : {
					'pageNum' : ${currentPage}
			},
				type : 'POST',
				cache : false,  
				success : function(data){
					document.sm1.action = "1category_all_price_desc";
					document.sm1.submit();
				} 
			});
			e.preventDefault();
		} else if (selectValue == "MostPopular") {
			$.ajax({
				url : '1category_all_popular',
				data : {
					'pageNum' : ${currentPage}
			},
				type : 'POST',
				cache : false,  
				success : function(data){
					document.sm1.action = "1category_all_popular";
					document.sm1.submit();
				} 
			});
			e.preventDefault();
		} else if (selectValue == "NewRelease") {
			$.ajax({
				url : '1category_all',
				data : {
					'pageNum' : ${currentPage}
			},
				type : 'POST',
				cache : false,  
				success : function(data){
					document.sm1.action = "1category_all";
					document.sm1.submit();
				} 
			});
			e.preventDefault();
		}
	}
</script>
</head>
<body>

	<!-- include_common_top.jsp start-->
	<jsp:include page="1include_common_header.jsp" />
	<!-- include_common_top.jsp end-->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center">
				<div class="col-first">
					<h1>Shop Category page</h1>
					<nav class="d-flex align-items-center justify-content-start">
						<a href="1index">Home<i class="fa fa-caret-right"
							aria-hidden="true"></i></a> <a href="1category_all">Perfume
							Category</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!-- Start container -->
	<form name=sm1>
	<div class="container">
		<div class="row">
			<div class="col-xl-9 col-lg-8 col-md-7">
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					<a href="#" class="grid-btn active"><i class="fa fa-th"
						aria-hidden="true"></i></a> 
					<div class="sorting">
						<select id="sorting" onchange="sort()">
							<option id="NewRelease" value="NewRelease">New Release</option>
							<option id="NameASC" value="NameASC" selected="selected">Name (asc)</option>
							<option id="NameDESC" value="NameDESC">Name (desc)</option>
							<option id="PriceASC" value="PriceASC" >Price (asc)</option>
							<option id="PriceDESC" value="PriceDESC">Price (desc)</option>
							<option id="MostPopular" value="MostPopular">Most Popular</option>
						</select>
					</div>
					
					<div class="pagination" >
					</div>
				</div>
				<!-- End Filter Bar -->
				<!-- Start Best Seller -->
				<section class="lattest-product-area pb-40 category-list">
					<div class="row">
						<%
							for (Product product : productList) {
						%>
						<div class="col-xl-4 col-lg-6 col-md-12 col-sm-6 single-product">
							<div class="content">
								<div class="content-overlay"></div>
								<img class="content-image img-fluid d-block mx-auto"
									src="./img/product/<%=product.getP_image()%>" alt="">
								
							</div>
							<div class="price">
								<h5>
									<input type="hidden" id="p_name[]" name="p_name[]"
										value="<%=product.getP_name()%>"> <a
										href="1product_view1?p_no=<%=product.getP_no()%>" style="color:#000000;"><%=product.getP_name()%></a>
								</h5>
								<h3>
									<input type="hidden" id="p_price[]" name="p_price[]"
										value="<%=product.getP_price()%>"> ‎‎₩
									<fmt:formatNumber value='<%=product.getP_price()%>'
										pattern="###,###,###" />
								</h3>
							</div>
						</div>
						<%
							}
						%>
						
					</div>
				</section>
				<!-- End Best Seller -->
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					
					<div class="pagination" >
						
					</div>
				</div>
				<!-- End Filter Bar -->
			</div>
			<div class="col-xl-3 col-lg-4 col-md-5">
				<div class="sidebar-categories">
					<div class="head">Browse Categories</div>
					<ul class="main-categories">
						<li class="main-nav-list"><a data-toggle="collapse"
							href="#fruitsVegetable" aria-expanded="false"
							aria-controls="fruitsVegetable"> <span
								class="lnr lnr-arrow-right"></span>Perfumes<span class="number">(${totalProductCount })
							</span></a>
							<ul class="collapse" id="fruitsVegetable" data-toggle="collapse"
								aria-expanded="false" aria-controls="fruitsVegetable">
								<li class="main-nav-list child"><a href="1category_women">Women<span
										class="number">(${totalProductCountWomen })</span></a></li>
								<li class="main-nav-list child"><a href="1category_men">Men<span
										class="number">(${totalProductCountMen })</span></a></li>
							</ul></li>
					</ul>
				</div>
				<div class="sidebar-filter mt-50">
					<div class="top-filter-head">Product Filters</div>
					<div class="common-filter">
						<div class="head">Brands</div>
						<form action="#">
							<ul>
								<%
									for (Product product : productList) {
								%>
								<li class="filter-list"><input class="pixel-radio"
									type="radio" id="<%=product.getBr_name()%>" name="brand">
									<label for="<%=product.getBr_name()%>"><%=product.getBr_name()%><span>(29)</span></label></li>
								<%
									}
								%>
							</ul>
						</form>
					</div>
					<div class="common-filter">
						<div class="head">Color</div>
						<form action="#">
							<ul>
								<li class="filter-list"><input class="pixel-radio"
									type="radio" id="7.5ml" name="brand"> <label
									for="7.5ml">7.5ml<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio"
									type="radio" id="30ml" name="brand"> <label for="30ml">30ml<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio"
									type="radio" id="40ml" name="brand"> <label for="40ml">40ml<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio"
									type="radio" id="50ml" name="brand"> <label for="50ml">50ml<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio"
									type="radio" id="75ml" name="brand"> <label for="75ml">75ml<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio"
									type="radio" id="100ml" name="brand"> <label
									for="100ml">100ml<span>(29)</span></label></li>
							</ul>
						</form>
					</div>
					<div class="common-filter">
						<div class="head">Price</div>
						<div class="price-range-area">
							<div id="price-range"></div>
							<div class="value-wrapper d-flex">
								<div class="price">Price:</div>
								<span>$</span>
								<div id="lower-value"></div>
								<div class="to">to</div>
								<span>$</span>
								<div id="upper-value"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
	

	<!-- include_common_top.jsp start-->
	<jsp:include page="1include_common_footer.jsp" />
	<!-- include_common_top.jsp end-->

	<!-- Modal Quick Product View -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="container relative">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="product-quick-view">
					<div class="row align-items-center">
						<div class="col-lg-6">
							<div class="quick-view-carousel">
								<div class="item"
									style="background: url(img/organic-food/q1.jpg);"></div>
								<div class="item"
									style="background: url(img/organic-food/q1.jpg);"></div>
								<div class="item"
									style="background: url(img/organic-food/q1.jpg);"></div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="quick-view-content">
								<div class="top">
									<h3 class="head">Mill Oil 1000W Heater, White</h3>
									<div class="price d-flex align-items-center">
										<span class="lnr lnr-tag"></span> <span class="ml-10">$149.99</span>
									</div>
									<div class="category">
										Category: <span>Household</span>
									</div>
									<div class="available">
										Availibility: <span>In Stock</span>
									</div>
								</div>
								<div class="middle">
									<p class="content1">Mill Oil is an innovative oil filled
										radiator with the most modern technology. If you are looking
										for something that can make your interior look awesome, and at
										the same time give you the pleasant warm feeling during the
										winter.</p>
									<a href="#" class="view-full">View full Details <span
										class="lnr lnr-arrow-right"></span></a>
								</div>
								<div class="bottom">
									<div class="color-picker d-flex align-items-center">
										Color: <span class="single-pick"></span> <span
											class="single-pick"></span> <span class="single-pick"></span>
										<span class="single-pick"></span> <span class="single-pick"></span>
									</div>
									<div class="quantity-container d-flex align-items-center mt-15">
										Quantity: <input type="text" class="quantity-amount ml-15"
											value="1" />
										<div class="arrow-btn d-inline-flex flex-column">
											<button class="increase arrow" type="button"
												title="Increase Quantity">
												<span class="lnr lnr-chevron-up"></span>
											</button>
											<button class="decrease arrow" type="button"
												title="Decrease Quantity">
												<span class="lnr lnr-chevron-down"></span>
											</button>
										</div>

									</div>
									<div class="d-flex mt-20">
										<a href="#" class="view-btn color-2"><span>Add to
												Cart</span></a> <a href="#" class="like-btn"><span
											class="lnr lnr-layers"></span></a> <a href="#" class="like-btn"><span
											class="lnr lnr-heart"></span></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
