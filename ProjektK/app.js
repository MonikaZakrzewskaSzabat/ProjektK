angular.module('Konf', [])
.controller('MainCtrl', [
'$scope',
function($scope){
  $scope.test = 'Hello world!';
}
function personController($scope) {
    $scope.person = {
        firstName: "John",
        lastName: "Doe"
    };
    $scope.myVar = false;
    $scope.toggle = function() {
        $scope.myVar = !$scope.myVar;
    };
}]);