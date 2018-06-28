package com.hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-string-reverse/problem
 */
public class StringReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringInput = scanner.next();

        String reversedString = new StringBuilder(stringInput).reverse().toString();

        System.out.println(stringInput.equals(reversedString) ? "Yes" : "No");

    }
}
