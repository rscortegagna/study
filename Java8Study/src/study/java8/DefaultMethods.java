package study.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethods {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("a word");
        words.add("a huge word");
        words.add("a big word");

        Comparator<String> comparator = new CompareStringBySize();

        //custom sort ArrayList
        //java7
        Collections.sort(words, comparator);
        System.out.println("output with java 7: " + words);
        //java8
        words.sort(comparator);
        System.out.println("output with java 8: " + words);
        System.out.println();

        //foreach Iterable
        //java7
        System.out.println("==foreach java 7==");
        for (String word : words) {
            System.out.println(word);
        }
        //java8
        //more verbose here for study purpose
        System.out.println();
        System.out.println("==foreach java 8==");
        words.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}

class CompareStringBySize implements Comparator<String> {
    public int compare(String string1, String string2) {
        //not using Integer.compare for study purpose
        if (string1.length() < string2.length()) {
            return -1;
        }
        if (string1.length() > string2.length()) {
            return 1;
        }
        return 0;
    }
}