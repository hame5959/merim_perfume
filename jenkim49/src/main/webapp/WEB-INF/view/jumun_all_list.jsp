<%@page import="jenkim49.jumun.Jumun"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Jumun> jumunList = (ArrayList<Jumun>)request.getAttribute("jumunList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 주문 리스트</title>
</head>
<body>
<!-- loop start -->
					<%for(Jumun jumun:jumunList){%>
					<tr>
						<td width=50 align=center bgcolor="ffffff" height="20"><%=jumun.j_no%></td>
						<td width=300 bgcolor="ffffff" style="padding-left: 10">
							<a href="jumun_view?j_no=<%=jumun.j_no%>" class="jumun">
						 	<%=jumun.j_name%>,
						 	<%=jumun.j_total_price%>
							</a>
						</td>
						
					</tr>
					<!-- loop end -->
					<%}%>
</body>
</html>