// @author Ionescu Radu
// @date 28.11.2021
package com.ionescu.radu.firsteeapp.controller;

import com.ionescu.radu.firsteeapp.model.database.DatabaseStatements;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SQLServlet", value = "/SQLServlet")
public class SQLServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-CONTENT/view/pages/sql_statement.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ResultSet resultSet = DatabaseStatements.executeStatement(request.getParameter("statement"));
		if(resultSet == null)
		{
			request.setAttribute("sqlResponse", "Statement executed!");
		}
		else
		{
			try
			{
				List<String> results = new ArrayList<>();
				while(resultSet.next())
				{
					String            result       = "";
					ResultSetMetaData meta         = resultSet.getMetaData();
					int               columnNumber = meta.getColumnCount();
					for(int i = 1 ; i <= columnNumber ; i++)
					{
						result += resultSet.getString(i);
					}
					results.add(result);
				}
				request.setAttribute("sqlList", results);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-CONTENT/view/pages/sql_response.jsp");
		dispatcher.forward(request, response);
	}
}