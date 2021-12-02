package ro.ionescu.radu.main;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Decimal number :");
		int decimal = inputScanner.nextInt();

		// V 1
		int   i      = 0;
		int   d1     = decimal;
		int[] binary = new int[32];

		while(d1 != 0)
		{
			binary[i++] = d1 % 2;
			d1 /= 2;
		}

		for(int j = i - 1 ; j >= 0 ; j--)
		{
			System.out.print(binary[j]);
		}

		// V 2
		System.out.println();
		for(i = 31; i >= 0 ; i--)
		{
			System.out.print((decimal >> i) % 2);
		}
	}
}