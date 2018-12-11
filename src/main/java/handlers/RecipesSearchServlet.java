/**
 * 
 */
package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import htmlGenerator.CreateContent;
import ovenPack.RecipesFetcherYummly;
import yummlyRequest.recipes.YummlyRequest;
import yummlyResponse.recipes.RecipesResponse;

/**
 * @author anuragjha
 * RecipeSearchServlet handles request to search for recipes
 */
public class RecipesSearchServlet extends HttpServlet {

	/**
	 * 
	 */
	public RecipesSearchServlet() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println("POST Request for RecipesSearchServlet : " + request.getRequestURL().toString());
		
		YummlyRequest yummlyRequest = new YummlyRequest();
		yummlyRequest.setAllowedIngredient(request.getParameter("allowedIngredient"));
		yummlyRequest.setExcludedIngredient(request.getParameter("excludedIngredient"));
		
		if(!(request.getParameter("maxTotalTimeInSeconds").equals(""))) {
			yummlyRequest.setMaxTotalTimeInSeconds
				(Integer.parseInt(request.getParameter("maxTotalTimeInSeconds"))*60);
		}
		
		System.out.println("allowedIngredient in yummlyRequest: " + yummlyRequest.getAllowedIngredient());
		System.out.println("excludedIngredient in yummlyRequest: " + yummlyRequest.getExcludedIngredient());
		System.out.println("maxTotalTimeInSeconds in yummlyRequest: " + yummlyRequest.getMaxTotalTimeInSeconds());
		
		RecipesResponse recipesResponse  = RecipesFetcherYummly.searchRequest(yummlyRequest);
		
		response.setStatus(HttpServletResponse.SC_OK);
 
		response.setContentType("text/html");
		response.getWriter().println(new CreateContent().searchFormHTML());

		response.getWriter().println(recipesResponse.toHTML());

	}	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
