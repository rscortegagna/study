package com.hackerrank.introduction;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-date-and-time/problem
 */
public class DateAndTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String monthInput = scanner.next();
        String dayInput = scanner.next();
        String yearInput = scanner.next();

        System.out.println(getDay(dayInput, monthInput, yearInput));
    }

    private static DayOfWeek getDay(String day, String month, String year) {
        LocalDate date = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        return date.getDayOfWeek();
    }
}
