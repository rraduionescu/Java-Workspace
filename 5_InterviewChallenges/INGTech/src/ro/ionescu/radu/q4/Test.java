package ro.ionescu.radu.q4;

public class Test
{
	public static void main(String[] args)
	{
		String first  = "something";
		String second = "something";
		String third  = new String("something");
		String fourth = new String("something");

		System.out.println(first == second);
		System.out.println(third == fourth);
		System.out.println(first == fourth);
	}
}