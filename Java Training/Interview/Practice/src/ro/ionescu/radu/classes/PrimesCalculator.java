package ro.ionescu.radu.classes;

public class PrimesCalculator
{
	public static long[] calculate(int length)
	{
		long[] numbers = new long[length];
		int c = 0;
		for(int i = 2 ; i < 20 * length ; i++)
		{
			if(verify(i))
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

	public static boolean verify(long number)
	{
		int step = 1;
		for(int i = 2 ; i <= Math.sqrt(number) ; i += step)
		{
			if(number % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}
