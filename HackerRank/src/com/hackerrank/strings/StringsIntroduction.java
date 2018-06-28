package com.hackerrank.strings;


import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-strings-introduction/problem
 */
public class StringsIntroduction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String A = scanner.next();
        String B = scanner.next();

        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " + B.substring(0, 1).toUpperCase() + B.substring(1));
    }
}
