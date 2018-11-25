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

/**
 * @author anuragjha
 *
 */
public class RecipeFetcher1F2F {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//create URL object
		//URL url = new URL("https://www.yelp.com/biz/the-velo-rouge-cafe-san-francisco");
		//https://www.food2fork.com/api/search?key=319edf4b32c59048e5ec0eeeb9b1014c&q=bread%20butter&page=1
		URL url = new URL("https://www.food2fork.com/api/search?key=319edf4b32c59048e5ec0eeeb9b1014c&q=bread%20butter&page=1");
		
		
		//create secure connection 
		HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

		//set HTTP method
		connection.setRequestMethod("GET");	
		
		//System.out.println("Request: " + connection.getRequestProperties().toString());
		connection.connect();

		printHeaders(connection);
		printBody(connection);
		
		

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


	public static void printBody(URLConnection connection) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(connection.getInputStream()));
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		} 
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
