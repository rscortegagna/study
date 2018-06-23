package com.java8;

import java.util.*;
import java.util.stream.Collectors;

public class OptionalAndCollectors {
    public static void main(String[] args) {
        List<TennisPlayer> players = new ArrayList<>();
        players.add(new TennisPlayer("Roger Federer", 20));
        players.add(new TennisPlayer("Rafael Nadal", 17));
        players.add(new TennisPlayer("Pete Sampras", 14));
        players.add(new TennisPlayer("Roy Emerson", 12));
        players.add(new TennisPlayer("Nova Djokovic", 12));


        //Optional
        //doing more verbose code here for study purpose
        Optional<TennisPlayer> optionalTennisPlayer = players.stream()
                .filter(tp -> tp.getGrandSlamsTitles() > 15)
                .findAny();

        //TennisPlayer player = optionalTennisPlayer.get();

        optionalTennisPlayer.ifPresent(tp -> System.out.println(tp.getName()));

        //less verbose option
        players.stream()
                .filter(tp -> tp.getGrandSlamsTitles() > 15)
                .findAny()
                .ifPresent(tp -> System.out.println(tp.getName()));

        //Collector
        //toList
        List<TennisPlayer> listCollector = players.stream()
                .filter(tp -> tp.getGrandSlamsTitles() > 15)
                .collect(Collectors.toList());

        //toMap
        Map<String, Integer> mapCollector = players.stream()
                .filter(tp -> tp.getGrandSlamsTitles() > 15)
                .collect(Collectors.toMap(
                        tp -> tp.getName(),
                        tp -> tp.getGrandSlamsTitles()
                ));

        System.out.println(mapCollector);

        //average of titles by player
        //not using method reference for study purpose
        OptionalDouble average = players.stream()
                .mapToInt(tp -> tp.getGrandSlamsTitles())
                .average();

        System.out.println("Average: " + average.getAsDouble());
    }
}
