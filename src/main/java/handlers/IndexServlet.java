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

/**
 * @author anuragjha
 * IndexServlet class handles "/" request
 */
public class IndexServlet extends HttpServlet{


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		System.out.println("GET Request for IndexServlet : " + request.getRequestURL().toString());


		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");
		response.getWriter().println(new CreateContent().searchFormHTML());

	}

	/**
	 * 
	 */
	public IndexServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
