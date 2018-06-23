package com.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Dates {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println(today);

        LocalDate worldCup = LocalDate.of(2018, Month.JUNE, 14);

        //between days
        Period period = Period.between(today, worldCup);
        System.out.println(period.getMonths() + " months and " + period.getDays() + " days");

        //operation
        LocalDate nextWorldCup = worldCup.plusYears(4);
        System.out.println(nextWorldCup);

        //formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedValue = nextWorldCup.format(formatter);
        System.out.println(formattedValue);

        //formatter with hours
        DateTimeFormatter formatterWithTime = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(formatterWithTime));
    }

}
