package ro.ionescu.radu.classes;

public class Instructor extends Person
{
	public void teach()
	{
		System.out.println("Instructor " + name + " is teaching a lesson.");
	}

	public void present()
	{
		System.out.println("Hi, i'm instructor " + name + "!");
	}
	public void present(int hours)
	{
		present();
		System.out.println("This course will take " + hours + " hours!");
	}
}
