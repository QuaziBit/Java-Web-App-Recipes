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
 * Servlet implementation class UserRecipes
 */
@WebServlet("/UserRecipes")
public class UserRecipes extends HttpServlet 
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
    public UserRecipes() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		
		response.setContentType(responseType);
		
		PrintWriter out = response.getWriter();
		
		String action_name = request.getParameter("");
		
		
		out.close();
	}

}
