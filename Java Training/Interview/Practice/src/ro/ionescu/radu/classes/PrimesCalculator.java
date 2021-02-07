package ro.ionescu.radu.classes;

public class PrimesCalculator
{
	public static long[] calculate(int length)
	{
		long[] numbers = new long[length];
		int c = 0;
		for(int i = 2 ; i < 20 * length ; i++)
		{
			if(check(i))
			{
				numbers[c] = i;
				c++;
			}
			if(c == length)
			{
				break;
			}
		}
		return numbers;
	}

	public static boolean check(long number)
	{
		if(number != 2 && number % 2 == 0)
		{
			return false;
		}
		for(int i = 3 ; i <= Math.sqrt(number) ; i += 2)
		{
			if(number % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}
