/*//[1]==========================//*/
/*
INSERT INTO images (image_path)
VALUES('image 1');
INSERT INTO images (image_path)
VALUES('image 2');
INSERT INTO images (image_path)
VALUES('image 3');
INSERT INTO images (image_path)
VALUES('image 4');
INSERT INTO images (image_path)
VALUES('image 5');
*/

/*//[2]==========================//*/
/*
INSERT INTO ingredients (ingredient_name, ingr_image_id, nutrition_fact_id)
VALUES('ingredient name 1', null, null);
INSERT INTO ingredients (ingredient_name, ingr_image_id, nutrition_fact_id)
VALUES('ingredient name 2', null, null);
INSERT INTO ingredients (ingredient_name, ingr_image_id, nutrition_fact_id)
VALUES('ingredient name 3', null, null);
INSERT INTO ingredients (ingredient_name, ingr_image_id, nutrition_fact_id)
VALUES('ingredient name 4', null, null);
INSERT INTO ingredients (ingredient_name, ingr_image_id, nutrition_fact_id)
VALUES('ingredient name 5', null, null);
*/

/*//[3]==========================//*/
/*
INSERT INTO recipes (recipe_name, image_id, video_id, likes, description)
VALUES('recipe 1', 1, null, 3, "Recipe 1: Description");
INSERT INTO recipes (recipe_name, image_id, video_id, likes, description)
VALUES('recipe 2', 2, null, 4, "Recipe 2: Description");
INSERT INTO recipes (recipe_name, image_id, video_id, likes, description)
VALUES('recipe 3', 3, null, 5, "Recipe 3: Description");
INSERT INTO recipes (recipe_name, image_id, video_id, likes, description)
VALUES('recipe 4', 5, null, 5, "Recipe 4: Description");
*/

/*//[4]==========================//*/
/*
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(1, 1);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(1, 2);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(1, 3);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(1, 5);

INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(2, 1);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(2, 4);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(2, 1);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(2, 3);

INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(3, 2);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(3, 4);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(3, 4);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(3, 5);

INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(4, 1);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(4, 2);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(4, 3);
INSERT INTO recipe_ingredients (ri_recipe_id, ri_ingredient_id)
VALUE(4, 4);
*/


/*[5]==========================*/
/*
INSERT INTO users (first_name, last_name, user_name, user_password, user_email, user_image_paht)
VALUES('First Name 1', 'Last Name 1', 'user 1', 'password_1', 'email_1@email.com', 'user image 1');
INSERT INTO users (first_name, last_name, user_name, user_password, user_email, user_image_paht)
VALUES('First Name 2', 'Last Name 2', 'user 2', 'password_2', 'email_2@email.com', 'user image 2');
INSERT INTO users (first_name, last_name, user_name, user_password, user_email, user_image_paht)
VALUES('First Name 3', 'Last Name 3', 'user 3', 'password_3', 'email_3@email.com', 'user image 3');
*/

/*[5_1]==========================*/
/*
INSERT INTO user_recipes (ur_user_id, ur_recipe_id)
VALUES(1,1);
INSERT INTO user_recipes (ur_user_id, ur_recipe_id)
VALUES(2,2);
INSERT INTO user_recipes (ur_user_id, ur_recipe_id)
VALUES(3,3);
INSERT INTO user_recipes (ur_user_id, ur_recipe_id)
VALUES(1,4);
*/






