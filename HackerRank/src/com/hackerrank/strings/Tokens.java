package com.hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-string-tokens/problem
 */
public class Tokens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringInput = scanner.nextLine();
        scanner.close();

        String delimiter = "[ !,?._'@]+";
        String[] tokens = stringInput.trim().split(delimiter);

        if (stringInput.isEmpty() || stringInput.trim().isEmpty()) {
            System.out.println("0");
        } else if (stringInput.length() > 400000) {
            return;
        } else {
            System.out.println(tokens.length);
        }

        for (String token : tokens) {
            System.out.println(token);
        }
    }
}