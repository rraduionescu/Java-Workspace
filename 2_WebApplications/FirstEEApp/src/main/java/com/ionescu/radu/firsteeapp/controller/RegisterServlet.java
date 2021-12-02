// @author Ionescu Radu
// @date 28.11.2021
package com.ionescu.radu.firsteeapp.controller;

import com.ionescu.radu.firsteeapp.model.database.DatabaseUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-CONTENT/view/pages/register.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email     = request.getParameter("r_em");
		String password  = request.getParameter("r_pw");
		String firstName = request.getParameter("r_fn");
		String lastName  = request.getParameter("r_ln");

		try
		{
			DatabaseUser.createUser(email, password, firstName, lastName);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-CONTENT/view/pages/login.jsp");
		dispatcher.forward(request, response);
	}
}