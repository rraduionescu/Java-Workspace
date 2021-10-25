package ro.ionescu.radu.main;

import java.util.Arrays;

public class Main
{
	public static void main(String[] args)
	{
		// Execution Control
		int a = 93, b = 34;
		if(a > b)
		{
			System.out.println("a > b");
		}
		else
		{
			System.out.println("a <= b");
		}

		switch(a)
		{
			case 5:
				System.out.println("5");
				break;
			case 93:
				System.out.println("a = 93");
				break;
			default:
				System.out.println("default");
		}

		int number = 1023493;
		while(number != 0)
		{
			System.out.print(number % 10);
			number /= 10;
		}

		System.out.println();
		outerFor:
		for(int i = 1 ; i < 3 ; i++)
		{
			for(int j = 1 ; j < 10 ; j++)
			{
				if(j % 5 == 0)
				{
					System.out.println();
					continue outerFor;
				}
				System.out.print(j);
			}
			System.out.println();
		}

		// Arrays
		int[] integerArray = new int[10];
		for(int i = 0 ; i < integerArray.length ; i++)
		{
			integerArray[i] = (int)(i * 30 * Math.random());
		}
		for(int i : integerArray)
		{
			System.out.print(i + " ");
		}
		System.out.println("\n" + Arrays.toString(integerArray));

		int[][] integerMatrix = new int[5][5];
		for(int i = 0 ; i < integerMatrix.length ; i++)
		{
			for(int j = 0 ; j < integerMatrix[i].length ; j++)
			{
				if(i * j < 10)
				{
					System.out.print("0");
				}
				System.out.print(integerMatrix[i][j] = i * j);
				System.out.print(" ");
			}
			System.out.println();
		}

		int[][] int2DAraay = new int[4][];
		int2DAraay[0] = new int[5];
		int2DAraay[1] = new int[2];
		int2DAraay[2] = new int[4];
		int2DAraay[3] = new int[3];
		for(int i = 0 ; i < int2DAraay.length ; i++)
		{
			for(int j = 0 ; j < int2DAraay[i].length ; j++)
			{
				int2DAraay[i][j] = i * j;
			}
		}
		int2DAraay[0] = integerArray;
		for(int i = 0 ; i < int2DAraay.length ; i++)
		{
			for(int j = 0 ; j < int2DAraay[i].length ; j++)
			{
				if(int2DAraay[i][j] < 10)
				{
					System.out.print("0");
				}
				System.out.print(int2DAraay[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println(Arrays.deepToString(int2DAraay));

		Arrays.sort(integerArray);
		System.out.println(Arrays.toString(integerArray));
	}
}
