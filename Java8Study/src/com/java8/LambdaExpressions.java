package com.java8;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("a word");
        words.add("a huge word");
        words.add("a big word");

        //custom sort ArrayList with lambda
        // not using Comparator.comparingInt(String::length) for study purpose
        words.sort((string1, string2) -> Integer.compare(string1.length(), string2.length()));
        System.out.println("output with java 8 (lambda): " + words);
        System.out.println();

        //foreach Iterable with lambda
        //not using method reference for study purpose
        System.out.println("==foreach java 8 (lambda)==");
        words.forEach(s -> System.out.println(s));
    }
}
