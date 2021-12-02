package ro.ionescu.radu.q2;

public class Test
{
	public static void main(String[] args)
	{
		Integer integer = new Integer(634);
		boolean bool    = true;
		float   f       = 12.45f;
		Double  doub    = new Double("123.584");

		System.out.println(integer.getClass().isPrimitive());
		System.out.println("boolean value: " + bool);
		System.out.println("float value: " + f);
		System.out.println(doub.getClass().isPrimitive());
	}
}