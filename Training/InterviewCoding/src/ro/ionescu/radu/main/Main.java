package ro.ionescu.radu.main;

import ro.ionescu.radu.classes.Circle;

import java.util.Scanner;
import java.util.Stack;

public class Main
{
	public static void main(String[] args)
	{
		// 1.a FIBONACCI Series (iterative) Time complexity: O(n)
		Scanner scanner = new Scanner(System.in);
		System.out.print("Fibonacci series length: ");
		int fibonacciLength = scanner.nextInt();
		while(fibonacciLength <= 0)
		{
			System.out.println("Series length should be greater than zero!!!");
			System.out.println("Fibonacci series length: ");
			fibonacciLength = scanner.nextInt();
		}
		if(fibonacciLength == 1)
		{
			System.out.println("Fibonacci series: 0");
		}
		else if(fibonacciLength == 2)
		{
			System.out.println("Fibonacci series: 0 1");
		}
		else
		{
			System.out.print("Fibonacci series: 0 1");
			int f1 = 0, f2 = 1;
			for(int i = 2 ; i < fibonacciLength ; i++)
			{
				f2 = f1 + f2;
				f1 = f2 - f1;
				System.out.print(" " + f2);
			}
		}
		System.out.println();

		// 1.b FIBONACCI Series (recursive) Time complexity: O(2ˆn)
		System.out.print("Fibonacci series length: ");
		fibonacciLength = scanner.nextInt();
		System.out.println("The " + fibonacciLength + "th number is: " + fibonacci(fibonacciLength - 1));

		// 2. Prime numbers
		System.out.print("Input number: ");
		int     inputPrime = scanner.nextInt();
		boolean isPrime    = true;
		for(int i = 2 ; i < Math.sqrt(inputPrime) ; i++)
		{
			if(inputPrime % i == 0)
			{
				isPrime = false;
			}
		}
		if(isPrime)
		{
			System.out.println(inputPrime + " is prime.");
		}
		else
		{
			System.out.println(inputPrime + " is not prime.");
		}

		// 3. OOP Exercises
		// Declare and allocate an instance of class Circle called c1
		//  with default radius and color
		Circle c1 = new Circle();
		// Use the dot operator to invoke methods of instance c1.
		System.out.println("The circle has radius of "
				+ c1.getRadius() + " and area of " + c1.getArea());

		// Declare and allocate an instance of class circle called c2
		//  with the given radius and default color
		Circle c2 = new Circle(2.0);
		// Use the dot operator to invoke methods of instance c2.
		System.out.println("The circle has radius of "
				+ c2.getRadius() + " and area of " + c2.getArea());

		Circle c3 = new Circle(2.0, "blue");
		// Use the dot operator to invoke methods of instance c2.
		System.out.println("The circle has radius of "
				+ c2.getRadius() + " and area of " + c2.getArea());

		// 4. Stack
		scanner = new Scanner(System.in);
		int sum = 0;

		System.out.println("Enter the 1st number:");
		int num1 = scanner.nextInt();
		System.out.println("Enter the 2nd number:");
		int num2 = scanner.nextInt();
		System.out.println("Enter the 3rd number:");
		int num3 = scanner.nextInt();

		Stack<Integer> st = new Stack<Integer>();

		System.out.println("[]");

		System.out.print("[");
		st.push(num1);
		for(Integer i : st)
		{
			System.out.print(i);
		}
		System.out.println("]");

		System.out.print("[");
		st.push(num2);
		for(Integer i : st)
		{
			System.out.print(i + "\n");
		}
		System.out.println("]");

		System.out.print("[");
		st.push(num3);
		for(Integer i : st)
		{
			System.out.print(i + "\n");
		}
		System.out.println("]");

		System.out.print("[");
		st.pop();
		for(Integer i : st)
		{
			System.out.print(i + "\n");
		}
		System.out.println("]");

		// html css jquery javascript java algoritmi
	}

	static int fibonacci(int n)
	{
		if(n < 0)
		{
			return -1;
		}
		if(n == 0)
		{
			return 0;
		}
		else if(n == 1)
		{
			return 1;
		}
		else
		{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}