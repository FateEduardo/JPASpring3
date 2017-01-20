MyApp.controller('userContoller',function($scope,userService){
	$scope.user={}
	
	
	$scope.listUser=function(){
		userService.listUser()
         .then(
         function(d) {
        	
             $scope.user=angular.copy(d);
             console.log($scope.user);
         },
         function(errResponse){
             console.error('Error while fetching Users');
         }
     );
	};
	
	$scope.isAdmin=function(){

	}
});


MyApp.factory('userService',  function($http,$q) {
	var result={
			listUser:listUser
		};
		
		var path='http://localhost:8080/jpaproject';
		
		function listUser(){
			 var deferred = $q.defer();
			 $http.get(path+'/User/List').then(
					 function(response){
						 deferred.resolve(response.data);
						},
				         function(errResponse){
							console.error('Error in listAllUser');
							deferred.reject(errResponse);
						}	 
			 );
			 return deferred.promise;
		};
			 
			 return result;

});
