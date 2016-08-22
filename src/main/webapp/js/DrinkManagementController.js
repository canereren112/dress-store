app.controller('DrinkManagementController', function($scope, $http) {	

	initPage();

	
	function initPage(){
		showCoffeeAddContent();
		

	}
	
	$scope.initDrinks = function () {

		$scope.fillDrinksView();

	};
	
	function showCoffeeAddContent(){
		 $scope.coffeAddContent=true;
		 $scope.condimentAddContent=false;
	}
	
	function showCondimentAddContent(){
		 $scope.coffeAddContent=false;
		 $scope.condimentAddContent=true;
	}
	
	$scope.clickCoffeeButton = function (){
		showCoffeeAddContent();
	}
	
	$scope.clickCondimentButton = function (){
		showCondimentAddContent();
	}
	
	$scope.addNewCoffee = function(){
		
		var dataObj = { name:$scope.coffeeName, cost: $scope.coffeePrice};
		var response = $http.post('http://localhost:9966/kahveciefendi/api/v1/beverages', dataObj);
		response.success(function(response) {

            alert(response.message);
            
            if (response.errorCode == 0) {
            	// $scope.message = response;
            	$scope.getAllCoffees();
            }
		});
		
		response.error(function(response) {
			alert( "Hata: " + response.message);
		});
		
		$scope.coffeeName='';
		$scope.coffeePrice='';
	}

	$scope.getAllCoffees = function(){
		
		var response = $http.get('http://localhost:9966/kahveciefendi/api/v1/beverages');
		response.success(function(response) {
            if (!angular.isUndefined(response.errorCode)) {
                alert(response.message);
            } else {
            	$scope.coffees =  response;
            }
			
		});
		
		response.error(function(response) {
			alert( "Hata: " + response.message);
		});
		
		
		
	}
	
	$scope.addNewCondiment = function(){
		
		var dataObj = { name:$scope.condimentName, cost: $scope.condimentPrice};
		var response = $http.post('http://localhost:9966/kahveciefendi/api/v1/condiments', dataObj);
		response.success(function(response) {
            alert(response.message);
            
            if (response.errorCode == 0) {
            	$scope.getAllCondiments();
            }
		});
		
		response.error(function(response) {
			alert( "Hata: " + response.message);
		});
		
		$scope.condimentName='';
		$scope.condimentPrice='';
	}

	$scope.getAllCondiments = function(){
		
		var response = $http.get('http://localhost:9966/kahveciefendi/api/v1/condiments');
		response.success(function(response) {
		// todo error durumunu check et
            if (!angular.isUndefined(response.errorCode)) {
                alert(response.message);
            } else {
            	$scope.condiments =  response;
            }
		
		});
		
		response.error(function(response) {
			alert( "Hata: " + response.message);
		});
		
	}
	
  
	$scope.deleteDrink = function(id, drinkType){
		var response = $http.delete('http://localhost:9966/kahveciefendi/api/v1/' +drinkType + '/'+ id);
		response.success(function(response) {
			alert(response.message);
			
            if (response.errorCode == 0) {
            	$scope.fillDrinksViewByType(drinkType);
            }
			});
		
		response.error(function(response) {
			alert( "Hata: " + response.message);
		});
	}
	
	$scope.addDrinkToModal = function(drink, drinkType){
	
		if(drinkType==$scope.coffeType){
			$scope.modalCoffee = "";
			$scope.modalCoffee = angular.copy(drink);
		}else if(drinkType==$scope.condimentType){
			$scope.modalCondiment = "";
			$scope.modalCondiment = angular.copy(drink);
		}
	}
	
	$scope.editDrink = function(modalDrink, drinkType){
		var response = $http.put('http://localhost:9966/kahveciefendi/api/v1/' + drinkType+ '/' + modalDrink.id, modalDrink);
		response.success(function(response) {
			alert(response.message);
			
            if (response.errorCode == 0) {
            	$scope.fillDrinksViewByType(drinkType);
            }
		});
		
		response.error(function(response) {
			alert( "Hata: " + response.message);
		});
	}
	
	$scope.fillDrinksViewByType = function (drinkType){
		if(drinkType == $scope.coffeType){
			$scope.getAllCoffees();
		}else if(drinkType == $scope.condimentType){
			$scope.getAllCondiments();
		}
	}
	
	$scope.fillDrinksView = function(){
		$scope.getAllCoffees();
		$scope.getAllCondiments();
	}
	

});
