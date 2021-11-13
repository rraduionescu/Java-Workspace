package ro.theoutfit.ionescu.radu.main;

import ro.theoutfit.ionescu.radu.http.HttpConnection;

import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			String response = HttpConnection.getResponse();
			if(!response.equals("GET request failed!"))
			{
				System.out.println(response);
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}