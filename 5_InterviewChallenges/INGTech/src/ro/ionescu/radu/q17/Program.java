package ro.ionescu.radu.q17;

import java.util.ArrayList;
import java.util.Arrays;

public class Program
{
	public static void main(String[] args)
	{
		int[] tickets = new int[]{2, 11, 4, 8, 10, 9, 5, 2, 11};

		ArrayList<Integer> results = new ArrayList<>();
		Arrays.sort(tickets);

		for(int i : tickets)
		{
			System.out.print(i + " ");
		}
		System.out.println();

		int max = 1;
		for(int i = 1 ; i < tickets.length ; i++)
		{
			if(tickets[i] - tickets[i - 1] == 0 || tickets[i] - tickets[i - 1] == 1)
			{
				max++;
			}
			else
			{
				results.add(max);
				max = 1;
			}
			if(i == tickets.length - 1)
			{
				results.add(max);
			}
		}
		max = 0;
		for(Integer i : results)
		{
			System.out.print(i + " ");
			if(i.intValue() > max)
			{
				max = i.intValue();
			}
		}
		System.out.println("\n" + max);
	}
}