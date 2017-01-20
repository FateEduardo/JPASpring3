MyApp.controller('mainController',function($scope,mainService){
	
	$scope.userList=function(){
		return mainService.listUser();
	};
	

	
//	$scope.allUsers=function(){
//			userService.listUser('http://localhost:8080/jpaproject/Cart/List').then(
//				function(ans){
//					$scope.user=angular.copy(ans);
//				},
//		         function(err){
//					console.error('Error in listAllUser');
//				}
//			
//			);
//	}
});

MyApp.factory('mainService',  function($http) {
	
	
	function listCar(){
		 $http.get(path+'/Cart/List').then(
				 function(ans){
					 	console.log(ans)
					
					},
			         function(err){
						console.error('Error in listAllUser');
					}	 
		 )
	};
	
	return result;
});