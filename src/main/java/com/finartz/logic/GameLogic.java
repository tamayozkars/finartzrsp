package com.finartz.logic;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.finartz.WEB.model.MapPopulator.build;

/**
 * GameLogic
 */
@Service
public class GameLogic {

    private Map<String, Boolean> firstWins;

    public synchronized boolean isSame(String firstPlayerMove, String secondPlayerMove){
        if (firstWins == null) {
            firstWins = new HashMap<>();
            firstWins.put("paper-scissors", false);
            firstWins.put("paper-rock", true);
            firstWins.put("rock-scissors", true);
            firstWins.put("rock-paper", false);
            firstWins.put("scissors-paper", true);
            firstWins.put("scissors-rock", false);
        }



        if  (  firstPlayerMove.equals(secondPlayerMove)   ) {
            return true;
        }




        return false;
    }

    public synchronized boolean firstWins(String firstPlayerMove, String secondPlayerMove){



        if (firstWins == null) {
            firstWins = build();
        }



        return  firstWins.get(firstPlayerMove + "-" + secondPlayerMove) ;
            }



}
