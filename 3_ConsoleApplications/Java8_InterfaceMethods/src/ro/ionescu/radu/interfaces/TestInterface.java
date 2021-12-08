package ro.ionescu.radu.interfaces;

public interface TestInterface
{
	int addNumbers(int a, int b);

	default void printHello()
	{
		System.out.println("Hello TestInterface.");
	}

	static void printStaticMethod()
	{
		System.out.println("Java 8 static TestInterface method.");
	}
}