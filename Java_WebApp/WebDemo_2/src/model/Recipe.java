package model;

import java.util.HashMap;
import java.sql.Date;

public class Recipe 
{
	private int ID = 0;
	private String recipe_name = "";
	private String recipe_image_path = "";
	private String recipe_video_path = "";
	private int likes = 0;
	private String short_description = "";
	private String description = "";
	private Date recipe_reg_date = null;

	private User user = null; 
	private HashMap<Integer, User_Recipe> recipeToUser = null;
	
	public Recipe()
	{
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public String getRecipe_image_path() {
		return recipe_image_path;
	}

	public void setRecipe_image_path(String recipe_image_path) {
		this.recipe_image_path = recipe_image_path;
	}

	public String getRecipe_video_path() {
		return recipe_video_path;
	}

	public void setRecipe_video_path(String recipe_video_path) {
		this.recipe_video_path = recipe_video_path;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRecipe_reg_date() {
		return recipe_reg_date;
	}

	public void setRecipe_reg_date(Date recipe_reg_date) {
		this.recipe_reg_date = recipe_reg_date;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HashMap<Integer, User_Recipe> getRecipeToUser() {
		return recipeToUser;
	}

	public void setRecipeToUser(HashMap<Integer, User_Recipe> recipeToUser) {
		this.recipeToUser = recipeToUser;
	}
	
	@Override
	public String toString()
	{
		return (ID + "; " + recipe_name + "; " + recipe_image_path + "; " + recipe_video_path + "; " + likes + "; " + short_description + "; " + description + "; " + recipe_reg_date.toString());
	}
	
	
}
