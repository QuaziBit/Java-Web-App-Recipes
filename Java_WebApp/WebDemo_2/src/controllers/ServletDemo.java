package controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.*;
import model.Recipe;
import model.User;

/**
 * Servlet implementation class ServletDemo
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	
	
	/*
	private DatabaseAccess dbAccess = new DatabaseAccess();
	private DatabaseAccessUpdate dbAccessUpdate = new DatabaseAccessUpdate();
	private DatabaseAccessDelete dbAccessDelete = new DatabaseAccessDelete();
	private DatabaseAccessInsert dbAccessInsert = new DatabaseAccessInsert();
	*/
	
	// Set response content type
	private String responseType = "text/html";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.setContentType(responseType);
		
		response.setContentType(responseType);
		
		//DatabaseAccess
		ConnectionInfo connectionInfo = new ConnectionInfo(null, null, null, null);
		
		//Users
		UserDB userDB = new UserDB(connectionInfo);
		RecipeDB recipeDB  = new RecipeDB(connectionInfo);
		UserRecipeRelationDB userRecipeRelationDB = new UserRecipeRelationDB(connectionInfo);
		
		//User Tests
		//=============================================//
		
		/*
		userDB.findAllUsers();
		userDB.findUserByID(1);
		*/
		
		
		/*
		String str = "2017-11-30";
		Date date = Date.valueOf(str);
		
		User someUser = new User();
		someUser.setF_name("F_Name");
		someUser.setL_name("L_Name");
		someUser.setUser_name("User Name");
		someUser.setUser_password("User Password");
		someUser.setUser_email("User Email");
		someUser.setUser_image_path(null);
		someUser.setUser_reg_date(date);
		
		userDB.findUserByFirstLastName(someUser);
		userDB.findUserByUserName(someUser);
		userDB.findUserByEmail(someUser);
		*/
		
		
		/*
		String str = "2017-12-07";
		Date date = Date.valueOf(str);
		
		User newUser = new User();
		newUser.setF_name("Alex");
		newUser.setL_name("Matveyev");
		newUser.setUser_name("ADMIN");
		newUser.setUser_password("BLABLABLA");
		newUser.setUser_email("ALEX@gmail.com");
		newUser.setUser_image_path(null);
		newUser.setUser_reg_date(date);
		
		userDB.addUser(newUser);
		userDB.findAllUsers();
		*/
		
		
		/*
		String str = "2017-12-07";
		Date date = Date.valueOf(str);
		
		User user = new User();
		user.setF_name("Olexandr");
		user.setL_name("Matveyev");
		user.setUser_name("ADMIN");
		user.setUser_password("BLABLABLA");
		user.setUser_email("ALEX@gmail.com");
		user.setUser_image_path(null);
		user.setUser_reg_date(date);
		
		User currentUser = null;
		userDB.findUserByFnameLnameEmail(user);
		currentUser = userDB.getUser();
		
		User updatedUser = currentUser;
		updatedUser.setF_name("Olexandr");
		updatedUser.setL_name("Matveyev");
		
		userDB.updateUser(updatedUser);
		userDB.findUserByFirstLastName(updatedUser);
		*/
		
		
		/*
		String str = "2017-12-02";
		Date date = Date.valueOf(str);
		
		User someUser = new User();
		someUser.setF_name("Olexandr");
		someUser.setL_name("Matveyev");
		someUser.setUser_name("ADMIN");
		someUser.setUser_password("BLABLABLA");
		someUser.setUser_email("ALEX@gmail.com");
		someUser.setUser_image_path(null);
		someUser.setUser_reg_date(date);
		
		userDB.deleteUser(someUser);
		userDB.findAllUsers();
		System.out.println();
		*/
		
		
		/*
		String str = "2017-11-30";
		Date date = Date.valueOf(str);
		
		User someUser = new User();
		someUser.setF_name("Updated 2");
		someUser.setL_name("Updated 2");
		someUser.setUser_name(null);
		someUser.setUser_password(null);
		someUser.setUser_email("Updated 2");
		someUser.setUser_image_path(null);
		someUser.setUser_reg_date(null);
		
		userDB.findUserAndRecepes(someUser);
		*/
		
		
		/*
		recipeDB.findRecipeByID(4);
		userDB.findUserByRecipe(recipeDB.getRecipe());
		*/
		
		//=============================================//
		
		//Recipe Relations Tests
		//=============================================//
		
		/*
		userDB.findUserByID(1);
		userRecipeRelationDB.findAllUserRecipeRelations(userDB.getUser());
		*/
		
		
		//=============================================//
		
		//Recipe Tests
		//=============================================//
		
		/*
		recipeDB.findAllRecipes();
		*/
		
		
		/*
		Recipe someRecipe = new Recipe();
		someRecipe.setRecipe_name("recipe 1");
		
		recipeDB.findRecipeByName(someRecipe);
		*/
		
		
		//Add new Recipe
		/*
		String str = "2017-11-30";
		Date date = Date.valueOf(str);
		
		User someUser = new User();
		someUser.setF_name("F_Name");
		someUser.setL_name("L_Name");
		someUser.setUser_name("User Name");
		someUser.setUser_password("User Password");
		someUser.setUser_email("User Email");
		someUser.setUser_image_path(null);
		someUser.setUser_reg_date(date);
		
		userDB.findUserByFnameLnameEmail(someUser);
		User tmp_user = userDB.getUser();
		
		
		String str_2 = "2017-12-09";
		Date date_2 = Date.valueOf(str_2);
		
		Recipe newRecipe = new Recipe();
		newRecipe.setRecipe_name("Stuffed Chicken Valentino");
		newRecipe.setRecipe_image_path("NULL");
		newRecipe.setRecipe_video_path("NULL");
		newRecipe.setLikes(0);
		newRecipe.setShort_description("This is a dish to serve guests--be ready to impress! Good enough to be served at a high-priced restaurant, but easy enough to make yourself. Creamy mozzarella and roasted red peppers make the dish really special. Serve over pasta with Alfredo sauce.");
		newRecipe.setDescription("1: Preheat oven to 350 degrees F (175 degrees C). Slice a chicken breast in half lengthwise, leaving the halves attached on one side: opened and laid flat, the chicken breast should resemble a butterfly. Place between two sheets of plastic wrap, and pound flat. Repeat with remaining chicken breasts. 2: Combine Parmesan cheese with Italian seasoning and chives, and sprinkle over chicken breasts. At one end of each breast, place 3 strips of roasted pepper. Top with 1 tablespoon shredded cheese. Roll each breast up, starting on the side with the peppers and cheese. Insert a toothpick in each roll to prevent unrolling. Place in prepared baking dish. Season rolls with salt and pepper to taste, and drizzle with olive oil. 3: Bake in preheated oven for 15 minutes. Set oven to broil, and continue cooking for 5 to 10 minutes. Remove from oven, slice to display the colorful filling, and serve.");
		newRecipe.setRecipe_reg_date(date_2);
		
		recipeDB.addRecipe(tmp_user, newRecipe);
		recipeDB.findAllRecipes();
		*/
		
		
		
		
		//Delete Recipe
		/*
		String str = "2017-11-30";
		Date date = Date.valueOf(str);
		
		User someUser = new User();
		someUser.setF_name("F_Name");
		someUser.setL_name("L_Name");
		someUser.setUser_name("User Name");
		someUser.setUser_password("User Password");
		someUser.setUser_email("User Email");
		someUser.setUser_image_path(null);
		someUser.setUser_reg_date(date);
		
		userDB.findUserByFnameLnameEmail(someUser);
		User tmp_user = null;
		tmp_user = userDB.getUser();
		
		String str_2 = "2018-10-05";
		Date date_2 = Date.valueOf(str_2);
		
		Recipe someRecipe = new Recipe();
		someRecipe.setRecipe_name("recipe 5");
		someRecipe.setRecipe_image_path("Image Path");
		someRecipe.setRecipe_video_path(null);
		someRecipe.setLikes(5);
		someRecipe.setDescription("Recipe 5: Description");
		someRecipe.setRecipe_reg_date(date_2);
		
		Recipe tmp_recipe = null;
		recipeDB.findRecipeByUserAndRecipeNameDate(tmp_user, someRecipe);
		tmp_recipe = recipeDB.getRecipe();
		
		userRecipeRelationDB.deleteUserRecipeRelation(tmp_user, tmp_recipe);
		recipeDB.deleteRecipe(tmp_recipe);
		recipeDB.findAllRecipes();
		*/
		
		
		//Update recipe
		/*
		String str = "2017-11-30";
		Date date = Date.valueOf(str);
		
		User someUser = new User();
		someUser.setF_name("First Name 2");
		someUser.setL_name("Last Name 2");
		someUser.setUser_name("user 2");
		someUser.setUser_password("password_2");
		someUser.setUser_email("email_2@email.com");
		someUser.setUser_image_path("user image 2");
		someUser.setUser_reg_date(date);
		
		userDB.findUserByFnameLnameEmail(someUser);
		User tmp_user = null;
		tmp_user = userDB.getUser();
		
		String str_2 = "2017-01-02";
		Date date_2 = Date.valueOf(str_2);
		
		Recipe someRecipe = new Recipe();
		someRecipe.setRecipe_name("Recipe 2");
		someRecipe.setRecipe_image_path("NULL");
		someRecipe.setRecipe_video_path("NULL");
		someRecipe.setLikes(50);
		someRecipe.setShort_description(null);
		someRecipe.setDescription("Recipe 2: Description");
		someRecipe.setRecipe_reg_date(date_2);
		
		Recipe tmp_recipe = null;
		recipeDB.findRecipeByUserAndRecipeNameDate(tmp_user, someRecipe);
		tmp_recipe = recipeDB.getRecipe();
		
		
		String str_3 = "2017-12-09";
		Date date_3 = Date.valueOf(str_3);
		
		//Updating current recipe
		tmp_recipe.setRecipe_name("Just Like Wendy's Chili");
		tmp_recipe.setRecipe_image_path("2");
		tmp_recipe.setRecipe_video_path("1");
		tmp_recipe.setLikes(0);
		tmp_recipe.setShort_description("After trying several clone recipes and adjusting them to my tastes, I've concocted what I think is the best clone. Serve topped with finely diced white onions and/or shredded cheese. Enjoy!");
		tmp_recipe.setDescription("1: Heat olive oil in a large pot over medium-high heat. Press ground beef into the hot oil to form one large patty; let the bottom brown, 8 to 10 minutes. Stir and break the ground beef into crumbles and cook until no longer pink, about 5 more minutes. 2: Stir celery, onion, and green bell pepper into ground beef and cook until onion is translucent, about 5 minutes; pour in stewed tomatoes, diced tomatoes with green chiles, tomato sauce, and water. Break apart large chunks of stewed tomatoes. Stir in chili seasoning. 3: Mix kidney beans and pinto beans into chili, season with salt and black pepper, and bring to a boil. Reduce heat to low and simmer for 1 hour. Mix vinegar into chili.");
		tmp_recipe.setRecipe_reg_date(date_3);
		
		recipeDB.updateRecipe(tmp_recipe);
		recipeDB.findAllRecipes();
		*/
		
		//find Recipes In Limit Range
		/*
		int start = 0;
		int end = 5;
		recipeDB.findRecipesInLimitRange(start, end);
		*/
		
		
		
		//=============================================//
		
		System.out.println();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
