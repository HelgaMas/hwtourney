package ru.netology.domain;

import java.util.ArrayList;
import java.util.List;


public class Game {

    public List<Player> players = new ArrayList<>();

    public void register(Player player) {
        this.players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {

        Player firstPlayer = findByName(playerName1);
        Player secondPlayer = findByName(playerName2);

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(playerName1);
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException(playerName2);
        }
        int result = firstPlayer.getStrength() - secondPlayer.getStrength();

        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return 2;
        }
        return 0;
    }
}