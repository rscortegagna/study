package com.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.next();
        String secondString = scanner.next();

        System.out.println(isAnagram(firstString,secondString) ? "Anagrams" : "Not Anagrams");
    }

    static boolean isAnagram(String firstString, String secondString) {
        Map<Character, Integer> word1 = new HashMap<>();
        Map<Character, Integer> word2 = new HashMap<>();

        for (char c : firstString.toLowerCase().toCharArray()) {
            word1.merge(c, 1, Integer::sum);
        }
        for (char c : secondString.toLowerCase().toCharArray()) {
            word2.merge(c, 1, Integer::sum);
        }

        if (word1.equals(word2)) {
            return true;
        } else {
            return false;
        }
    }

}
