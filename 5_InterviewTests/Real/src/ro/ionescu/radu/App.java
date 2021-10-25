package ro.ionescu.radu;

import java.util.ArrayList;
import java.util.List;

public class App
{

	public static void main(String args[])
	{
		System.out.println(alternatingCharacters("AAABBB"));
	}

	public static Object[] returnStringAsArray()
	{
		return new String[]{"Java", "Quiz"};
	}

	public static int alternatingCharacters(String s)
	{
		int del = 0;
		fori:
		for(int i = 0 ; i < s.length() ; i++)
		{
			char c = s.charAt(i);
			for(int j = i + 1 ; s.charAt(j) == c && j < s.length() ; j++)
			{
				del++;
				if(j == s.length() - 1)
				{
					break fori;
				}
				if(s.charAt(j+1)!=c)
				{
					i=j;
				}
			}
		}
		return del;
	}
}