package com.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MethodReferences {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("a word");
        words.add("a huge word");
        words.add("a big word");

        //custom sort ArrayList with lambda
        //words.sort(Comparator.comparingInt(s -> s.length()));
        words.sort(Comparator.comparingInt(String::length));
        System.out.println("output with java 8: " + words);
        System.out.println();

        //foreach Iterable with lambda
        System.out.println("==foreach java 8==");
        //words.forEach(s -> System.out.println(s));
        words.forEach(System.out::println);
    }
}
