package ro.ionescu.radu.main;

import ro.ionescu.radu.classes.Dog;
import ro.ionescu.radu.classes.Person;

public class Main
{
	public static void main(String[] args)
	{
		Person person = new Person();
		person.changeName("Radu");
		person.presentation();
		person.eat();
		person.presentation();
		person.eat();
		person.eat();
		person.changeName("Tibi");
		person.presentation();

		Dog dog1 = new Dog();
		Dog dog2 = new Dog("Azor");
		Dog dog3 = new Dog("Labush", 492942L, (short)842);

		System.out.println(dog1);
		System.out.println(dog2);
		System.out.println(dog3);
		dog3.scratch();
		System.out.println(dog3);
		dog3.setName("Max");
		dog3.setFleas(1000000L);
		dog3.setHairs((short)10000);
		System.out.println(dog3);
		System.out.println("Bark! My dog name is " + dog3.getName() + " and i have " + dog3.getFleas() + " fleas and " + dog3.getHairs() + " hairs.");
	}
}
