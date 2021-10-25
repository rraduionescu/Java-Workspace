package ro.ionescu.radu.classes;

public class Person
{
	String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void present()
	{
		System.out.println("Hi, i'm " + name + "!");
	}
}
