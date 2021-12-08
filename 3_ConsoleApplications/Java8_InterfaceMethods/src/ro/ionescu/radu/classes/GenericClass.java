package ro.ionescu.radu.classes;

import ro.ionescu.radu.interfaces.GenericInterface;
import ro.ionescu.radu.interfaces.TestInterface;

public class GenericClass extends GenericSuperclass implements GenericInterface, TestInterface
{
	// Should be declared as public explicitly (although it is by default public abstract in interface declaration, not J8 related)
	public int addNumbers(int a, int b)
	{
		return a + b;
	}

	// Should be declared as public explicitly (although it is by default public abstract in interface declaration, not J8 related)
	public void printText(String text)
	{
		System.out.println(text);
	}

	// Should be declared as public explicitly (although it is by default public in interface declaration)
	// Furthermore, printHello() MUST be overridden to avoid the diamond of death. (static & default are also public)
	public void printHello()
	{
		System.out.println("Hello GenericClass.");
	}
}