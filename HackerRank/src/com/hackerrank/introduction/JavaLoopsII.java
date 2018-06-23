package com.hackerrank.introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-loops/problem
 */
public class JavaLoopsII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repetitions = scanner.nextInt();
        for (int i = 0; i < repetitions; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            printResult(a, b, n);
        }
        scanner.close();
    }

    private static void printResult(int initial, int number, int repetitions) {
        List<Integer> result = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < repetitions; i++) {
            if (i == 0) {
                temp = (int) (initial + (Math.pow(2, i) * number));
                result.add(temp);
            } else {
                temp += Math.pow(2, i) * number;
                result.add(temp);
            }
        }
        System.out.println(result.toString().replace("[", "").replace("]", "").replace(",", ""));
    }
}
