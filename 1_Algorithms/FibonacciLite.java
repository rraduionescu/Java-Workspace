import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(calculateRecursive(n));
    }
    public static long calculateRecursive(int length)
    {
        if(length == 0)
        {
            return 0;
        }
        else if(length < 3)
        {
            return 1;
        }
        else
        {
            return calculateRecursive(length - 1) + calculateRecursive(length - 2);
        }
    }
}