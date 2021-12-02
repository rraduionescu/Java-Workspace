// @author Ionescu Radu
// @date 28.11.2021
package com.ionescu.radu.firsteeapp.model.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NBRRates
{
	public static final String DATE = getDATE();
	public static final float EUR_RATE = getEUR_RATE();

	private static final String GET_URL = "https://www.bnr.ro/nbrfxrates.xml";
	private static final String METHOD = "GET";
	private static final String CONTENT_TYPE = "application/xml";

	private static String getDATE()
	{
		try
		{
			String  rates   = NBRRates.getRates();
			Pattern pattern = Pattern.compile("date=\"");
			Matcher matcher = pattern.matcher(rates);
			if(matcher.find())
			{
				return rates.substring(matcher.end(), matcher.end() + 10);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private static float getEUR_RATE()
	{
		float result = 0;
		try
		{
			String  rates   = NBRRates.getRates();
			Pattern pattern = Pattern.compile("<Rate currency=\"EUR\">");
			Matcher matcher = pattern.matcher(rates);
			if(matcher.find())
			{
				result = Float.parseFloat(rates.substring(matcher.end(), matcher.end() + 6));
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	private static String getRates() throws IOException
	{
		URL               url        = new URL(GET_URL);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();

		connection.setRequestMethod(METHOD);
		connection.setRequestProperty("ACCEPT", CONTENT_TYPE);

		int responseCode = connection.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_OK)
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
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