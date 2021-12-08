package ro.ionescu.radu.interfaces;

public interface GenericInterface
{
	void printText(String text);

	default void printHello()
	{
		System.out.println("Hello GenericInterface.");
	}

	static void printStaticMethod()
	{
		System.out.println("Java 8 static GenericInterface method.");
	}
}