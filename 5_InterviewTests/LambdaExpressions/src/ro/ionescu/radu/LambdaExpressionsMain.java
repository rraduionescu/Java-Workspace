package ro.ionescu.radu;

import java.util.Comparator;

@SuppressWarnings({"Convert2Lambda", "Anonymous2MethodRef", "ComparatorCombinators", "Convert2MethodRef"})
public class LambdaExpressionsMain
{
	public static void main(String[] args)
	{
		String s1 = "hello", s2 = "world";

		// Inner anonymous class implementing Comparator interface
		Comparator<String> comparator = new Comparator<String>()
		{
			@Override
			public int compare(String o1, String o2)
			{
				return o1.compareTo(o2);
			}
		};
		System.out.println("s1 - s2 comparison : " + comparator.compare(s1, s2));
		System.out.println("s1 - s1 comparison : " + comparator.compare(s1, s1));

		// Comparator lambda expression
		Comparator<String> lambdaComparator = (o1, o2) -> o1.compareTo(o2);
		System.out.println("s1 - s2 comparison lambda : " + lambdaComparator.compare(s1, s2));
		System.out.println("s1 - s1 comparison lambda : " + lambdaComparator.compare(s1, s1));
	}
}