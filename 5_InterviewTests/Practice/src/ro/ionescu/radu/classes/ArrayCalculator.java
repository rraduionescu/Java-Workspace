package ro.ionescu.radu.classes;

public class ArrayCalculator
{
	public static int[] sort(int[] array)
	{
		for(int i = 0 ; i < array.length ; i++)
		{
			for(int j = i ; j < array.length ; j++)
			{
				if(array[i] > array[j])
				{
					int aux = array[i];
					array[i] = array[j];
					array[j] = aux;
				}
			}
		}
		return array;
	}

	public static int[] reverse(int[] array)
	{
		int[] reversed = new int[array.length];
		for(int i = array.length - 1 ; i >= 0 ; i--)
		{
			reversed[array.length - i - 1] = array[i];
		}
		return reversed;
	}

	public static int[] removeDuplicates(int[] array)
	{
		sort(array);
		int aux = 0;
		for(int i = 0 ; i < array.length ; i++)
		{
			if(array[aux] != array[i])
			{
				aux++;
				array[aux] = array[i];
			}
		}
		int[] clean = new int[aux + 1];
		for(int i = 0 ; i < clean.length ; i++)
		{
			clean[i] = array[i];
		}
		return clean;
	}
}
