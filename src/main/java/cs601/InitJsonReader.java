/**
 * 
 */
package cs601;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author anuragjha
 *
 */
public class InitJsonReader {

	private static Project5Init project5Init = null;

	/**
	 * jsonFileReader process Review file and then notifies DataStore 
	 * @param inputFile
	 */
	public static Object project5InitJsonReader(String file, Class<?> initClass)	{

		JsonParser parser = new JsonParser();
		Path path = Paths.get(file);	


		try(
				BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"))
				)	{
			String line;
			//System.out.println("Processing " + "project5Init.json" + " file.");

			//while((line = reader.readLine()) != null)	{
			if((line = reader.readLine()) != null)	{
				try {
					//parses each line into JsonObject
					JsonObject object =  parser.parse(line).getAsJsonObject();
					//creates Init object from the Json Object 
					if(initClass == Project5Init.class) {
						project5Init = new Gson().fromJson(object, Project5Init.class);
					}

				} catch(JsonSyntaxException jse)	{
					System.out.println("Project4 init reader - Skipping line ...");
				}
			}	

		}	catch(IOException ioe)	{
			System.out.println("Could not process init file");
			System.out.println("Exiting System");
			System.exit(0);
		}

		if(initClass == Project5Init.class) {
			return project5Init;
		} 
		else {
			return null;
		}

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Project5Init init = Project5InitReader.project5InitjsonReader();
		//System.out.println("init: " + init);

	}

}

