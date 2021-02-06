package ro.ionescu.radu.main;

import ro.ionescu.radu.classes.FibonacciCalculator;
import ro.ionescu.radu.classes.PrimesCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args)
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Input Fibonacci stream length: ");
		try
		{
			String lengthString = bufferedReader.readLine();
			int length = Integer.parseInt(lengthString);

			// Fibonacci series recursive
			long startTime = System.nanoTime();
			System.out.println("\nFibonacci stream recursive: ");
			for(int count = 1 ; count <= length ; count++)
			{
				System.out.print(FibonacciCalculator.calculateRecursive(count) + " ");
			}
			long elapsedTime = System.nanoTime() - startTime;
			System.out.println("\nElapsed time recursive: " + elapsedTime + " ns");

			// Fibonacci series iterative
			startTime = System.nanoTime();
			System.out.println();
			System.out.println("Fibonacci stream iterative: ");
			for(int count = 1 ; count <= length ; count++)
			{
				System.out.print(FibonacciCalculator.calculateIterative(count) + " ");
			}
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("\nElapsed time iterative: " + elapsedTime + " ns");

			// Testing prime numbers
			for(int i = 0 ; i < 5 ; i++)
			{
				System.out.print("\nInput number to be tested: ");
				String numberString = bufferedReader.readLine();
				long number = Long.parseLong(numberString);
				if(PrimesCalculator.verify(number))
				{
					System.out.println("The number is prime!");
				}
				else
				{
					System.out.println("The number is not prime!");
				}
			}

			// Prime number series
			System.out.print("\nInput prime stream length: ");
			String lengthPrimeString = bufferedReader.readLine();
			int lengthPrime = Integer.parseInt(lengthPrimeString);
			long[] numbers = PrimesCalculator.calculate(lengthPrime);
			System.out.print("First " + lengthPrime + " prime numbers: ");
			for(long l : numbers)
			{
				System.out.print(l + " ");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
