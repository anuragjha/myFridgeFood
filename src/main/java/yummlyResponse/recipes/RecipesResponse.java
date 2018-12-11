/**
 * 
 */
package yummlyResponse.recipes;

import htmlGenerator.HTML;

/**
 * @author anuragjha
 * RecipesResponses class is response template for a Recipes search
 */
public class RecipesResponse {

	Criteria criteria;
	MatchResult[] matches;
	int totalMatchCount;
	
	
	
	/**
	 * constructor
	 */
	public RecipesResponse() {
	}

	/**
	 * returns html reprentation; 
	 * @return
	 */
	public String toHTML() {
		StringBuilder RecipesResponseHtml = new StringBuilder();
		
		RecipesResponseHtml.append(criteria.toHTML());
		RecipesResponseHtml.append(HTML.h3("Matches"));
		
		RecipesResponseHtml.append(HTML.tableOpen()); 
		 RecipesResponseHtml.append(HTML.preBuiltHtml(MatchResult.fieldNamesAsHtmlTableHeaders()));	  
		 for(MatchResult match : matches) {
			 RecipesResponseHtml.append(HTML.preBuiltHtml(match.toHTML()));
		 }
		RecipesResponseHtml.append(HTML.tableClose());
		
		return RecipesResponseHtml.toString();
		
		
	}
	
	

}
