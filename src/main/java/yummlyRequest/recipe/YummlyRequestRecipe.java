/**
 * 
 */
package yummlyRequest.recipe;

/**
 * @author anuragjha
 * YummlyRequestRecipe class 
 */
public class YummlyRequestRecipe {
	
	String recipeid;

	public YummlyRequestRecipe(String recipeid) {
		this.recipeid = recipeid;
	}
	
	
	
	/**
	 * @return the recipeid
	 */
	public String getRecipeid() {
		return recipeid;
	}

	/**
	 * @param recipeid the recipeid to set
	 */
	public void setRecipeid(String recipeid) {
		this.recipeid = recipeid;
	}

	/**
	 * 
	 */
	public YummlyRequestRecipe() {
		// TODO Auto-generated constructor stub
	}

}
