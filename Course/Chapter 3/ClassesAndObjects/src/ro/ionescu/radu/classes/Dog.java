package ro.ionescu.radu.classes;

public class Dog
{
	private String name;
	private long fleas;
	private short hairs;

	public Dog(String name, long fleas, short hairs)
	{
		this.name  = name;
		this.fleas = fleas;
		this.hairs = hairs;
	}

	public Dog(String name)
	{
		this(name, 1215L, (short)142);
	}

	public Dog()
	{
		this("no name", 1215L, (short)142);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getFleas()
	{
		return fleas;
	}

	public void setFleas(long fleas)
	{
		this.fleas = fleas;
	}

	public short getHairs()
	{
		return hairs;
	}

	public void setHairs(short hairs)
	{
		this.hairs = hairs;
	}

	public void scratch()
	{
		fleas--;
		hairs -= 10;
	}

	@Override
	public String toString()
	{
		return "Dog{" +
				"name='" + name + '\'' +
				", fleas=" + fleas +
				", hairs=" + hairs +
				'}';
	}
}
