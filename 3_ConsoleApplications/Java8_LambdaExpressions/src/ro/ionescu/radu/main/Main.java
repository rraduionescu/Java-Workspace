package ro.ionescu.radu.main;

import ro.ionescu.radu.interfaces.LambdaInterface;

import java.util.*;
import java.util.function.Consumer;

public class Main
{
	public static void main(String[] args)
	{
		LambdaInterface         lambdaInterface;
		Consumer<String>        stringConsumer;
		String                  text        = "Hello, Lambda!";
		List<Integer>           values      = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		Map<Character, Integer> occurrences = new HashMap<>();
		for(int i = 0 ; i < text.length() ; i++)
		{
			if(occurrences.get(text.toLowerCase().charAt(i)) == null)
			{
				occurrences.put(text.toLowerCase().charAt(i), 1);
			}
			else
			{
				occurrences.put(text.toLowerCase().charAt(i), occurrences.get(text.toLowerCase().charAt(i)) + 1);
			}
		}

		// LambdaInterface functional interface implementation
		lambdaInterface = lText->System.out.println(lText);
		lambdaInterface.printText(text);

		// Consumer functional interface implementation
		stringConsumer = lText->System.out.println(lText);
		stringConsumer.accept(text);

		// Anonymous Consumer functional interface implementation
		values.forEach(v->System.out.print(v + " "));
		occurrences.forEach((k, v)->System.out.println("key:" + k + " value:" + v));
	}
}