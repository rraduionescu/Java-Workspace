package ro.ionescu.radu.main;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Main
{
	public static void main(String[] args)
	{
		long startTime, endTime, collectionTime, streamTime, parallelTime;

		// Collection creation
		List<Integer> integerList = new LinkedList<>();
		for(int i = 0 ; i < 100_000 ; i++)
		{
			integerList.add(i);
		}

		// Printing from collection
		startTime = System.nanoTime();
		for(Integer i : integerList)
		{
			System.out.print(i + " ");
		}
		endTime        = System.nanoTime();
		collectionTime = (endTime - startTime) / 1_000_000;

		// Printing from stream
		Stream<Integer> integerStream = integerList.stream();
		startTime = System.nanoTime();
		integerStream.forEach(i->System.out.print(i + " "));
		endTime    = System.nanoTime();
		streamTime = (endTime - startTime) / 1_000_000;

		// Printing from parallel stream
		integerStream = integerList.parallelStream();
		startTime     = System.nanoTime();
		integerStream.forEach(i->System.out.print(i + " "));
		endTime      = System.nanoTime();
		parallelTime = (endTime - startTime) / 1_000_000;

		// Results
		System.out.println();
		System.out.println("Collection print duration(ms): " + collectionTime);
		System.out.println("Stream print duration(ms): " + streamTime);
		System.out.println("Parallel stream print duration(ms): " + parallelTime);
	}
}