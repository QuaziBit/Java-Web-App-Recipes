package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.sql.Date;

import model.Recipe;
import model.User;
import model.User_Recipe;

public class RecipeDB 
{
	private Recipe global_recipe = null;
	private HashMap<Integer, Recipe> recipes = new HashMap<Integer, Recipe>();
	private ArrayList<Recipe> recipes_list = null;
	
	private ConnectionInfo connectionInfo = null;
	
	public RecipeDB(ConnectionInfo connectionInfo)
	{
		this.connectionInfo = connectionInfo;
	}
	
	public int totalNumberOfRecipes()
	{
		int total = 0;
		
        String sql = "SELECT COUNT(*) AS `total` FROM recipes.recipes;";
		
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
	            total = rs.getInt("total");

	            //System.out.println("Total Recipes: " + total);
	         
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
		
		return total;
	}
	
	public void findAllRecipes()
	{
		global_recipe = null;
		recipes = null;
		recipes = new HashMap<Integer, Recipe>();
		
        String sql = "SELECT * FROM recipes.recipes;";
		
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
	            int tmp_id = rs.getInt("ID");
	            String recipe_name = rs.getString("recipe_name");
	            String recipe_image_path = rs.getString("recipe_image_path");;
	            String recipe_video_path = rs.getString("recipe_video_path");
	            int likes = rs.getInt("likes");
	            String short_description = rs.getString("short_description");
	            String description = rs.getString("description");
	            Date recipe_reg_date = rs.getDate("recipe_reg_date");
	            
	            global_recipe = new Recipe();
	            global_recipe.setID(tmp_id);
	            global_recipe.setRecipe_name(recipe_name);
	            global_recipe.setRecipe_image_path(recipe_image_path);
	            global_recipe.setRecipe_video_path(recipe_video_path);
	            global_recipe.setLikes(likes);
	            global_recipe.setShort_description(short_description);
	            global_recipe.setDescription(description);
	            global_recipe.setRecipe_reg_date(recipe_reg_date);
	            
	            recipes.put(global_recipe.getID(), global_recipe);
	            
	            //System.out.println(global_recipe.toString());
	         
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
	
	public void findRecipesInLimitRange(int limit, int offset)
	{
		global_recipe = null;
		recipes = new HashMap<Integer, Recipe>();
		
        String sql = "SELECT * FROM recipes.recipes LIMIT ? OFFSET ?;";
		
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
	        preparedStmt.setInt(1, limit);
	        preparedStmt.setInt(2, offset);
	         
	        rs = preparedStmt.executeQuery();
	        while(rs.next())
	        {
	            //Retrieve by column name
	            int tmp_id = rs.getInt("ID");
	            String recipe_name = rs.getString("recipe_name");
	            String recipe_image_path = rs.getString("recipe_image_path");;
	            String recipe_video_path = rs.getString("recipe_video_path");
	            int likes = rs.getInt("likes");
	            String short_description = rs.getString("short_description");
	            String description = rs.getString("description");
	            Date recipe_reg_date = rs.getDate("recipe_reg_date");
	            
	            global_recipe = new Recipe();
	            global_recipe.setID(tmp_id);
	            global_recipe.setRecipe_name(recipe_name);
	            global_recipe.setRecipe_image_path(recipe_image_path);
	            global_recipe.setRecipe_video_path(recipe_video_path);
	            global_recipe.setLikes(likes);
	            global_recipe.setShort_description(short_description);
	            global_recipe.setDescription(description);
	            global_recipe.setRecipe_reg_date(recipe_reg_date);
		        
	            recipes.put(global_recipe.getID(), global_recipe);
	            
	            //System.out.println(global_recipe.toString());
		        
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
	
	public void findRecipeByID(int id)
	{
		global_recipe = null;
		
        String sql = "SELECT * FROM recipes.recipes WHERE ID = ?;";
		
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
	            int tmp_id = rs.getInt("ID");
	            String recipe_name = rs.getString("recipe_name");
	            String recipe_image_path = rs.getString("recipe_image_path");;
	            String recipe_video_path = rs.getString("recipe_video_path");
	            int likes = rs.getInt("likes");
	            String short_description = rs.getString("short_description");
	            String description = rs.getString("description");
	            Date recipe_reg_date = rs.getDate("recipe_reg_date");
	            
	            global_recipe = new Recipe();
	            global_recipe.setID(tmp_id);
	            global_recipe.setRecipe_name(recipe_name);
	            global_recipe.setRecipe_image_path(recipe_image_path);
	            global_recipe.setRecipe_video_path(recipe_video_path);
	            global_recipe.setLikes(likes);
	            global_recipe.setShort_description(short_description);
	            global_recipe.setDescription(description);
	            global_recipe.setRecipe_reg_date(recipe_reg_date);
		        
	            //System.out.println(global_recipe.toString());
		        
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
	
	public void findRecipeByName(Recipe tmp_recipe)
	{
		global_recipe = null;
		
        String sql = "SELECT * FROM recipes.recipes WHERE recipe_name = ?;";
		
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
	        preparedStmt.setString(1, tmp_recipe.getRecipe_name());
	         
	        rs = preparedStmt.executeQuery();
	         
	        while(rs.next())
	        {
	            //Retrieve by column name
	            int tmp_id = rs.getInt("ID");
	            String recipe_name = rs.getString("recipe_name");
	            String recipe_image_path = rs.getString("recipe_image_path");;
	            String recipe_video_path = rs.getString("recipe_video_path");
	            int likes = rs.getInt("likes");
	            String short_description = rs.getString("short_description");
	            String description = rs.getString("description");
	            Date recipe_reg_date = rs.getDate("recipe_reg_date");
	            
	            global_recipe = new Recipe();
	            global_recipe.setID(tmp_id);
	            global_recipe.setRecipe_name(recipe_name);
	            global_recipe.setRecipe_image_path(recipe_image_path);
	            global_recipe.setRecipe_video_path(recipe_video_path);
	            global_recipe.setLikes(likes);
	            global_recipe.setShort_description(short_description);
	            global_recipe.setDescription(description);
	            global_recipe.setRecipe_reg_date(recipe_reg_date);
		        
	            //System.out.println(global_recipe.toString());
		        
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
	
	public void findRecipeByNameLIKE(Recipe tmp_recipe)
	{
		global_recipe = null;
		recipes = new HashMap<Integer, Recipe>();
		
        String sql = "SELECT * FROM recipes.recipes WHERE recipe_name LIKE ?;";
		
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
	        preparedStmt.setString(1, tmp_recipe.getRecipe_name() + "%");
	         
	        rs = preparedStmt.executeQuery();
	         
	        while(rs.next())
	        {
	            //Retrieve by column name
	            int tmp_id = rs.getInt("ID");
	            String recipe_name = rs.getString("recipe_name");
	            String recipe_image_path = rs.getString("recipe_image_path");;
	            String recipe_video_path = rs.getString("recipe_video_path");
	            int likes = rs.getInt("likes");
	            String short_description = rs.getString("short_description");
	            String description = rs.getString("description");
	            Date recipe_reg_date = rs.getDate("recipe_reg_date");
	            
	            global_recipe = new Recipe();
	            global_recipe.setID(tmp_id);
	            global_recipe.setRecipe_name(recipe_name);
	            global_recipe.setRecipe_image_path(recipe_image_path);
	            global_recipe.setRecipe_video_path(recipe_video_path);
	            global_recipe.setLikes(likes);
	            global_recipe.setShort_description(short_description);
	            global_recipe.setDescription(description);
	            global_recipe.setRecipe_reg_date(recipe_reg_date);
		        
	            recipes.put(global_recipe.getID(), global_recipe);
	            
	            //System.out.println(global_recipe.toString());
		        
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
	
	public void findRecipeByUserAndRecipeNameDate(User user, Recipe recipe)
	{
        String sql;
        sql = "SELECT recipes.ID, recipes.recipe_name, " +
			  "recipes.recipe_image_path, recipes.recipe_video_path, " +
			  "recipes.likes, recipes.short_description, recipes.description, recipes.recipe_reg_date " +
			  "FROM recipes.recipes, recipes.users, recipes.user_recipes " +
			  "WHERE recipe_name = ? AND recipe_reg_date = ? " +
			  "AND users.ID = ? " +
			  "AND ur_recipe_id = recipes.ID " +
			  "AND users.ID = ur_user_id;";
		
		Connection conn = null;
		PreparedStatement preparedStmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		   
		try 
		{
			// Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");
	         
	        // Open a connection
		    conn = DriverManager.getConnection(connectionInfo.get_db_url(), connectionInfo.get_user(), connectionInfo.get_passw());
		         
	         // Execute SQL query
	        stmt = conn.createStatement();
	         
	        preparedStmt = conn.prepareStatement(sql);
	         
	        preparedStmt.setString(1, recipe.getRecipe_name());
	        preparedStmt.setDate(2, recipe.getRecipe_reg_date());
	        preparedStmt.setInt(3, user.getID());
	        	         
	        rs = preparedStmt.executeQuery();
	         
	        while(rs.next())
	        {
	            //Retrieve by column name
	            int tmp_id = rs.getInt("ID");
	            String recipe_name = rs.getString("recipe_name");
	            String recipe_image_path = rs.getString("recipe_image_path");;
	            String recipe_video_path = rs.getString("recipe_video_path");
	            int likes = rs.getInt("likes");
	            String short_description = rs.getString("short_description");
	            String description = rs.getString("description");
	            Date recipe_reg_date = rs.getDate("recipe_reg_date");
	            
	            global_recipe = new Recipe();
	            global_recipe.setID(tmp_id);
	            global_recipe.setRecipe_name(recipe_name);
	            global_recipe.setRecipe_image_path(recipe_image_path);
	            global_recipe.setRecipe_video_path(recipe_video_path);
	            global_recipe.setLikes(likes);
	            global_recipe.setShort_description(short_description);
	            global_recipe.setDescription(description);
	            global_recipe.setRecipe_reg_date(recipe_reg_date);
		        
	            //System.out.println(global_recipe.toString());
		        
	         }
	        
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
	
	public void addRecipe(User user, Recipe newRecipe)
	{
        String sql;
        sql = "INSERT INTO recipes.recipes (recipe_name, recipe_image_path, recipe_video_path, likes, short_description, description, recipe_reg_date) "
        		+ "VALUES(?, ?, ?, ?, ?, ?, ?);";
		
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
	         
	        preparedStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStmt.setString(1, newRecipe.getRecipe_name());
	        preparedStmt.setString(2, newRecipe.getRecipe_image_path());
	        preparedStmt.setString(3, newRecipe.getRecipe_video_path());
	        preparedStmt.setInt(4, newRecipe.getLikes());
	        preparedStmt.setString(5, newRecipe.getShort_description());
	        preparedStmt.setString(6, newRecipe.getDescription());
	        preparedStmt.setDate(7, newRecipe.getRecipe_reg_date());
	        	         
	        preparedStmt.executeUpdate();
			
	        ResultSet rs = preparedStmt.getGeneratedKeys();
	        int newRecipeID = -1;
	        if(rs.next())
	        {
	        	newRecipeID = rs.getInt(1);
	        }
	        else 
	        {
                System.out.println("Creating user failed, no ID obtained.");
            }
	        
	        UserRecipeRelationDB tmp = new UserRecipeRelationDB(connectionInfo);
	        newRecipe.setID(newRecipeID);
	        tmp.addUserRecipeRelation(user, newRecipe);
	        
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
	
	public void updateRecipe(Recipe newRecipe)
	{
        String sql;
        sql = "UPDATE recipes.recipes SET " +
        	  "recipe_name = ?, " +
			  "recipe_image_path = ?, " +
			  "recipe_video_path = ?, " +
			  "recipes.likes = ?, " +
			  "recipes.short_description = ?, " +
			  "recipes.description = ?, " +
			  "recipe_reg_date = ? " +
			  "WHERE recipes.recipes.ID = ?;";
		
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
	         
	        
	        preparedStmt.setString(1, newRecipe.getRecipe_name());
	        preparedStmt.setString(2, newRecipe.getRecipe_image_path());
	        preparedStmt.setString(3, newRecipe.getRecipe_video_path());
	        preparedStmt.setInt(4, newRecipe.getLikes());
	        preparedStmt.setString(5, newRecipe.getShort_description());
	        preparedStmt.setString(6, newRecipe.getDescription());
	        preparedStmt.setDate(7, newRecipe.getRecipe_reg_date());
	        preparedStmt.setInt(8, newRecipe.getID());
	        
	        	         
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
	
	public void deleteRecipe(Recipe recipe)
	{
        String sql;
        sql = "DELETE FROM recipes.recipes WHERE recipes.ID = ?;";
		
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
	         
	        preparedStmt.setInt(1, recipe.getID());
	        	         
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
	
	
	
	public Recipe getRecipe() {
		return global_recipe;
	}
	
	public ArrayList<Recipe> getArrayListOfREcipes()
	{
		if(recipes != null)
		{
			Collection<Recipe> values = recipes.values();
			recipes_list = new ArrayList<Recipe>(values);
		}
				
		return recipes_list;
	}

	public HashMap<Integer, Recipe> getRecipes() {
		return recipes;
	}
}
