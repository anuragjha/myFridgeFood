/**
 * 
 */
package yummlyResponse.recipes;

import htmlGenerator.CreateContent;
import htmlGenerator.HTML;

/**
 * @author anuragjha
 *
 */
public class Criteria {

	String q; //spaces have to be encoded
	String[] allowedIngredient;
	String[] excludedIngredient;
	String[] allowedAllergy;
	String[] allowedDiet;  ///////////create general method for all String arrays ////!!!!!!!!!!
	String[] allowedCuisine;
	String[] excludedCuisine;
	String[] allowedCourse;
	String[] excludedCourse;
	String[] allowedHoliday;
	int maxTotalTimeInSeconds;


	/**
	 * 
	 */
	public Criteria() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String toHTML() {
		StringBuilder criteriaHtml = new StringBuilder();
		criteriaHtml.append(HTML.h3("Criteria"));

		//this.allowedIngredientHtml(criteriaHtml);
		//this.excludedIngredientHtml(criteriaHtml);
		criteriaHtml.append(HTML.pOpen());
		criteriaHtml.append(" \\|/ ");
		this.attributeStringArrayHtml(criteriaHtml, allowedIngredient, "Allowed Ingredient");
		this.attributeStringArrayHtml(criteriaHtml, excludedIngredient, "Excluded Ingredient");
		//this.totalTimeHtml(criteriaHtml);// time
		criteriaHtml.append(HTML.pClose());
		return criteriaHtml.toString();
	}


	private void attributeStringArrayHtml(StringBuilder criteriaHtml, String[] attributes, String header) {
		if(attributes != null) {
			
			criteriaHtml.append(header + " : ");
			for(String attribute : attributes) {
				criteriaHtml.append(attribute + "    ");
			}
			criteriaHtml.append(" \\|/ ");
			//			criteriaHtml.append(HTML.pClose());
		}

	}


	private void totalTimeHtml(StringBuilder criteriaHtml) {
		String header = "Max Prep Time";
		criteriaHtml.append(header + " : ");
		criteriaHtml.append(maxTotalTimeInSeconds + "    ");
		//criteriaHtml.append(HTML.pClose());

	}

	private void allowedIngredientHtml(StringBuilder criteriaHtml) {
		if(allowedIngredient != null) {
			criteriaHtml.append(HTML.pOpen() + "Allowed Ingredient : ");
			for(String allowedIngred : allowedIngredient) {
				criteriaHtml.append(allowedIngred + "    ");
			}
			criteriaHtml.append(HTML.pClose());
		}

	}


	private void excludedIngredientHtml(StringBuilder criteriaHtml) {
		if(excludedIngredient != null) {
			criteriaHtml.append(HTML.pOpen() + "Excluded Ingredient : ");
			for(String excludedIngred : excludedIngredient) {
				criteriaHtml.append(excludedIngred + "    ");
			}
			criteriaHtml.append(HTML.pClose());
		}

	}

	private void allowedAllergyHtml(StringBuilder criteriaHtml) {
		if(allowedAllergy != null) {
			criteriaHtml.append(HTML.pOpen() + "Allowed Allergy : ");
			for(String allowedAllerg : allowedAllergy) {
				criteriaHtml.append(allowedAllerg + "    ");
			}
			criteriaHtml.append(HTML.pClose());
		}

	}

	private void allowedDietHtml(StringBuilder criteriaHtml) {
		if(allowedDiet != null) {
			criteriaHtml.append(HTML.pOpen() + "Allowed Diet : ");
			for(String diet : allowedDiet) {
				criteriaHtml.append(diet + "    ");
			}
			criteriaHtml.append(HTML.pClose());
		}

	}

	private void allowedCuisineHtml(StringBuilder criteriaHtml) {
		if(allowedCuisine != null) {
			criteriaHtml.append(HTML.pOpen() + "Allowed Cuisine : ");
			for(String cui : allowedCuisine) {
				criteriaHtml.append(cui + "    ");
			}
			criteriaHtml.append(HTML.pClose());
		}

	}

	private void excludedCuisineHtml(StringBuilder criteriaHtml) {
		if(excludedCuisine != null) {
			criteriaHtml.append(HTML.pOpen() + "Excluded Cuisine : ");
			for(String cui : excludedCuisine) {
				criteriaHtml.append(cui + "    ");
			}
			criteriaHtml.append(HTML.pClose());
		}

	}


	private void allowedCourseHtml(StringBuilder criteriaHtml) {
		if(allowedCourse != null) {
			criteriaHtml.append(HTML.pOpen() + "Allowed Course : ");
			for(String course : allowedCourse) {
				criteriaHtml.append(course + "    ");
			}
			criteriaHtml.append(HTML.pClose());
		}

	}


	private void excludedCourseHtml(StringBuilder criteriaHtml) {
		if(excludedCourse != null) {
			criteriaHtml.append(HTML.pOpen() + "Excluded Course : ");
			for(String course : excludedCourse) {
				criteriaHtml.append(course + "    ");
			}
			criteriaHtml.append(HTML.pClose());
		}

	}




}
