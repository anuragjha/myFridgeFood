/**
 * 
 */
package yummlyResponse.recipe;

/**
 * @author anuragjha
 *
 */
public class Unit {

	String id;//: "fea252f8-9888-4365-b005-e2c63ed3a776",
	String name;//: "calorie",
	String abbreviation;//: "kcal",
	String plural;//: "calories",
	String pluralAbbreviation;//: "kcal",
	boolean decimal;//: true
	
	
	public Unit() {
		// TODO Auto-generated constructor stub
	}

	
	public String toHtml() {
		
		return name ;

	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}



	/**
	 * @return the plural
	 */
	public String getPlural() {
		return plural;
	}



	/**
	 * @return the pluralAbbreviation
	 */
	public String getPluralAbbreviation() {
		return pluralAbbreviation;
	}



	/**
	 * @return the decimal
	 */
	public boolean isDecimal() {
		return decimal;
	}
	
	
	

}
