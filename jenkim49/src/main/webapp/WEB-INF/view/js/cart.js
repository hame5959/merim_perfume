
function checkoutInsertDirect() {
	
	  var checkRow = "";
	   var j_name="";
	   var   j_total_qty="";
	   var j_total_price="";
	   var  jd_item_qty="";
	   var jd_items_price="";
	   var p_no="";
		   var arr=new Array();
	   var obj=new Object();
	   $("[name='checkOne']:checked").each(function(i,elements) {
		
	      index=$(elements).index("input:checkbox[name=checkOne]");
	      checkRow = checkRow + $(this).val() + ",";
	      j_name =j_name+$("[name=p_name]").eq(index).val()+ ",";
          j_total_qty =j_total_qty+ $("[name=total_qty]").val()+ ",";
          j_total_price =j_total_price+ ($('#subtotal').text().replace(/,/g, ''))+",";	
          jd_item_qty = jd_item_qty+ $("[name=cart_qty]").eq(index).val()+ ",";
          jd_items_price =jd_items_price+ ($("[name=checkppp]").eq(index).val())+ ",";
          p_no =p_no+ $("[name=p_no]").eq(index).val()+ ",";
	   });

	   alert("totalPrice="+j_total_price);
	   alert("totalqty="+ j_total_qty);
	  checkRowStr = checkRow.substring(0, checkRow.lastIndexOf(",")).toString();
	  j_nameStr = j_name.substring(0, j_name.lastIndexOf(",")).toString();
	  j_total_qtyStr = j_total_qty.substring(0, j_total_qty.lastIndexOf(",")).toString();
	  j_total_priceStr = j_total_price.substring(0, j_total_price.lastIndexOf(",")).toString();
	  jd_item_qtyStr = jd_item_qty.substring(0, jd_item_qty.lastIndexOf(",")).toString();
	  jd_items_priceStr = jd_items_price.substring(0, jd_items_price.lastIndexOf(",")).toString();
	  p_noStr = p_no.substring(0, p_no.lastIndexOf(",")).toString();
	   alert("totalPrice2="+j_total_priceStr);
	   alert("totalqty2="+ j_total_qtyStr);
	  
	   if (checkRow == '') {
	      alert("please select item");
	      return false;

	   }

	checkRowStrArr=checkRowStr.split(",");
	   j_nameStrArr=j_nameStr.split(",");
	j_total_qtyStrArr=j_total_qtyStr.split(",");
	j_total_priceStrArr=j_total_priceStr.split(",");
	jd_item_qtyStrStrArr=jd_item_qtyStr.split(",");
	jd_items_priceStrArr=jd_items_priceStr.split(",");
	p_noStrArr=p_noStr.split(",");

	

	for (var i = 0; i < checkRowStrArr.length; i++) {
		var jumun = new  Object();
		j_no : parseInt("0"),
		jumun.j_name =j_nameStrArr[i];
		jumun.j_total_qty = j_total_qtyStrArr[i];
		jumun.j_total_price = j_total_priceStrArr[i];
		jumun.m_id =$("[name=m_id]").val()
		jumun. jd_item_qty = jd_item_qtyStrStrArr[i];
		jumun.jd_items_price = jd_items_priceStrArr[i];
		jumun.p_no =p_noStrArr[i];
		alert(jumun);
		arr.push(jumun);
	}





	   console.log("### checkRow => {}" + checkRow);

     if (confirm("Do you want to checkout?")) {
         alert(JSON.stringify(arr));
         jQuery.ajaxSettings.traditional = true;
            $.ajax({
               url : 'cjumun_insert_action_directly',
               type : 'POST',
               dataType : 'json',
          data:JSON.stringify(arr),
          contentType:"application/json",
               success : function(data) {
                  alert("success");
                 /* document.sm1.action = "cjumun_insert_action_directly";
	          		document.sm1.method = "POST";
	          		document.sm1.submit();*/
              	document.sm1.action = "1checkout";
                document.sm1.submit();

               },
               complete : function() {
                  /* document.sm1.action = "cjumun_insert_action_directly";
	          		document.sm1.method = "POST";
	          		document.sm1.submit();*/
            		document.sm1.action = "1checkout";
                    document.sm1.submit();
            	   
               }


         
   
            })

         }
      }
      

   function allCheckFunc(obj) {
      $("[name=checkOne]").prop("checked", $(obj).prop("checked"));
      $("[name=cart_price]").prop("checked", $(obj).prop("checked"));
   }

   function oneCheckFunc(obj) {
      var allObj = $("[name=checkAll]");
      var objName = $(obj).attr("name");
      var checked='';
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
         sumAlltotalPrice();
      });
      $("[name=checkOne]").each(function() {
         $(this).click(function() {
            oneCheckFunc($(this));
            sumAlltotalPrice();
         });
      });
      
   });
   function sumAlltotalPrice() {
	      var checkRow =[];
	      var checkRow2=[];
	      $("input:checkbox[name=checkOne]:checked").each(function(i,elements) {
	    	  index=$(elements).index("input:checkbox[name=checkOne]");
	         checkRow.push(parseInt($("[name=checkppp]").eq(index).val()));
	         checkRow2.push(parseInt($("[name=cart_qty]").eq(index).val()));
	          });
	      alert(checkRow2);
		   
		
	      const array1 = checkRow;
	      const array2=checkRow2;
	      const reducer = (accumulator, currentValue) => accumulator + currentValue;
	     $('#subtotal').text(array1.reduce(reducer));
	     


	
	    $("[name=total_qty]").val(array2.reduce(reducer));
	  alert($("[name=total_qty]").val());
	    if (checkRow == '') {
	            alert("please select item");
	            return false;

	         }
	      

	      // $('.subtotal').text('dasd');
	   


	   }
