<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="../driverFrontendWebApp/static/css/searchFrontend.css"
	rel="stylesheet">
<link href="../driverFrontendWebApp/static/css/icon.css"
	rel="stylesheet">
<title>HomePage</title>
</head>
<body>
	<!-- <div ng-app="seachApp" class="generic-container" ng-controller="SearchController as ctrl">
		<form name="searchForm" ng-submit="ctrl.searchPrice()">
			<table>
				<tr>
					<td>Phương tiện: </td>
					<td>
						<select ng-model="ctrl.search.driveType"
								ng-options="i.name for i in ctrl.driverTypes"></select>
					</td>
				</tr>
				<tr>
					<td>Loại đồ vật : </td>
					<td>
						<select ng-model="ctrl.search.merchandise"
								ng-options="i.name for i in ctrl.merchandises"></select>
						value : {{"ctrl.search.merchandise".code}}
					</td>
				</tr>
				<tr>
					<td>Thời gian giao hàng : </td>
					<td>
						<input type="text" id="datepicker" ng-model="ctrl.search.deliveryDate"/>
					</td>
				</tr>
				<tr>
					<td>Nơi chuyển đi</td>
					<td>
						<input type="text" ng-model="ctrl.search.orgin"/>
					</td>
				</tr>
				<tr>
					<td>Nơi chuyển đến</td>
					<td>
						<input type="text" ng-model="ctrl.search.destination"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Xem phí vận chuyển" /></td>
				</tr>
			</table>
		</form>
	</div> -->


	<div class="searchForm" ng-app="seachApp"
		ng-controller="SearchController as ctrl" id="price-card">
		<h2>TRA CỨU</h2>
		<form name="searchForm" ng-submit="ctrl.searchPrice()">
			<table>
				<tr>
					<!-- <td width="20%"><label>Phương tiện:</label></td> -->
					<td width="100%"><select ng-model="ctrl.search.driveType" class="icon-select"
						ng-options="i.name for i in ctrl.driverTypes">
							<option value="" disabled selected>Chọn loại phương tiện</option>
						</select></td>
				</tr>
				<tr>
					<!-- <td><label>Loại đồ vật :</label></td> -->
					<td><select ng-model="ctrl.search.merchandise" class="icon-select"
								ng-options="i.name for i in ctrl.merchandises">
							<option value="" disabled selected>Chọn loại đồ vật</option>
						</select> <!-- value :{{ctrl.search.merchandise.code}} -->
					</td>
				</tr>
				<tr>	
					<!-- <td><label>Thời gian giao hàng :</label></td> -->
					<td>
						<input type="text" id="datepicker" placeholder="dd/MM/yyyy"
							   ng-model="ctrl.search.deliveryDate" />
					</td>
				</tr>
				<tr>
					<!-- <td><label>Nơi chuyển đi</label></td> -->
					<td>
						<input id="from" type="text"  
								class="icon-googlemap"
								placeholder="Nơi chuyển đi"/>
						<input ng-model="ctrl.search.orgin" type="text" id="loc_from" style="display: none;"/>
						<!-- <input type="text" name="someData" ng-value="ctrl.search.orgin" value="(1,2)"/> -->
						<!-- <input type="text" id="datepicker" placeholder="aaa"
							   ng-model="ctrl.search.orgin" /> -->
					</td>
				</tr>
				<tr>
					<!-- <td><label>Nơi chuyển đến</label></td> -->
					<td>
						<input id="to" type="text" class="icon-googlemap" placeholder="Nơi chuyển đến"/>
						<input type="hidden" id="loc_to" ng-model="ctrl.search.destination" style="display: none;"/>
					</td>
				</tr>
				<tr>
					<!-- <td></td> -->
					<td><input type="submit" value="Xem phí vận chuyển" /></td>
				</tr>
				<tr ng-show="ctrl.showPrice">
					<td>
						<label>TỔNG : {{ctrl.price}}</label>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="map" id="map"></div>

	<script src="../driverFrontendWebApp/static/js/lib/jquery-3.2.1.min.js"></script>
	<script src="../driverFrontendWebApp/static/js/customEvent/PlaceAutocomplete.js"></script>
	<script>
		function initMap(){
			var map = new google.maps.Map(document.getElementById('map'), {
		        center: {lat:   21.0011367, lng: 105.84501410000007},
		        zoom: 12
		      });
			var priceCard = document.getElementById('price-card');
			map.controls[google.maps.ControlPosition.TOP_RIGHT].push(priceCard);
			var fromInput = document.getElementById('from');
			var hiddenLocFrom = document.getElementById('loc_from');
			var toInput = document.getElementById('to');
			var hiddenLocTo = document.getElementById('loc_to');
			autoComplete(map , fromInput , 'A', hiddenLocFrom);
			autoComplete(map , toInput , 'B' , hiddenLocTo);
			/* angular.element(document.getElementById('yourControllerElementID')).scope().autoComplete(map , fromInput , 'A', hiddenLocFrom);
			angular.element(document.getElementById('yourControllerElementID')).scope().autoComplete(map , toInput , 'B' , hiddenLocTo); */
		}
		
	</script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDnYZk3sQQZeXSfZKttMhBlA3vXW7AT4tI&libraries=places&callback=initMap"
        async defer></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="../driverFrontendWebApp/static/js/service/app.js"></script>
	<script
		src="../driverFrontendWebApp/static/js/service/searchService.js"></script>
	<script
		src="../driverFrontendWebApp/static/js/controller/searchController.js"></script>
</body>
</html>