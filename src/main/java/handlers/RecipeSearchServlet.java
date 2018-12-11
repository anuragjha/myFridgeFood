package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import htmlGenerator.CreateContent;
import ovenPack.RecipeFetcherYummly;
import yummlyRequest.recipe.YummlyRequestRecipe;
import yummlyResponse.recipe.RecipeResponse;

/**
 * @author anuragjha
 * RecipeSearchServlet handles request to search for recipe
 */
public class RecipeSearchServlet extends HttpServlet{

	/**
	 * 
	 */
	public RecipeSearchServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println("Get Request for Recipe Search Servlet : " + request.getRequestURL().toString());
		
		YummlyRequestRecipe yummlyRequestRecipe = new YummlyRequestRecipe();
		yummlyRequestRecipe.setRecipeid(request.getPathInfo().split("/")[1]);
		
		System.out.println("recipeid: " + yummlyRequestRecipe.getRecipeid());

		
		RecipeResponse recipeResponse  = RecipeFetcherYummly.searchRequest(yummlyRequestRecipe);
		
		response.setStatus(HttpServletResponse.SC_OK); 
		response.setContentType("text/html");
		response.getWriter().println(new CreateContent().searchFormHTML());
		response.getWriter().println(recipeResponse.toHTML());

	}	
	
	
}
