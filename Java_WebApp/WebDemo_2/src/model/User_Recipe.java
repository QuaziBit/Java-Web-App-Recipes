package model;

public class User_Recipe 
{
	//ID, ur_user_id, ur_recipe_id
	private int ID = 0;
	private int ur_user_id = 0;
	private int ur_recipe_id = 0;
	
	public User_Recipe()
	{
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getUr_user_id() {
		return ur_user_id;
	}

	public void setUr_user_id(int ur_user_id) {
		this.ur_user_id = ur_user_id;
	}

	public int getUr_recipe_id() {
		return ur_recipe_id;
	}

	public void setUr_recipe_id(int ur_recipe_id) {
		this.ur_recipe_id = ur_recipe_id;
	}
	
	
	
}
