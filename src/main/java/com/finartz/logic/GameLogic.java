package com.finartz.logic;

import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import static com.finartz.WEB.model.MapPopulator.build;

/**
 * GameLogic
 */
@Service
public class GameLogic {

    private Map<String, Boolean> firstWins = build();

    public synchronized boolean isSame(String firstPlayerMove, String secondPlayerMove){
        return firstPlayerMove.equals(secondPlayerMove) ;
    }

    public synchronized boolean firstWins(String firstPlayerMove, String secondPlayerMove){
        return  firstWins.get(firstPlayerMove + "-" + secondPlayerMove) ;
    }

    public synchronized boolean firstWinsContains(String firstPlayerMove, String secondPlayerMove){
        return  firstWins.containsKey(firstPlayerMove + "-" + secondPlayerMove) ;
    }
}
