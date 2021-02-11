package ro.ionescu.radu.main;

import ro.ionescu.radu.classes.Instructor;
import ro.ionescu.radu.classes.Person;

public class Main
{
	public static void main(String[] args)
	{
		Instructor instructor = new Instructor();
		instructor.setName("Radu");
		instructor.present();
		instructor.teach();
		System.out.println("Is instructor a person? " + (instructor instanceof Person));
		System.out.println("Is instructor an instructor? " + (instructor instanceof Instructor));
		System.out.println("Is instructor an object? " + (instructor instanceof Object));
		Person[] persons = new Person[2];
		persons[0] = new Person();
		persons[1] = instructor;
		persons[0].setName("Vlad");
		persons[0].present();
		persons[1].present();
		if(persons[1] instanceof Instructor)
		{
			((Instructor)persons[1]).teach();
		}
	}
}
