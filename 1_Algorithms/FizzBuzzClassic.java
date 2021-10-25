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
        for(int i=1;i<=number;i++)
        {
            if(i%3!=0 && i%5!=0)
            {
                System.out.print(i);
            }
            if(i%3==0)
            {
             System.out.print("Fizz");
            }
            if(i%5==0)
            {
             System.out.print("Buzz");
            }
            System.out.println();
        }
    }
}