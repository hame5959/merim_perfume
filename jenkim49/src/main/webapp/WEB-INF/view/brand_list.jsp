
<%@page import="jenkim49.brand.Brand"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Brand> brandList=
		(ArrayList<Brand>)request.getAttribute("brandList");


	String ERROR_MSG=(String)request.getAttribute("ERROR_MSG");
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>방명록 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="css/styles.css">
<link rel="stylesheet"
	href="css/guest.css">
<script	src="js/brand.js"></script>
<script type="text/javascript">
	<%
	if(ERROR_MSG!=null){
		out.println("alert('"+ERROR_MSG+"')");	
	}
	%>
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
		<!-- include_common_top.jsp start-->

		<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->

			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper content start -->
		<div id="wrapper">
			




         
<div id="content">	
<table border=0 cellpadding=0 cellspacing=0>
	<tr>
		<td><br />
			<table style="padding-left: 10px" border=0 cellpadding=0
				cellspacing=0>
				<tr>
					<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>브랜드 관리 -
							리스트</b></td>
				</tr>
			</table>
			<form name="f" method="post" >

				<table border="0" cellpadding="0" cellspacing="1" width="590"
					bgcolor="BBBBBB">
					<tr>
						<td width=50 align=center bgcolor="E6ECDE" height="22">번호</td>
						<td width=300 align=center bgcolor="E6ECDE">이름</td>
				
						<td width=120 align=center bgcolor="E6ECDE">이름</td>
					
					</tr>
					<!-- loop start -->
					<%for (Brand brand : brandList){%>
					<tr>
						<td width=50 align=center bgcolor="ffffff" height="20"><%=brand.br_no%></td>
						<td width=300 bgcolor="ffffff" style="padding-left: 10">
							<a href="brand_view?br_no=<%=brand.br_no%>" class="user">
						 	<%=brand.br_name%>
							</a>
						</td>
						
					</tr>
					<!-- loop end -->
					<%}%>
					
					
				</table>
			</form> <br> <!-- button -->
			<table border="0" cellpadding="0" cellspacing="1" width="590">
				<tr>
					<td align="right"><input type="button"
						onclick="brandCreateform();" value="브랜드 쓰기" /></td>
				</tr>
			</table></td>
	</tr>
</table>


     </div>
</div>



		</div>
		<!-- wrapper content end-->
		<!-- footer start-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			
			<!-- include_common_bottom.jsp end-->
		</div>
		<!-- footer end -->
	</div>
	<!--container end-->
</body>
</html>