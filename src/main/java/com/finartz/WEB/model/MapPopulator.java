package com.finartz.WEB.model;

import java.util.HashMap;

/**
 * MapPopulator
 */
public class MapPopulator {

    public static HashMap<String, Boolean> build() {
        HashMap<String, Boolean> firstWins = new HashMap<>();
        firstWins.put("paper-scissors", false);
        firstWins.put("paper-rock", true);
        firstWins.put("rock-scissors", true);
        firstWins.put("rock-paper", false);
        firstWins.put("scissors-paper", true);
        firstWins.put("scissors-rock", false);
        return firstWins;
    }
}
