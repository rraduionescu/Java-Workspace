// @author Ionescu Radu
// @date 28.11.2021
package com.ionescu.radu.firsteeapp.controller;

import com.ionescu.radu.firsteeapp.model.classes.InvoiceParser;
import com.ionescu.radu.firsteeapp.model.classes.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;

@WebServlet(name = "NirServlet", value = "/NirServlet")
public class NirServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			String             fileName       = request.getParameter("file");
			ArrayList<String>  stringProducts = InvoiceParser.getInvoiceProductsStrings(getServletContext().getRealPath("/WEB-CONTENT/invoices/" + fileName));
			ArrayList<Product> products       = InvoiceParser.getProducts(stringProducts);
			RequestDispatcher  dispatcher     = request.getRequestDispatcher("/WEB-CONTENT/view/pages/nir.jsp");

			request.setAttribute("products", products);
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}