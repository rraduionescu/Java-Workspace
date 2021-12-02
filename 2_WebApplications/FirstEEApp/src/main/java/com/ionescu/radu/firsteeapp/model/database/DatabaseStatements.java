// @author Ionescu Radu
// @date 28.11.2021
package com.ionescu.radu.firsteeapp.model.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseStatements
{
	public static ResultSet executeStatement(String statementString)
	{
		try
		{
			Connection connection = DatabaseConnection.getConnection();
			assert connection != null;
			Statement statement = connection.createStatement();
			statement.execute(statementString);
			return statement.getResultSet();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}