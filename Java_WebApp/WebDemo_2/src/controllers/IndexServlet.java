package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.*;
import model.Recipe;
import model.User;
import model.User_Recipe;
import html_generator.GenerateHTML;
import logic.IndexLogic;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet 
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
    public IndexServlet() 
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
		
		if(session.getAttribute("index_logic") == null)
		{
			session.setAttribute("index_logic", new IndexLogic());
		}
		
		PrintWriter out = response.getWriter();
		String action_name = request.getParameter("action_name");
				
		if(action_name.equals("first_load"))
		{
			IndexLogic index_logic = (IndexLogic) session.getAttribute("index_logic");
	        out.println(index_logic.firstLoad());
		}
		else if(action_name.equals("next_recipes"))
		{
			IndexLogic index_logic = (IndexLogic) session.getAttribute("index_logic");
			out.println(index_logic.nextRecipes());
		}
		else if(action_name.equals("last_recipes"))
		{
			IndexLogic index_logic = (IndexLogic) session.getAttribute("index_logic");
			out.println(index_logic.lastRecipes());
		}
		else if(action_name.equals("page_num"))
		{
			IndexLogic index_logic = (IndexLogic) session.getAttribute("index_logic");
			out.println(index_logic.pageNums());
		}
		
		/*
		else if(action_name.equals("search_recipes"))
		{
			System.out.println("search_recipes");
			getServletContext().getRequestDispatcher("/search.html").forward(request, response);
		}
		else if(action_name.equals("user_login"))
		{
			System.out.println("user_login");
			getServletContext().getRequestDispatcher("/login.html").forward(request, response);
		}
		else if(action_name.equals("user_registration"))
		{
			System.out.println("user_registration");
			getServletContext().getRequestDispatcher("/registration.html").forward(request, response);
		}
		*/
		out.close();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		response.setContentType(responseType);
		
		doGet(request, response);
	}

}
