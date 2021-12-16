package ro.skillvalue.ionescu.radu.classes;

public class SpaceRemover
{
	public static String removeSpaces(String input)
	{
		return input.replaceAll(" {2,}", " ");
	}
}