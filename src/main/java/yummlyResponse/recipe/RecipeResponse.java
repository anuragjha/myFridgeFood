package yummlyResponse.recipe;

import java.util.ArrayList;

import htmlGenerator.HTML;

/**
 * RecipeResponse class is response template for a Recipe search
 * @author anuragjha
 *
 */
public class RecipeResponse {

	ArrayList<NutritionEstimates> nutritionEstimates;
	String name;
	String prepTime;
	String id;
	String[] ingredientLines;
	int numberOfServings;


	public RecipeResponse() {
	}

	/**
	 * returns html reprentation; 
	 * @return
	 */
	public String toHTML() {
		StringBuilder recipeResponseHtml = new StringBuilder();

		recipeResponseHtml.append(HTML.h3("Recipe for : " + name));

		this.getRecipe(recipeResponseHtml);
		
		this.getNutrition(recipeResponseHtml);

		return recipeResponseHtml.toString();
	}

	/**
	 * get Nutritional details for a recipe
	 * @param recipeResponseHtml
	 */
	private void getNutrition(StringBuilder recipeResponseHtml) {
		recipeResponseHtml.append(HTML.tableOpen()); 
		recipeResponseHtml.append(HTML.preBuiltHtml(MatchResultRecipe.nutritionAsHtmlTableHeaders()));
		recipeResponseHtml.append(HTML.tableClose());

		recipeResponseHtml.append(HTML.tableOpen()); 
		int count = 0;
		for(NutritionEstimates ne : nutritionEstimates) {	
			if(ne.value != 0) {
				count  = count + 1;
				if(count%6 == 1) {
					recipeResponseHtml.append(HTML.trOpen());
				}

				recipeResponseHtml.append(HTML.tdOpen());
				recipeResponseHtml.append(ne.toHtml());
				recipeResponseHtml.append(HTML.tdClose());

				if(count%6 == 0) {
					recipeResponseHtml.append(HTML.trClose());
				}

			}
		}
		recipeResponseHtml.append(HTML.tableClose());
		
	}

	/**
	 * 
	 * @param recipeResponseHtml
	 */
	private void getRecipe(StringBuilder recipeResponseHtml) {
		recipeResponseHtml.append(HTML.tableOpen()); 
		recipeResponseHtml.append(HTML.preBuiltHtml(MatchResultRecipe.fieldNamesAsHtmlTableHeaders()));	  
		recipeResponseHtml.append(HTML.trOpen());  //////
		recipeResponseHtml.append(HTML.td(name));	
		recipeResponseHtml.append(HTML.td(" "));	
		recipeResponseHtml.append(HTML.tdOpen());
		for(int i=0; i < ingredientLines.length; i++) {
			recipeResponseHtml.append(HTML.breakLine());
			recipeResponseHtml.append(" " + ingredientLines[i] + ".");
		}
		recipeResponseHtml.append(HTML.tdClose());
		recipeResponseHtml.append(HTML.td(" "));	
		recipeResponseHtml.append(HTML.td(""+numberOfServings));
		recipeResponseHtml.append(HTML.trClose());
		recipeResponseHtml.append(HTML.tableClose());
	
		recipeResponseHtml.append(HTML.breakLine());recipeResponseHtml.append(HTML.breakLine());
		recipeResponseHtml.append(HTML.breakLine());recipeResponseHtml.append(HTML.breakLine());
		
	}


	@Override
	public String toString() {
		return name + prepTime + ingredientLines.toString() + numberOfServings;
	}
}
