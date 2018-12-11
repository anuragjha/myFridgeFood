/**
 * 
 */
package htmlGenerator;

import java.io.UnsupportedEncodingException;

import htmlGenerator.HTML.INPUTTYPE;

/**
 * @author anuragjha
 * CreateContent handles creation of html content
 */
public class CreateContent {
	
	private StringBuilder responseHeader;
	private StringBuilder responseBody;
	
	
	/**
	 * constructor
	 */
	public CreateContent() {
		this.responseHeader = new StringBuilder();
		this.responseBody = new StringBuilder();
	}
	
	
	
	/**
	 * buildUserForm method builds the form to Search for Recipe
	 * @return
	 */
	public String searchFormHTML() {
		//this.responseHeader.append("HTTP/1.0 200 OK\n" + "\r\n");
		
		this.responseBody.append(HTML.htmlOpen());
		 this.responseBody.append(HTML.head("Search Recipes"));
		 this.responseBody.append(HTML.bodyOpen());
		  this.createUserSearchForm();
		 this.responseBody.append(HTML.bodyClose());
		this.responseBody.append(HTML.htmlClose());

		//getting content length
		//this.responseHeader.append("Content-Length: "+ this.getContentLength(this.responseBody.toString()) + "\n\r\n");

		return this.responseHeader.toString() + this.responseBody.toString();
	}
	
	
	/**
	 * getContentLength method gets the content length
	 * @param responseBody
	 * @return
	 */
	public int getContentLength(String responseBody) {
		int contentLength = 0;
		try {
			contentLength  = responseBody.getBytes("UTF-8").length;
			return contentLength;
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unable to get Content-Length");
			return contentLength;
		}

	}
	
	///////////////////////////////////////// HTML general ////////////////
	
	
	/**
	 * createUserSearchForm method writes HTML form for Recipes Search
	 */
	private void createUserSearchForm() {
		this.responseBody.append("<h1 align=\"center\">Smart Food</h1>");
		this.responseBody.append("<h3>Search for Recipes</h3>");	

		this.responseBody.append(HTML.formOpen("/recipessearch", HTML.FORMMETHOD.POST));	
		
		this.responseBody.append(HTML.label("allowedIngredient", " Include Ingredient:"));	
		this.responseBody.append(HTML.input
				(INPUTTYPE.textarea, "allowedIngredient", "allowedIngredient"));
		
		this.responseBody.append(HTML.label("excludedIngredient", " Exclude Ingredient:"));	
		this.responseBody.append(HTML.input
				(INPUTTYPE.textarea, "excludedIngredient", "excludedIngredient"));
		
		this.responseBody.append(HTML.label("maxTotalTimeInSeconds", " Max Prep Time:"));	
		this.responseBody.append(HTML.input
				(INPUTTYPE.text, "maxTotalTimeInSeconds", "maxTotalTimeInSeconds") + HTML.breakLine());
		
		this.responseBody.append(HTML.submit());	    
		
		this.responseBody.append(HTML.formClose());

	}
	
	
	public static void main(String[] args) {
		
		CreateContent cc = new CreateContent();
		System.out.println(cc.searchFormHTML());
	}

}
