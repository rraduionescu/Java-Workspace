// @author Ionescu Radu
// @date 28.11.2021
package com.ionescu.radu.firsteeapp.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "InvoiceUploadServlet", value = "/InvoiceUploadServlet")
public class InvoiceUploadServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		File                file;
		String              filePath      = "/usr/local/tomcat/webapps/FirstEEApp/WEB-CONTENT/invoices/";
		int                 MAX_MEM_SIZE  = 4 * 1024;
		int                 MAX_FILE_SIZE = 10000 * 1024;
		DiskFileItemFactory factory       = new DiskFileItemFactory();
		ServletFileUpload   upload        = new ServletFileUpload(factory);

		factory.setRepository(new File("/usr/local/tomcat/pdf_temp"));
		factory.setSizeThreshold(MAX_MEM_SIZE);
		upload.setSizeMax(MAX_FILE_SIZE);

		try
		{
			List<FileItem>     fileItems = upload.parseRequest(request);
			Iterator<FileItem> iterator  = fileItems.iterator();
			FileItem           fileItem  = iterator.next();
			String             fileName  = "";

			if(!fileItem.isFormField())
			{
				fileName = fileItem.getName();
				file     = new File(filePath + fileName);

				fileItem.write(file);
			}

			request.setAttribute("file", fileName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-CONTENT/view/pages/invoice_preview.jsp");
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}