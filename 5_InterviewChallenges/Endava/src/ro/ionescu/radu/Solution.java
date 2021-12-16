package ro.ionescu.radu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result
{
	public static List<Integer> starsAndBars(String inputString, List<Integer> startIndex, List<Integer> endIndex)
	{
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 0 ; i < startIndex.size() ; i++)
		{
			String partial  = inputString.substring(startIndex.get(i) - 1, endIndex.get(i));
			int    firstBar = -1;
			first:
			for(int j = 0 ; j < partial.length() ; j++)
			{
				if(partial.charAt(j) == '|')
				{
					firstBar = j;
					break first;
				}
			}
			int lastBar = -1;
			last:
			for(int j = partial.length() - 1 ; j >= 0 ; j--)
			{
				if(partial.charAt(j) == '|')
				{
					lastBar = j;
					break last;
				}
			}
			if(firstBar == -1 || firstBar == lastBar)
			{
				result.add(0);
			}
			else
			{
				int stars = 0;
				for(int j = firstBar + 1 ; j < lastBar ; j++)
				{
					if(partial.charAt(j) == '*')
					{
						stars++;
					}
				}
				result.add(stars);
			}
		}
		return result;
	}
}

public class Solution
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String         s              = bufferedReader.readLine();

		int startIndexCount = Integer.parseInt(bufferedReader.readLine().trim());
		List<Integer> startIndex = IntStream.range(0, startIndexCount).mapToObj(i->
		{
			try
			{
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			}
			catch(IOException ex)
			{
				throw new RuntimeException(ex);
			}
		})
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(toList());

		int endIndexCount = Integer.parseInt(bufferedReader.readLine().trim());
		List<Integer> endIndex = IntStream.range(0, endIndexCount).mapToObj(i->
		{
			try
			{
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			}
			catch(IOException ex)
			{
				throw new RuntimeException(ex);
			}
		})
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> result = Result.starsAndBars(s, startIndex, endIndex);
		System.out.println(result);

		bufferedReader.close();
	}
}