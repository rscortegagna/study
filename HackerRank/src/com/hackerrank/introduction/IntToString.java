package com.hackerrank.introduction;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-int-to-string/problem
 */
public class IntToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int integerInput = scanner.nextInt();
        scanner.close();

        String numberAsString = String.valueOf(integerInput);

        if (integerInput == Integer.parseInt(numberAsString)) {
            System.out.println("Good job");
        } else {
            System.out.println("Wrong answer.");
        }
    }
}

