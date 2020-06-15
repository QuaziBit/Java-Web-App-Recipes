package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ConnectionInfo;
import database.RecipeDB;
import database.UserDB;
import database.UserRecipeRelationDB;
import html_generator.GenerateHTML;
import logic.IndexLogic;
import logic.SearchLogic;
import model.Recipe;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	// Set response content type
	private String responseType = "text/html";
    
	@Override
	public void init() throws ServletException 
	{
		
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType(responseType);
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("searchLogic") == null)
		{
			session.setAttribute("searchLogic", new SearchLogic());
			session.setAttribute("entered_val", null);
		}
		
		PrintWriter out = response.getWriter();
		String action_name = request.getParameter("action_name");
		
		if(action_name.equals("first_load"))
		{
			SearchLogic searchLogic = (SearchLogic) session.getAttribute("searchLogic");
			System.out.println("session ID: " + session.getId());

			out.println(searchLogic.firstLoad());
		}
		else if(action_name.equals("search_recipe"))
		{
			String output_html = "";
			
			if(!request.getParameter("entered_val").equals("") && request.getParameter("entered_val") != null)
			{
				String entered_val = request.getParameter("entered_val");
				session.setAttribute("entered_val", entered_val);
				System.out.println("session ID: " + session.getId());
				
				System.out.println("Entered value: " + ( (String) session.getAttribute("entered_val")) );
			}
			
			if((String) session.getAttribute("entered_val") != null)
			{
				SearchLogic searchLogic = (SearchLogic) session.getAttribute("searchLogic");
				String entered_val = (String) session.getAttribute("entered_val");
				System.out.println("session ID: " + session.getId());
				out.println(searchLogic.searchRecipes(entered_val));
			}
			else
			{
				out.println(output_html);
			}
		}
		else if(action_name.equals("next_recipes"))
		{
			SearchLogic searchLogic = (SearchLogic) session.getAttribute("searchLogic");
			System.out.println("session ID: " + session.getId());
			out.println(searchLogic.nextRecipes());
		}
		else if(action_name.equals("last_recipes"))
		{
			SearchLogic searchLogic = (SearchLogic) session.getAttribute("searchLogic");
			System.out.println("session ID: " + session.getId());
			out.println(searchLogic.lastRecipes());
		}
		else if(action_name.equals("page_num"))
		{
			SearchLogic searchLogic = (SearchLogic) session.getAttribute("searchLogic");
			System.out.println("session ID: " + session.getId());
			out.println(searchLogic.pageNums());
		}
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
