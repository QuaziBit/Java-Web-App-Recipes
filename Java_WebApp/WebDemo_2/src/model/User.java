package model;

import java.util.HashMap;
import java.sql.Date;

public class User 
{
	private int ID = 0;
	private String f_name = "";
	private String l_name = "";
	private String user_name = "";
	private String user_password = "";
	private String user_email = "";
	private String user_image_path = "";
	private Date user_reg_date = null;

	private HashMap<Integer, Recipe> recipes = null; 
	private HashMap<Integer, User_Recipe> recipeToUser = null;
	
	public User()
	{
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_image_path() {
		return user_image_path;
	}

	public void setUser_image_path(String user_image_path) {
		this.user_image_path = user_image_path;
	}

	public Date getUser_reg_date() {
		return user_reg_date;
	}

	public void setUser_reg_date(Date user_reg_date) {
		this.user_reg_date = user_reg_date;
	}
	
	public HashMap<Integer, Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(HashMap<Integer, Recipe> recipes) {
		this.recipes = recipes;
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
		return (ID + "; " + f_name + "; " + l_name + "; " + user_name + "; " + user_password + "; " + user_email + "; " + user_image_path + "; " + user_reg_date);
	}
}
