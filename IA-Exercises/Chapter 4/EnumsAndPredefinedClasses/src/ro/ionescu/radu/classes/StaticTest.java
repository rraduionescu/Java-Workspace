package ro.ionescu.radu.classes;

public class StaticTest
{
	public static int count = 0;
	static
	{
		count = 10;
	}

	public StaticTest()
	{
		count++;
	}
}
