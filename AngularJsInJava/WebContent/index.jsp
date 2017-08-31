<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AJAX with Servlets using AngularJS</title>
<script type="text/javascript" src="js/angular.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<script>
	var app = angular.module('myApp', []);

	function MyController($scope, $http) {

		$scope.getDataFromServer = function() {
			$http({
				method : 'GET',
				url : 'javaAngularJS'
			}).success(function(data, status, headers, config) {
				$scope.players = data;
			}).error(function(data, status, headers, config) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});

		};
	};
</script>
</head>
<body>
	<div data-ng-app="myApp">
		<div data-ng-controller="MyController">
			<button data-ng-click="getDataFromServer()">Fetch data from server</button>
			<table class="tftable table-fill">
			    <tr>
			        <th class="text-left">ID</th>
			        <th class="text-left">Name</th>
			        <th class="text-left">FED</th>
			        <th class="text-left">FIDE</th>
			      </tr>
			    <tr data-ng-repeat="player in players">
			        <td class="text-left">{{player.idJugador}}</td>
			        <td class="text-left">{{player.nombre}}</td>
			        <td class="text-left">{{player.fed}}</td>
			        <td class="text-left">{{player.fide}}</td>
			    </tr>
			</table>

		</div>
	</div>
</body>
</html>