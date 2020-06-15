package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import html_generator.GenerateHTML;
import logic.LoginLogic;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet 
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
    public UserProfile() 
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
		
		String action_name = request.getParameter("action_name");

		if(action_name.equals("first_load"))
		{
			User user = null;
			user = (User) session.getAttribute("user_login");

			out.println(user.toString());
		}
		
		out.close();
	}

}
