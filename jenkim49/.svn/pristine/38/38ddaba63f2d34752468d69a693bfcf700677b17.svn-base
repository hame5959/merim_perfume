<%@page import="jenkim49.product.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"
 %>
<%
	Product product=(Product)request.getAttribute("product");

	
	
	
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
 
<script	src="js/product.js"></script>
 
<script type="text/javascript">
/*
function guestRemove() {
	if (window.confirm("정
			말 삭제하시겠습니까?")) {
		document.f.method='POST';
		document.f.action='guest_remove_action.jsp';
		document.f.submit();
	}
}
*/
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
			<td>
				<!--contents--> <br />
				<table style="padding-left: 10px" border=0 cellpadding=0
					cellspacing=0>
					<tr>
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>상품 관리 -
								상품 상세보기</b></td>
					</tr>
				</table> <!-- view Form  -->
			<form name="f" method="post">
					<input type="hidden" name="p_no" value="<%=product.p_no%>" />
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">번호</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><%=product.p_no %></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><%=product.p_name %></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">브랜드</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><%=product.br_name%></td>
						</tr>
						
							<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">태그</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><%=product.t_name%></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">카테고리</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><%=product.p_category%> </td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">키워드</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><%=product.p_keyword%></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><%=product.p_des %>

							</td>
						</tr>
						
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><%=product.p_image %>

							</td>
							<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><%=product.p_volume %>

							</td>
							<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px">><%=product.p_price %>

							</td>
							<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><%=product.p_count %>
						</tr>
						</tr>
						</tr>
						</tr>
					</table>
				</form>
 <br />
				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td align=center>
						<input type="button" value="수정" onClick="productModify();">&nbsp;
						<input type="button" value="삭제" onClick="productRemove();">&nbsp;
						<input type="button" value="목록" onClick="productList();"></td>
				
						
						
						<!-- -999, jumun.j_total_qty, jumun.j_total_price, jumun.j_no, jumunDetail.getP_no() -->
				
				<form name="b">
					<input type="hidden" name="m_id" value="jenkim49"> 
					<input type="hidden" name="j_total_price" value="<%=(product.p_price).intValue()%>"> 
					<input type="hidden" name="j_total_qty" value=5>
					<input type="hidden" name="j_name" value="<%=product.p_name%>">
					<input type="hidden" name="p_no" value="<%=product.p_no%>">
					<input type="button" onclick="BuyNow()" value="바로구매하기">
				</form>	
						
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>


		</div>
		<!-- wrapper content end-->
		<!-- footer start-->
		<div id="footer">
	
		</div>
		<!-- footer end -->
	</div>
	<!--container end-->
</body>
</html>