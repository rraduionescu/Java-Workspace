package ro.ionescu.radu.encapsulation.main;

import ro.ionescu.radu.encapsulation.classes.Person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main
{
	public static void main(String[] args)
	{
		// Object instantiation (no parameters, parameters and object constructors)
		Person person1 = new Person();
		Person person2 = new Person("Ana", 33, LocalDate.now().minus(33, ChronoUnit.YEARS));
		Person person3 = new Person(person1);

		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
		System.out.println();

		// Setting the name
		try
		{
			person1.setName("Corina");
			person1.setName("Bo");
			person1.setName("Rafael");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		// Setting the age
		try
		{
			person1.setAge(28);
			person1.setAge(-4);
			person1.setAge(256);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		// Setting the birthdate
		try
		{
			person1.setBirthdate(LocalDate.now().minus(28, ChronoUnit.YEARS));
			person1.setBirthdate(LocalDate.now());
			person1.setBirthdate(LocalDate.now().minus(1, ChronoUnit.DAYS));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println();

		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
		System.out.println();

		try
		{
			person3.setName("May");
			person3.setAge(person2.getAge());
			person3.setBirthdate(person2.getBirthdate());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
	}
}