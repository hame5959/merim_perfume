<%@page import="jenkim49.product.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
ArrayList<Product> productList=
(ArrayList<Product>)request.getAttribute("productList");
String ERROR_MSG=(String)request.getAttribute("ERROR_MSG");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

</script>
</head>


<body>
<%for(Product product:productList){%>
<%=product.p_name%>
<%} %>
</body>
</html>