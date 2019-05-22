<%@page import="java.util.List"%>
<%@page import="jenkim49.review.Review"%>
<%@page import="jenkim49.qna.Qna"%>
<%@page import="jenkim49.product.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%
   Product product = (Product) request.getAttribute("product");
	String m_id=(String)session.getAttribute("sMemberId");
	boolean isLogin=false;
	if(m_id!=null){
		isLogin=true;
	}
	List<Product> recommendList = (List<Product>)request.getAttribute("recommendList");
%>


<%
		ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
		ArrayList<Qna> qnaList = (ArrayList<Qna>)request.getAttribute("qnaList");
		Qna qnarRe = (Qna)request.getAttribute("qna");
%>


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
<link rel="stylesheet" href="css/linearicons.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href="css/ion.rangeSlider.css" />
<link rel="stylesheet" href="css/ion.rangeSlider.skinFlat.css" />
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/star.css">

<!-- JavaScript ============================================= -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">


/* *****************************별표출력 필수로 앞에있어야함********************************* */

$(function(){
	// $("#reviews-tab").val("");
		$.fn.generateStars = function() {
	        	return this.each(function(i,e){$(e).html($('<span/>').width($(e).text()*16));});
	        	};
	    $('.star-prototype').generateStars();
     
})
/* *****************************무빙금지********************************* */



   //Calculate total price
   function addToCart(){
      if (confirm("Do you want to proceed your order?")) {      
         $.ajax({
            url : 'cart_insert_action',
            type : 'POST',
            dataType : 'text',
            data : {
               cart_qty : $("[name=j_total_qty]").val(),
               cart_price : ($("[name=j_total_qty]").val()*$("[name=j_total_price_init]").val()),
               m_id : $("[name=m_id]").val(),
               p_no : $("[name=p_no]").val()
            },
            success : function(data) {
            	alert("success");
            	document.sm1.action = "cart_insert_action";
                document.sm1.submit();
            }
         })
   	  }
   }

   // Proceed to checkout Directly
   function checkoutInsertDirect() {
      if (confirm("Do you want to proceed your order?")) {      
         $.ajax({
            url : 'jumun_insert_action_directly',
            type : 'POST',
            dataType : 'text',
            data : {
               j_no : parseInt("0"),
               j_name : $("[name=p_name]").val(),
               j_total_qty : $("[name=j_total_qty]").val(),
               j_total_price : ($("[name=j_total_qty]").val()*$("[name=j_total_price_init]").val()),
               m_id : $("[name=m_id]").val(),
               jd_item_qty : $("[name=j_total_qty]").val(),
               jd_items_price : ($("[name=j_total_qty]").val()*$("[name=j_total_price_init]").val()),
               p_no : $("[name=p_no]").val()
            },
            success : function(data) {
            	document.sm1.action = "1checkout";
                document.sm1.submit();
            }
         })
      }
   }
   
   /* *****************************리뷰라인********************************* */
   
  $(function(){
      	$('#reviews-tab').on('click',function(e){
      		$.ajax({
      			url:"reviewOnepNo",
      			method:"POST",
      			data:{
      				p_no:$("[name=p_no]").val()
      			},
      			beforeSend:function(){
      				console.log("시작 전...");
      			},
      			complete:function(){
      				console.log("완료 후...");
      			},
      			success:function(data){
      				console.log("콜백실행");
      				console.log("review가 정상적으로 입력");
      				
      			}
      		})
      	});
      	
      	
        })
        
      $(function(){
      	$('#reviewsubmit').on('click',function(e){
      		$.ajax({
      			url:"review_insert_action",
      			method:"POST",
      			data:{
      				p_no:$("[name=p_no]").val(),
      				M_id:$("#r_m_id").val(),
      				R_title:$("#R_title").val(),
      				R_content:$("#R_content").val(),
      				R_star:$("#R_star").val(),
      				R_date:$("#R_date").val()
      			},
      			beforeSend:function(){
      				console.log("쓰기액션");
      			},
      			completeSend:function(){
      				console.log("쓰기액션 완료")
      			},
      			success:function(data){
      				
  				$("reviewsubmit").val()
      			}
      		})
      	});
      })
      
      
      
      $(function(){ 
          $('#DeleteBR').on('click', function(e) { 
              $.ajax({
                  url:"review_delete_action", 
                  method:"POST",
                  data:{
                	r_no:$("#DeleteBR").val()
                  },
                  success:function(data) { 
                  		alert("삭제성공")
                          console.log("쓰기액션콜백실행");
                          console.log("쓰기액션 comment가 정상적으로 입력되었습니다.");
                          $("#DeleteBR").val("");
                  }
              })
          });
      })  
   
      
      
      
    /* ************************************************************** */   
    
    
    
    
       /* ************************답글라인************************************** */   
       
       
        function qnaReplyform() {
        	
        	document.f.action = "qna_reply_form";
        	document.f.method='POST';
        	document.f.submit();
        }
        
        
        var pno= 1;
        
        $(function(){ 
            $('#comments-tab').on('click', function(e) { 
            	
                $.ajax({
                    method:"POST",
                    data:{
                    	p_no:$("[name=p_no]").val()
                    },
                    beforeSend:function() {
                        console.log("시작 전...");
                    },
                    complete:function() {
                        console.log("완료 후..."); 
                    },
                    success:function(data) {
                            console.log("콜백실행");
                            console.log("comment가 정상적으로 입력되었습니다.");
                            $("#comments-tab").val("");
                            
                    }
                })
            });
        })
        
        
         $(function(){ 
            $('#submit').on('click', function(e) { 
         
                $.ajax({
                	
                    url:"qna_write_action",
                    method:"POST",
        
                    data:{
             
                    	p_no:$("[name=p_no]").val(),
                    	M_id:$("#M_id").val(),
                    	Q_content:$("#Q_content").val(),
                    	Q_title:$("#Q_title").val()
                    },
                    beforeSend:function() {
                        console.log("쓰기액션 시작 전...");
                    },
                    complete:function() {
                        console.log("쓰기액션 완료 후..."); 
                    },
                    success:function(data) {   
             
                   
                    		alert("쓰기성공!")
                            console.log("쓰기액션콜백실행");
                            console.log("쓰기액션 comment가 정상적으로 입력되었습니다.");
                            $("#submit").val("");
                           
                    }
                })
            });
        })
        

  $(function(){ 
           $('#DeleteSPAN').on('click', function(e) { 
               $.ajax({
                   url:"qna_delete_action", 
                   method:"POST",
                   data:{
                   	q_no:$("#DeleteSPAN").val()
                   	
                   },
                   success:function(data) { 
                   			alert("삭제성공!")
                           console.log("쓰기액션콜백실행");
                           console.log("쓰기액션 comment가 정상적으로 입력되었습니다.");
                           $("#DeleteSPAN").val("");
                          
                   }
               })
           });
       })  
       
    		  
    $(document).on('mouseup', '#ReplyB', function(e){ 

    	$.ajax({ url : "qna_reply_form_main" ,
    		type : "POST" ,
    		data : {
    			 q_no:$("#Q_noPick").val()+""
    		},
    		success : function(result)
    		{ 
    			
    			$("#ReplyB").trigger("click");
    			$("#Q_title_RE").html("[RE]"+result.q_title);
    			$("#Q_title_RE").val("[RE]"+result.q_title);
    			$("#M_id_RE").val(result.m_id);
    			$("#Q_content_RE").val(result.q_content);
    			$("#Q_no_RE").val(result.q_no);
    			$("#check").text(result.q_no+"번의 [RE]답글달기를 시작합니다");
    			$("#check").css('color', 'red');
    			
    		}
    	});
    }); 
      
  $(function(){ 
	  
            $('#submitRE').on('click', function(e) { 
            	
            	alert(" 답글 쓰 - 기 성공! ");
            	
                $.ajax({
                    url:"qna_reply_action", //리스트를 뿌린다 
                    method:"POST",
                    data:{
                    	Q_no:$("#Q_no_RE").val(),
                    	p_no:$("[name=p_no]").val(),
                    	M_id:$("#M_id_RE").val(),
                    	Q_content:$("#Q_content_RE").val(),
                    	Q_title:$("#Q_title_RE").val()
          
                    },
                    beforeSend:function() {
                        console.log("RE답글쓰기액션 시작 전...");
                    },
                    complete:function() {
                        console.log("RE답글쓰기액션 완료 후..."); //됬는데 컨트롤러까지 안가
                    },
                    success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback
             
                            console.log("RE답글쓰기액션콜백실행");
                            console.log("RE답글쓰기액션 comment가 정상적으로 입력되었습니다.");
                        
                            
                            $("#submitRE").val("");
                           
                    }
                })
            });
        }) 
        
       
       
       
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
               <h1>Single Product Page</h1>
               <nav class="d-flex align-items-center justify-content-start">
                  <a href="index.html">Home<i class="fa fa-caret-right"
                     aria-hidden="true"></i></a> <a href="single.html">Single Product
                     Page</a>
               </nav>
            </div>
         </div>
      </div>
   </section>
   <!-- End Banner Area -->

   <!-- Start Product Details -->
   <form name=sm1>
   <div class="container">
      <div class="product-quick-view">
         <div class="row align-items-center">
            <div class="col-lg-6">
               <div class="quick-view-carousel-details">
                  <img alt="" src="./img/product/<%=product.getP_image() %>">
               </div>
            </div>
            <div class="col-lg-6">
               <div class="quick-view-content">
                  <div class="top">
                     <input type="hidden" name="m_id" value="<%=m_id%>"></input>
                     <input type="hidden" name="p_no" value="<%=product.getP_no()%>">
                     <h3 class="head">
                        <input type="hidden" name="p_name" value="<%=product.getP_name()%>"><%=product.getP_name()%></h3>
                     <div class="price d-flex align-items-center">
                        <span class="lnr lnr-tag"></span> 
                        <span class="ml-10"> 
                        <input type="hidden" name="j_total_price_init" value="<%=product.getP_price()%>">
                            ₩ <fmt:formatNumber value='<%=product.getP_price()%>' pattern="###,###,###"/></span>
                     </div>
                     <div class="category">
                        Category: <span><%=product.getP_category()%></span>
                     </div>
                     <div class="available">
                        Availibility: <span>In Stock</span>
                     </div>
                  </div>
                  <div class="middle">
                     <p class="content"><%=product.getP_des()%></p>
                     <input type="hidden" id="t_name" value="<%=product.getT_name() %>">
                     <p class="content">Tag: <%=product.getT_name()%></p>
                  </div>
                  <div>
                     <div class="quantity-container d-flex align-items-center mt-15">
                        Quantity: 
                        <input type="text" name="j_total_qty" class="quantity-amount ml-15" value="1" />
                        <div class="arrow-btn d-inline-flex flex-column">
                           <button class="increase arrow" type="button" title="Increase Quantity" >
                              <span class="lnr lnr-chevron-up"></span>
                           </button>
                           <button class="decrease arrow" type="button" title="Decrease Quantity" >
                              <span class="lnr lnr-chevron-down"></span>
                           </button>
                        </div>
                        <input type="hidden" name="j_total_price">  

                     </div>
                     <div class="d-flex mt-20">
                        <input type="button" class="view-btn color-2" onclick="addToCart();" value="Add to Cart">
                        <input type="button" class="view-btn color-2" onclick="checkoutInsertDirect();" value="Checkout">
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   </div>
   </form>
   <div class="container">
      <div
         class="details-tab-navigation d-flex justify-content-center mt-30">
         <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li><a class="nav-link" id="description-tab" data-toggle="tab"
               href="#description" role="tab" aria-controls="description"
               aria-expanded="true">Description</a></li>
            <li><a class="nav-link" id="specification-tab"
               data-toggle="tab" href="#specification" role="tab"
               aria-controls="specification">Specification</a></li>
            <li><a class="nav-link" id="comments-tab" data-toggle="tab"
               href="#comments" role="tab" aria-controls="comments">Comments</a></li>
            <li><a class="nav-link active" id="reviews-tab"
               data-toggle="tab" href="#reviews" role="tab"
               aria-controls="reviews">Reviews</a></li>
         </ul>
      </div>
      <div class="tab-content" id="myTabContent">
         <div class="tab-pane fade" id="description" role="tabpanel"
            aria-labelledby="description">
            <div class="description">
               <p><%=product.getP_des()%></p>
            </div>
         </div>
         <div class="tab-pane fade" id="specification" role="tabpanel"
            aria-labelledby="specification">
            <div class="specification-table">
               <div class="single-row">
                  <span>Volume</span> <span><%=product.getP_volume()%></span>
               </div>
               <div class="single-row">
                  <span>Weight</span> <span>79g</span>
               </div>
               <div class="single-row">
                  <span>Quality checking</span> <span>Yes</span>
               </div>
               <div class="single-row">
                  <span>Expiration Date</span> <span>1~3Years</span>
               </div>
            </div>
         </div>
         
  <!--  게시판 시작  -->
            <div class="tab-pane fade" id="comments" role="tabpanel" aria-labelledby="comments">
                        <div class="review-wrapper">
                            <div class="row">
                                <div class="col-xl-6">
                                    <div class="total-comment">
                                  
                                    <!-- 싱글 댓글 뿌리기 -->
                                    <!-- loop -->
                                    
                                 <%  for(Qna qna : qnaList){%>
                                   <div class="single-comment" id="single-comment">
                              
                                	<form name="f1" method="post">
										<input type="hidden" id="Q_noPick" name="Q_noPick" value="<%=qna.getQ_no()%>"/>
											
                                            <div class="user-details d-flex align-items-center flex-wrap">
                                                <img src="img/organic-food/u1.png" class="img-fluid order-1 order-sm-1" alt="">
                                                <div class="user-name order-3 order-sm-2">
                                                    <h4><%=qna.getQ_title()%></h4>
                                                  <%--   <h4><%=getTitleString(qna)%></h4> --%>
                                                    <span><%=qna.getM_id()%></span>
                                                    <br/>
                                                    <span><b>날짜 : </b><%=qna.getQ_date()%></span>        
                                                    <span><%=qna.getQ_no()%></span>        
                                                   
                                                </div>
                                               
                                                <%-- <a target="_blank" href="qna_reply_form?Q_no=<%=qna.getQ_no()%>" class="view-btn color-2 reply order-2 order-sm-3"> --%>
                                                
                                                <a class="view-btn color-2 reply order-2 order-sm-3"  id="ReplyB">
                                                <i class="fa fa-reply" aria-hidden="true"></i>
                                                <span id="ReplySPAN" name="ReplySPAN" value="<%=qna.getQ_no()%>">Reply</span>
                                                </a>
                                                <%-- qna_delete_action?q_no=<%=qna.getQ_no()%> href="qna_delete_action?q_no=<%=qna.getQ_no()%>"--%>
                                                <button href="#" class="view-btn color-2 reply order-2 order-sm-3" id="DeleteSPAN" name="DeleteSPAN" value="<%=qna.getQ_no()%>">
                                                <i class="fa fa-reply" aria-hidden="true"></i>
                                                <span>Delete</span>
                                                </button>
                                         
                                            </div>
                                           	<p class="user-comment">
                                            <%=qna.getQ_content() %>
                                            </p>
                                      </form>
                                        </div>
                                   <!------------------->
                                   	<%}%> 
                                      
                                        
                             
                                    </div>
                                </div>
                                
                                
                         <!-----------쓰기 폼! ------ --> 
                                <div class="col-xl-6">
                                    <div class="add-review" id="add-review">
                                        <h3>Post a comment</h3>
                                        <form name="f" class="main-form" method="POST">
                                        	<input type="hidden" name="P_no" id="P_no" value="<%=product.getP_no()%>">
                                        	
                                        	<!-- 이름 세션의 사용자아이디찾기 -->
                                            <input type="text" placeholder="YOUR ID" 
                                            onfocus="this.placeholder=''" onblur="this.placeholder = 'YOUR ID'" 
                                            required class="common-input" name="M_id" id="M_id" value="<%=m_id%>">
                                            
                                            <!-- 제목 -->
                                             <input type="text" placeholder="제목을 입력하세요.." 
                                            onfocus="this.placeholder=''" 
                                            onblur="this.placeholder = '제목을 입력하세요..'" 
                                            required class="common-input" name="Q_title" id="Q_title">
                                  
                                            <!-- Messege -->
                                            <textarea placeholder="건의내용을 입력하세요.." 
                                            onfocus="this.placeholder=''" 
                                            onblur="this.placeholder = '건의내용을 입력하세요..'" 
                                            required class="common-textarea" name="Q_content" id="Q_content"></textarea>
                                            
                                            <button class="view-btn color-2" id="submit">
                                            <span>Submit Now</span></button>
                                            
                                        </form>
                                        
                                          
                         				<!---------답글 달기폼이 있어야대- 답글폼은 데이터를 받아서 새로 뿌려야하는데--------->   
                                          <h3>Post a REPLY comment</h3>
                                          <h6 id="check"></h6>
                                        <form name="f" class="main-form" method="POST">
                                        	<div id="reply-q_no"></div>
                                        	<!-- 이름 세션의 사용자아이디찾기 -->
                                            <input type="text" placeholder="YOUR ID" 
                                            onfocus="this.placeholder=''" onblur="this.placeholder = 'YOUR ID'" 
                                            required class="common-input" name="M_id_RE" id="M_id_RE">
                                            
                                            <!-- 제목 수정불가 -->
                                            <div  type="text" align="center" required class="common-input" name="Q_title_RE" id="Q_title_RE"></div>
                                            
                                            <!-- Q_no -->
                                            <div  type="text" align="center" required class="common-input" name="Q_no_RE" id="Q_no_RE"></div>
                                            
                                            <!-- Messege -->
                                            <textarea placeholder="건의내용을 입력하세요.." 
                                            onfocus="this.placeholder=''" 
                                            onblur="this.placeholder = '건의내용을 입력하세요..'" 
                                            required class="common-textarea" name="Q_content_RE" id="Q_content_RE"></textarea>
                                            
                                            <button class="view-btn color-2" id="submitRE">
                                            <span>Submit Now</span></button>
                                            
                                        </form>
                                        
                                        
                                        
                                    </div>
                                </div>
                                
                         <!------------------->   
            
                            </div>
                        </div>
                    </div>
                  
                    
            <!-----^&^&^&^&^&^-------------->     
                    
                  <div class="tab-pane fade show active" id="reviews" role="tabpanel" aria-labelledby="reviews">
                        <div class="review-wrapper">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="review-stat d-flex align-items-center flex-wrap">
                                       <!--  <div class="review-overall">
                                            <h3>평점</h3>
                                            <div class="main-review">4.5</div>
                                        </div> -->
                                        <div class="review-count">
                                            <h4>리뷰 추천도</h4>
                                            <div class="single-review-count d-flex align-items-center">
                                                <span>5 Star</span>
                                                <div class="total-star five-star d-flex align-items-center">
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                </div>
                                                <span>아주 추천해요</span>
                                            </div>
                                            <div class="single-review-count d-flex align-items-center">
                                                <span>4 Star</span>
                                                <div class="total-star four-star d-flex align-items-center">
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                </div>
                                                <span>추천해요</span>
                                            </div>
                                            <div class="single-review-count d-flex align-items-center">
                                                <span>3 Star</span>
                                                <div class="total-star three-star d-flex align-items-center">
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                </div>
                                                <span>보통이에요</span>
                                            </div>
                                            <div class="single-review-count d-flex align-items-center">
                                                <span>2 Star</span>
                                                <div class="total-star two-star d-flex align-items-center">
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                </div>
                                                <span>그저그래요</span>
                                            </div>
                                            <div class="single-review-count d-flex align-items-center">
                                                <span>1 Star</span>
                                                <div class="total-star one-star d-flex align-items-center">
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                </div>
                                                <span>추천하고 싶지 않아요</span>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="total-comment">
            <!-- 싱글 댓글 뿌리기 -->
                                    <!-- loop -->
                                    
                                    <% for(Review review :reviewList){ %>
                                        <div class="single-comment">
                                         <form name="f" method="post"> 
                                            <input type="hidden" name="p_no" value="<%=review.getP_no()%>" id="p_no"/>
                                            <input type="hidden" name="r_star" value="<%=review.getR_star()%>" id="r_star"/>
                                            <div class="user-details d-flex align-items-center">
                                                <img src="img/organic-food/u1.png" class="img-fluid" alt="">
                                                <div class="user-name">
                                                    <h4><%=review.getR_title() %></h4>
                                                    <span><%=review.getM_id() %></span>
                                                    <br/>
                                                   <span><b>날짜 : </b><%=review.getR_date() %></span>
                                                   <br/>
                                                    <span class="star-prototype" value="<%=review.getR_star() %>" id="starView"><%=review.getR_star() %></span>
                                                    <hr/>
                                                </div>
                                               
                                             	<button 
                                             	 class="view-btn color-2 reply order-2 order-sm-3"  id="DeleteBR" name="DeleteBR" value="<%=review.getR_no()%>">
                                                <i class="fa fa-reply" aria-hidden="true"></i>
                                                <span>Delete</span>
                                                </button>
                                           
                                               
                                            </div>
                                            
                                            <p class="user-comment">
                                            <%=review.getR_content() %>
                                            </p>
                                            </form>
                                                
                                        </div>
                                          <%} %>
                                    </div>
                                </div>
                                
                                
                                
                                <div class="col-lg-6">
                                    <div class="add-review">
                                        <h3>Add a Review</h3>
                                        
                                        <!--쓰기폼 시작 -->
                                        <form class="main-form" method="post">
                                          <input type="hidden" name="r_p_no" id="r_p_no" value="<%=product.getP_no()%>"/>
                                            <!-- 이름 세션의 사용자아이디찾기 -->
                                            <input type="text" placeholder="YOUR ID" 
                                            onfocus="this.placeholder=''" 
                                            onblur="this.placeholder = 'YOUR ID'" 
                                            required class="common-input" name="r_m_id" id="r_m_id" value="<%=m_id%>">
                                            
                                            <input type="text" placeholder="별은 1에서 5까지 정수로만 입력해주세요" 
                                            onfocus="this.placeholder=''" 
                                            onblur="this.placeholder = '리뷰 점수를 넣어주세요'" 
                                            required class="common-input" name="R_star" id="R_star">
                                            
                                            <div class="single-review-count mb-15 d-flex align-items-center">
                                            <hr/>
                                            <span>※</span>
                                            <div class="total-star five-star d-flex align-items-center">
                                                <i class="fa fa-star" aria-hidden="true"></i>
                                                <i class="fa fa-star" aria-hidden="true"></i>
                                                <i class="fa fa-star" aria-hidden="true"></i>
                                                <i class="fa fa-star" aria-hidden="true"></i>
                                                <i class="fa fa-star" aria-hidden="true"></i>
                                            </div>
                                            <span>별은 1에서 5까지 정수로만 입력해주세요</span>
                                       		 </div>
                                        
                                            
                                            
                                            <input type="text" placeholder="제목 작성" 
                                            onfocus="this.placeholder=''" 
                                            onblur="this.placeholder = '제목을 작성해주세요'" 
                                            required class="common-input"id="R_title" name="R_title">
                                            
                                            <textarea placeholder="리뷰 작성" onfocus="this.placeholder=''"
                                            onblur="this.placeholder = '리뷰를 작성해주세요'" 
                                            required class="common-textarea" id="R_content" name="R_content"></textarea>
                                            
                                            <button id ="reviewsubmit" class="view-btn color-2"><span>Submit Now</span></button>
                                        </form>
                                        <!-- 쓰기폼 끝 -->
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
<!--  게시판 끝  -->
   <!-- End Product Details -->

   <!-- Start Tag Recommend Product Area -->
   	<br>
   	<br>
      <div class="container">
         <div class="organic-section-title text-center">
            <h3>Related Product</h3>
         </div>
         <div class="row mt-30">
		    <% for(Product recommend:recommendList) { %>
            <div class="col-lg-3 col-md-4 col-sm-6">
               <div class="single-search-product d-flex">
                  <a href="1product_view1?p_no=<%=recommend.getP_no()%>"><img alt="" src="./img/product/<%=recommend.getP_image() %>"></a>
                  <div class="desc">
                     <a href="1product_view1?p_no=<%=recommend.getP_no()%>" class="title"><%=recommend.getP_name() %>
                       </a>
                     <div class="price">
                        <span class="ml-10" >₩ <fmt:formatNumber value='<%=recommend.getP_price()%>' pattern="###,###,###"/></span>
                     </div>
                  </div>
               </div>
            </div>
		    <% } %>
         </div>
      </div>
   <section class="pt-100 pb-100">
   </section>
   <!-- End Most Search Product Area -->
   
   <!-- include_common_top.jsp start-->
   <jsp:include page="1include_common_footer.jsp"/>         
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
                           <p class="content">Mill Oil is an innovative oil filled
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
   <script src="js/product.js"></script>
   <script src="js/ion.rangeSlider.js"></script>
   <script src="js/jquery.magnific-popup.min.js"></script>
   <script src="js/main.js"></script>

</body>
</html>