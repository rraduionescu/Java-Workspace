package ro.ionescu.radu.classes;

public class ArmstrongCalculator
{
	public static boolean check(int number)
	{
		int copy = number, armstrong = 0;
		while(copy != 0)
		{
			armstrong += Math.pow(copy % 10, 3);
			copy /= 10;
		}
		return number == armstrong;
	}
}
