package ro.skillvalue.ionescu.radu.main;

import ro.skillvalue.ionescu.radu.classes.PalindromeChecker;
import ro.skillvalue.ionescu.radu.classes.SpaceRemover;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String  input;

		System.out.print("Input string: ");
		input = scanner.nextLine();

		if(PalindromeChecker.checkPalindrome(input))
		{
			System.out.println("Input sequence can be rearranged to form a palindromic sequence.\n");
		}
		else
		{
			System.out.println("Input sequence can NOT be rearranged to form a palindromic sequence.\n");
		}

		System.out.print("Input string: ");
		input = scanner.nextLine();

		System.out.println(SpaceRemover.removeSpaces(input));
	}
}