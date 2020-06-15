package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import model.Recipe;
import model.User;
import model.User_Recipe;

public class UserDB 
{
	private User global_user = null;
	private HashMap<Integer, User> users = null;
	
	private ConnectionInfo connectionInfo = null;
	
	public UserDB(ConnectionInfo connectionInfo)
	{
		this.connectionInfo = connectionInfo;
	}
	
	/**
	 * This method will retrieve all users from data base;
	 * After execution of this method call getUsers() in order to get all users.
	 */
	public void findAllUsers()
	{
		global_user = null;
		
		users = new HashMap<Integer, User>();
		
        String sql = "SELECT * FROM recipes.users;";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		   
		try 
		{
			// Register JDBC driver
	         Class.forName(connectionInfo.get_jdbc_driver());
	         
	         // Open a connection
	         conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
	         
	         // Execute SQL query
	         stmt = conn.createStatement();
	         
	         rs = stmt.executeQuery(sql);
	         
	         // Extract data from result set
	         while(rs.next())
	         {
	            //Retrieve by column name
	            int tmp_id  = rs.getInt("ID");
	            String first_name = rs.getString("first_name");
	            String last_name = rs.getString("last_name");;
	            String user_name = rs.getString("user_name");
	            String user_password = rs.getString("user_password");
	            String user_email = rs.getString("user_email");
	            String user_image_paht = rs.getString("user_image_paht");
	            Date user_reg_date = rs.getDate("user_reg_date");
	            
	            global_user = new User();
	            global_user.setID(tmp_id);
	            global_user.setF_name(first_name);
	            global_user.setL_name(last_name);
	            global_user.setUser_name(user_name);
	            global_user.setUser_password(user_password);
	            global_user.setUser_email(user_email);
	            global_user.setUser_image_path(user_image_paht);
	            global_user.setUser_reg_date(user_reg_date);
		         
		        users.put(global_user.getID(), global_user);
	            
		        //System.out.println(global_user.toString());
	         }		
			// Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException se) 
		{
			//Handle errors for JDBC
			System.out.println("Cannot execute query: " + se.getSQLState() + "\n" + se.getMessage());
		} 
		catch(Exception e) 
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			//finally block used to close resources
			try 
			{
				if(stmt!=null)
			    {
					stmt.close();
			    }
			} 
			catch(SQLException se2) 
			{
				
			} // nothing we can do
			try 
			{
				if(conn!=null)
				{
					conn.close();	
				}
			} 
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
		}
	}
	
