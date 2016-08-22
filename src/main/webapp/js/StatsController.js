app.controller('StatsController', function($scope, $http) {	

	initPage();
	
	function initPage(){
		showStatsContent();
	}
	
	function showStatsContent(){
		 $scope.statsHeader='Kullanicilar';
		 $scope.reducedCost='Indirimli Fiyat';
	}
	
	$scope.initStats = function () {
		$scope.fillUserStatsView();		
	};
	
	$scope.fillUserStatsView = function(){
		$scope.getStats('http://localhost:9966/kahveciefendi/api/v1/stats/users');
	}
	
	$scope.clickUserStatsButton = function (){
		showStatsContent();
		$scope.getStats('http://localhost:9966/kahveciefendi/api/v1/stats/users');
	}
	
	$scope.clickCoffeeStatsButton = function (){
		$scope.statsHeader='Icecekler';
		 $scope.reducedCost='';
		$scope.getStats('http://localhost:9966/kahveciefendi/api/v1/stats/beverages');
	}
			
	$scope.clickCondimentStatsButton = function (){
		$scope.statsHeader='Eklentiler';
		 $scope.reducedCost='';
		$scope.getStats('http://localhost:9966/kahveciefendi/api/v1/stats/condiments');
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