/**
 * 
 */
package JsonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cs601.Config;

/**
 * @author anuragjha
 *
 */
public class JsonReader {

	/**
	 * readConfig method reads the config file
	 * @return
	 */
	public Config readConfig() {
		Config config = null;
		
		String file = "config.json";
		Path path = Paths.get(file); 

		try(
				BufferedReader inStream = Files.newBufferedReader(path, Charset.forName("UTF-8"))
				) {

			String line = "";
			while((line = inStream.readLine()) != null) {

				JsonParser parser = new JsonParser();
				JsonObject jObject = parser.parse(line).getAsJsonObject();

				config = new Gson().fromJson(jObject, Config.class);
				
				
			}

		} catch (IOException ioe) {
			
			System.out.println("Error in opening Config file");
		} 
		
		return config;
	}


	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		JsonReader jr = new JsonReader();
		System.out.println(jr.readConfig().toString());
		
	}

}
