package utilities;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Created by Ionescu Radu Stefan //

public class DatabaseConnection
{
	public static Connection getConnection()
	{
		Connection connection = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e)
		{
			Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "MySql JDBC Driver Fail", e);
		}
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carexpress?autoReconnect=true&useSSL=false", "admin", "carexpressadmin");
		}
		catch(SQLException e)
		{
			Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Database Connection Fail", e);
		}
		return connection;
	}
}