package servlets;

import com.sun.istack.internal.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utilities.DatabaseConnection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

// Created by Ionescu Radu Stefan //

@WebServlet(name = "Database", urlPatterns = {"/Database"})
public class Database extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		Connection databaseConnection;
		PreparedStatement statement;
		String query;
		String option;

		option = request.getParameter("option");
		databaseConnection = DatabaseConnection.getConnection();

		switch(option)
		{
			case "insert_client":
			{
				//<editor-fold desc="inserare client">
				String id_client = request.getParameter("id_client");
				String first_name = request.getParameter("first_name");
				String last_name = request.getParameter("last_name");

				query = "INSERT INTO client(id_client, first_name, last_name) VALUES ('" + id_client + "','" + first_name + "','" + last_name + "');";
				try
				{
					statement = databaseConnection.prepareStatement(query);
					statement.execute();
					System.out.println("INFO: - client " + id_client + " inserted in table");
				}
				catch(SQLIntegrityConstraintViolationException s)
				{
					System.out.println("INFO: - client " + id_client + " already exists in table");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
				//</editor-fold>
			}
			case "insert_address":
			{
				//<editor-fold desc="inserare adresa">
				String id_client = request.getParameter("id_client");
				String address = request.getParameter("address");

				query = "UPDATE client SET address='"+address+"' WHERE id_client='"+id_client+"';";
				try
				{
					statement = databaseConnection.prepareStatement(query);
					statement.execute();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
				//</editor-fold>
			}
			case "insert_option_row":
			{
				//<editor-fold desc="inserare rand optiune">
				String name = request.getParameter("name");
				String id_rental = request.getParameter("id_rental");
				String id_vehicle = request.getParameter("id_vehicle");
				String id_client = request.getParameter("id_client");
				String id_centre = request.getParameter("id_centre");
				query = "INSERT INTO option_row VALUES ('" + name + "','" + id_rental + "','" + id_vehicle + "','" + id_client + "','" + id_centre + "');";
				try
				{
					statement = databaseConnection.prepareStatement(query);
					statement.execute();
					System.out.println("INFO: - option_row " + name + " inserted in table");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
				//</editor-fold>
			}
			case "insert_rental":
			{
				//<editor-fold desc="inserare inchiriere">
				String start_date = request.getParameter("start_date");
				String end_date = request.getParameter("end_date");
				String id_vehicle = request.getParameter("id_vehicle");
				String id_client = request.getParameter("id_client");
				String id_centre = request.getParameter("id_centre");

				query = "INSERT INTO rental ( start_date, end_date, id_vehicle, id_client, id_centre) VALUES ('" + start_date + "','" + end_date + "','" + id_vehicle + "','" + id_client + "','" + id_centre + "');";
				try
				{
					statement = databaseConnection.prepareStatement(query);
					statement.execute();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				query = "SELECT * FROM rental WHERE ( start_date='" + start_date + "' AND end_date='" + end_date + "' AND id_vehicle='" + id_vehicle + "' AND id_client='" + id_client + "' AND id_centre='" + id_centre + "');";
				try
				{
					ResultSet results;
					PrintWriter writer = response.getWriter();
					statement = databaseConnection.prepareStatement(query);
					results = statement.executeQuery();
					JSONArray array = convert(results);
					writer.write(array.toJSONString());
					System.out.println("INFO: - rental " + start_date + " - " + end_date + " inserted in table");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
				//</editor-fold>
			}
			case "select_option":
			{
				//<editor-fold desc="selectare optiuni">
				PrintWriter writer;
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				writer = response.getWriter();
				query = "SELECT * FROM carexpress.option;";
				getResults(databaseConnection, query, writer);
				break;
				//</editor-fold>
			}
			case "select_address":
			{
				//<editor-fold desc="selectare adresa">
				PrintWriter writer;
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				writer = response.getWriter();
				query = "SELECT address FROM carexpress.client WHERE id_client='" + request.getParameter("id_client") + "';";
				getResults(databaseConnection, query, writer);
				break;
				//</editor-fold>
			}
			case "select_rental":
			{
				//<editor-fold desc="selectare inchirieri">
				String id_client = request.getParameter("id_client");
				PrintWriter writer;
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				writer = response.getWriter();
				query = "SELECT * FROM rental WHERE id_client='" + id_client + "';";
				getResults(databaseConnection, query, writer);
				break;
				//</editor-fold>
			}
			case "select_rental_vehicle":
			{
				//<editor-fold desc="selectare vehicule inchiriate">
				String id_vehicle = request.getParameter("id_vehicle");
				PrintWriter writer;
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				writer = response.getWriter();
				query = "SELECT * FROM vehicle WHERE id_vehicle='" + id_vehicle + "';";

				getResults(databaseConnection, query, writer);

				break;
				//</editor-fold>
			}
			case "select_rental_option":
			{
				//<editor-fold desc="selectare optiuni inchiriere">
				String id_rental = request.getParameter("id_rental");
				PrintWriter writer;
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				writer = response.getWriter();
				query = "SELECT * FROM carexpress.option " +
						"WHERE " +
						"name IN (SELECT name FROM option_row WHERE option_row.id_rental = '" + id_rental + "');";

				getResults(databaseConnection, query, writer);

				break;
				//</editor-fold>
			}
			case "select_vehicle":
			{
				//<editor-fold desc="selectare vehicul">
				String category = request.getParameter("category");
				String startDate = request.getParameter("s_date");
				String endDate = request.getParameter("e_date");
				PrintWriter writer;
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				writer = response.getWriter();

				if(category.compareTo("*") != 0)
				{
					query = "SELECT * FROM vehicle " +
							"WHERE " +
							"id_vehicle NOT IN (SELECT id_vehicle FROM rental WHERE (('" + endDate + "'>= start_date AND '" + startDate + "'<= end_date) OR ('" + startDate + "'<=end_date AND '" + endDate + "'>=start_date)))" +
							"AND " +
							"category='" + category + "';";
				}
				else
				{
					query = "SELECT * FROM vehicle " +
							"WHERE " +
							"id_vehicle NOT IN (SELECT id_vehicle FROM rental WHERE (('" + endDate + "'>= start_date AND '" + startDate + "'<= end_date) OR ('" + startDate + "'<=end_date AND '" + endDate + "'>=start_date)));";
				}
				getResults(databaseConnection, query, writer);
				break;
				//</editor-fold>
			}
		}
		if(databaseConnection != null)
		{
			try
			{
				databaseConnection.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private void getResults(Connection databaseConnection, String query, PrintWriter writer)
	{
		PreparedStatement statement;
		ResultSet results;
		try
		{
			statement = databaseConnection.prepareStatement(query);
			results = statement.executeQuery();
			JSONArray array = convert(results);
			writer.write(array.toJSONString());
			System.out.println(array.toJSONString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private static JSONArray convert(@NotNull ResultSet results) throws SQLException
	{
		JSONArray jsonArray = new JSONArray();
		ResultSetMetaData resultSetMetaData = results.getMetaData();

		while(results.next())
		{
			int numColumns = resultSetMetaData.getColumnCount();
			JSONObject obj = new JSONObject();

			for(int i = 1; i < numColumns + 1; i++)
			{
				String column_name = resultSetMetaData.getColumnName(i);

				if(resultSetMetaData.getColumnType(i) == java.sql.Types.ARRAY)
				{
					obj.put(column_name, results.getArray(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.BIGINT)
				{
					obj.put(column_name, results.getInt(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.BOOLEAN)
				{
					obj.put(column_name, results.getBoolean(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.BLOB)
				{
					obj.put(column_name, results.getBlob(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.DOUBLE)
				{
					obj.put(column_name, results.getDouble(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.FLOAT)
				{
					obj.put(column_name, results.getFloat(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.INTEGER)
				{
					obj.put(column_name, results.getInt(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.NVARCHAR)
				{
					obj.put(column_name, results.getNString(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.VARCHAR)
				{
					obj.put(column_name, results.getString(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.TINYINT)
				{
					obj.put(column_name, results.getInt(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.SMALLINT)
				{
					obj.put(column_name, results.getInt(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.DATE)
				{
					obj.put(column_name, results.getDate(column_name));
				}
				else if(resultSetMetaData.getColumnType(i) == java.sql.Types.TIMESTAMP)
				{
					obj.put(column_name, results.getTimestamp(column_name));
				}
				else
				{
					obj.put(column_name, results.getObject(column_name));
				}
			}
			jsonArray.add(obj);
		}
		return jsonArray;
	}
}