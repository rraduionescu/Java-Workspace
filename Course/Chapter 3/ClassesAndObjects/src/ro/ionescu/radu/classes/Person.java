package ro.ionescu.radu.classes;

public class Person
{
	String name;
	int weight = 67;

	public void presentation()
	{
		System.out.println("Hi, my name is " + name + " and i weight " + weight + " kilograms.");
	}

	public void changeName(String newName)
	{
		name = newName;
	}

	public void eat()
	{
		weight++;
	}
}
