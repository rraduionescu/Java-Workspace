// @author Ionescu Radu
// @date 28.11.2021
package com.ionescu.radu.firsteeapp.model.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUser
{
	public static void createUser(String email, String password, String firstName, String lastName) throws SQLException
	{
		Connection connection = DatabaseConnection.getConnection();
		assert connection != null;
		Statement statement = connection.createStatement();
		statement.execute("INSERT INTO user(email, password, first_name, last_name) VALUES('" + email + "', '" + password + "', '" + firstName + "', '" + lastName + "');");
	}

	public static boolean checkUser(String email, String password) throws SQLException
	{
		Connection connection = DatabaseConnection.getConnection();
		assert connection != null;
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT email, password FROM user WHERE email='" + email + "';");
		resultSet.next();
		String sqlPassword = resultSet.getString(2);
		return password.equals(sqlPassword);
	}
}