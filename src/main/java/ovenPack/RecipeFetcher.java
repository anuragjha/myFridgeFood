/**
 * 
 */
package ovenPack;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author anuragjha
 *
 */
public class RecipeFetcher {	

	//api key : 319edf4b32c59048e5ec0eeeb9b1014c
	//https://www.food2fork.com/api/search?key=319edf4b32c59048e5ec0eeeb9b1014c&q=bread%20butter&page=1

	private Recipes recipes;
	private boolean isOK;


	/**
	 * @return the isOK
	 */
	public boolean isOK() {
		return isOK;
	}

	/**
	 * sendMessage method sends message to Slack
	 */
	public void sendMessage(String searchString) {
		this.doSendMessage(searchString);
	}

	/**
	 * doSendMessage method implements sending messages to and reading response from Slack
	 * @throws IOException
	 */
	private void doSendMessage(String searchString) {



		//String jsonMessage = new Gson().toJson(slackMessage);



		//create URL object
		//String forURL = "https://www.food2fork.com/api/search?key=319edf4b32c59048e5ec0eeeb9b1014c";
		String forURL = "https://www.google.com/search";
		//		String forURL = ("https://www.food2fork.com/api/search"
		//				+ "?key=319edf4b32c59048e5ec0eeeb9b1014c&q=" + searchString).trim();
		System.out.println(forURL);
		URL url;
		try {
			url = new URL(forURL);

			//create secure connection 
			HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

			//set HTTP method
			//connection.setRequestMethod("GET");
			//		connection.addRequestProperty("X-Mashape-Key", "319edf4b32c59048e5ec0eeeb9b1014c");
			//		connection.addRequestProperty("Content-Type", "application/json");
			//		-H 'X-Mashape-Key: <required>' \
			//		  -H 'Accept: application/json'
			connection.setDoOutput(true);
			connection.connect();

			byte[] postData = searchString.getBytes("UTF-8");
			try(DataOutputStream out = new DataOutputStream(connection.getOutputStream())){
				out.write(postData);
			}
			String input = "";
			String a = connection.getResponseCode() + "********" +connection.getResponseMessage();
			System.out.println(a);
			try {
				if(connection.getErrorStream()!=null) {
					System.out.println("Input Stream is null!!!!!"+connection.getErrorStream().toString());
				}else {
				BufferedReader br =
						new BufferedReader(
								new InputStreamReader(connection.getInputStream(),"UTF-8"));

				while ((input = br.readLine()) != null){
				}
				br.close();
				System.out.println("\nResponse");
				System.out.println(input);
				}
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//		System.out.println("HEADERS");
			//		printHeaders(connection);
			//
			//		System.out.println("BODY");
			//		printBody(connection);
			//Project3Logger.write(Level.INFO, "Response Body : \n", 0);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	/**
	 * printHeaders method reads Slack response headers
	 * @param connection
	 */
	private void printHeaders(URLConnection connection) {
		Map<String,List<String>> headers = connection.getHeaderFields();
		for(String key: headers.keySet()) {
			System.out.print("KEY: " + key);
			List<String> values = headers.get(key);
			System.out.print("\tVALUES: ");
			for(String value: values) {
				System.out.println("\t" + value);
			}
		}		
	}

	/**
	 * printBody method reads Slack response body
	 * @param connection
	 * @throws IOException
	 */
	private void printBody(URLConnection connection) throws IOException {
		//HashMap<String,String> slackResponse = new HashMap<String,String>();

		try(
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(connection.getInputStream()))
				) {
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
				//Project3Logger.write(Level.INFO, line + "\n", 0);
				try {
					//parses each line into JsonObject
					JsonObject object =  new JsonParser().parse(line).getAsJsonObject();
					//creates SlackResponse object from the Json Object
					recipes = new Gson().fromJson(object, Recipes.class);
				} catch(JsonSyntaxException jse)	{
					System.out.println("Skipping line ...");
				}

			}
			System.out.println("Food2Fork response : ");
		}

	}



	public static void main(String[] args) {

		RecipeFetcher rf = new RecipeFetcher();
		rf.sendMessage("Chicken");

	}
}

