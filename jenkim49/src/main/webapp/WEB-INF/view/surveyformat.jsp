<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>BLUEB</title>
</head>

<body onload="init();">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">
var sell_price;
var amount;

alert($('input[name=sell_price1]').val());ccc


function init () {
		sell_price = document.form.sell_price[i].value;
		amount = document.form.amount.value;
		document.form.sum.value = sell_price;
		change();
}

function add () {
	hm = document.form.amount;
	sum = document.form.sum;
	hm.value ++ ;

	sum.value = parseInt(hm.value) * sell_price;
}

function del () {
	hm = document.form.amount;
	sum = document.form.sum;
		if (hm.value > 1) {
			hm.value -- ;
			sum.value = parseInt(hm.value) * sell_price;
		}
}

function change () {
	hm = document.form.amount;
	sum = document.form.sum;

		if (hm.value < 0) {
			hm.value = 0;
		}
	sum.value = parseInt(hm.value) * sell_price;
}  

</script>

<form name="form" method="get">
수량 : <input type=hidden name="sell_price1" value="5500">
<input type="text" name="amount" value="1" size="3" onchange="change();">
	<input type="button" value=" + " onclick="add();">
    <input type="button" value=" - " onclick="del();"><br>
금액 : <input type="text" name="sum" size="11" readonly>원
<br>
수량 : <input type=hidden name="sell_price2" value="6000">
<input type="text" name="amount" value="1" size="3" onchange="change();">
	<input type="button" value=" + " onclick="add();">
    <input type="button" value=" - " onclick="del();"><br>
금액 : <input type="text" name="sum" size="11" readonly>원
</form>
</body>