package logic;

import java.util.HashMap;

import database.ConnectionInfo;
import database.RecipeDB;
import database.UserDB;
import database.UserRecipeRelationDB;
import html_generator.GenerateHTML;
import model.Recipe;

public class IndexLogic 
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
	
	public IndexLogic()
	{
		connectionInfo = new ConnectionInfo(null, null, null, null);
		
		userDB = new UserDB(connectionInfo);
		recipeDB  = new RecipeDB(connectionInfo);
		generateHTML = new GenerateHTML();
	}
	
	public String firstLoad()
	{
		String output_html = "";
		
		recipeDB.findRecipesInLimitRange(5, offset);
		recipes = recipeDB.getRecipes();
		
		if(!recipes.isEmpty() && recipes != null)
		{
	        for(HashMap.Entry<Integer, Recipe> pair : recipes.entrySet())
	        {
	        	output_html += generateHTML.generateRecipes(pair.getValue());
	        }
		}
		
		int tmp_offset = recipeDB.totalNumberOfRecipes();
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
	
	public String nextRecipes()
	{
		String output_html = "";
		
		if(offset < max_offset && offset >= 0)
		{
			offset += 5;
			
			recipeDB.findRecipesInLimitRange(5, offset);
			recipes = recipeDB.getRecipes();
			
			if(!recipes.isEmpty() && recipes != null)
			{
		        for(HashMap.Entry<Integer, Recipe> pair : recipes.entrySet())
		        {
		        	output_html += generateHTML.generateRecipes(pair.getValue());
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
			
			recipeDB.findRecipesInLimitRange(5, offset);
			recipes = recipeDB.getRecipes();
			
			if(!recipes.isEmpty() && recipes != null)
			{
		        for(HashMap.Entry<Integer, Recipe> pair : recipes.entrySet())
		        {
		        	output_html += generateHTML.generateRecipes(pair.getValue());
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
