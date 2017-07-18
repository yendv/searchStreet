/**
 * YENDV
 */

'use strict';

angular.module('seachApp').controller('SearchController' , ['$scope', 'SearchService', function($scope,SearchService){
	var self = this;
	self.search = {orgin:'', destination:'', driveType:'', merchandise:'', quanlity:'', deliveryDate:'' };
	self.driverTypes= [];
	self.merchandises = [];
	self.price= 3213212132131 ;
	self.showPrice = true;	
	
	self.searchPrice = searchPrice;
	//self.autoComplete = autoComplete;
	initFunc();
	
	function initFunc(){
		SearchService.initFunc().then(
			function(d){
				var data = d;
				self.driverTypes = data["driverType"];
				self.merchandises = data["merchandise"];
			},
			function(errRespose){
				console.log("Errors.");
			}
		);	
	}
	
	function searchPrice(search){
		console.log(self.search);
		SearchService.searchPrice(self.search).then(
				function(d){
					self.price = d;
				},
				function(errResponse){
					console.log("Errors.");
				}
		);
	}
	
	/*$scope.autoComplete= function autoComplete(map, inputComplete, strIcon, inputHiddenLoc){ 
		var infoWindow = new google.maps.InfoWindow();
		var autoComplete = new google.maps.places.Autocomplete(inputComplete);
		var marker = new google.maps.Marker({
			map: map,
			label : strIcon , 
			anchorPoint: new google.maps.Point(0, -29)
		});
		autoComplete.addListener('place_changed', function(){
			infoWindow.close();
			marker.setVisible(false);
			var place = autoComplete.getPlace();
			if(!place.geometry){
				window.alert("No detail avaiable for input" + place.name+ "'");
	            return;
			}
			if(place.geometry.viewport){
				map.fitBounds(place.geometry.viewport);
			}else{
				map.setCenter(place.geometry.location);
			}
			map.setZoom(12);
			inputHiddenLoc = place.geometry.location.toString();
			inputHiddenLoc.trigger('input'); 
	        marker.setPosition(place.geometry.location);
	        marker.setVisible(true);
	        //inputHiddenLoc.value = place.geometry.location.toString();
		})
	}*/ 
}]);

/*$(function(){
	$('#loc_from').change(function(){
		var text = $(this).val();
		$('[ng-model="ctrl.search.orgin"]').val(text).trigger('input');
	})
	
})*/