/**
 * DauVi
 */
'use strict';

var map;
/*function initMap(idMap){
	 var map = new google.maps.Map(document.getElementById(idMap), {
     center: {lat:   21.0011367, lng: 105.84501410000007},
     zoom: 12
   });
	return map;
}*/


function autoComplete(map, inputComplete, strIcon, inputHiddenLoc){ 
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
        marker.setPosition(place.geometry.location);
        marker.setVisible(true);
        //inputHiddenLoc.value = place.geometry.location.toString();
	})
} 
