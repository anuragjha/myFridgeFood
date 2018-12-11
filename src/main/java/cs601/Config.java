/**
 * 
 */
package cs601;

/**
 * @author anuragjha
 *
 */
public class Config {

	private int port;
	private String loggerFile;
	
	
	/**
	 * constructor
	 */
	public Config() {
	}
	

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	

	/**
	 * @return the file
	 */
	public String getloggerFile() {
		return loggerFile;
	}


	@Override
	public String toString() {
		return "port: " + port + "\nloggerFile: " + loggerFile;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
