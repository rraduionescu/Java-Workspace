// @author Ionescu Radu
// @date 28.11.2021
package com.ionescu.radu.firsteeapp.controller;

import com.ionescu.radu.firsteeapp.model.database.DatabaseUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-CONTENT/view/pages/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email    = request.getParameter("l_em");
		String password = request.getParameter("l_pw");
		try
		{
			if(DatabaseUser.checkUser(email, password))
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-CONTENT/view/pages/invoice_upload.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				PrintWriter writer = response.getWriter();
				writer.print("<html><body><script>alert('Wrong credentials!');</script></body></html>");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}