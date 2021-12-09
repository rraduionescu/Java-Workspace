package ro.ionescu.radu.classes;

import ro.ionescu.radu.interfaces.GenericInterface;
import ro.ionescu.radu.interfaces.TestInterface;

public class GenericClass extends GenericSuperclass implements GenericInterface, TestInterface
{
	public int addNumbers(int a, int b)
	{
		return a + b;
	}

	public void printText(String text)
	{
		System.out.println(text);
	}

	// Furthermore, printHello() MUST be overridden to avoid the diamond of death. (static & default are also public)
	public void printHello()
	{
		System.out.println("Hello GenericClass.");
	}
}