package ionescu.radu.exercise;

import java.util.ArrayList;
import java.util.Arrays;

public class Program
{
	public static void main(String[] args)
	{
		int[]              tickets = new int[]{8, 5, 4, 8, 4};
		ArrayList<Integer> results = new ArrayList<>();
		Arrays.sort(tickets);
		int max = 1;
		for(int i = 1 ; i < tickets.length ; i++)
		{
			if(tickets[i] - tickets[i - 1] == 0 && tickets[i] - tickets[i - 1] == 1)
			{
				max++;
			}
			else
			{
				results.add(max);
				max = 1;
			}
		}
		max = 0;
		for(Integer i : results)
		{
			if(i.intValue() > max)
			{
				max = i.intValue();
			}
		}
		System.out.println(max);
	}
}
