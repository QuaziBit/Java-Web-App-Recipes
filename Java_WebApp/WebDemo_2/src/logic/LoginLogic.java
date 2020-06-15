package logic;

import database.ConnectionInfo;
import database.UserDB;
import model.User;

public class LoginLogic 
{
	private ConnectionInfo connectionInfo = null;
	private UserDB userDB = null;
	
	public LoginLogic()
	{
		connectionInfo = new ConnectionInfo(null, null, null, null);
		
		userDB = new UserDB(connectionInfo);
	}
	
	public User login(String user_name, String password, String email)
	{
		User user = new User();
		user.setUser_name(user_name);
		user.setUser_password(password);
		user.setUser_email(email);
		
		User tmp = null;
		userDB.findUserByUnamePasswordEmail(user);
		tmp = userDB.getUser();
		
		return tmp;
	}
	
}
