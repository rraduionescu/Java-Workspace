package ro.skillvalue.ionescu.radu.classes;

public class PalindromeChecker
{
	public static boolean checkPalindrome(String input)
	{
		if(input.length() % 2 == 0)
		{
			long check = input.charAt(0);

			for(int i = 1 ; i < input.length() ; i++)
			{
				check = check ^ input.charAt(i);
			}

			return check == 0;
		}
		else
		{
			int[] characterCount = new int[256];

			for(int i = 0 ; i < input.length() ; i++)
			{
				characterCount[input.charAt(i)]++;
			}
			int oddCount = 0;
			for(int i = 0 ; i < characterCount.length ; i++)
			{
				if(characterCount[i] % 2 == 1)
				{
					oddCount++;
				}
				if(oddCount > 1)
				{
					return false;
				}
			}
			return true;
		}
	}
}