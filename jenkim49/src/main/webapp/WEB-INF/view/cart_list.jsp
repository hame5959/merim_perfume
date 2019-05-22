<%@page import="jenkim49.member.MemberService"%>
<%@page import="java.util.List"%>
<%@page import="jenkim49.member.Member"%>
<%@page
	import="org.apache.taglibs.standard.tag.common.fmt.ParseDateSupport"%>
<%@page import="jenkim49.cart.Cart"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="jenkim49.product.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- TO DO LIST -->
<!-- update: 모든 행의 parameters가 넘어감 > 한개만 어떻게 넘길까요.. -->
<!-- deleteAll: m_id session으로 받아와서 넘겨주는거 처리 -->
<!-- cart redirect: m_id session으로 받아와서 넘겨주는거 처리 -->
<%
	ArrayList<Member> mList=(ArrayList<Member>) request.getAttribute("memberList");
	ArrayList<HashMap> cartList = (ArrayList<HashMap>) request.getAttribute("cartList");
	String ERROR_MSG = (String) request.getAttribute("ERROR_MSG");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TEST</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/guest.css">
<script type="text/javascript">
<%if (ERROR_MSG != null) {
				out.println("alert('" + ERROR_MSG + "')");
			}%>
	
</script>
<script src="js/product.js"></script>
<script type="text/javascript">
function addComma(num) {
	  var regexp = /\B(?=(\d{3})+(?!\d))/g;
	  return num.toString().replace(regexp, ',');
	}

	function allCheckFunc(obj) {
		$("[name=checkOne]").prop("checked", $(obj).prop("checked"));
	}

	function oneCheckFunc(obj) {
		var allObj = $("[name=checkAll]");
		var objName = $(obj).attr("name");

		if ($(obj).prop("checked")) {
			checkBoxLength = $("[name=" + objName + "]").length;
			checkedLength = $("[name=" + objName + "]:checked").length;

			if (checkBoxLength == checkedLength) {
				allObj.prop("checked", true);
			} else {
				allObj.prop("checked", false);
			}
		} else {
			allObj.prop("checked", false);
		}
	}

	$(function() {
		$("[name=checkAll]").click(function() {
			allCheckFunc(this);
		});
		$("[name=checkOne]").each(function() {
			$(this).click(function() {
				oneCheckFunc($(this));
			});
		});
	});

	function deleteAction() {
		var checkRow = "";
		$("input[name='checkOne']:checked").each(function() {
			checkRow = checkRow + $(this).val() + ",";
		});
		checkRow = checkRow.substring(0, checkRow.lastIndexOf(","));
		if (checkRow == '') {
			alert("please select item");
			return false;
		}
		console.log("### checkRow => {}" + checkRow);
		if (confirm("Do you want to delete?")) {
			document.sm1.method = 'POST';
			document.sm1.action = "cart_delete_action_one";
			document.sm1.submit();

		}
	}
	
	
	function BuyNow() {
		var checkRow = "";
		$("input[name='checkOne']:checked").each(function() {
			checkRow = checkRow + $(this).val() + ",";
		});
		checkRow = checkRow.substring(0, checkRow.lastIndexOf(","));
		if (checkRow == '') {
			alert("please select item");
			return false;
		}
		console.log("### checkRow => {}" + checkRow);
		if (confirm("Do you want to delete?")) {
			  
            $.ajax({
               url : 'cart_delete_action_one',
               type : 'POST',
               dataType : 'text',
               data : {
                  cart_no : $("[name=p_no]").val()
               },
               success : function(data) {
                  alert("success");
               }
            })

         }
      }
      
	
	

	function updateAction() {
		
		var checkRow = "";
		$("input[name='checkOne']:checked").each(function() {
			checkRow = checkRow + $(this).val() + ",";
		});
		checkRow = checkRow.substring(0, checkRow.lastIndexOf(","));
		if (checkRow == '') {
			alert("please select item");
			return false;
		}
		console.log("### checkRow => {}" + checkRow);
	
		var cart_qty = $("[name=cart_qty]").val();
		var cart_price = $("[name=cart_price]").val();
		var cart_no = $("[name=cart_no]").val();
	
		
		
			document.sm1.method = 'POST';
			document.sm1.action = "cart_update_action";
			document.sm1.submit();
		
	}

	function modifyProductQuantity(id, quantity) {
		if (isNaN($("#" + id).val())) {
			alert('please enter number');
			$("#" + id).focus();
			$("#" + id).val(0);
			return;
		}
		var q = parseInt($("#" + id).val()) + parseInt(quantity);
		$("#" + id).val(q);
	}
	
	

	$(function() {
		$('.bt_up').click(function() {
			var n = $('.bt_up');
			var num = $(".num").val();
			var price=$("#price td:eq(3)").text();  
			num = $(".num").val(num * 1 + 1);
			var total=0;
			total=parseInt(price)*parseInt(num.val());
			numt=$(".numt").val(addComma(total));
		});
		$('.bt_down').click(function() {
			var n = $('.bt_down');
			var num = $(".num").val();
			var price=$("#price td:eq(3)").text();  
			num = $(".num").val(num * 1 - 1);
			var total=0;
			total=parseInt(price)*parseInt(num.val());
			//numt=$(".numt").val(total);
			numt=$(".numt").val(addComma(total));
			
		});
	})

