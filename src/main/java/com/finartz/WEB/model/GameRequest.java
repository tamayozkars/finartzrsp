package com.finartz.WEB.model;

/**
 * GameRequest
 */
public class GameRequest {

    private String firstPlayerName;
    private String firstPlayerMove;
    private String secondPlayerName;
    private String secondPlayerMove;

    public String getFirstPlayerName() {
        return firstPlayerName;
    }

    public void setFirstPlayerName(String firstPlayerName) {
        this.firstPlayerName = firstPlayerName;
    }

    public String getFirstPlayerMove() {
        return firstPlayerMove;
    }

    public void setFirstPlayerMove(String firstPlayerMove) {
        this.firstPlayerMove = firstPlayerMove;
    }

    public String getSecondPlayerName() {
        return secondPlayerName;
    }

    public void setSecondPlayerName(String secondPlayerName) {
        this.secondPlayerName = secondPlayerName;
    }

    public String getSecondPlayerMove() {
        return secondPlayerMove;
    }

    public void setSecondPlayerMove(String secondPlayerMove) {
        this.secondPlayerMove = secondPlayerMove;
    }
}
