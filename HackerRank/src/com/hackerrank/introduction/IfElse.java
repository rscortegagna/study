package com.hackerrank.introduction;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-if-else/problem
 */
public class IfElse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int integerInput = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();

        if (integerInput % 2 == 1) {
            System.out.println("Weird");
        } else {
            if (2 <= integerInput && integerInput <= 5) {
                System.out.println("Not Weird");
            }

            if (6 <= integerInput && integerInput <= 20) {
                System.out.println("Weird");
            }

            if (20 < integerInput) {
                System.out.println("Not Weird");
            }
        }
    }
}
