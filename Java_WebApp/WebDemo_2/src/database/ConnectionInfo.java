package database;

import java.sql.*;

public class ConnectionInfo 
{
	/*
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/recipes";
    
    //  Database credentials
    static final String USER = "****";
    static final String PASS = "********";
    */
	
	private String jdbc_driver = "com.mysql.jdbc.Driver";
	private String db_url = "jdbc:mysql://localhost:3306/recipes";
	private String user = "****";
	private String passw = "********";
	
	public ConnectionInfo(String jdbc_driver, String db_url, String user, String passw)
	{
		if(jdbc_driver != null && db_url != null && user != null && passw != null)
		{
			this.jdbc_driver = jdbc_driver;
			this.db_url = db_url;
			this.user = user;
			this.passw = passw;
		}
	}
	
	public String get_jdbc_driver()
	{
		return jdbc_driver;
	}
	
	public String get_db_url()
	{
		return db_url;
	}
	
	public String get_user()
	{
		return user;
	}
	
	public String get_passw()
	{
		return passw;
	}
}
