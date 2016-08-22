var app = angular.module('CoffeeApplication', []);

app.controller('CoreController', function($scope, $http) {	
	 

	$scope.initCore = function () {

		
		$scope.showLoginPage();
		$scope.coffeType = 'beverages';
		$scope.condimentType = 'condiments';
		$scope.orderCondimentArray = [];
	}
	$scope.showDrinkPage = function(){
		$scope.orderPage = false;
		$scope.drinkManagementPage = true;
		$scope.statsPage = false;
		$scope.loginPage = false;
		$scope.getAllViewDrinks($scope.coffeType);
		$scope.getAllViewDrinks($scope.condimentType);
		}
	
	$scope.showStatsPage = function(){
		$scope.orderPage = false;
		$scope.drinkManagementPage = false;
		$scope.statsPage = true;
		$scope.loginPage = false;
		$scope.fillUserStatsView();	
	}
	
	$scope.showLoginPage = function(){
//		console.log($scope.authenticated);
		$scope.authenticated2=false;
		$scope.orderPage = false;
		$scope.drinkManagementPage = false;
		$scope.statsPage = false;
		$scope.loginPage = true;
		$scope.fillUserStatsView();	
	}
	
	$scope.showOrderPage = function(){
		$scope.orderPage = true;
		$scope.drinkManagementPage = false;
		$scope.statsPage = false;
		$scope.loginPage = false;
		$scope.getAllOrderDrinks($scope.coffeType);
		$scope.getAllOrderDrinks($scope.condimentType);
	}
	
	$scope.fillUserStatsView = function(){
		$scope.getStats('http://localhost:9966/kahveciefendi/api/v1/stats/users');
	}
	
	$scope.getAllViewDrinks = function(drinkType){
		
		var response = $http.get('http://localhost:9966/kahveciefendi/api/v1/' + drinkType);
		response.success(function(response) {
            if (!angular.isUndefined(response.errorCode)) {
                alert(response.message);
            } else if(drinkType == $scope.coffeType){
				$scope.coffees =  response;
			}else if(drinkType == $scope.condimentType){
				$scope.condiments = response;
			}			
			
		});
		
		response.error(function(response) {
			alert( "Hata: " + response.message);
		});
			
		
	}
	

	$scope.getAllOrderDrinks = function(drinkType){

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
	
	$scope.getStats = function(url){
		
		var response = $http.get(url);
		response.success(function(response) {
            if (!angular.isUndefined(response.errorCode)) {
                alert(response.message);
            } else {
     			$scope.stats =  response;	
             }     			
			
		});
		
		response.error(function(response) {
			alert( "Hata: " + response.message);
		});		
		
	}	
	

	
});