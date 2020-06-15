package html_generator;

import java.sql.Date;

import model.*;

public class GenerateHTML 
{
	private int current_page = 0;
	private int total_pages = 0;

	public GenerateHTML()
	{
		
	}
	
	public String generateIndexPage()
	{
		String html = null;
		
		html = "";
		
		return null;
	}
	
	public String generateSearchPage()
	{
		String html = null;
		
		html = "";
		
		return null;
	}
	
	public String generateLoginPage()
	{
		String html = null;
		
		html = "";
		
		return null;
	}
	
	public String generateRegistrationPage()
	{
		String html = null;
		
		html = "";
		
		return null;
	}
	
	public String generateRecipes(Recipe recipe)
	{
		String html = null;
		
		int ID = recipe.getID();
		String recipe_name = recipe.getRecipe_name();
		String recipe_image_path = recipe.getRecipe_image_path();
		String recipe_video_path = recipe.getRecipe_video_path();
		int likes = recipe.getLikes();
		String short_description = recipe.getShort_description();
		String description = recipe.getDescription();
		Date recipe_reg_date = recipe.getRecipe_reg_date();
		
		
		html = 
				"<div id='r_" + ID + "' class='recipe_block'>" +
				"<img src='" + recipe_image_path + "' class='scale_img'>" +
				"<p class='recipe_name_container'>" + recipe_name + "</p>" +
				"<p class='recipe_desc_container'>" + short_description + "</p>" +
				"<p class='recipe_likes_container'> Likes: " + likes + "</p>" +
				"<p class='recipe_details_container'>" +
					"<a href='#'>RECIPE DETAILS</a>" +
				"</p>" +
				"</div>";
		
		return html;
	}
	
	public String generateEmptyRecipes()
	{
		String html = null;
		
		html = 
				"<div id='' class='recipe_block'>" +
				"<img src='images/recipe_images/no_image.jpg' class='scale_img'>" +
				"<p class='recipe_name_container'> No Recipe </p>" +
				"<p class='recipe_desc_container'> No Recipe </p>" +
				"<p class='recipe_likes_container'> Likes: No Recipe </p>" +
				"<p class='recipe_details_container'>" +
					"<a href='#'>RECIPE DETAILS</a>" +
				"</p>" +
				"</div>";
		
		return html;
	}
	
	public String generatePageNum()
	{
		String recipe_html = null;

		recipe_html = "<p class='num_of_pages'> Page: " + current_page + " out of: " + total_pages + "</p>";
		
		return recipe_html;
	}
	
	public String generateRegistrationMessage(boolean success)
	{
		String recipe_html = null;
		
		if(success)
		{
			String message = "Your account was successfully created, please click Login in order to login to your account.";
			recipe_html = "<span class='success'>" + message + "</span>";
		}
		else 
		{
			String message = "We was not able to create an account for you.";
			recipe_html = "<span class='failure'>" + message + "</span>";
		}
		
		return recipe_html;
	}
	
	public String generateLoginMessage()
	{
		String recipe_html = null;
		
		String message = "We was not able to find your account information";
		recipe_html = "<span class='failure'>" + message + "</span>";
		
		return recipe_html;
	}
	
	
	
	
	public void setCurrentPageNum(int current_page) {
		this.current_page = current_page;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
}
