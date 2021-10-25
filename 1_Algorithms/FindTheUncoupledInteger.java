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
        String in = scanner.nextLine();
        String[] input = in.split(", ");
        int result = Integer.parseInt(input[0]);
        for(int i=1;i<input.length;i++)
        {
            result = result ^ Integer.parseInt(input[i]);
        }
        System.out.println(result);
    }
}