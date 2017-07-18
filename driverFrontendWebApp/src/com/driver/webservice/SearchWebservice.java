package com.driver.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import javax.ejb.EJB;
import javax.json.JsonArray;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.commonutils.EnumDRIVER;
import com.contextlookup.ContextLookup;
import com.driver.entity.client.DriverType;
import com.driver.entity.client.Guide;
import com.driver.entity.client.Merchandise;
import com.driver.manager.client.DriverTypeManager;
import com.driver.manager.client.GuideManager;
import com.driver.manager.client.MerchandiseManager;
import com.googlemap.UtilGoogleMap;


@Path("/search")
public class SearchWebservice {
	private String language = "vi-VN";
	
	@Path("/data")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String init() throws NamingException, JSONException{
		JSONObject data= new JSONObject();
		MerchandiseManager merchandiseManager = ContextLookup.initMerchandiseManager();
		DriverTypeManager driverTypeManager = ContextLookup.initDriverTypeManager();
		List<Merchandise> merchandiseLst = merchandiseManager.search(null, null);
		if(merchandiseLst != null && merchandiseLst.isEmpty() == false){
			JSONArray merchandiseJsonArr = new JSONArray();
			for (Merchandise merchandise : merchandiseLst) {
				JSONObject merJson = new JSONObject();
				merJson.put("code", merchandise.getCode());
				merJson.put("name", merchandise.getName());
				merchandiseJsonArr.put(merJson);
			}
			data.put("merchandise", merchandiseJsonArr);
		}
		List<DriverType> driverTypeLst = driverTypeManager.search(null, null);
		if(driverTypeLst != null && driverTypeLst.isEmpty() == false){
			JSONArray driverTypeJSONArr = new JSONArray();
			for (DriverType driverType : driverTypeLst) {
				JSONObject merJson = new JSONObject();
				merJson.put("code", driverType.getCode());
				merJson.put("name", driverType.getName());
				driverTypeJSONArr.put(merJson);
			}
			data.put("driverType", driverTypeJSONArr);
		}
		return data.toString();
	}
	
	@Path("/searchprice")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public String searchData(String searchStr) throws SQLException, NamingException, JSONException, IOException, KeyManagementException, NoSuchAlgorithmException{
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonSearch = new JSONObject(searchStr);
		String origin = (String) jsonSearch.get("orgin");
		String destination = (String) jsonSearch.get("destination");
		origin = origin.replaceAll(" ", "+");
		destination = destination.replaceAll(" ", "+");
		JSONObject driveType = (JSONObject) jsonSearch.get("driveType");//note
		String quanlity = (String) jsonSearch.get("quanlity");
		String deliveryDate = (String) jsonSearch.get("deliveryDate");
		String param ="?" + "origin=" + origin + "&language="+ language + "&destination=" + destination;
		/*JSONObject jsonObj = UtilGoogleMap.searchStreetDetail(param);
		jsonArr.put(jsonObj);*/
		UtilGoogleMap.writeFileSearchStreetDetail(param);
		return jsonArr.toString();
	}
	
	
	
}
