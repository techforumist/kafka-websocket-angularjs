var app = angular.module("MyApp", []);

app.controller("HomeController", function($scope, $http) {
	$scope.messages = [];
	$scope.id = 0;
	$scope.sendMessage = function() {
		$http.get('/sendMessage?message=' + $scope.message).success(
				function(data) {
					// console.log(data);
					$scope.messages.push({
						value : $scope.message,
						id : ++$scope.id
					});
					$scope.message = "";
				}).error(function(data) {
			// console.log(data);
		});
		// console.log("called--");
	};
});