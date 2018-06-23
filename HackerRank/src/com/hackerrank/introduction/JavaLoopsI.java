package com.hackerrank.introduction;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-loops-i/problem
 */
public class JavaLoopsI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int integerInput = scanner.nextInt();
        scanner.close();

        //starting in 1 and finishing in 11 to do not check 0
        for (int i = 1; i < 11; i++) {
            System.out.println(integerInput + " x " + i + " = " + integerInput * i);
        }
    }
}
