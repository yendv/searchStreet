/**
 * YENDV 
 */

var myApp = angular.module('seachApp',['$scope', 'searchCustomEvent', function($scope,SearchController){
	
}]);

myApp.directive('customOnChange', function(){
	 return {
	    restrict: 'A',
	    link: function (scope, element, attrs) {
	      var onChangeFunc = scope.$eval(attrs.customOnChange);
	      element.bind('change', onChangeFunc);
	      console.log(element.value);
	      $scope.search.orgin = element.value;
	    }
	  };
});