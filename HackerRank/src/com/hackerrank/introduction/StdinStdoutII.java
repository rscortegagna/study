package com.hackerrank.introduction;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-stdin-stdout/problem
 */
public class StdinStdoutII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer integerInput = scanner.nextInt();
        Double doubleInput = scanner.nextDouble();
        scanner.nextLine();
        String stringInput = scanner.nextLine();
        scanner.close();

        System.out.println("String: " + stringInput);
        System.out.println("Double: " + doubleInput);
        System.out.println("Int: " + integerInput);
    }
}
