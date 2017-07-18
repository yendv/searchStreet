/**
 * 
 */
package com.googlemap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;

import org.codehaus.jettison.json.JSONObject;





import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;



/**
 * @author dauvi
 *
 */
public class UtilGoogleMap {
	private static String urlStr= "https://maps.googleapis.com/maps/api/";
	private static String key="AIzaSyDnYZk3sQQZeXSfZKttMhBlA3vXW7AT4tI";
	
	public static JSONObject searchStreetDetail(String param) throws IOException{
		urlStr += ("directions/json" + param + "&key=" + key);
		URL url = new URL(urlStr);
		InputStream is = url.openStream();
		JSONObject jsonObj = readJsonFromInputStream(is);
		return jsonObj;
	}
	
	public static void writeFileSearchStreetDetail(String param) throws IOException, KeyManagementException, NoSuchAlgorithmException{
		installPolicy();//disable trust in https
		String urlStrSearch =urlStr +  ("directions/json" + param + "&key=" + key);
		URL url = new URL(null, "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670,151.1957&radius=500&types=food&name=cruise&key=AIzaSyDnYZk3sQQZeXSfZKttMhBlA3vXW7AT4tI", new sun.net.www.protocol.https.Handler());
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
		int status = con.getResponseCode();
		String s1 = con.getResponseMessage();
		System.err.println(s1);
		InputStream is= null;
		if(status == 400){
			is = url.openStream();
		}else is = con.getInputStream();
		//is = url.openStream();
		writeFile("C:/Users/dauvi/Desktop/googlemap/data.txt", is);
	}
	
	private static JSONObject readJsonFromInputStream(InputStream is) throws IOException{
		StringBuilder responseData = new StringBuilder();
		JSONObject jsonObj = null;
		try {
			int cp = 0;
			while((cp= is.read()) != -1){
				responseData.append((char) cp);
			}
			jsonObj = new JSONObject(responseData.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//is.close();
		}
		return jsonObj;
	}
	
	private static void writeFile(String urlSaveFile, InputStream is) throws IOException{
		/*try (BufferedWriter bw = new BufferedWriter
			    (new OutputStreamWriter(new FileOutputStream(urlSaveFile), StandardCharsets.UTF_8))) {
			String content = data;
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		OutputStream outputStream = null;
		try {
			outputStream  =  new FileOutputStream(new File(urlSaveFile));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = is.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			outputStream.close();
		}
	}
	
	 public static void installPolicy() throws NoSuchAlgorithmException, KeyManagementException {
	        SSLContext sc = SSLContext.getInstance("TLS");
	        sc.init(null, new TrustManager[] { new TrustAllX509TrustManager() }, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
	                public boolean verify(String string, SSLSession ssls) {
	                    return true;
	                }
	            });
	    }
}
