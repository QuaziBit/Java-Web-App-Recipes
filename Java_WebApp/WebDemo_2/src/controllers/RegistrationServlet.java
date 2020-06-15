package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import html_generator.GenerateHTML;
import logic.RegistrationLogic;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet 
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
    public RegistrationServlet() 
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
					
		if(action_name.equals("user_registration"))
		{
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			String user_name = request.getParameter("user_name");
			String user_password = request.getParameter("user_password");
			String user_email = request.getParameter("user_email");
			
			if(!first_name.equals("") && !last_name.equals("") && !user_name.equals("") && !user_password.equals("") && !user_email.equals(""))
			{
				boolean userCreated = false;
				
				RegistrationLogic reg_l_tmp = new RegistrationLogic();
				userCreated = reg_l_tmp.createNewUser(first_name, last_name, user_name, user_password, user_email);
				
				GenerateHTML gen_tmp = new GenerateHTML();
				
				out.println(gen_tmp.generateRegistrationMessage(userCreated));
			}
			else
			{
				GenerateHTML tmp = new GenerateHTML();
				out.println(tmp.generateRegistrationMessage(false));
			}
		}
		
		out.close();
	}

	
	
	
	
	
	
	
}
