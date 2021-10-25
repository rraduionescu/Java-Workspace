package ro.ionescu.radu.classes;

public class FibonacciCalculator
{
	public static long calculateRecursive(int length)
	{
		if(length < 3)
		{
			return 1;
		}
		else
		{
			return calculateRecursive(length - 1) + calculateRecursive(length - 2);
		}
	}

	public static long calculateIterative(int length)
	{
		if(length < 3)
		{
			return 1;
		}
		else
		{
			long first = 1, second = 1, number = 0;
			for(int count = 3 ; count <= length ; count++)
			{
				number = first + second;
				first = second;
				second = number;
			}
			return number;
		}
	}
}
