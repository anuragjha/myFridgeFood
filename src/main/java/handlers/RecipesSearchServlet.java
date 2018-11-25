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
import ovenPack.RecipeFetcherYummly;
import yummlyRequest.recipes.YummlyRequest;
import yummlyResponse.recipes.RecipesResponse;

/**
 * @author anuragjha
 *
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
		//System.out.println("allowedIngredient :" + request.getParameter("allowedIngredient"));
		//System.out.println("excludedIngredient :" + request.getParameter("excludedIngredient"));
		
		YummlyRequest yummlyRequest = new YummlyRequest();
		yummlyRequest.setAllowedIngredient(request.getParameter("allowedIngredient"));
		yummlyRequest.setExcludedIngredient(request.getParameter("excludedIngredient"));
		System.out.println("allowedIngredient in yummlyRequest: " + yummlyRequest.getAllowedIngredient());
		System.out.println("excludedIngredient in yummlyRequest: " + yummlyRequest.getExcludedIngredient());
		
		RecipesResponse recipesResponse  = RecipeFetcherYummly.searchRequest(yummlyRequest);
		
		response.setStatus(HttpServletResponse.SC_OK);
		//response.setContentType("application/json"); 
		response.setContentType("text/html");
		response.getWriter().println(new CreateContent().searchFormHTML());
		///////////////// -->> instead use RecipeFetcherYummly
		///////////////// -->> make yummly fetcher better and give params capability
		response.getWriter().println(recipesResponse.toHTML());

	}	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
