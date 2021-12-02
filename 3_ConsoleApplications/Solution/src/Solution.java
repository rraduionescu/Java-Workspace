import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution
{

	public static void main(String[] args)
	{
		BufferedReader sc      = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int      m      = Integer.parseInt(sc.readLine());
			String[] values = sc.readLine().split(" ");
			int      n      = values.length;

			LinkedList list = new LinkedList();
			for(int i = 0 ; i < n ; i++)
			{
				list.add(values[i]);
			}

			if(m < 1 || m > n)
			{
				System.out.println("NIL");
			}
			else
			{
				System.out.println(list.get(n - m));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}