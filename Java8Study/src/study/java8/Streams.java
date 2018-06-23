package study.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TennisPlayer {
    private String name;
    private int grandSlamsTitles;

    public TennisPlayer(String name, int grandSlamsTitles) {
        this.name = name;
        this.grandSlamsTitles = grandSlamsTitles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrandSlamsTitles() {
        return grandSlamsTitles;
    }

    public void setGrandSlamsTitles(int grandSlamsTitles) {
        this.grandSlamsTitles = grandSlamsTitles;
    }
}

public class Streams {

    public static void main(String[] args) {
        List<TennisPlayer> players = new ArrayList<>();
        players.add(new TennisPlayer("Roger Federer", 20));
        players.add(new TennisPlayer("Rafael Nadal", 17));
        players.add(new TennisPlayer("Pete Sampras", 14));
        players.add(new TennisPlayer("Roy Emerson", 12));
        players.add(new TennisPlayer("Nova Djokovic", 12));

        //simple sort
        System.out.println("== Most Grand Slam single titles ==");
        players.sort(Comparator.comparing(TennisPlayer::getGrandSlamsTitles).reversed());
        players.forEach(player -> System.out.println(player.getName() + " - " + player.getGrandSlamsTitles()));
        System.out.println();

        //filtering
        System.out.println("== Players with 15+ Grand Slam titles ==");
        players.stream()
                .filter(player -> player.getGrandSlamsTitles() > 15)
                .forEach(player -> System.out.println(player.getName()));

        //sum
        int totalTitles = players.stream()
                .mapToInt(TennisPlayer::getGrandSlamsTitles)
                .sum();
        System.out.println();
        System.out.println("== Total of Grand Slam titles: " + totalTitles + " ==");
    }
}
