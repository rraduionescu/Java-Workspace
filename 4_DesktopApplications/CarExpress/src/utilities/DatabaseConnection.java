package utilities;

import classes.Vehicle;
import java.sql.*;
import java.util.ArrayList;
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
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://172.20.10.9:3306/carexpress?autoReconnect=true&useSSL=false", "admin", "carexpressadmin");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }
}