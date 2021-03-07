package ro.ionescu.radu;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result
{
	public static List<Integer> starsAndBars(String s, List<Integer> startIndex, List<Integer> endIndex)
	{
		ArrayList<Integer> result = new ArrayList<>();
		for(int i =0 ;i< startIndex.size();i++)
		{
			String partial = s.substring(startIndex.get(i)-1,endIndex.get(i));
			int firstBar=-1;
			first : for(int j =0 ; j<partial.length();j++)
			{
				if(partial.charAt(j) == '|')
				{
					firstBar = j;
					break first;
				}
			}
			int lastBar =-1;
			last : for(int j = partial.length()-1;j>=0;j--)
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
				int stars =0;
				for(int j=firstBar+1;j<lastBar;j++)
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
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		int startIndexCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> startIndex = IntStream.range(0, startIndexCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(toList());

		int endIndexCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> endIndex = IntStream.range(0, endIndexCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> result = Result.starsAndBars(s, startIndex, endIndex);
		System.out.println(result);

		/*bufferedWriter.write(
				result.stream()
						.map(Object::toString)
						.collect(joining("\n"))
						+ "\n"
		);*/

		bufferedReader.close();
		//bufferedWriter.close();
	}
}