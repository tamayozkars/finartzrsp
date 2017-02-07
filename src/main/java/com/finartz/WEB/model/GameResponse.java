package com.finartz.WEB.model;

/**
 * GameResponse
 */
public class GameResponse {

    private boolean firstPlayerWins;
    private boolean secondPlayerWins;
    private String message;
    private String winner;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean isFirstPlayerWins() {
        return firstPlayerWins;
    }

    public void setFirstPlayerWins(boolean firstPlayerWins) {
        this.firstPlayerWins = firstPlayerWins;
    }

    public boolean isSecondPlayerWins() {
        return secondPlayerWins;
    }

    public void setSecondPlayerWins(boolean secondPlayerWins) {
        this.secondPlayerWins = secondPlayerWins;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
