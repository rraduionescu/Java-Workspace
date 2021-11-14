package ro.theoutfit.ionescu.radu.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection
{
	private static final String GET_URL = "https://op-app.azurewebsites.net/api/dev-test/get-products";
	private static final String METHOD = "GET";
	private static final String CONTENT_TYPE = "application/json";
	private static final String API_KEY = "&aBWaR&r[12x)I9Q2mhi9y4W";

	public static String getResponse() throws IOException
	{
		URL               url        = new URL(GET_URL);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();

		connection.setRequestMethod(METHOD);
		connection.setRequestProperty("ACCEPT", CONTENT_TYPE);
		connection.setRequestProperty("API_KEY", API_KEY);

		int responseCode = connection.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_OK)
		{
			BufferedReader in       = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String         inputLine;
			StringBuilder  response = new StringBuilder();

			while((inputLine = in.readLine()) != null)
			{
				response.append(inputLine);
			}
			in.close();

			return response.toString();
		}
		else
		{
			return "GET request failed!";
		}
	}
}