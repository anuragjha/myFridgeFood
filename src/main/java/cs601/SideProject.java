/**
 * 
 */
package cs601;

import handlers.IndexServlet;
import handlers.RecipeSearchServlet;
import handlers.RecipesSearchServlet;
import server.SideProServer;

/**
 * @author anuragjha
 * SideProject class starts the web service
 */
public class SideProject {


	private static Project5Init project5Init;
	private static Project5Logger SmartFoodLogger;

	/**
	 * constructor
	 * @param init
	 */
	public SideProject(Project5Init init) {
		project5Init = init;
		this.initializeLogger();
	}


	/**
	 * initializeLogger method opens the logger to be used
	 */
	private void initializeLogger() {
		Project5Logger.initialize("Smart Food - " + project5Init.getPortSP(), project5Init.getLoggerFile());
	}


	/**
	 * startApplication method binds the application to the port, where it listens to client request
	 * @param port
	 */
	private void startApplication() {
		System.out.println("Smart Food");

		SideProServer server = new SideProServer(project5Init.getPortSP());
		server.initialize(project5Init.getMinThreads(), project5Init.getMaxThreads(), 
				project5Init.getTimeout());

		server.addMapping(IndexServlet.class, "/");
		server.addMapping(RecipesSearchServlet.class, "/recipessearch");
		server.addMapping(RecipeSearchServlet.class, "/recipesearch/*");

		server.start();
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Project5Init init;

		if(new CmdLineArgsValidator().check(args))	{
			//reading configuration file content into Project4Init object
			init = (Project5Init) InitJsonReader.
					project5InitJsonReader(args[0], Project5Init.class);
			AppConstants.setInit(init);
		} else {
			init = null;
			System.out.println("Unable to initialize, exiting system");
			System.exit(1);
		}

		SideProject webService = new SideProject(init);

		webService.startApplication();

		Project5Logger.close();
	}



}
