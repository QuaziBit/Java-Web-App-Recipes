package logic;

import java.sql.Date;
import java.util.Calendar;
import database.ConnectionInfo;
import database.UserDB;
import model.User;

public class RegistrationLogic 
{
	private ConnectionInfo connectionInfo = null;
	private UserDB userDB = null;
	
	public RegistrationLogic()
	{
		connectionInfo = new ConnectionInfo(null, null, null, null);
		
		userDB = new UserDB(connectionInfo);
	}
	
	public boolean createNewUser(String f_name, String l_name, String user_name, String password, String email)
	{
		boolean userCreated = false;
		
		User user = new User();
		user.setUser_email(email);
		userDB.findUserByEmail(user);
		
		if(userDB.getUser() == null)
		{
			Calendar calendar = Calendar.getInstance();
			Date reg_date = new Date(calendar.getTime().getTime());
			
			//Can add user
			User tmp_user = new User();
			tmp_user.setF_name(f_name);
			tmp_user.setL_name(l_name);
			tmp_user.setUser_name(user_name);
			tmp_user.setUser_password(password);
			tmp_user.setUser_email(email);
			tmp_user.setUser_image_path("NULL");
			tmp_user.setUser_reg_date(reg_date);
			
			userDB.addUser(tmp_user);
			
			userCreated = true;
			
		}
		else
		{
			//User exists
			userCreated = false;
		}
		
		return userCreated;
	}
}
