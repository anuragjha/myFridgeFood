/**
 * 
 */
package yummlyResponse.recipe;

import htmlGenerator.HTML;

/**
 * @author anuragjha
 *
 */
public class NutritionEstimates {

	String attribute;//: "FAT_KCAL",
	String description;//: null,
	Float value;//: 35,
	Unit unit;


	public String toHtml() {
		StringBuilder nutritionEstimatesHtml = new StringBuilder();

		String preBuilt = "";
		if(description != null) {
			if(unit.isDecimal()) {
				preBuilt = description + " - " + value + " " + unit.getAbbreviation() + ", ";
			} else {
				preBuilt = description + " - " + value.intValue() + " " + unit.getAbbreviation() + ", "; 	 
			}
		} else {
			if(unit.isDecimal()) {
				preBuilt = attribute + " - " + value + " " + unit.getAbbreviation() + ", ";
			} else {
				preBuilt = attribute + " - " + value.intValue() + " " + unit.getAbbreviation() + ", "; 	 
			}
		}
		
		//nutritionEstimatesHtml.append(HTML.tdOpen());
		nutritionEstimatesHtml.append(HTML.preBuiltHtml(preBuilt));
		//nutritionEstimatesHtml.append(HTML.tdClose());

		return nutritionEstimatesHtml.toString();
	}


	/**
	 * 
	 */
	public NutritionEstimates() {
		// TODO Auto-generated constructor stub
	}





	/**
	 * @return the attribute
	 */
	public String getAttribute() {
		return attribute;
	}





	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}





	/**
	 * @return the value
	 */
	public Float getValue() {
		return value;
	}





	/**
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}




}
