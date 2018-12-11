/**
 * 
 */
package yummlyResponse.recipes;

import htmlGenerator.HTML;

/**
 * @author anuragjha
 *
 */
public class attribute {

	private String[] course;
	private String[] cuisine;


	public String toHTML() {
		StringBuilder attributeHtml = new StringBuilder();

		attributeHtml.append(HTML.tdOpen());
		if(course != null && course.length >= 1) {
			for(String crse : course) {
				attributeHtml.append(crse + "  ");
			}
		}
		attributeHtml.append(HTML.tdClose());

		attributeHtml.append(HTML.tdOpen());
		if(cuisine != null && cuisine.length >= 1) {
			for(String cui : cuisine) {
				attributeHtml.append(cui + "  ");
			}
		}
		attributeHtml.append(HTML.tdClose());

		if(attributeHtml.toString().length() > 0) {
			return attributeHtml.toString();
		} else {
			return "";
		}

	}


	/**
	 * 
	 */
	public attribute() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
