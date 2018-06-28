package com.hackerrank.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-string-compare/problem
 */
public class SubstringComparision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }

    private static String getSmallestAndLargest(String s, int substringSize) {
        List<String> tempArray = new ArrayList<>();

        for (int i = 0; i < s.length() - substringSize + 1; i++) {
            tempArray.add(s.substring(i, i + substringSize));
        }

        tempArray.sort(String::compareTo);

        //keeping this variables for better readability
        String smallest = tempArray.get(0);
        String largest = tempArray.get(tempArray.size() - 1);

        return smallest + "\n" + largest;
    }


}
