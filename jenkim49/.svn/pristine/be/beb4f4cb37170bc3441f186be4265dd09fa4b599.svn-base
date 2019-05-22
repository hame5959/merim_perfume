
function search() {
	document.searchB.action="product_search";
	document.searchB.mehod='POST';
	document.searchB.submit();

}

//------- Start Quantity Increase & Decrease Value --------//

function addComma(num) {
	  var regexp = /\B(?=(\d{3})+(?!\d))/g;
	  return num.toString().replace(regexp, ',');
	}


var value,
    quantity = document.getElementsByClassName('quantity-container');



function createBindings(quantityContainer) {
    var quantityAmount = quantityContainer.getElementsByClassName('quantity-amount')[0];
    var increase = quantityContainer.getElementsByClassName('increase')[0];
    var decrease = quantityContainer.getElementsByClassName('decrease')[0];
   
    increase.addEventListener('click', function ()
    		{
    	increaseValue(quantityAmount);
    	
    	});
    decrease.addEventListener('click', function () {
    	decreaseValue(quantityAmount); 
    	});
}

function init() {
    for (var i = 0; i < quantity.length; i++ ) {
        createBindings(quantity[i]);
  
    }
};

function increaseValue(quantityAmount) {
	//alert(quantityAmount,priceAmount);
	//alert(quantity,price);
	value = parseInt(quantityAmount.value, 10);


    value = isNaN(value) ? 0 : value;
    value++;
    
    quantityAmount.value = value;



}

function decreaseValue(quantityAmount) {
	//alert(quantityAmount,priceAmount);
	//alert(quantity,price);
	value = parseInt(quantityAmount.value, 10);
	
    console.log(quantityAmount, quantityAmount.value);
   
  
    value = isNaN(value) ? 0 : value;
    if(value<=1){return false;}
    if (value > 1) value--;

    quantityAmount.value = value;

}
init();

