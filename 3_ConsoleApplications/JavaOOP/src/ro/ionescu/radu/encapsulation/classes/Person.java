package ro.ionescu.radu.encapsulation.classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person
{
	private String name;
	private int age;
	private LocalDate birthdate;

	public Person()
	{
		super();
		this.name      = "";
		this.age       = 0;
		this.birthdate = LocalDate.now();
	}

	public Person(String name, int age, LocalDate birthdate)
	{
		super();
		this.name      = name;
		this.age       = age;
		this.birthdate = birthdate;
	}

	public Person(Person person)
	{
		super();
		this.name      = person.getName();
		this.age       = person.getAge();
		this.birthdate = person.getBirthdate();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) throws Exception
	{
		if(name.length() > 2)
		{
			this.name = name;
		}
		else
		{
			throw new Exception("Exception: Invalid name - '" + name + "' ( must contain minimum three characters ).");
		}
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age) throws Exception
	{
		if(age > 0 && age < 125)
		{
			this.age = age;
		}
		else
		{
			throw new Exception("Exception: Invalid age - '" + age + "' ( must be between zero and 125 ).");
		}
	}

	public LocalDate getBirthdate()
	{
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) throws Exception
	{
		if(birthdate.compareTo(LocalDate.now()) < 0)
		{
			this.birthdate = birthdate;
		}
		else
		{
			throw new Exception("Exception: Invalid birthdate - '" + birthdate + "' ( must be between before today's date ).");
		}
	}

	@Override
	public String toString()
	{
		return "Hi, I'm " + name + ", and I'm " + age + " years old and my birthdate is " + birthdate + ".";
	}
}