/*
   function sumtotalPrice() {
      var checkRow =[];
      $("input:checkbox[name=checkOne]:checked").each(function(i,elements) {
    	  index=$(elements).index("input:checkbox[name=checkOne]");
         checkRow.push(parseInt($("[name=checkppp]").eq(index).val()));	
          });
    
      const array1 = checkRow;
      const reducer = (accumulator, currentValue) => accumulator + currentValue;
     $('.subtotal').text(array1.reduce(reducer));
         if (checkRow == '') {
            alert("please select item");
            return false;

         }
   }
      */
   
      // $('.subtotal').text('dasd');
   


   
   function deleteDirect() {
      var checkRow = "";
      $("[name='checkOne']:checked").each(function() {
         checkRow = checkRow + $(this).val() + ",";
      });
      checkRow = checkRow.substring(0, checkRow.lastIndexOf(","));
      
      if (checkRow == '') {
         alert("please select item");
         return false;
   
      }
      
      console.log("### checkRow => {}" + checkRow);
      if (confirm("Do you want to delete?"+checkRow)) {
    	  alert(checkRow[0]+","+checkRow[1]+","+checkRow[2]+"@@@");
            $.ajax({
                  url : 'cart_delete_action_one',
                  type : 'POST',
                  dataType : 'text',
                  data : {
                     cart_no : checkRow,
                     m_id: "jenkim49"
                  },
                  success : function(data) {
                     alert("success");
                     document.sm1.action = "cart_delete_action_one";
 	          		document.sm1.method = "POST";
 	          		document.sm1.submit();
                  }
               })

            

      }
   }
   
   
   

   
   
   
    // ------- Start Quantity Increase & Decrease Value --------//

    function addComma(num) {
       var regexp = /\B(?=(\d{3})+(?!\d))/g;
       return num.toString().replace(regexp, ',');
     }

  
    var value,
        quantity = document.getElementsByClassName('cart-single-item');
   
    var total,price= document.getElementsByClassName('price');
    var totalArray=[];
    var totals=[];
    totals.push($('.priceppp').text());
     
    // $(".subtotal").text(totals);
       
    function createBindings(quantityContainer) {
       
        var quantityAmount = quantityContainer.getElementsByClassName('quantity-amount')[0];
        var priceAmount=quantityContainer.getElementsByClassName('pricepp')[0];
        var priceAmount2=quantityContainer.getElementsByClassName('priceppp')[0];
       const priceAmount3=quantityContainer.getElementsByClassName('pricepppp')[0];
        var increase = quantityContainer.getElementsByClassName('increase')[0];
        var decrease = quantityContainer.getElementsByClassName('decrease')[0];
       var update =quantityContainer.getElementsByClassName('update')[0];
        increase.addEventListener('click', function ()
              {
           increaseValue(quantityAmount,priceAmount,priceAmount2,priceAmount3,totalArray);
           
              // totalArray.push(totals);
               
               
           // cartUpdate();

           
           });
        update.addEventListener('click', function () {
           updateValue(priceAmount,quantityAmount); 
                  
       });
        decrease.addEventListener('click', function () {
           decreaseValue(quantityAmount,priceAmount,priceAmount2,priceAmount3); 
     
           });
    }

  
    
    function init() {
        for (var i = 0; i < quantity.length; i++ ) {
            createBindings(quantity[i]);
      
        }
    };
    
