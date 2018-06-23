package com.hackerrank.introduction;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem
 */
public class StdinStdoutI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int integerInput1 = scanner.nextInt();
        int integerInput2 = scanner.nextInt();
        int integerInput3 = scanner.nextInt();
        scanner.close();

        System.out.println(integerInput1);
        System.out.println(integerInput2);
        System.out.println(integerInput3);
    }
}
