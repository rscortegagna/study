package com.hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-substring/problem
 */
public class Substring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.next();
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        System.out.println(S.substring(start, end));
    }

}
