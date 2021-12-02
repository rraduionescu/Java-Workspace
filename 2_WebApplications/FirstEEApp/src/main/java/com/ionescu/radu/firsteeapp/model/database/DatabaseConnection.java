// @author Ionescu Radu
// @date 28.11.2021
package com.ionescu.radu.firsteeapp.model.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection
{
	protected static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bfk_db", "root", "qweasdzxc");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}
}