function updateValue(priceAmount,quantityAmount){
   
   var checkRow = "";
   var cart_qty="";
   var cart_price="";
   var cart_date="";
   var arr=new Array();
   var obj=new Object();
    	     
   $("[name='checkOne']:checked").each(function(i,elements) {
     alert('adsadsadasd');
      index=$(elements).index("input:checkbox[name=checkOne]");
      checkRow = checkRow + $(this).val() + ",";
 	  cart_qty=cart_qty+($("[name=cart_qty]").eq(index).val())+",";	
 	  cart_price=cart_price+($('.priceppp').eq(index).text().replace(/,/g, ''))+",";	
   });


  checkRowStr = checkRow.substring(0, checkRow.lastIndexOf(",")).toString();
   cart_qtyStr = cart_qty.substring(0, cart_qty.lastIndexOf(",")).toString();
   cart_priceStr = cart_price.substring(0, cart_price.lastIndexOf(",")).toString();
  

   if (checkRow == '') {
      alert("please select item");
      return false;

   }
alert(typeof checkRow)
   checkRowArr=checkRowStr.split(",");
cart_qtyArr=cart_qtyStr.split(",");
cart_priceArr=cart_priceStr.split(",");
alert("길이"+checkRowArr.length);
alert(checkRowArr[0]+"@@"+checkRowArr[1]);
for (var i = 0; i < checkRowArr.length; i++) {
	var cart = new  Object();
	cart.cart_no=checkRowArr[i];
	cart.cart_qty=cart_qtyArr[i];
	cart.cart_price=cart_priceArr[i];
	
		arr.push(cart);
}




   console.log("### checkRow => {}" + checkRow);

   if (confirm("Do you want to delete?"+checkRow)) {
	   alert(arr[0]+","+arr[1]+","+arr[2]+"@@@");
	   alert(JSON.stringify(arr));
	   jQuery.ajaxSettings.traditional = true;
	   $.ajax({
    	            url : 'cart_update_action',
    	               type : 'POST',
    	               dataType : 'json',
    	          data:JSON.stringify(arr),
    	          contentType:"application/json",
    	               success : function(arr) {
    	                  alert("success");
    	                  document.sm1.action = "cart_update_action";
    	          		document.sm1.method = "POST";
    	          		document.sm1.submit();
    	               }
		
    	            })

         

   }

   
}
    /*
	 * function updateValue(priceAmount,quantityAmount){
	 * 
	 * alert(priceAmount.value); var checkRow = ""; var arr= new Array(); var
	 * obj=new Object();
	 * 
	 * 
	 * 
	 *  }
	 * 
	 * $("[name='checkOne']:checked").each(function() { checkRow = checkRow +
	 * $(this).val() + ","; }); checkRow = checkRow.substring(0,
	 * checkRow.lastIndexOf(",")); if (checkRow == '') { alert("please select
	 * item"); return false; } obj.cart_no =checkRow; obj.cart_qty=
	 * quantityAmount.value; obj.cart_price=priceAmount.value;
	 * 
	 * arr.push(obj);
	 * 
	 * 
	 * alert(arr);
	 * 
	 * 
	 * console.log("### checkRow => {}" + checkRow); if (confirm("Do you want to
	 * update?"+checkRow+checkRow[0])) {
	 * 
	 * $.ajax({ url : 'cart_update_action', type : 'POST', dataType : 'json',
	 * data:JSON.stringify(arr), contentType:"application/json", success :
	 * function(data) { alert("success"); } })
	 * 
	 * 
	 *  }
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
  
function increaseValue(quantityAmount,priceAmount,priceAmount2,priceAmount3,totalArray) {
    var checkRow = "";
     $("[name='checkOne']:checked").each(function() {
        checkRow = checkRow + $(this).val() + ",";
     });
     checkRow = checkRow.substring(0, checkRow.lastIndexOf(","));
     
     if (checkRow == '') {
        alert("please select item");
        return false;
  
     }
     
   // alert(quantityAmount,priceAmount);
   // alert(quantity,price);
   value = parseInt(quantityAmount.value, 10);
    console.log(quantityAmount, quantityAmount.value);
   const mulPrice=parseInt(priceAmount3.value,10);

    value = isNaN(value) ? 0 : value;
    value++;
    
    quantityAmount.value = value;


    total=parseInt(mulPrice)*parseInt(quantityAmount.value, 10);

 
 
priceAmount.value =total;

priceAmount2.innerHTML=addComma(total);
var increasetotalValue=parseInt($('#subtotal').text())+parseInt(priceAmount3.value,10);

$('#subtotal').text(increasetotalValue);
}

    function decreaseValue(quantityAmount,priceAmount,priceAmount2,priceAmount3) {
       // alert(quantityAmount,priceAmount);
       // alert(quantity,price);
       value = parseInt(quantityAmount.value, 10);
       
        console.log(quantityAmount, quantityAmount.value);
       
        const mulPrice=parseInt(priceAmount3.value,10);
        value = isNaN(value) ? 0 : value;
        if(value<=1){return false;}
          if (value > 1) value--;
      
        
       
        quantityAmount.value = value;
    
     
   
      
        total=parseInt(mulPrice)*parseInt(quantityAmount.value, 10);

    
    priceAmount.value =total;

    priceAmount2.innerHTML=addComma(total);
    var decreasetotalValue=parseInt($('#subtotal').text())-parseInt(priceAmount3.value,10);

    $('#subtotal').text(decreasetotalValue);
   
    }
/*
 * function decreaseValue(quantityAmount,priceAmount,priceAmount2) { value =
 * parseInt(quantityAmount.value, 10);
 * alert(priceAmount+","+priceAmount2+","+quantityAmount);
 * console.log(quantityAmount, quantityAmount.value);
 * 
 * value = isNaN(value) ? 0 : value; if (value > 0) value--;
 * 
 * quantityAmount.value = value; alert( quantityAmount.value );
 * 
 * 
 * total=parseInt(priceAmount.value)*parseInt(quantityAmount.value, 10);
 * 
 * 
 * 
 * priceAmount.value =total;
 * 
 * priceAmount2.innerHTML=total; }
 */
  init();

  

// ------- End Quantity Increase & Decrease Value --------//
