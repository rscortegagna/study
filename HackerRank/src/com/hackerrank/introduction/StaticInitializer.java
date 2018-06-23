package com.hackerrank.introduction;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-static-initializer-block/problem
 */
public class StaticInitializer {
    static Scanner scanner = new Scanner(System.in);
    static int B;
    static int H;
    static boolean flag;

    static {
        B = scanner.nextInt();
        H = scanner.nextInt();

        if (B <= 0 || H < 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {
            flag = true;
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}

