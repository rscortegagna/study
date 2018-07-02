package com.tennisrank.dao;

import com.tennisrank.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlayersDAO {
    private final static Map<Long, Player> PLAYERS = new HashMap<>();

    static {
        generateIdAndADD(new Player("Rafael Nadal"));
        generateIdAndADD(new Player("Roger Federen"));
        generateIdAndADD(new Player("Novak Djokovic"));
        generateIdAndADD(new Player("Pete Sampras"));
        generateIdAndADD(new Player("Andre Agassi"));
        generateIdAndADD(new Player("Gustavo Kuerten"));
    }

    public Collection<Player> searchBySimilarity(String nome) {
        if (nome == null)
            return PLAYERS.values();

        List<Player> matchResults = new ArrayList<>();

        for (Player player : PLAYERS.values()) {
            if (player.getName().toLowerCase().contains(nome.toLowerCase()))
                matchResults.add(player);
        }

        return matchResults;
    }

    public void add(Player player) {
        generateIdAndADD(player);
    }

    private static void generateIdAndADD(Player player) {
        long id = PLAYERS.size() + 1L;
        player.setId(id);
        PLAYERS.put(id, player);
    }
}
