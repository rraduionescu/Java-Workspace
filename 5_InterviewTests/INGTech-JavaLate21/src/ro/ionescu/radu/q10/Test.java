package ro.ionescu.radu.q10;

public class Test
{
	public static void main(String[] args)
	{
		Test test = new Test();
		test.divide(4, 0);
	}

	public int divide(int a, int b)
	{
		int c = -1;
		try
		{
			c = a / b;
		}
		catch(Exception e)
		{
			System.err.print("Exception ");
		}
		finally
		{
			System.err.println("Finally ");
		}
		return c;
	}
}