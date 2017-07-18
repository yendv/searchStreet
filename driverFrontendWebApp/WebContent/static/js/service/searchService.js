/**
 * YENDV
 */
angular.module('seachApp').factory('SearchService',['$http', '$q', function($http, $q){
	var url = '/driverFrontendWebApp/api/search';

	var factory = {
			initFunc : initFunc, 
			searchPrice : searchPrice
	};
	
	return factory;
	
	function initFunc(){
		var deferred = $q.defer();
		var utlInfo = url + '/data';
		$http.get(utlInfo).then(
			function(response){
				deferred.resolve(response.data);
			},
			function(errResponse){
				deferred.resolve(errResponse);
			}
		);
		return deferred.promise;
	}
	
	
	function searchPrice(search){
		var deferred = $q.defer();
		var urlSearch = url + '/searchprice';
		$http.post(urlSearch, search).then(
			function(response){
				deferred.resolve(response.data);
			},
			function(errResponse){
				deferred.resolve(errResponse);
			}
		);
		return deferred.promise;
	}
}]);