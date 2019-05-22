
<%@page import="jenkim49.accord.Accord"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Accord> accordList = (ArrayList<Accord>) request.getAttribute("accordList");
	String ERROR_MSG = (String) request.getAttribute("ERROR_MSG");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>향 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/guest.css">
<script src="js/product.js"></script>
<script type="text/javascript">
	
<%if (ERROR_MSG != null) {
				out.println("alert('" + ERROR_MSG + "')");
			}%>
	
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




			<form name="searchB">
				<input type="text" name="p_name" placeholder="검색어를 입력하세요"
					onkeyup="enterkey()" /> <input type="button" value="검색"
					onclick="search()" />


			</form>

			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>향 관리 -
											리스트</b></td>
								</tr>
							</table>
							<form name="f" method="post">

								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=200 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=600 align=center bgcolor="E6ECDE">설명</td>
										<td width=200 align=center bgcolor="E6ECDE">이미지</td>
										<td width=200 align=center bgcolor="E6ECDE">삭제</td>
									</tr>
									<!-- loop start -->
									<%
										for (Accord accord : accordList) {
									%>
									<tr>
										<td width=200 align=center bgcolor="ffffff" height="20"><a
											href="accord_view?acd_name=<%=accord.getAcd_name()%>"><%=accord.getAcd_name()%></a></td>
										<td width=600 bgcolor="ffffff" style="padding-left: 10">
											<%=accord.getAcd_des()%>
										</td>
										<td width=200 align=center><%=accord.getAcd_img() %></td>
										<td width=200 align=center><a onclick="accordDelete();">삭제</a></td>

									</tr>
									<!-- loop end -->
									<%
										}
									%>


								</table>
							</form> <br> <!-- button -->
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align="right"><input type="button"
										onclick="accordCreateForm();" value="향 등록" /></td>
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
	<!--container end-->
</body>
</html>