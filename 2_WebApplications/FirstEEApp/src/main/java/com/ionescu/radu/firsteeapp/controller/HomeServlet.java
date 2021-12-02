// @author Ionescu Radu
// @date 28.11.2021
package com.ionescu.radu.firsteeapp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "homeServlet")
public class HomeServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-CONTENT/view/pages/home.jsp");
		dispatcher.forward(request, response);
	}
}