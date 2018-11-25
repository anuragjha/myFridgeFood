/**
 * 
 */
package ovenPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import yummlyRequest.recipes.YummlyRequest;
import yummlyResponse.recipes.RecipesResponse;

/**
 * @author anuragjha
 *
 */
public class RecipeFetcherYummly {



	public static RecipesResponse searchRequest(YummlyRequest yreq) {
		
		try {
			return fetch(yreq);
		} catch (IOException e) {
			System.out.println("error in fetching the search result from yummly");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	private static RecipesResponse fetch(YummlyRequest yreq) throws IOException {

		//create URL object
		//URL url = new URL("https://www.yelp.com/biz/the-velo-rouge-cafe-san-francisco");
		//https://www.food2fork.com/api/search?key=319edf4b32c59048e5ec0eeeb9b1014c&q=bread%20butter&page=1
		String baseURL = "https://api.yummly.com/v1/api/recipes?_app_id=f12ecfaa&_app_key=2b105957596be49815d7c73edf2ac31b";
		//String queries = "&allowedIngredient=chicken";
		StringBuilder queries = new StringBuilder();
		if(yreq.getAllowedIngredient().length() > 2) {
			queries.append(yreq.getAllowedIngredient());
		}
		if(yreq.getExcludedIngredient().length() > 2) {
			queries.append(yreq.getExcludedIngredient());
		} 
		System.out.println("Request to Yummly: " + baseURL + queries.toString());


		URL url = new URL(baseURL + queries.toString());


		//create secure connection 
		HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

		//set HTTP method
		connection.setRequestMethod("GET");		//convert to post
		connection.connect();

		printHeaders(connection);
		RecipesResponse recipesResponse= printBody(connection);

		return recipesResponse;

	}


	public static void printHeaders(URLConnection connection) {
		Map<String,List<String>> headers = connection.getHeaderFields();
		for(String key: headers.keySet()) {
			System.out.println(key);
			List<String> values = headers.get(key);
			for(String value: values) {
				System.out.println("\t" + value);
			}
		}		
	}


	public static RecipesResponse printBody(URLConnection connection) throws IOException {
		RecipesResponse recipesResponse;
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(connection.getInputStream()));
		
		String line;
		JsonParser parser = new JsonParser();
		JsonObject jObject = null;
		while((line = reader.readLine()) != null) {
			System.out.println("for RecipesResponse: " + line);
			jObject = parser.parse(line).getAsJsonObject();
		} 
		return new Gson().fromJson(jObject, RecipesResponse.class);
	}


	private static String getRequest() {
		String path = "https://www.food2fork.com/api/search?key=319edf4b32c59048e5ec0eeeb9b1014c&q=bread%20butter&page=1";
		String request = "GET " + path + " HTTP/1.1" + "\n" //GET request
				+ "Host: " + 80 + "\n" //Host header required for HTTP/1.1
				+ "Connection: close\n" //make sure the server closes the connection after we fetch one page
				+ "\r\n";								
		return request;
	}

	private static String postRequest() {
		String query = "key=319edf4b32c59048e5ec0eeeb9b1014c&q=bread%20butter&page=1";
		String request = "POST " + "https://www.food2fork.com/api/search" + " HTTP/1.1" + "\n"//POST request
				+ "Host: " + 80 + "\n"    //Host header required for HTTP/1.1
				+ "Content-Length: " + query.getBytes().length + "\n" 
				+ "Connection: close\n" //make sure the server closes the connection after we fetch one page
				+ "\r\n" + query;	
		System.out.println("string:\n" + request);
		return request;
	}



}
