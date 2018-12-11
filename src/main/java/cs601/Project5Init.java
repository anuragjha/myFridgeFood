/**
 * 
 */
package cs601;

/**
 * @author anuragjha
 * WebInit class holds the config information 
 *
 */
public class Project5Init {

	private int portSP;
	private String loggerFile;
	
	//ThreadPool 
	private int minThreads;
	private int maxThreads;
	private int timeout;
	
	//URI basepath
	private String basepath;
		
	
	/**
	 * constructor
	 */
	public Project5Init()	{
		
	}
	
	
	/**
	 * @return the port
	 */
	public  int getPortSP() {
		return portSP;
	}



	/**
	 * @return the loggerFile
	 */
	public  String getLoggerFile() {
		return loggerFile;
	}
	
	/**
	 * @return the basepathWebService
	 */
	public  String getBasepath() {
		return basepath;
	}
	
	
	/**
	 * @return the minThreads
	 */
	public  int getMinThreads() {
		return minThreads;
	}


	/**
	 * @return the maxThreads
	 */
	public  int getMaxThreads() {
		return maxThreads;
	}


	/**
	 * @return the timeout
	 */
	public  int getTimeout() {
		return timeout;
	}

	@Override
	public String toString()	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("port: " + this.portSP + "\n");
		sb.append("loggerFile: " + this.loggerFile + "\n");

		return sb.toString();
	}
	
	
	/**
	 * @param args
	 */
	public  void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
