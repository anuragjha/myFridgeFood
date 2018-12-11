/**
 * 
 */
package cs601;

/**
 * @author anuragjha
 * AppConstants class contains config parameters
 */
public class AppConstants {

	private static Project5Init init;
	
	/**
	 * @return the configFile
	 */
	public static Project5Init getInit() {
		return init;
	}

	/**
	 * @param configFile the configFile to set
	 */
	public static void setInit(Project5Init configFile) {
		
		AppConstants.init = configFile;
	}

	/**
	 * 
	 */
	public AppConstants() {
		// TODO Auto-generated constructor stub
	}

	
	
}
