package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import html_generator.GenerateHTML;
import logic.IndexLogic;
import logic.LoginLogic;
import logic.RegistrationLogic;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
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
    public LoginServlet() 
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
		
		String url = "";

		if(action_name.equals("user_login"))
		{
			User user = null;
			
			String user_name = request.getParameter("user_name");
			String user_password = request.getParameter("user_password");
			String user_email = request.getParameter("user_email");
			
			if(!user_name.equals("") && !user_password.equals("") && !user_email.equals(""))
			{
				LoginLogic login = new LoginLogic();
				user = login.login(user_name, user_password, user_email);
				
				if(user != null)
				{
					session.setAttribute("user_login", user);
				}
				
				url = "/WebDemo_2/user_profile.html";
			}
			
			if(user != null)
			{
				out.println(url);
			}
			else
			{
				GenerateHTML tmp = new GenerateHTML();
				out.println(tmp.generateLoginMessage());
			}
		}
				
		out.close();
	}

}
