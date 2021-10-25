package ro.ionescu.radu.classes;

public class PalindromeCalculator
{
	public static boolean checkStringIterative(String string)
	{
		StringBuilder inverse = new StringBuilder();
		for(int i = string.length() - 1 ; i >= 0 ; i--)
		{
			inverse.append(string.charAt(i));
		}
		System.out.println("String : " + string);
		System.out.println("Inverse: " + inverse);
		return string.compareTo(inverse.toString()) == 0;
	}

	public static boolean checkStringRecursive(String string)
	{
		String inverse = reverseString(string);
		System.out.println("String : " + string);
		System.out.println("Inverse: " + inverse);
		return string.compareTo(inverse) == 0;
	}

	public static String reverseString(String string)
	{
		if(string.isEmpty())
		{
			return string;
		}
		return string.charAt(string.length() - 1) + reverseString(string.substring(0,string.length() - 1));
	}

	public static boolean checkIntegerIterative(int number)
	{
		int inverse = number % 10, copy = number;
		number = number / 10;
		while(number != 0)
		{
			inverse = inverse * 10 + number % 10;
			number = number / 10;
		}
		System.out.println("Integer: " + copy);
		System.out.println("Inverse: " + inverse);
		return copy == inverse;
	}
}