</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">

		<!-- wrapper content start -->
		<div id="wrapper">
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>LIST</b></td>
								</tr>
							</table> <!-- TABLE CONTENT -->

							<form name="sm1" method="post">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td><input type="checkbox" name="checkAll"
											value="${m_id}" /></td>
										<td width=300 align=center bgcolor="E6ECDE">Product</td>
										<td width=60 align=center bgcolor="E6ECDE">Volume</td>
										<td width=60 align=center bgcolor="E6ECDE">Price</td>
										<td width=60 align=center bgcolor="E6ECDE">Quantity</td>
										<td width=120 align=center bgcolor="E6ECDE">Total</td>
									</tr>
									<!-- loop start -->
								
									<%
										for (HashMap cart : cartList) {
									%>
									<tr id="price">
										<td><input type="hidden" id="cart_no" name="cart_no"
											class="cart_no" value=<%=cart.get("cart_no")%>> <input
											type="hidden" name="m_id" value="jenkim49"> <input
											type="hidden" name="cart_date"
											value="<%=cart.get("cart_date")%>"> <input
											type="checkbox" name="checkOne"
											value=<%=cart.get("cart_no")%>></td>
										<td width=300 bgcolor="ffffff" align="center"
											style="padding-left: 10"><a
											href="product_view?p_no=<%=cart.get("p_no")%>" class="user">
												<%=cart.get("p_name")%>
										</a></td>
										<td width=300 bgcolor="ffffff" align="center"padding-left: 10">
											<%=cart.get("p_volume")%>
										</td>
										<td width=300 bgcolor="ffffff" align="center"
											style="padding-left: 10" class="price" id="price"><%=cart.get("p_price")%></td>
										<td width=100 bgcolor="ffffff" align="center"
											style="padding-left: 10">
											<table>
												<tr>
													<td><input
														type="text" name="cart_qty"
														value="<%=cart.get("cart_qty")%>" id="cart_qty"
														class="num" /></td>
													<td>

														<div>
															<input type="button" id='countup' class="bt_up" alt=""
																value="UP" />
														</div>
														<div>
															<input type="button" id='countdown' class="bt_down"
																alt="" value="DOWN" />
														</div>


													</td>

												</tr>
											</table>
										</td>
										<td width=300 bgcolor="ffffff" align="center"
											style="padding-left: 10"><input type="text"
											name="cart_price" class="numt"
											value=<%=cart.get("cart_price")%>> <%=cart.get("cart_price")%>
										</td>
									</tr>
							
									<!-- loop end -->
								</table>
							</form> <br> <!-- button -->
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td><input type='button' onclick='deleteAction();'
										value='DELETE ONE' /></td>
									<td><input type='button' onclick='updateAction();'
										value='UPDATE' /></td>
										

			<form name="b">
					
					<input type="hidden" name="j_total_qty" value="<%=cart.get("cart_qty")%>">
					<input type="hidden" name="j_name" value="테스트">
					<input type="hidden" name="j_total_price" value="<%=cart.get("cart_price")%>">
					<input type="hidden" name="co_date" value="<%=cart.get("cart_price")%>">
					<input type="hidden" name="m_id" value="jenkim49"> 

					<input type="button" onclick="BuyNow()" value="바로구매하기">
				</form>
								</tr>
							</table>
					</tr>
				</table>
		<%
										}
										
									%>
			</div>
		</div>

	</div>
	<!— wrapper content end—>
	</div>
	<!—container end—>
</body>
</html>