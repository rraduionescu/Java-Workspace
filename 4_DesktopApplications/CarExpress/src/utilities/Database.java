package utilities;

import classes.Centre;
import classes.Client;
import classes.Option;
import classes.OptionRow;
import classes.Rental;
import classes.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

// Created by Ionescu Radu Stefan //

public class Database
{
    private final Connection databaseConnection = DatabaseConnection.getConnection();
    private PreparedStatement statement;
    
    public void insertOption(String name, String price, String description)
    {
        String query = "INSERT INTO carexpress.option VALUES('"+name+"','"+price+"','"+description+"');";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            statement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //<editor-fold desc="SELECT">
    public ArrayList<Vehicle> getVehicles()
    {
        ResultSet results;
        String query = "SELECT * FROM carexpress.vehicle;";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            results = statement.executeQuery();
            return convertVehicles(results);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Centre> getCentres()
    {
        ResultSet results;
        String query = "SELECT * FROM carexpress.centre;";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            results = statement.executeQuery();
            return convertCentres(results);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Rental> getRentals()
    {
        ResultSet results;
        String query = "SELECT * FROM carexpress.rental;";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            results = statement.executeQuery();
            return convertRentals(results);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Client> getClients()
    {
        ResultSet results;
        String query = "SELECT * FROM carexpress.client;";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            results = statement.executeQuery();
            return convertClients(results);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Option> getOptions()
    {
        ResultSet results;
        String query = "SELECT * FROM carexpress.option;";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            results = statement.executeQuery();
            return convertOptions(results);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<OptionRow> getOptionRows()
    {
        ResultSet results;
        String query = "SELECT * FROM carexpress.option_row;";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            results = statement.executeQuery();
            return convertOptionRows(results);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //</editor-fold>
    
    //<editor-fold desc="DELETE">
    public void deleteCentre(String idCentre)
    {
        String query = "DELETE FROM carexpress.centre WHERE id_centre='"+idCentre+"';";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            statement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void deleteOptionRow(String name, String idRental)
    {
        String query = "DELETE FROM carexpress.option_row WHERE id_rental='"+idRental+"' AND name='"+ name +"';";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            statement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void deleteOption(String name)
    {
        String query = "DELETE FROM carexpress.option WHERE name='"+name+"';";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            statement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void deleteClient(String idClient)
    {
        String query = "DELETE FROM carexpress.client WHERE id_client='"+idClient+"';";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            statement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void deleteRental(String idRental)
    {
        String query = "DELETE FROM carexpress.rental WHERE id_rental='"+idRental+"';";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            statement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void deleteVehicle(String idVehicle)
    {
        String query = "DELETE FROM carexpress.vehicle WHERE id_vehicle='"+idVehicle+"';";
        try
        {
            statement = databaseConnection.prepareStatement(query);
            statement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //</editor-fold>
    
    //<editor-fold desc="CONVERSIONS">
    public static ArrayList<Vehicle> convertVehicles(ResultSet results) throws SQLException
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ResultSetMetaData resultSetMetaData = results.getMetaData();

        while (results.next())
        {
            int numColumns = resultSetMetaData.getColumnCount();
            Vehicle v = new Vehicle();

            for (int i = 1; i < numColumns + 1; i++)
            {
                String column_name = resultSetMetaData.getColumnName(i);

                if (column_name.compareTo("id_vehicle") == 0)
                {
                    v.setIdVehicle(results.getString(column_name));
                }
                else if (column_name.compareTo("make") == 0)
                {
                    v.setMake(results.getString(column_name));
                }
                else if (column_name.compareTo("model") == 0)
                {
                    v.setModel(results.getString(column_name));
                }
                else if (column_name.compareTo("category") == 0)
                {
                    v.setCategory(results.getString(column_name));
                }
                else if (column_name.compareTo("power") == 0)
                {
                    v.setPower(results.getInt(column_name));
                }
                else if (column_name.compareTo("fuel") == 0)
                {
                    v.setFuel(results.getBoolean(column_name));
                }
                else if (column_name.compareTo("gearbox") == 0)
                {
                    v.setGearbox(results.getBoolean(column_name));
                }
                else if (column_name.compareTo("fuel_consumption") == 0)
                {
                    v.setFuelConsumption(results.getFloat(column_name));
                }
                else if (column_name.compareTo("trunk") == 0)
                {
                    v.setTrunk(results.getInt(column_name));
                }
                else if (column_name.compareTo("doors") == 0)
                {
                    v.setDoors(results.getInt(column_name));
                }
                else if (column_name.compareTo("price") == 0)
                {
                    v.setPrice(results.getFloat(column_name));
                }
                else if (column_name.compareTo("id_centre") == 0)
                {
                    v.setIdCentre(results.getString(column_name));
                }
            }
            vehicles.add(v);
        }
        return vehicles;
    }
    public static ArrayList<Centre> convertCentres(ResultSet results) throws SQLException
    {
        ArrayList<Centre> centres = new ArrayList<>();
        ResultSetMetaData resultSetMetaData = results.getMetaData();

        while (results.next())
        {
            int numColumns = resultSetMetaData.getColumnCount();
            Centre c = new Centre();

            for (int i = 1; i < numColumns + 1; i++)
            {
                String column_name = resultSetMetaData.getColumnName(i);

                if (column_name.compareTo("id_centre") == 0)
                {
                    c.setIdCentre(results.getString(column_name));
                }
                else if (column_name.compareTo("address") == 0)
                {
                    c.setAddress(results.getString(column_name));
                }
                else if (column_name.compareTo("phone_number") == 0)
                {
                    c.setPhone(results.getString(column_name));
                }
            }
            centres.add(c);
        }
        return centres;
    }
    public static ArrayList<Rental> convertRentals(ResultSet results) throws SQLException
    {
        ArrayList<Rental> rentals = new ArrayList<>();
        ResultSetMetaData resultSetMetaData = results.getMetaData();

        while (results.next())
        {
            int numColumns = resultSetMetaData.getColumnCount();
            Rental r = new Rental();

            for (int i = 1; i < numColumns + 1; i++)
            {
                String column_name = resultSetMetaData.getColumnName(i);

                if (column_name.compareTo("id_rental") == 0)
                {
                    r.setIdRental(Integer.parseInt(results.getString(column_name)));
                }
                else if (column_name.compareTo("id_centre") == 0)
                {
                    r.setIdCentre(results.getString(column_name));
                }
                else if (column_name.compareTo("id_client") == 0)
                {
                    r.setIdClient(results.getString(column_name));
                }
                else if (column_name.compareTo("id_vehicle") == 0)
                {
                    r.setIdVehicle(results.getString(column_name));
                }
                else if (column_name.compareTo("start_date") == 0)
                {
                    DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
                    Date date = new Date();
                    try
                    {
                        date = format.parse(results.getString(column_name));
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    r.setStart(date);
                }
                else if (column_name.compareTo("end_date") == 0)
                {
                    DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
                    Date date = new Date();
                    try
                    {
                        date = format.parse(results.getString(column_name));
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    r.setEnd(date);
                }
            }
            rentals.add(r);
        }
        return rentals;
    }
    public static ArrayList<Client> convertClients(ResultSet results) throws SQLException
    {
        ArrayList<Client> clients = new ArrayList<>();
        ResultSetMetaData resultSetMetaData = results.getMetaData();

        while (results.next())
        {
            int numColumns = resultSetMetaData.getColumnCount();
            Client c = new Client();

            for (int i = 1; i < numColumns + 1; i++)
            {
                String column_name = resultSetMetaData.getColumnName(i);

                if (column_name.compareTo("first_name") == 0)
                {
                    c.setFirstName(results.getString(column_name));
                }
                else if (column_name.compareTo("last_name") == 0)
                {
                    c.setLastName(results.getString(column_name));
                }
                else if (column_name.compareTo("id_client") == 0)
                {
                    c.setIdClient(results.getString(column_name));
                }
            }
            clients.add(c);
        }
        return clients;
    }
    public static ArrayList<Option> convertOptions(ResultSet results) throws SQLException
    {
        ArrayList<Option> options = new ArrayList<>();
        ResultSetMetaData resultSetMetaData = results.getMetaData();

        while (results.next())
        {
            int numColumns = resultSetMetaData.getColumnCount();
            Option o = new Option();

            for (int i = 1; i < numColumns + 1; i++)
            {
                String column_name = resultSetMetaData.getColumnName(i);

                if (column_name.compareTo("name") == 0)
                {
                    o.setName(results.getString(column_name));
                }
                else if (column_name.compareTo("description") == 0)
                {
                    o.setDescription(results.getString(column_name));
                }
                else if (column_name.compareTo("price") == 0)
                {
                    o.setPrice(Float.parseFloat(results.getString(column_name)));
                }
            }
            options.add(o);
        }
        return options;
    }
    public static ArrayList<OptionRow> convertOptionRows(ResultSet results) throws SQLException
    {
        ArrayList<OptionRow> optionRows = new ArrayList<>();
        ResultSetMetaData resultSetMetaData = results.getMetaData();

        while (results.next())
        {
            int numColumns = resultSetMetaData.getColumnCount();
            OptionRow o = new OptionRow();

            for (int i = 1; i < numColumns + 1; i++)
            {
                String column_name = resultSetMetaData.getColumnName(i);

                if (column_name.compareTo("name") == 0)
                {
                    o.setName(results.getString(column_name));
                }
                else if (column_name.compareTo("id_rental") == 0)
                {
                    o.setIdRental(Integer.parseInt(results.getString(column_name)));
                }
                else if (column_name.compareTo("id_vehicle") == 0)
                {
                    o.setIdVehicle(results.getString(column_name));
                }
                else if (column_name.compareTo("id_client") == 0)
                {
                    o.setIdClient(results.getString(column_name));
                }
                else if (column_name.compareTo("id_centre") == 0)
                {
                    o.setIdCentre(results.getString(column_name));
                }
            }
            optionRows.add(o);
        }
        return optionRows;
    }
    //</editor-fold>
}
