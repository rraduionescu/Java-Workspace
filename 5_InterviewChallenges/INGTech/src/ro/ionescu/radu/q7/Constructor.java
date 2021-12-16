package ro.ionescu.radu.q7;

class Constructor
{
	static String str;

	public void Constructor()
	{
		System.out.println("In constructor");
		str = "Hello World";
	}

	public static void main(String[] args)
	{
		Constructor constructor = new Constructor();
		System.out.println(str);
	}
}