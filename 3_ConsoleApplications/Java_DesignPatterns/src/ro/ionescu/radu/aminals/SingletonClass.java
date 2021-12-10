package ro.ionescu.radu.aminals;

public class SingletonClass
{
	private static SingletonClass instance = new SingletonClass();

	private SingletonClass()
	{

	}

	public static SingletonClass getInstance()
	{
		return instance;
	}

	public int add(int a, int b)
	{
		return a + b;
	}
}