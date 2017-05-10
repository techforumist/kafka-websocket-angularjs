var app = angular.module("MyApp", []);

app.controller("HomeController", function($scope, $http) {
	$scope.messages = [];
	var ws = new WebSocket("ws://localhost:8082/websocket");
	$scope.id = 0;
	ws.onmessage = function(data) {
		//console.log(JSON.parse(data.data));
		var message = JSON.parse(data.data);
		message.id = ++$scope.id;
		$scope.messages.push(message);
		$scope.$digest();
	};
	ws.onerror = function(data) {
		console.log(data);
	};
	//console.log('created');
});