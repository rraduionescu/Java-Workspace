package ro.ionescu.radu;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class MaxSum
{
	public static int findMaxSum(List<Integer> list)
	{
		int max1 = list.get(0), max2 = list.get(1), pos1 = 0, pos2 = 0, sum = 0;
		for(int i = 0 ; i < list.size() ; i++)
		{
			if(list.get(i) > max1)
			{
				max1 = list.get(i);
				pos1 = i;
			}
		}
		list.remove(pos1);
		for(int i = 0 ; i < list.size() ; i++)
		{
			if(list.get(i) > max2)
			{
				max2 = list.get(i);
				pos2 = i;
			}
		}
		return max1 + max2;
		//Collections.sort(list, Collections.reverseOrder());
		//return list.get(0) + list.get(1);
	}

	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(5, 9, 7, 11);
		System.out.println(findMaxSum(list));
	}
}
