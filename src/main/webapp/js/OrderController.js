app.controller('OrderController', function($scope, $http) {	
	
	$scope.initOrder = function(){
		$scope.getAllDrinks($scope.coffeType);
		$scope.getAllDrinks($scope.condimentType);
		$scope.getCart();
	}
	
	$scope.getAllDrinks = function(drinkType){

		var response = $http.get('http://localhost:9966/kahveciefendi/api/v1/' + drinkType);
		response.success(function(response) {
            if (!angular.isUndefined(response.errorCode)) {
                alert(response.message);
            } else
			if(drinkType == $scope.coffeType){
				$scope.orderCoffees = response;
			}else if(drinkType == $scope.condimentType){
				$scope.orderCondiments = response;
			}
		
		});
		
		response.error(function(response) {
			alert( "Hata: " + response.message);
		});
		
	}
	
	
	$scope.selectCoffee = function(orderCoffee){
		$scope.selectedCofee = '';
		$scope.selectedCofee = angular.copy(orderCoffee)
	}
	
	$scope.addDrinkToBasket = function(){
		$scope.orderItemDetails =  '';
		$scope.orderDetailString  ='';
		
//		for (i = 0; i < $scope.orderCondiments.length; i++) { 
//			$scope.orderItemDetails =  $scope.orderItemDetails + '"orderItemDetails": [ {"condiment": { "id" : ' +  JSON.stringify($scope.orderCondiments[i].id)+ '},'+'"count":'+ JSON.stringify($scope.orderCondimentArray[$scope.orderCondiments[i].id]) + '}]';
//			if(i!=($scope.orderCondiments.length-1)){
//				$scope.orderItemDetails =  $scope.orderItemDetails + ',';	
//			}
//		}
	
		for (i = 0; i < $scope.orderCondiments.length; i++) { 
		$scope.orderItemDetails =  $scope.orderItemDetails +' {"condiment": { "id" : ' +  JSON.stringify($scope.orderCondiments[i].id)+ '},'+'"count":'+ JSON.stringify($scope.orderCondimentArray[$scope.orderCondiments[i].id]) + '}';
			if(i!=($scope.orderCondiments.length-1)){
				$scope.orderItemDetails =  $scope.orderItemDetails + ',';	
			}
		}		
		$scope.orderItemDetails = '"orderItemDetails": [' + $scope.orderItemDetails + ']';
		
		$scope.orderDetailString = '{"beverage":'+	JSON.stringify($scope.selectedCofee) + ','+ $scope.orderItemDetails +'}';
		$scope.orderDetailObject = JSON.parse( $scope.orderDetailString  );
		console.log($scope.orderDetailString);
		var response = $http.post('http://localhost:9966/kahveciefendi/api/v1/cart/items', $scope.orderDetailString);
		response.success(function(response) {
            if (!angular.isUndefined(response.errorCode)) {
                alert(response.message);
            } else {
				 //$scope.cartOrderItems = response.order.orderItems;
				 $scope.cartOrder = response.order;
				console.log(response.order);
            }
		});
		
		response.error(function(response) {
			alert( "Hata: " + response.message);
		});
	}
	
	$scope.checkOutTheBasket= function(){
		var response = $http.post('http://localhost:9966/kahveciefendi/api/v1/cart/orders');
		response.success(function(response) {
            if (!angular.isUndefined(response.errorCode)) {
                alert(response.message);
            } else {
				console.log(response);
            }
		});
	}
	
	$scope.deleteFromBasket = function(index){
		var response = $http.delete('http://localhost:9966/kahveciefendi/api/v1/cart/items/' + index);
		response.success(function(response) {
            if (!angular.isUndefined(response.errorCode)) {
                alert(response.message);
            } else {
            	 $scope.cartOrder = response.order;
 				console.log(response.order);            }
		});
	}
	
	$scope.getCart = function(index){
		var response = $http.get('http://localhost:9966/kahveciefendi/api/v1/cart/' );
		response.success(function(response) {
            if (!angular.isUndefined(response.errorCode)) {
                alert(response.message);
            } else {
            	 $scope.cartOrder = response.order;
 				console.log(response.order);     
 				}
		});
	}

});