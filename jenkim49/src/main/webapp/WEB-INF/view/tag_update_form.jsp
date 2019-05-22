
<%@page import="jenkim49.tag.Tag"%>
<%@page import="jenkim49.tag.Tag"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Tag tag=(Tag)request.getAttribute("tag");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>방명록 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">













<script	src="js/tag.js"></script>
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
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
								방명록 수정</b></td>
					</tr>
				</table> <!-- modify Form  -->
					<form name="f" method="post">
					<input type="hidden" name="t_no" value="<%=tag.t_no%>" />
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">번호</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><%=tag.t_no %></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 150" name="t_name" 
								value="<%=tag.t_name %>"></td>
						</tr>
					
								<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">count</td>
							<td align="left" width=490 bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 150" name="t_count" 
								value="<%=tag.t_count %>"></td>
						</tr>
					
					</table>
				</form>
				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td align=center>
						<input type="button" value="수정" onClick="tagModifyAction()"> &nbsp; 
						<input type="button" value="목록" onClick="tagList()"></td>
					</tr>
				</table></td>
		</tr>
	</table>
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