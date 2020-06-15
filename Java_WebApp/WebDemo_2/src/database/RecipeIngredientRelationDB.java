package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.sql.Date;

import model.Recipe;

public class RecipeIngredientRelationDB
{
	private ConnectionInfo connectionInfo = null;
	
	public RecipeIngredientRelationDB(ConnectionInfo connectionInfo)
	{
		this.connectionInfo = connectionInfo;
	}
	
	
}
