package logic;

import java.util.HashMap;

import database.ConnectionInfo;
import database.RecipeDB;
import database.UserDB;
import database.UserRecipeRelationDB;
import html_generator.GenerateHTML;
import model.Recipe;

public class SearchLogic 
{
	private ConnectionInfo connectionInfo = null;
	private UserDB userDB = null;
	private RecipeDB recipeDB  = null;
	private UserRecipeRelationDB userRecipeRelationDB = null;
	
	private GenerateHTML generateHTML = null;
	private HashMap<Integer, Recipe> recipes = null;
	
	private int max_offset = 0;
	private int offset = 0;
	private int current_page = 1;
	private int total_pages = 0;
	
	public SearchLogic()
	{
		connectionInfo = new ConnectionInfo(null, null, null, null);
		userDB = new UserDB(connectionInfo);
		recipeDB  = new RecipeDB(connectionInfo);
		
		generateHTML = new GenerateHTML();
	}
	
	public String firstLoad()
	{
		current_page = 1;
		
		String output_html = "";
		
		Recipe tmp_r = new Recipe();
		tmp_r.setRecipe_name("NULL");
		
		recipeDB.findRecipeByNameLIKE(tmp_r);
		recipes = recipeDB.getRecipes();
		
		if(!recipes.isEmpty() && recipes != null)
		{
	        for(HashMap.Entry<Integer, Recipe> pair : recipes.entrySet())
	        {
	        	output_html += generateHTML.generateRecipes(pair.getValue());
	        }
		}
		System.out.println("offset: " + offset);
		
		if(output_html.length() < 1)
		{
			output_html = generateHTML.generateEmptyRecipes();
		}
		
		int tmp_offset = recipeDB.getRecipes().size();
		if( (tmp_offset % 5) == 0)
		{
			max_offset = tmp_offset;
			total_pages = (max_offset / 5);
		}
		else
		{
			max_offset = tmp_offset - (tmp_offset % 5);
			total_pages = (max_offset / 5) + 1;
		}
		generateHTML.setTotal_pages(total_pages);
		
		return output_html;
	}
	
	public String searchRecipes(String entered_val)
	{
		String output_html = "";
		
		Recipe recipe = new Recipe();
		recipe.setRecipe_name(entered_val);
		recipeDB.findRecipeByNameLIKE(recipe);
		
		recipes = recipeDB.getRecipes();
		
		int counter = 0;
		if(!recipes.isEmpty() && recipes != null)
		{
			//Have to be fixed to prevent looping via all records
	        for(HashMap.Entry<Integer, Recipe> pair : recipes.entrySet())
	        {
	        	if(counter < 5)
	        	{
		        	output_html += generateHTML.generateRecipes(pair.getValue());
	        	}
	        	counter++;
	        }
		}
		
		if(output_html.length() < 1)
		{
			output_html = generateHTML.generateEmptyRecipes();
		}
		
		int tmp_offset = recipes.size();
		if( (tmp_offset % 5) == 0)
		{
			max_offset = tmp_offset;
			total_pages = (max_offset / 5);
		}
		else
		{
			max_offset = tmp_offset - (tmp_offset % 5);
			total_pages = (max_offset / 5) + 1;
		}
		
		offset = 0;
		current_page = 1;
		
		generateHTML.setTotal_pages(total_pages);
		
		return output_html;
	}
	
	public String nextRecipes()
	{
		String output_html = "";
		
		if(offset < max_offset && offset >= 0)
		{
			offset += 5;
							
			if(!recipes.isEmpty() && recipes != null)
			{
		        for(HashMap.Entry<Integer, Recipe> pair : recipes.entrySet())
		        {
		        	if(pair.getValue().getID() > offset && pair.getValue().getID() <= (offset + 5))
		        	{
			        	output_html += generateHTML.generateRecipes(pair.getValue());
		        	}
		        }
			}
			
			current_page += 1;
		}

		return output_html;
	}
	
	public String lastRecipes()
	{
		String output_html = "";
		
		if(offset <= max_offset && offset > 0)
		{
			offset -= 5;
			
			if(!recipes.isEmpty() && recipes != null)
			{
		        for(HashMap.Entry<Integer, Recipe> pair : recipes.entrySet())
		        {
		        	if(pair.getValue().getID() > offset && pair.getValue().getID() <= (offset + 5))
		        	{
			        	output_html += generateHTML.generateRecipes(pair.getValue());
		        	}
		        }
			}
			current_page -= 1;
		}
		
		return output_html;
	}
	
	public String pageNums()
	{
		String output_html = "";

		generateHTML.setCurrentPageNum(current_page);
		output_html = generateHTML.generatePageNum();
		
		return output_html;
	}
}
