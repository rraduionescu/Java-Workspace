package steganography;

import java.util.Arrays;

public class Tests
{
	public static void main(String[] args)
	{
		boolean[] bits = new boolean[15];
		bits[0] = true;   // 1
		bits[1] = false;  // 0
		bits[2] = false;  // 0
		bits[3] = true;   // 1
		bits[4] = true;   // 1
		bits[5] = false;  // 0
		bits[6] = false;  // 0
		bits[7] = false;  // 0
		bits[8] = true;   // 1
		bits[9] = false;  // 0
		bits[10] = true;  // 1
		bits[11] = true;  // 1
		bits[12] = true;  // 1
		bits[13] = false; // 0
		bits[14] = true;  // 1

		byte[] bytes = new byte[25];
		bytes[0] = 97;   // 97
		bytes[1] = 97;   // 96.
		bytes[2] = 97;   // 96.
		bytes[3] = 98;   // 97
		bytes[4] = 98;   // 97
		bytes[5] = 98;   // 98.
		bytes[6] = 99;   // 98.
		bytes[7] = 99;   // 98.
		bytes[8] = 99;   // 99
		bytes[9] = 100;  // 100
		bytes[10] = 100; // 99.
		bytes[11] = 100; // 99.
		bytes[12] = 101; // 101
		bytes[13] = 101; // 100.
		bytes[14] = 101; // 101
		bytes[15] = 102; // 102
		bytes[16] = 102; // 102
		bytes[17] = 102; // 102
		bytes[18] = 103; // 103
		bytes[19] = 103; // 103
		bytes[20] = 103; // 103
		bytes[21] = 104; // 104
		bytes[22] = 104; // 104
		bytes[23] = 104; // 104
		bytes[24] = 104; // 104

		System.out.println(Arrays.toString(bytes));

		for(int i = 0 ; i < bits.length ; i++)
		{
			if(bits[i] == true)
			{
				if((bytes[i] & 0b0000_0001) == 0)
				{
					System.out.println(i);
					bytes[i]--;
				}
			}
			else
			{
				if((~bytes[i] & 0b0000_0001) == 0)
				{
					System.out.println(i);
					bytes[i]--;
				}
			}
		}

		System.out.println(Arrays.toString(bytes));
	}
}