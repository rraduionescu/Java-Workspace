package ro.ionescu.radu.main;

import ro.ionescu.radu.classes.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;

public class Main
{
	public static void main(String[] args)
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Input Fibonacci series length: ");
		try
		{
			String lengthString = bufferedReader.readLine();
			int length = Integer.parseInt(lengthString);

			// 1. Fibonacci series recursive
			long startTime = System.nanoTime();
			System.out.println("Fibonacci series recursive: ");
			for(int count = 1 ; count <= length ; count++)
			{
				System.out.print(FibonacciCalculator.calculateRecursive(count) + " ");
			}
			long elapsedTime = System.nanoTime() - startTime;
			System.out.println("\nElapsed time recursive: " + elapsedTime + " ns");

			// 1. Fibonacci series iterative
			startTime = System.nanoTime();
			System.out.println("Fibonacci series iterative: ");
			for(int count = 1 ; count <= length ; count++)
			{
				System.out.print(FibonacciCalculator.calculateIterative(count) + " ");
			}
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("\nElapsed time iterative: " + elapsedTime + " ns");

			// 2. Testing prime numbers
			System.out.print("\nInput number to be tested if prime: ");
			String numberString = bufferedReader.readLine();
			long number = Long.parseLong(numberString);
			if(PrimesCalculator.check(number))
			{
				System.out.println("The number is prime!");
			}
			else
			{
				System.out.println("The number is NOT prime!");
			}

			// 2. Prime number series
			System.out.print("\nInput prime series length: ");
			String lengthPrimeString = bufferedReader.readLine();
			int lengthPrime = Integer.parseInt(lengthPrimeString);
			long[] numbers = PrimesCalculator.calculate(lengthPrime);
			System.out.print("First " + lengthPrime + " prime numbers: ");
			for(long l : numbers)
			{
				System.out.print(l + " ");
			}

			// 3. Checking if a String is a palindrome iterative
			System.out.print("\n\nInput palindrome string: ");
			String string = bufferedReader.readLine();
			if(PalindromeCalculator.checkStringIterative(string))
			{
				System.out.println("The string is a palindrome!");
			}
			else
			{
				System.out.println("The string is NOT a palindrome!");
			}

			// 3. Checking if a String is a palindrome recursive
			System.out.print("\nInput palindrome string: ");
			string = bufferedReader.readLine();
			if(PalindromeCalculator.checkStringRecursive(string))
			{
				System.out.println("The string is a palindrome!");
			}
			else
			{
				System.out.println("The string is NOT a palindrome!");
			}

			// 4. Checking if an integer is a palindrome
			System.out.print("\nInput palindrome integer: ");
			String integer = bufferedReader.readLine();
			int palindrome = Integer.parseInt(integer);
			if(PalindromeCalculator.checkIntegerIterative(palindrome))
			{
				System.out.println("The integer is a palindrome!");
			}
			else
			{
				System.out.println("The integer is NOT a palindrome!");
			}

			// 5. Checking if an integer is an Armstrong number
			System.out.print("\nInput Armstrong integer: ");
			integer = bufferedReader.readLine();
			int armstrong = Integer.parseInt(integer);
			if(ArmstrongCalculator.check(armstrong))
			{
				System.out.println("The integer is an armstrong number!");
			}
			else
			{
				System.out.println("The integer is NOT an armstrong number!");
			}

			// 6. Factorial number
			System.out.print("\nInput integer for factorial: ");
			integer = bufferedReader.readLine();
			int factorial = Integer.parseInt(integer);
			System.out.println(factorial + "! = " + FactorialCalculator.calculateIterative(factorial));

			// 7. Reverse an array
			int[] nums = {5, 1, 6, 8, 2, 4, 7, 5, 2, 1};
			System.out.println("\nNormal array  : " + Arrays.toString(nums));
			System.out.println("Reversed array: " + Arrays.toString(ArrayCalculator.reverse(nums)));

			// 8. Sort array
			System.out.println("Sorted array  : " + Arrays.toString(ArrayCalculator.sort(nums)));

			// 9. Remove array duplicates
			System.out.println("No duplicates : " + Arrays.toString(ArrayCalculator.removeDuplicates(nums)));

			//10. Print JAVA pattern
			System.out.println("\n   J    A  V     V  A    ");
			System.out.println("   J   A A  V   V  A A   ");
			System.out.println("J  J  AAAAA  V V  AAAAA  ");
			System.out.println(" JJ  A  A  A  V  A     A ");

			//11.Date
			Date date = new Date();
			System.out.println();
			System.out.println(date.toString());

			// T. The single unpaired number in a vector in O(n)
			int[] pairs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1};
			System.out.print("\nVector: " + Arrays.toString(pairs));

			int single = pairs[0];
			for(int i = 1 ; i < 17 ; i++)
			{
				single = single ^ pairs[i];
			}
			System.out.println("\nThe single unpaired number in a vector in O(n): " + single);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
