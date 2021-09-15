package com;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
	    Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.print("\nN: ");
            int n = scanner.nextInt();

            if (n < 15)
            {
                var result = new ShortNumbersCalculator(n).getSum();
                System.out.printf("Result = %s : %s", result[0], result[1]);
            }
            else
            {
                var result = new LongNumbersCalculator(n).getSum();
                System.out.printf("Result = %s : %s", result[0], result[1]);
            }
        }
    }
}
