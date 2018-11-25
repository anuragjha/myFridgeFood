/**
 * 
 */
package yummlyRequest.recipes;

/**
 * @author anuragjha
 *
 */
public class YummlyRequest {

	String q; //zrt+ert
	boolean requirePictures;
	String allowedIngredient;
	String excludedIngredient;
	String allowedAllergy;
	String allowedDiet;
	String allowedCuisine;
	String excludedCuisine;
	String allowedCourse;
	String excludedCourse;
	int maxTotalTimeInSeconds;
	/////////	 http://api.yummly.com/v1/api/recipes?_app_id=YOUR_ID&_app_key=YOUR_APP_KEY&q=onion+soup
	////////	&maxResult=10&start=10 ##pagination

	/**
	 * 
	 */
	public YummlyRequest() {
		// TODO Auto-generated constructor stub
	}





	/**
	 * @return the q
	 */
	public String getQ() {
		return q;
	}





	/**
	 * @param q the q to set
	 */
	public void setQ(String q) {
		this.q = q;
	}





	/**
	 * @return the requirePictures
	 */
	public boolean isRequirePictures() {
		return requirePictures;
	}





	/**
	 * @param requirePictures the requirePictures to set
	 */
	public void setRequirePictures(boolean requirePictures) {
		this.requirePictures = requirePictures;
	}





	/**
	 * @return the allowedIngredient
	 */
	public String getAllowedIngredient() {
		return allowedIngredient;
	}





	/**
	 * @param allowedIngredient the allowedIngredient to set
	 */
	public void setAllowedIngredient(String allowedIngredient) {
		String[] allowedIngredients = allowedIngredient.split(" "); 
		//allowedIngredient[]=garlic               // &allowedIngredient[]=cognac
		
		StringBuilder sb = new StringBuilder();
		//if(allowedIngredients.length == 1) {
		//	sb.append("allowedIngredient[]=" + allowedIngredients[0]);
		//} else {
		//	sb.append("allowedIngredient[]=" + allowedIngredients[0]);
			for(int i = 0; i< allowedIngredients.length; i++) {
				if(allowedIngredients[i].equals("")) {
					break;
				}
				sb.append("&allowedIngredient[]=" + allowedIngredients[i]);
			}
		//}
		this.allowedIngredient = sb.toString();
	}





	/**
	 * @return the excludedIngredient
	 */
	public String getExcludedIngredient() {
		return excludedIngredient;
	}





	/**
	 * @param excludedIngredient the excludedIngredient to set
	 */
	public void setExcludedIngredient(String excludedIngredient) {
		
		String[] excludedIngredients = excludedIngredient.split(" "); 
		//allowedIngredient[]=garlic               // &allowedIngredient[]=cognac
		
		StringBuilder sb = new StringBuilder();
		//if(excludedIngredients.length == 1) {
		//	sb.append("excludedIngredient[]=" + excludedIngredients[0]);
		//} else {
			//sb.append("excludedIngredient[]=" + excludedIngredients[0]);
			for(int i = 0; i< excludedIngredients.length; i++) {
				if(excludedIngredients[i].equals("")) {
					break;
				}
				sb.append("&excludedIngredient[]=" + excludedIngredients[i]);
			}
		//}
		this.excludedIngredient = sb.toString();
	}





	/**
	 * @return the allowedAllergy
	 */
	public String getAllowedAllergy() {
		return allowedAllergy;
	}





	/**
	 * @param allowedAllergy the allowedAllergy to set
	 */
	public void setAllowedAllergy(String allowedAllergy) {
		this.allowedAllergy = allowedAllergy;
	}





	/**
	 * @return the allowedDiet
	 */
	public String getAllowedDiet() {
		return allowedDiet;
	}





	/**
	 * @param allowedDiet the allowedDiet to set
	 */
	public void setAllowedDiet(String allowedDiet) {
		this.allowedDiet = allowedDiet;
	}





	/**
	 * @return the allowedCuisine
	 */
	public String getAllowedCuisine() {
		return allowedCuisine;
	}





	/**
	 * @param allowedCuisine the allowedCuisine to set
	 */
	public void setAllowedCuisine(String allowedCuisine) {
		this.allowedCuisine = allowedCuisine;
	}





	/**
	 * @return the excludedCuisine
	 */
	public String getExcludedCuisine() {
		return excludedCuisine;
	}





	/**
	 * @param excludedCuisine the excludedCuisine to set
	 */
	public void setExcludedCuisine(String excludedCuisine) {
		this.excludedCuisine = excludedCuisine;
	}





	/**
	 * @return the allowedCourse
	 */
	public String getAllowedCourse() {
		return allowedCourse;
	}





	/**
	 * @param allowedCourse the allowedCourse to set
	 */
	public void setAllowedCourse(String allowedCourse) {
		this.allowedCourse = allowedCourse;
	}





	/**
	 * @return the excludedCourse
	 */
	public String getExcludedCourse() {
		return excludedCourse;
	}





	/**
	 * @param excludedCourse the excludedCourse to set
	 */
	public void setExcludedCourse(String excludedCourse) {
		this.excludedCourse = excludedCourse;
	}





	/**
	 * @return the maxTotalTimeInSeconds
	 */
	public int getMaxTotalTimeInSeconds() {
		return maxTotalTimeInSeconds;
	}





	/**
	 * @param maxTotalTimeInSeconds the maxTotalTimeInSeconds to set
	 */
	public void setMaxTotalTimeInSeconds(int maxTotalTimeInSeconds) {
		this.maxTotalTimeInSeconds = maxTotalTimeInSeconds;
	}





	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
