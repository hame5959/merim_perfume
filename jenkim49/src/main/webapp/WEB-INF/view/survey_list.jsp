
<%@page import="jenkim49.survey.Survey"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Survey> surveyList = (ArrayList<Survey>) request.getAttribute("surveyList");
	String ERROR_MSG = (String) request.getAttribute("ERROR_MSG");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>설문결과 목록</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/survey.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>설문 관리
											- 리스트</b></td>
								</tr>
							</table>
							<form name="f" method="post">

								<table border="0" cellpadding="0" cellspacing="1" width="800"
									bgcolor="BBBBBB">
									<tr>
										<td width=200 align=center bgcolor="E6ECDE" height="22">번호</td>
										<td width=200 align=center bgcolor="E6ECDE" height="22">좋아하는
											향1</td>
										<td width=200 align=center bgcolor="E6ECDE" height="22">좋아하는
											향2</td>
										<td width=200 align=center bgcolor="E6ECDE" height="22">좋아하는
											향3</td>
										<td width=200 align=center bgcolor="E6ECDE">연령대</td>
										<td width=200 align=center bgcolor="E6ECDE">성별</td>
										<td width=200 align=center bgcolor="E6ECDE">아이디</td>
									</tr>
									<!-- loop start -->
									<%
										for (Survey survey : surveyList) {
									%>
									<tr>
										<td width=200 align=center bgcolor="ffffff" height="20"><a
											href="survey_view?m_id=<%=survey.getM_id()%>"><%=survey.getS_no()%></a></td>
										<td width=200 align="center" bgcolor="ffffff"
											style="padding-left: 10"><%=survey.getS_fav1()%></td>
										<td width=200 align="center" bgcolor="ffffff"
											style="padding-left: 10"><%=survey.getS_fav2()%></td>
										<td width=200 align="center" bgcolor="ffffff"
											style="padding-left: 10"><%=survey.getS_fav3()%></td>
										<td width=200 align=center><%=survey.getS_age()%></td>
										<td width=200 align=center><%=survey.getS_gender()%></td>
										<td width=200 align=center><%=survey.getM_id()%></td>
									</tr>
									<!-- loop end -->
									<%
										}
									%>


								</table>
							</form> <br> <!-- button -->
							<table border="0" cellpadding="0" cellspacing="1" width="800">
								<tr>
									<td align="right"><input type="button"
										onclick="survey_insert_form();" value="신규설문 등록" /></td>
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