package ro.ionescu.radu.classes;

public class FactorialCalculator
{
	public static long calculateIterative(int number)
	{
		long factorial = 1;
		for(int i = 1 ; i <= number ; i++)
		{
			factorial *= i;
		}
		return factorial;
	}
}
