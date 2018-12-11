/**
 * 
 */
package yummlyResponse.recipes;

import htmlGenerator.HTML;

/**
 * @author anuragjha
 *
 */
public class flavor {

	private long piquant;
	private long meaty;
	private long bitter;
	private long sweet;
	private long sour;
	private long salty;
	
	
	/**
	 * 
	 */
	public flavor() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String toHTML() {
		StringBuilder flavorHtml = new StringBuilder();
		flavorHtml.append(HTML.tdOpen());
		 flavorHtml.append("piquant: " + piquant
				 + ", meaty: " + meaty
				 + ", bitter: " + bitter
				 + ", sweet: " + sweet
				 + ", sour: " + sour
				 + ", salty: " + salty);
		flavorHtml.append(HTML.tdClose());
		if(flavorHtml.toString().length() > 0) {
			return flavorHtml.toString();
		} else {
			return "";
		}
		
	}

	/**
	 * @return the piquant
	 */
	public float getPiquant() {
		return piquant;
	}



	/**
	 * @return the meaty
	 */
	public float getMeaty() {
		return meaty;
	}



	/**
	 * @return the bitter
	 */
	public float getBitter() {
		return bitter;
	}



	/**
	 * @return the sweet
	 */
	public float getSweet() {
		return sweet;
	}



	/**
	 * @return the sour
	 */
	public float getSour() {
		return sour;
	}



	/**
	 * @return the salty
	 */
	public float getSalty() {
		return salty;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
