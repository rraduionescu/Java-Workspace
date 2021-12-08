package ro.ionescu.radu.main;

import ro.ionescu.radu.classes.GenericClass;
import ro.ionescu.radu.interfaces.GenericInterface;
import ro.ionescu.radu.interfaces.TestInterface;

public class Main
{
	public static void main(String[] args)
	{
		GenericClass genericClass = new GenericClass();

		genericClass.printHello();

		genericClass.printText("Normal interface method implemented in class.");
		System.out.println(genericClass.addNumbers(14, 38));

		GenericInterface.printStaticMethod();
		TestInterface.printStaticMethod();
	}
}