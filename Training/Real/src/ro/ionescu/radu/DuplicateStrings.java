package ro.ionescu.radu;

import java.util.Arrays;
import java.util.HashMap;

public class DuplicateStrings
{
	public static HashMap<String, Boolean> wordMultiple(String[] strings)
	{
		HashMap<String, Boolean> result = new HashMap<>();
		Arrays.sort(strings);
		for(int i = 0 ; i < strings.length ; i++)
		{
			if(i < strings.length - 1 && strings[i] == strings[i + 1])
			{
				result.put(strings[i], true);
				int j = i + 1;
				while(strings[j] == strings[i])
				{
					j++;
				}
				strings = Arrays.copyOfRange(strings, j, strings.length);

			}
			else
			{
				result.put(strings[i], false);
			}
		}
		return result;
	}

	public static void main(String[] args)
	{
		HashMap<String, Boolean> result = wordMultiple(new String[]{"a", "b", "a", "c", "b"});
		System.out.println(Arrays.asList(result));
	}
}