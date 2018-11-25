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

	private long piquant = 0;
	private long meaty = 0;
	private long bitter = 0;
	private long sweet = 0;
	private long sour = 0;
	private long salty = 0;
	
	
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
				/* + ", meaty: " + meaty
				 + ", bitter: " + bitter
				 + ", sweet: " + sweet
				 + ", sour: " + sour
				 + ", salty: " + salty*/);
		flavorHtml.append(HTML.tdClose());
		return flavorHtml.toString();
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
