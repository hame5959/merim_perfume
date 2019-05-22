
<%@page import="jenkim49.product.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="member_login_check.jspf"%>
<%
	ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
	String ERROR_MSG = (String) request.getAttribute("ERROR_MSG");
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
						<li><a href="<%=loginHref%>"><%=loginButton%></a></li>
						<li><a href="<%=rightButton%>"><%=rightButton%></a></li>
					</ul>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container">
				<a class="navbar-brand" href="1index"> <img
					src="img/logo.png" alt="">
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div
					class="collapse navbar-collapse justify-content-end align-items-center"
					id="navbarSupportedContent">
					<ul class="navbar-nav">
						<li><a href="1index">Home</a></li>
						<li><a href="1category_all">Category</a></li>
						<li><a href="1category_men">Men</a></li>
						<li><a href="1category_women">Women</a></li>
						<li><a href="1survey">Survey</a></li>
						<li><a href="serviceChat">Chat Service</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- End Header Area -->


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