	public void findUserByID(int id)
	{
		global_user = null;
		
        String sql = "SELECT * FROM recipes.users WHERE ID = ?;";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		   
		try 
		{
			// Register JDBC driver
	        Class.forName(connectionInfo.get_jdbc_driver());
	         
	        // Open a connection
	        conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
	         
	        // Execute SQL query
	        stmt = conn.createStatement();
	        
	        preparedStmt = conn.prepareStatement(sql);
	        
	        //======================================================//
	         preparedStmt.setInt(1, id);
	         
	         rs = preparedStmt.executeQuery();
	         
	         while(rs.next())
	         {
	        	 //Retrieve by column name
		         int tmp_id  = rs.getInt("ID");
		         String first_name = rs.getString("first_name");
		         String last_name = rs.getString("last_name");;
		         String user_name = rs.getString("user_name");
		         String user_password = rs.getString("user_password");
		         String user_email = rs.getString("user_email");
		         String user_image_paht = rs.getString("user_image_paht");
		         Date user_reg_date = rs.getDate("user_reg_date");
		         
		         global_user = new User();
		         global_user.setID(tmp_id);
		         global_user.setF_name(first_name);
		         global_user.setL_name(last_name);
		         global_user.setUser_name(user_name);
		         global_user.setUser_password(user_password);
		         global_user.setUser_email(user_email);
		         global_user.setUser_image_path(user_image_paht);
		         global_user.setUser_reg_date(user_reg_date);
		         
		         //System.out.println(global_user.toString());
	         } 
	        //======================================================//
	        
			// Clean-up environment
	        preparedStmt.close();
	        rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException se) 
		{
			//Handle errors for JDBC
			System.out.println("Cannot execute query: " + se.getSQLState() + "\n" + se.getMessage());
		} 
		catch(Exception e) 
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			//finally block used to close resources
			try 
			{
				if(stmt!=null)
			    {
					stmt.close();
			    }
			} 
			catch(SQLException se2) 
			{
				
			} // nothing we can do
			try 
			{
				if(conn!=null)
				{
					conn.close();	
				}
			} 
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
		}
	}
	
	public void findUserByFirstLastName(User tmp_user)
	{
		global_user = null;
		
        String sql = "SELECT * FROM recipes.users WHERE first_name = ? AND last_name = ?;";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		   
		try 
		{
			// Register JDBC driver
	        Class.forName(connectionInfo.get_jdbc_driver());
	         
	        // Open a connection
	        conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
	         
	        // Execute SQL query
	        stmt = conn.createStatement();
	        
	        preparedStmt = conn.prepareStatement(sql);
	        
	        //======================================================//
	         preparedStmt.setString(1, tmp_user.getF_name());
	         preparedStmt.setString(2, tmp_user.getL_name());
	         
	         rs = preparedStmt.executeQuery();
	         
	         while(rs.next())
	         {
	        	 //Retrieve by column name
		         int tmp_id  = rs.getInt("ID");
		         String first_name = rs.getString("first_name");
		         String last_name = rs.getString("last_name");;
		         String user_name = rs.getString("user_name");
		         String user_password = rs.getString("user_password");
		         String user_email = rs.getString("user_email");
		         String user_image_paht = rs.getString("user_image_paht");
		         Date user_reg_date = rs.getDate("user_reg_date");
		            
		         global_user = new User();
		         global_user.setID(tmp_id);
		         global_user.setF_name(first_name);
		         global_user.setL_name(last_name);
		         global_user.setUser_name(user_name);
		         global_user.setUser_password(user_password);
		         global_user.setUser_email(user_email);
		         global_user.setUser_image_path(user_image_paht);
		         global_user.setUser_reg_date(user_reg_date);
		         
		         //System.out.println(global_user.toString());
	         }
	        //======================================================//
	        
			// Clean-up environment
	        preparedStmt.close();
	        rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException se) 
		{
			//Handle errors for JDBC
			System.out.println("Cannot execute query: " + se.getSQLState() + "\n" + se.getMessage());
		} 
		catch(Exception e) 
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			//finally block used to close resources
			try 
			{
				if(stmt!=null)
			    {
					stmt.close();
			    }
			} 
			catch(SQLException se2) 
			{
				
			} // nothing we can do
			try 
			{
				if(conn!=null)
				{
					conn.close();	
				}
			} 
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
		}
	}

	public void findUserByUserName(User tmp_user)
	{
		global_user = null;
		
        String sql = "SELECT * FROM recipes.users WHERE user_name = ?;";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		   
		try 
		{
			// Register JDBC driver
	        Class.forName(connectionInfo.get_jdbc_driver());
	         
	        // Open a connection
	        conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
	         
	        // Execute SQL query
	        stmt = conn.createStatement();
	        
	        preparedStmt = conn.prepareStatement(sql);
	        
	        //======================================================//
	         preparedStmt.setString(1, tmp_user.getUser_name());
	         
	         rs = preparedStmt.executeQuery();
	         
	         while(rs.next())
	         {
	        	 //Retrieve by column name
		         int tmp_id  = rs.getInt("ID");
		         String first_name = rs.getString("first_name");
		         String last_name = rs.getString("last_name");;
		         String user_name_tmp = rs.getString("user_name");
		         String user_password = rs.getString("user_password");
		         String user_email = rs.getString("user_email");
		         String user_image_paht = rs.getString("user_image_paht");
		         Date user_reg_date = rs.getDate("user_reg_date");
		            
		         global_user = new User();
		         global_user.setID(tmp_id);
		         global_user.setF_name(first_name);
		         global_user.setL_name(last_name);
		         global_user.setUser_name(user_name_tmp);
		         global_user.setUser_password(user_password);
		         global_user.setUser_email(user_email);
		         global_user.setUser_image_path(user_image_paht);
		         global_user.setUser_reg_date(user_reg_date);
		         
		         //System.out.println(global_user.toString());
	         }
	        //======================================================//
	        
			// Clean-up environment
	        preparedStmt.close();
	        rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException se) 
		{
			//Handle errors for JDBC
			System.out.println("Cannot execute query: " + se.getSQLState() + "\n" + se.getMessage());
		} 
		catch(Exception e) 
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			//finally block used to close resources
			try 
			{
				if(stmt!=null)
			    {
					stmt.close();
			    }
			} 
			catch(SQLException se2) 
			{
				
			} // nothing we can do
			try 
			{
				if(conn!=null)
				{
					conn.close();	
				}
			} 
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
		}
	}
	
	public void findUserByEmail(User tmp_user)
	{
		global_user = null;
		
        String sql = "SELECT * FROM recipes.users WHERE user_email = ?;";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		   
		try 
		{
			// Register JDBC driver
	        Class.forName(connectionInfo.get_jdbc_driver());
	         
	        // Open a connection
	        conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
	         
	        // Execute SQL query
	        stmt = conn.createStatement();
	        
	        preparedStmt = conn.prepareStatement(sql);
	        
	        //======================================================//
	         preparedStmt.setString(1, tmp_user.getUser_email());
	         
	         rs = preparedStmt.executeQuery();
	         
	         while(rs.next())
	         {
	        	 //Retrieve by column name
		         int tmp_id  = rs.getInt("ID");
		         String first_name = rs.getString("first_name");
		         String last_name = rs.getString("last_name");;
		         String user_name = rs.getString("user_name");
		         String user_password = rs.getString("user_password");
		         String user_email_tmp = rs.getString("user_email");
		         String user_image_paht = rs.getString("user_image_paht");
		         Date user_reg_date = rs.getDate("user_reg_date");
		            
		         global_user = new User();
		         global_user.setID(tmp_id);
		         global_user.setF_name(first_name);
		         global_user.setL_name(last_name);
		         global_user.setUser_name(user_name);
		         global_user.setUser_password(user_password);
		         global_user.setUser_email(user_email_tmp);
		         global_user.setUser_image_path(user_image_paht);
		         global_user.setUser_reg_date(user_reg_date);;
		         
		         //System.out.println(global_user.toString());
	         }
	        //======================================================//
	        
			// Clean-up environment
	        preparedStmt.close();
	        rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException se) 
		{
			//Handle errors for JDBC
			System.out.println("Cannot execute query: " + se.getSQLState() + "\n" + se.getMessage());
		} 
		catch(Exception e) 
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			//finally block used to close resources
			try 
			{
				if(stmt!=null)
			    {
					stmt.close();
			    }
			} 
			catch(SQLException se2) 
			{
				
			} // nothing we can do
			try 
			{
				if(conn!=null)
				{
					conn.close();	
				}
			} 
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
		}
	}
	
	public void findUserByFnameLnameEmail(User tmp_user)
	{
		global_user = null;
		
        String sql = "SELECT * FROM recipes.users WHERE first_name = ? AND last_name = ? AND user_email = ?;";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		   
		try 
		{
			// Register JDBC driver
	        Class.forName(connectionInfo.get_jdbc_driver());
	         
	        // Open a connection
	        conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
	         
	        // Execute SQL query
	        stmt = conn.createStatement();
	        
	        preparedStmt = conn.prepareStatement(sql);
	        
	        //======================================================//
	        preparedStmt.setString(1, tmp_user.getF_name());
	        preparedStmt.setString(2, tmp_user.getL_name());
	        preparedStmt.setString(3, tmp_user.getUser_email());
	         
	        rs = preparedStmt.executeQuery();
	         
	        while(rs.next())
	        {
	        	//Retrieve by column name
		        int tmp_id  = rs.getInt("ID");
		        String first_name_tmp = rs.getString("first_name");
		        String last_name_tmp = rs.getString("last_name");;
		        String user_name = rs.getString("user_name");
		        String user_password = rs.getString("user_password");
		        String user_email_tmp = rs.getString("user_email");
		        String user_image_paht = rs.getString("user_image_paht");
		        Date user_reg_date = rs.getDate("user_reg_date");
		            
		        global_user = new User();
		        global_user.setID(tmp_id);
		        global_user.setF_name(first_name_tmp);
		        global_user.setL_name(last_name_tmp);
		        global_user.setUser_name(user_name);
		        global_user.setUser_password(user_password);
		        global_user.setUser_email(user_email_tmp);
		        global_user.setUser_image_path(user_image_paht);
		        global_user.setUser_reg_date(user_reg_date);
		         
		        //System.out.println(global_user.toString());
	         }
	        //======================================================//
	        
			// Clean-up environment
	        preparedStmt.close();
	        rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException se) 
		{
			//Handle errors for JDBC
			System.out.println("Cannot execute query: " + se.getSQLState() + "\n" + se.getMessage());
		} 
		catch(Exception e) 
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			//finally block used to close resources
			try 
			{
				if(stmt!=null)
			    {
					stmt.close();
			    }
			} 
			catch(SQLException se2) 
			{
				
			} // nothing we can do
			try 
			{
				if(conn!=null)
				{
					conn.close();	
				}
			} 
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
		}
	}
	
	public void findUserByUnamePasswordEmail(User tmp_user)
	{
		global_user = null;
		
        String sql = "SELECT * FROM recipes.users WHERE user_name = ? AND user_password = ? AND user_email = ?;";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		   
		try 
		{
			// Register JDBC driver
	        Class.forName(connectionInfo.get_jdbc_driver());
	         
	        // Open a connection
	        conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
	         
	        // Execute SQL query
	        stmt = conn.createStatement();
	        
	        preparedStmt = conn.prepareStatement(sql);
	        
	        //======================================================//
	        preparedStmt.setString(1, tmp_user.getUser_name());
	        preparedStmt.setString(2, tmp_user.getUser_password());
	        preparedStmt.setString(3, tmp_user.getUser_email());
	         
	        rs = preparedStmt.executeQuery();
	         
	        while(rs.next())
	        {
	        	//Retrieve by column name
		        int tmp_id  = rs.getInt("ID");
		        String first_name_tmp = rs.getString("first_name");
		        String last_name_tmp = rs.getString("last_name");;
		        String user_name = rs.getString("user_name");
		        String user_password = rs.getString("user_password");
		        String user_email_tmp = rs.getString("user_email");
		        String user_image_paht = rs.getString("user_image_paht");
		        Date user_reg_date = rs.getDate("user_reg_date");
		            
		        global_user = new User();
		        global_user.setID(tmp_id);
		        global_user.setF_name(first_name_tmp);
		        global_user.setL_name(last_name_tmp);
		        global_user.setUser_name(user_name);
		        global_user.setUser_password(user_password);
		        global_user.setUser_email(user_email_tmp);
		        global_user.setUser_image_path(user_image_paht);
		        global_user.setUser_reg_date(user_reg_date);
		         
		        //System.out.println(global_user.toString());
	         }
	        //======================================================//
	        
			// Clean-up environment
	        preparedStmt.close();
	        rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException se) 
		{
			//Handle errors for JDBC
			System.out.println("Cannot execute query: " + se.getSQLState() + "\n" + se.getMessage());
		} 
		catch(Exception e) 
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			//finally block used to close resources
			try 
			{
				if(stmt!=null)
			    {
					stmt.close();
			    }
			} 
			catch(SQLException se2) 
			{
				
			} // nothing we can do
			try 
			{
				if(conn!=null)
				{
					conn.close();	
				}
			} 
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
		}
	}
	
	public void addUser(User newUser)
	{
		global_user = null;
		
        String sql;
        sql = "INSERT INTO users (first_name, last_name, user_name, user_password, user_email, user_image_paht, user_reg_date)"
        		+ " VALUES(?, ?, ?, ?, ?, ?, ?);";
		
		Connection conn = null;
		PreparedStatement preparedStmt = null;
		Statement stmt = null;
		   
		try 
		{
			// Register JDBC driver
	         Class.forName("com.mysql.jdbc.Driver");
	         
	         // Open a connection
		    conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
		         
	         // Execute SQL query
	        stmt = conn.createStatement();
	         
	         preparedStmt = conn.prepareStatement(sql);
	         
	         preparedStmt.setString(1, newUser.getF_name());
	         preparedStmt.setString(2, newUser.getL_name());
	         preparedStmt.setString(3, newUser.getUser_name());
	         preparedStmt.setString(4, newUser.getUser_password());
	         preparedStmt.setString(5, newUser.getUser_email());
	         preparedStmt.setString(6, newUser.getUser_image_path());
	         preparedStmt.setDate(7, newUser.getUser_reg_date());
	         
	         preparedStmt.executeUpdate();
			
			// Clean-up environment
	        preparedStmt.close();
	        stmt.close();
			conn.close();
		}
		catch(SQLException se) 
		{
			//Handle errors for JDBC
			System.out.println("Cannot execute query: " + se.getSQLState() + "\n" + se.getMessage());
		} 
		catch(Exception e) 
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			//finally block used to close resources
			try 
			{
				if(stmt!=null)
			    {
					stmt.close();
			    }
			} 
			catch(SQLException se2) 
			{
				
			} // nothing we can do
			try 
			{
				if(conn!=null)
				{
					conn.close();	
				}
			} 
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
		}
	}
	
	public void updateUser(User updatedUser)
	{
		global_user = null;
		
        String sql;
        sql = "UPDATE users SET first_name = ?, "
        		+ "last_name = ?, user_name = ?, "
        		+ "user_password = ?, "
        		+ "user_email = ?, "
        		+ "user_image_paht = ? "
        		+ "WHERE ID = ?;";
		
		Connection conn = null;
		PreparedStatement preparedStmt = null;
		Statement stmt = null;
		   
		try 
		{
			// Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");
	         
	        // Open a connection
		    conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
		         
	        // Execute SQL query
	        stmt = conn.createStatement();
	         
	        preparedStmt = conn.prepareStatement(sql);
	        
	        String first_name = updatedUser.getF_name();
	        String last_name = updatedUser.getL_name();
	        String user_name = updatedUser.getUser_name();
	        String user_password = updatedUser.getUser_password();
	        String user_email = updatedUser.getUser_email();
	        String user_image_path = updatedUser.getUser_image_path();
	        
	        preparedStmt.setString(1, first_name);
	        preparedStmt.setString(2, last_name);
	        preparedStmt.setString(3, user_name);
	        preparedStmt.setString(4, user_password);
	        preparedStmt.setString(5, user_email);
	        preparedStmt.setString(6, user_image_path);
	        preparedStmt.setInt(7, updatedUser.getID());
	         
	        preparedStmt.executeUpdate();
			
			// Clean-up environment
	        preparedStmt.close();
	        stmt.close();
			conn.close();
			
			global_user = null;
		}
		catch(SQLException se) 
		{
			//Handle errors for JDBC
			System.out.println("[updateUser()]: Cannot execute query: " + se.getSQLState() + "\n" + se.getMessage());
		} 
		catch(Exception e) 
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			//finally block used to close resources
			try 
			{
				if(stmt!=null)
			    {
					stmt.close();
			    }
			} 
			catch(SQLException se2) 
			{
				
			} // nothing we can do
			try 
			{
				if(conn!=null)
				{
					conn.close();	
				}
			} 
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
		}
	}
	
	public void deleteUser(User tmp_user)
	{
		global_user = null;
		
		//If user deleted all his records have to be deleted as well as user Recipes
		
		findUserByFnameLnameEmail(tmp_user);
		
        String sql;
        sql = "DELETE FROM users WHERE ID = ?;";
		
		Connection conn = null;
		PreparedStatement preparedStmt = null;
		Statement stmt = null;
		   
		try 
		{
			// Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");
	         
	        // Open a connection
		    conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
		         
	        // Execute SQL query
	        stmt = conn.createStatement();
	         
	        preparedStmt = conn.prepareStatement(sql);
	         
	        preparedStmt.setInt(1, global_user.getID()); 
	        
	        preparedStmt.executeUpdate();
			
			// Clean-up environment
	        preparedStmt.close();
	        stmt.close();
			conn.close();
			
			global_user = null;
		}
		catch(SQLException se) 
		{
			//Handle errors for JDBC
			System.out.println("[updateUser()]: Cannot execute query: " + se.getSQLState() + "\n" + se.getMessage());
		} 
		catch(Exception e) 
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			//finally block used to close resources
			try 
			{
				if(stmt!=null)
			    {
					stmt.close();
			    }
			} 
			catch(SQLException se2) 
			{
				
			} // nothing we can do
			try 
			{
				if(conn!=null)
				{
					conn.close();	
				}
			} 
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
		}
	}
	
	/**
	 * User object have to contain at least user first and last name, and email
	 * @param tmp_user
	 */
	public void findUserAndRecepes(User tmp_user)
	{
		global_user = null;
		
		UserRecipeRelationDB user_RecipeConnection_tmp = new UserRecipeRelationDB(connectionInfo);
		RecipeDB recipeConnection_tmp = new RecipeDB(connectionInfo);
		
		//Find user
		findUserByFnameLnameEmail(tmp_user);
		tmp_user = global_user;
		
		user_RecipeConnection_tmp.findAllUserRecipeRelations(tmp_user);
		tmp_user.setRecipeToUser(user_RecipeConnection_tmp.getUser_recipes());
        
        for(HashMap.Entry<Integer, User_Recipe> pair : tmp_user.getRecipeToUser().entrySet())
        {
        	recipeConnection_tmp.findRecipeByID(pair.getValue().getUr_recipe_id());
        	//System.out.println("");
        }
        
        tmp_user.setRecipes(recipeConnection_tmp.getRecipes());
        
        if(tmp_user.getRecipes() == null)
        {
        	System.out.println("No Recipes");
        }
        
        //Test
        System.out.println("\n\nUser ID: " + tmp_user.getID() + " has recipes");
        for(HashMap.Entry<Integer, Recipe> pair : tmp_user.getRecipes().entrySet())
        {
        	//System.out.println("\t" + pair.getValue().toString());
        }
	}
	
	public void findUserByRecipe(Recipe recipe)
	{
		global_user = null;
		
        String sql = "SELECT users.ID, users.first_name, users.last_name, " +
        			 "users.user_name, users.user_password, users.user_email, " +  
					 "users.user_image_paht, users.user_reg_date " + 
					 "FROM recipes.users, recipes.recipes, recipes.user_recipes " + 
					 "WHERE recipes.recipes.ID = ? " + 
					 "AND recipes.user_recipes.ur_recipe_id = recipes.recipes.ID " + 
					 "AND recipes.user_recipes.ur_user_id = recipes.users.ID;";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		   
		try 
		{
			// Register JDBC driver
	        Class.forName(connectionInfo.get_jdbc_driver());
	         
	        // Open a connection
	        conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
	         
	        // Execute SQL query
	        stmt = conn.createStatement();
	        
	        preparedStmt = conn.prepareStatement(sql);
	        
	        //======================================================//
	        preparedStmt.setInt(1, recipe.getID());
	         
	        rs = preparedStmt.executeQuery();
	         
	        while(rs.next())
	        {
	            //Retrieve by column name
	            int tmp_id  = rs.getInt("ID");
	            String first_name = rs.getString("first_name");
	            String last_name = rs.getString("last_name");
	            String user_name = rs.getString("user_name");
	            String user_password = rs.getString("user_password");
	            String user_email = rs.getString("user_email");
	            String user_image_paht = rs.getString("user_image_paht");
	            Date user_reg_date = rs.getDate("user_reg_date");
	            
		        global_user = new User();
		        global_user.setID(tmp_id);
		        global_user.setF_name(first_name);
		        global_user.setL_name(last_name);
		        global_user.setUser_name(user_name);
		        global_user.setUser_password(user_password);
		        global_user.setUser_email(user_email);
		        global_user.setUser_image_path(user_image_paht);
		        global_user.setUser_reg_date(user_reg_date);
		        
		        //System.out.println(global_user.toString());
		        //System.out.println("\t" + recipe.toString());
	        }
	        //======================================================//
	        
			// Clean-up environment
	        preparedStmt.close();
	        rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException se) 
		{
			//Handle errors for JDBC
			System.out.println("Cannot execute query: " + se.getSQLState() + "\n" + se.getMessage());
		} 
		catch(Exception e) 
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			//finally block used to close resources
			try 
			{
				if(stmt!=null)
			    {
					stmt.close();
			    }
			} 
			catch(SQLException se2) 
			{
				
			} // nothing we can do
			try 
			{
				if(conn!=null)
				{
					conn.close();	
				}
			} 
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
		}
	}
	
	public User getUser()
	{
		return global_user;
	}
	
	public HashMap<Integer, User> getUsers()
	{
		return users;
	}
	
	
}
