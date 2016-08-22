app.controller('LoginController', function($rootScope, $http, $location) {	

	var self = this

	  var authenticate = function(credentials, callback) {

	    var headers = credentials ? {authorization : "Basic "
	        + btoa(credentials.username + ":" + credentials.password)
	    } : {};

	    $http.get('api/v1/user', {headers : headers}).then(function(response) {
	      if (response.data.name) {
	    	  // reload and show menu 
	    	 if (!angular.isUndefined($rootScope.isAdmin)) {
		        location.reload();  
		        
	    	 }
	    	  
	    	$rootScope.username = response.data.name;
	    	$rootScope.role = response.data.authorities[0].authority;
			$rootScope.isAdmin = ($rootScope.role == 'ROLE_ADMIN')
			console.log("admin: " + $rootScope.isAdmin);
	    	
	        $rootScope.authenticated = true;
	        
	      } else {
	    	$rootScope.username = "";
	        $rootScope.authenticated = false;
	      }
	      callback && callback();
	    }, function() {
	      $rootScope.authenticated = false;
	      callback && callback();
	    });

	  }
	
	$rootScope.logout = function() {
		  $http.post('api/v1/logout', {}).finally(function() {
			  $rootScope.authenticated = false;
			  $rootScope.username = "";
		    $location.path("/");
		  });
		}

	authenticate();
});
