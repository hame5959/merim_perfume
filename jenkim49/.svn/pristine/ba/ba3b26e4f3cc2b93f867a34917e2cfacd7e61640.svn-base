<%@page import="jenkim49.review.Review"%>
<%@page import="java.util.HashMap"%>
<%@page import="jenkim49.qna.Qna"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<%
		ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
		ArrayList<Qna> qnaList = (ArrayList<Qna>)request.getAttribute("qnaList");
		Qna qnarRe = (Qna)request.getAttribute("qna");
%>


    <!DOCTYPE html>
    <html lang="zxx" class="no-js">
	<meta charset="UTF-8">
    <head>
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
            <link rel="stylesheet" href="css/star.css">
            <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
             
        <script type="text/javascript">
        
        $.ajaxSetup({
            type:"POST",
            async:true,
            error:function(xhr) {
                console.log("error html = " + xhr.statusText);
            }
        });
        
        
        /* *****************************리뷰라인********************************* */
        
        $(function(){
       	 $("#reviews-tab").val("");
    		$.fn.generateStars = function() {
    	        	return this.each(function(i,e){$(e).html($('<span/>').width($(e).text()*16));});
    	        	};
    	    $('.star-prototype').generateStars();
             
        })
        
           $(function(){
           	$('#reviews-tab').on('click',function(e){
           		//리뷰텝을 누루면!
           		$.ajax({
           			url:"reviewOnepNo", // 프로덕트넘버 리스트  뽑아줌
           			method:"POST",
           			//data:{}에서는 EL을 ""로 감싸야 한다. 이외에는 그냥 사용한다.
           			data:{
           				p_no:$("#p_no").val(),
           			},
           			beforeSend:function(){
           				console.log("시작 전...");
           			},
           			complete:function(){
           				console.log("완료 후...");
           			},
           			success:function(data){
           				
           				
           				//alert("success");
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
           				p_no:$("#p_no").val(),
           				M_id:$("#r_m_id").val(),
           				R_title:$("#R_title").val(),
           				R_content:$("#R_content").val(),
           				R_star:$("#R_star").val(),
           				R_date:$("R_date").val()
           			},
           			beforeSend:function(){
           				console.log("쓰기액션");
           			},
           			completeSend:function(){
           				console.log("쓰기액션 완료")
           			},
           			success:function(data){
           				
           				//alert("쓰기액션 success");
           				$("reviewsubmit").val()
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
            	//코멘트를 누르게 되면 ! 
            	
                $.ajax({
                    url:"1single", //리스트를 뿌린다 
                    method:"POST",
                    // data:{}에서는 EL을 ""로 감싸야 한다. 이외에는 그냥 사용한다.
                    data:{
                    	p_no:$("#p_no").val(),
                    },
                    beforeSend:function() {
                        console.log("시작 전...");
                    },
                    complete:function() {
                        console.log("완료 후..."); //됬는데 컨트롤러까지 안가
                    },
                    success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback
             
                            //alert("success");
                            console.log("콜백실행");
                            console.log("comment가 정상적으로 입력되었습니다.");
                            $("#comments-tab").val("");
                            
                    }
                })
            });
        })
        
        
         $(function(){ 
            $('#submit').on('click', function(e) { 
            	//제출시
                $.ajax({
                	
                    url:"qna_write_action", //리스트를 뿌린다 
                    method:"POST",
                    // data:{}에서는 EL을 ""로 감싸야 한다. 이외에는 그냥 사용한다.
                    data:{
                    	//데이터로 qna 객체를 만들어서 줘야하네?
                    	p_no:$("#p_no").val(),
                    	M_id:$("#M_id").val(),
                    	Q_content:$("#Q_content").val(),
                    	Q_title:$("#Q_title").val()
                    },
                    beforeSend:function() {
                        console.log("쓰기액션 시작 전...");
                    },
                    complete:function() {
                        console.log("쓰기액션 완료 후..."); //됬는데 컨트롤러까지 안가
                    },
                    success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback
             
                            //alert("쓰기액션 success");
                            console.log("쓰기액션콜백실행");
                            console.log("쓰기액션 comment가 정상적으로 입력되었습니다.");
                            $("#submit").val("");
                           
                    }
                })
            });
        })
        
      
      //ready? dom트리 다 완성후 사용 > ? 
    		  
    		  
    $(document).on('mouseup', '#ReplyB', function(e){ 
    	//alert(e.target);
    	$.ajax({ url : "qna_reply_form_main" ,
    		type : "POST" ,
    		data : {
    			 q_no:$("#Q_noPick").val()+""
    			 //이값을 동적으로 가지고오지 못하는거임 동적으로 가지고올려면??
    			//선택한아이의 값을가져올수있는거..
    		},
    		success : function(result)
    		{ 
    			//alert($("#ReplySPAN").val()+""+"번 째"); //영원히 68번째임
    			//alert($("#Q_noPick").val()+"번 째"); //영원히 68번째임
    			
    			
    			//alert(result);
    			//초기화 이벤트 호출
    			$("#ReplyB").trigger("click");	
    			//$("#Q_noPick").trigger("");
    			
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
                    // data:{}에서는 EL을 ""로 감싸야 한다. 이외에는 그냥 사용한다.
                    data:{
                    	//데이터로 qna 객체를 만들어서 줘야하네?
                    	Q_no:$("#Q_no_RE").val(),
                    	p_no:$("#p_no").val(),
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
             
                            //alert("RE답글쓰기액션 success");
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
        

            <!-- Start Header Area -->
            <header class="default-header">
                <div class="menutop-wrap">
                    <div class="menu-top container">
                        <div class="d-flex justify-content-between align-items-center">
                            <ul class="list">
                                <li><a href="tel:+12312-3-1209">+12312-3-1209</a></li>
                                <li><a href="mailto:support@colorlib.com">support@colorlib.com</a></li>                             
                            </ul>
                            <ul class="list">
                                <li><a href="#">login</a></li>
                            </ul>
                        </div>
                    </div>                  
                </div>
                <nav class="navbar navbar-expand-lg navbar-light">
                    <div class="container">
                          <a class="navbar-brand" href="index.html">
                            <img src="img/logo.png" alt="">
                          </a>
                          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                          </button>
                          <div class="collapse navbar-collapse justify-content-end align-items-center" id="navbarSupportedContent">
                            <ul class="navbar-nav">
                                <li><a href="#home">Home</a></li>
                                <li><a href="#catagory">Category</a></li>
                                <li><a href="#men">Men</a></li>
                                <li><a href="#women">Women</a></li>
                                <li><a href="#latest">latest</a></li>
                                    <!-- Dropdown -->
                                    <li class="dropdown">
                                      <a class="dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                        Pages
                                      </a>
                                      <div class="dropdown-menu">
                                        <a class="dropdown-item" href="category.html">Category</a>
                                        <a class="dropdown-item" href="single.html">Single</a>
                                        <a class="dropdown-item" href="cart.html">Cart</a>
                                        <a class="dropdown-item" href="checkout.html">Checkout</a>
                                        <a class="dropdown-item" href="confermation.html">Confermation</a>
                                        <a class="dropdown-item" href="login.html">Login</a>
                                        <a class="dropdown-item" href="tracking.html">Tracking</a>
                                        <a class="dropdown-item" href="generic.html">Generic</a>
                                        <a class="dropdown-item" href="elements.html">Elements</a>
                                      </div>
                                    </li>                                   
                            </ul>
                          </div>                        
                    </div>
                </nav>
            </header>
            <!-- End Header Area -->

            <!-- Start Banner Area -->
            <section class="banner-area organic-breadcrumb">
                <div class="container">
                    <div class="breadcrumb-banner d-flex flex-wrap align-items-center">
                        <div class="col-first">
                            <h1>Single Product Page</h1>
                             <nav class="d-flex align-items-center justify-content-start">
                                <a href="index.html">Home<i class="fa fa-caret-right" aria-hidden="true"></i></a>
                                <a href="single.html">Single Product Page</a>
                            </nav>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Banner Area -->

            <!-- Start Product Details -->
            <div class="container">
                <div class="product-quick-view">
                    <div class="row align-items-center">
                        <div class="col-lg-6">
                            <div class="quick-view-carousel-details">
                                <div class="item" style="background: url(img/q1.jpg);">

                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="quick-view-content">
                                <div class="top">
                                    <h3 class="head">Faded SkyBlu Denim Jeans</h3>
                                    <div class="price d-flex align-items-center"><span class="lnr lnr-tag"></span> <span class="ml-10">$149.99</span></div>
                                    <div class="category">Category: <span>Household</span></div>
                                    <div class="available">Availibility: <span>In Stock</span></div>
                                </div>
                                <div class="middle">
                                    <p class="content">Mill Oil is an innovative oil filled radiator with the most modern technology. If you are looking for something that can make your interior look awesome, and at the same time give you the pleasant warm feeling during the winter.</p>
                                </div>
                                <div >
                                    <div class="quantity-container d-flex align-items-center mt-15">
                                        Quantity:
                                        <input type="text" class="quantity-amount ml-15" value="1" />
                                        <div class="arrow-btn d-inline-flex flex-column">
                                            <button class="increase arrow" type="button" title="Increase Quantity"><span class="lnr lnr-chevron-up"></span></button>
                                            <button class="decrease arrow" type="button" title="Decrease Quantity"><span class="lnr lnr-chevron-down"></span></button>
                                        </div>

                                    </div>
                                    <div class="d-flex mt-20">
                                        <a href="#" class="view-btn color-2"><span>Add to Cart</span></a>
                                        <a href="#" class="like-btn"><span class="lnr lnr-layers"></span></a>
                                        <a href="#" class="like-btn"><span class="lnr lnr-heart"></span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="details-tab-navigation d-flex justify-content-center mt-30">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li>
                            <a class="nav-link" id="description-tab" data-toggle="tab" href="#description" role="tab" aria-controls="description" aria-expanded="true">Description</a>
                        </li>
                        <li>
                            <a class="nav-link" id="specification-tab" data-toggle="tab" href="#specification" role="tab" aria-controls="specification">Specification</a>
                        </li>
                        
                        <li>
                            <a class="nav-link" id="comments-tab" data-toggle="tab" href="#comments" role="tab" aria-controls="comments">Comments</a>
                        </li>
                        
                       <!--  <li><a href="qna_list">QnA리스트</a></li> -->
                        
                        <li>
                            <a class="nav-link active" id="reviews-tab" data-toggle="tab" href="#reviews" role="tab" aria-controls="reviews">Reviews</a>
                        </li>
                    </ul>
                </div>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade" id="description" role="tabpanel" aria-labelledby="description">
                        <div class="description">
                            <p>Beryl Cook is one of Britain’s most talented and amusing artists .Beryl’s pictures feature women of all shapes and sizes enjoying themselves .Born between the two world wars, Beryl Cook eventually left Kendrick School in Reading at the age of 15, where she went to secretarial school and then into an insurance office. After moving to London and then Hampton, she eventually married her next door neighbour from Reading, John Cook. He was an officer in the Merchant Navy and after he left the sea in 1956, they bought a pub for a year before John took a job in Southern Rhodesia with a motor company. Beryl bought their young son a box of watercolours, and when showing him how to use it, she decided that she herself quite enjoyed painting. John subsequently bought her a child’s painting set for her birthday and it was with this that she produced her first significant work, a half-length portrait of a dark-skinned lady with a vacant expression and large drooping breasts. It was aptly named ‘Hangover’ by Beryl’s husband and still hangs in their house today</p>
                            <p>It is often frustrating to attempt to plan meals that are designed for one. Despite this fact, we are seeing more and more recipe books and Internet websites that are dedicated to the act of cooking for one. Divorce and the death of spouses or grown children leaving for college are all reasons that someone accustomed to cooking for more than one would suddenly need to learn how to adjust all the cooking practices utilized before into a streamlined plan of cooking that is more efficient for one person creating less waste. The mission</p>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="specification" role="tabpanel" aria-labelledby="specification">
                        <div class="specification-table">
                            <div class="single-row">
                                <span>Width</span>
                                <span>128mm</span>
                            </div>
                            <div class="single-row">
                                <span>Height</span>
                                <span>508mm</span>
                            </div>
                            <div class="single-row">
                                <span>Depth</span>
                                <span>85mm</span>
                            </div>
                            <div class="single-row">
                                <span>Weight</span>
                                <span>52gm</span>
                            </div>
                            <div class="single-row">
                                <span>Quality checking</span>
                                <span>Yes</span>
                            </div>
                            <div class="single-row">
                                <span>Freshness Duration</span>
                                <span>03days</span>
                            </div>
                            <div class="single-row">
                                <span>When packeting</span>
                                <span>Without touch of hand</span>
                            </div>
                            <div class="single-row">
                                <span>Each Box contains</span>
                                <span>60pcs</span>
                            </div>
                        </div>
                    </div>
                    
                    
                    
                    
                    <!-- 코멘트 (질문창) 디비랑해서 가꼬오기 -->
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
                                                <a href="qna_delete_action?q_no=<%=qna.getQ_no()%>" class="view-btn color-2 reply order-2 order-sm-3"  id="DeleteB">
                                                <i class="fa fa-reply" aria-hidden="true"></i>
                                                <span id="DeleteSPAN" name="DeleteSPAN" value="<%=qna.getQ_no()%>">Delete</span>
                                                </a>
                                         
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
                                        	
                                        	<!-- 이름 세션의 사용자아이디찾기 -->
                                            <input type="text" placeholder="YOUR ID" 
                                            onfocus="this.placeholder=''" onblur="this.placeholder = 'YOUR ID'" 
                                            required class="common-input" name="M_id" id="M_id">
                                            
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
                                               
                                              <a href="review_delete_action?r_no=<%=review.getR_no()%>" 
                                             	 class="view-btn color-2 reply order-2 order-sm-3"  id="DeleteBR">
                                                <i class="fa fa-reply" aria-hidden="true"></i>
                                                <span id="DeleteSPAN" name="DeleteSPAN" value="<%=review.getR_no()%>">Delete</span>
                                                </a>
                                           
                                                
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
                                          <input type="hidden" name="r_p_no" id="r_p_no" />
                                            <!-- 이름 세션의 사용자아이디찾기 -->
                                            <input type="text" placeholder="YOUR ID" 
                                            onfocus="this.placeholder=''" 
                                            onblur="this.placeholder = 'YOUR ID'" 
                                            required class="common-input" name="r_m_id" id="r_m_id">
                                            
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
            
            <!-- End Product Details -->
                    
            <!-- Start Most Search Product Area -->
            <section class="pt-100 pb-100">
                <div class="container">
                    <div class="organic-section-title text-center">
                        <h3>Most Searched Products</h3>
                    </div>
                    <div class="row mt-30">
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r1.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Pixelstore fresh Blueberry</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $240.00</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r2.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Pixelstore fresh Cabbage</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $189.00</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r3.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Pixelstore fresh Raspberry</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $189.00</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r4.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Pixelstore fresh Kiwi</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $189.00</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r5.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Pixelstore Bell Pepper</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $120.00</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r6.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Pixelstore fresh Blackberry</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $120.00</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r7.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Pixelstore fresh Brocoli</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $120.00</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r8.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Pixelstore fresh Carrot</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $120.00</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r9.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Pixelstore fresh Strawberry</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $240.00</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r10.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Prixma MG2 Light Inkjet</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $240.00</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r11.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Pixelstore fresh Cherry</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $240.00 <del>$340.00</del></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-search-product d-flex">
                                <a href="02-11-product-details.html"><img src="img/r12.jpg" alt=""></a>
                                <div class="desc">
                                    <a href="02-11-product-details.html" class="title">Pixelstore fresh Beans</a>
                                    <div class="price"><span class="lnr lnr-tag"></span> $240.00 <del>$340.00</del></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Most Search Product Area -->
            <!-- start footer Area -->      
            <footer class="footer-area section-gap">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3  col-md-6 col-sm-6">
                            <div class="single-footer-widget">
                                <h6>About Us</h6>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore dolore magna aliqua.
                                </p>
                            </div>
                        </div>
                        <div class="col-lg-3  col-md-6 col-sm-6">
                            <div class="single-footer-widget">
                                <h6>Newsletter</h6>
                                <p>Stay update with our latest</p>
                                <div class="" id="mc_embed_signup">

                                        <form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="form-inline">

                                        <div class="d-flex flex-row">

                                            <input class="form-control" name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '" required="" type="email">


                                                <button class="click-btn btn btn-default"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></button>
                                                <div style="position: absolute; left: -5000px;">
                                                    <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                                                </div>
                                            
                                            <!-- <div class="col-lg-4 col-md-4">
                                                <button class="bb-btn btn"><span class="lnr lnr-arrow-right"></span></button>
                                            </div>  -->
                                        </div>      
                                        <div class="info"></div>
                                        </form>
                                </div>
                                </div>
                        </div>                      
                        <div class="col-lg-3  col-md-6 col-sm-6">
                            <div class="single-footer-widget mail-chimp">
                                <h6 class="mb-20">Instragram Feed</h6>
                                <ul class="instafeed d-flex flex-wrap">
                                    <li><img src="img/i1.jpg" alt=""></li>
                                    <li><img src="img/i2.jpg" alt=""></li>
                                    <li><img src="img/i3.jpg" alt=""></li>
                                    <li><img src="img/i4.jpg" alt=""></li>
                                    <li><img src="img/i5.jpg" alt=""></li>
                                    <li><img src="img/i6.jpg" alt=""></li>
                                    <li><img src="img/i7.jpg" alt=""></li>
                                    <li><img src="img/i8.jpg" alt=""></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="single-footer-widget">
                                <h6>Follow Us</h6>
                                <p>Let us be social</p>
                                <div class="footer-social d-flex align-items-center">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-dribbble"></i></a>
                                    <a href="#"><i class="fa fa-behance"></i></a>
                                </div>
                            </div>
                        </div>                          
                    </div>
                    <div class="footer-bottom d-flex justify-content-center align-items-center flex-wrap">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        <p class="footer-text m-0">Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </footer>   
            <!-- End footer Area -->      
            <!-- Modal Quick Product View -->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="container relative">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <div class="product-quick-view">
                            <div class="row align-items-center">
                                <div class="col-lg-6">
                                    <div class="quick-view-carousel">
                                        <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                        </div>
                                        <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                        </div>
                                        <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="quick-view-content">
                                        <div class="top">
                                            <h3 class="head">Mill Oil 1000W Heater, White</h3>
                                            <div class="price d-flex align-items-center"><span class="lnr lnr-tag"></span> <span class="ml-10">$149.99</span></div>
                                            <div class="category">Category: <span>Household</span></div>
                                            <div class="available">Availibility: <span>In Stock</span></div>
                                        </div>
                                        <div class="middle">
                                            <p class="content">Mill Oil is an innovative oil filled radiator with the most modern technology. If you are looking for something that can make your interior look awesome, and at the same time give you the pleasant warm feeling during the winter.</p>
                                            <a href="#" class="view-full">View full Details <span class="lnr lnr-arrow-right"></span></a>
                                        </div>
                                        <div class="bottom">
                                            <div class="color-picker d-flex align-items-center">Color:
                                                <span class="single-pick"></span>
                                                <span class="single-pick"></span>
                                                <span class="single-pick"></span>
                                                <span class="single-pick"></span>
                                                <span class="single-pick"></span>
                                            </div>
                                            <div class="quantity-container d-flex align-items-center mt-15">
                                                Quantity:
                                                <input type="text" class="quantity-amount ml-15" value="1" />
                                                <div class="arrow-btn d-inline-flex flex-column">
                                                    <button class="increase arrow" type="button" title="Increase Quantity"><span class="lnr lnr-chevron-up"></span></button>
                                                    <button class="decrease arrow" type="button" title="Decrease Quantity"><span class="lnr lnr-chevron-down"></span></button>
                                                </div>

                                            </div>
                                            <div class="d-flex mt-20">
                                                <a href="#" class="view-btn color-2"><span>Add to Cart</span></a>
                                                <a href="#" class="like-btn"><span class="lnr lnr-layers"></span></a>
                                                <a href="#" class="like-btn"><span class="lnr lnr-heart"></span></a>
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
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
            <script src="js/vendor/bootstrap.min.js"></script>
            <script src="js/jquery.ajaxchimp.min.js"></script>
            <script src="js/jquery.nice-select.min.js"></script>
            <script src="js/jquery.sticky.js"></script>
            <script src="js/ion.rangeSlider.js"></script>
            <script src="js/jquery.magnific-popup.min.js"></script>
            <script src="js/owl.carousel.min.js"></script>
            <script src="js/main.js"></script>  
           
        </body>
    </html>