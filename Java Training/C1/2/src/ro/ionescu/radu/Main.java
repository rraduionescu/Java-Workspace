package ro.ionescu.radu;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Hello");

		byte b;
		short s;
		int i;
		long l;
		float f;
		double d;
		char c;
		boolean x;

		String st = "4";
		System.out.println("String literal " + st);

		i = Integer.parseInt(st);
		System.out.println("Integer        " + i);

		l = 730_873_101;
		System.out.println("Long           " + l);

		c = 'x';
	}
}
