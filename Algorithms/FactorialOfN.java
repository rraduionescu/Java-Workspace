import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if(number == 0)
        {
            System.out.println(1);
        }
        else if(number>0)
        {
            BigInteger factorial = BigInteger.valueOf(1);
            for(int i = 1 ; i <= number ; i++)
            {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            System.out.println(factorial);
        }
    }
}