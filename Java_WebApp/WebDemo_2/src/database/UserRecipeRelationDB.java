package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import model.User;
import model.Recipe;
import model.User_Recipe;

public class UserRecipeRelationDB 
{
	private User user = null;
	private User_Recipe user_Recipe = null;
	private HashMap<Integer, User_Recipe> user_recipes = null;
	
	private ConnectionInfo connectionInfo = null;
	
	public UserRecipeRelationDB(ConnectionInfo connectionInfo)
	{
		this.connectionInfo = connectionInfo;
	}
	
	public void findAllUserRecipeRelations(User user)
	{
		user_recipes = new HashMap<Integer, User_Recipe>();
		
        String sql = "SELECT * FROM recipes.user_recipes WHERE recipes.user_recipes.ur_user_id = ?;";
		
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
	        preparedStmt.setInt(1, user.getID());
	         
	        rs = preparedStmt.executeQuery();
	         
	        while(rs.next())
	        {
	        	//Retrieve by column name
	        	int tmp_id  = rs.getInt("ID");
	        	int ur_user_id  = rs.getInt("ur_user_id");
	        	int ur_recipe_id  = rs.getInt("ur_recipe_id");
	        	 
	        	user_Recipe = new User_Recipe();
	        	user_Recipe.setID(tmp_id);
	        	user_Recipe.setUr_user_id(ur_user_id);
	        	user_Recipe.setUr_recipe_id(ur_recipe_id);
	        	 
	        	user_recipes.put(user_Recipe.getID(), user_Recipe);
	         
	        	//System.out.println("\t" + tmp_id + "; " + ur_user_id + "; " + ur_recipe_id); 
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
	
	public void addUserRecipeRelation(User tmp_user, Recipe tmp_recipe)
	{
        String sql;
        sql = "INSERT INTO recipes.user_recipes (ur_user_id, ur_recipe_id) VALUE(?, ?);";
        
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
	         
	        preparedStmt.setInt(1, tmp_user.getID());
	        preparedStmt.setInt(2, tmp_recipe.getID());
	         
	         
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
	
	public void deleteUserRecipeRelation(User tmp_user, Recipe tmp_recipe)
	{
        String sql;
        sql = "DELETE FROM recipes.user_recipes WHERE ur_user_id = ? AND ur_recipe_id = ?;";
        
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
	         
	        preparedStmt.setInt(1, tmp_user.getID());
	        preparedStmt.setInt(2, tmp_recipe.getID());
	        
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
	
	public User getUserWithRecipes()
	{
		return user;
	}
	
	public HashMap<Integer, User_Recipe> getUser_recipes() {
		return user_recipes;
	}
}
