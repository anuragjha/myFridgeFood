/**
 * 
 */
package yummlyResponse.recipe;

import htmlGenerator.HTML;

/**
 * @author anuragjha
 *
 */
public class MatchResultRecipe {

	/**
	 * 
	 */
	public MatchResultRecipe() {
		// TODO Auto-generated constructor stub
	}

	public static String fieldNamesAsHtmlTableHeaders() {
		StringBuilder htmlTableHeaders = new StringBuilder();
		htmlTableHeaders.append(HTML.trOpen());
		
		htmlTableHeaders.append(HTML.th("Recipe Name"));
		htmlTableHeaders.append(HTML.th(" -> "));
		htmlTableHeaders.append(HTML.th("Ingredients"));
		//htmlTableHeaders.append(HTML.th("id"));
		htmlTableHeaders.append(HTML.th(" -> "));
		htmlTableHeaders.append(HTML.th("No. of Servings"));
		//htmlTableHeaders.append(HTML.th("         "));
		//htmlTableHeaders.append(HTML.th("Prep Time(Mins)"));
		
		htmlTableHeaders.append(HTML.trClose());
		
		return htmlTableHeaders.toString();
	}
	
	
	public static String nutritionAsHtmlTableHeaders() {
		StringBuilder htmlTableHeaders = new StringBuilder();
		htmlTableHeaders.append(HTML.trOpen());
		htmlTableHeaders.append(HTML.th("Nutrition Estimates"));
		htmlTableHeaders.append(HTML.trClose());
	
		return htmlTableHeaders.toString();

	}
	
	

}
