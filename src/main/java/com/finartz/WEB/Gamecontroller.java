package com.finartz.WEB;

import com.finartz.WEB.model.GameRequest;
import com.finartz.WEB.model.GameResponse;
import com.finartz.logic.GameLogic;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameController
 */
@RestController
@RequestMapping("/game")
public class Gamecontroller implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @RequestMapping(value = "/play", method = RequestMethod.POST)
    public GameResponse play(@RequestBody GameRequest request) {
        GameLogic gameLogic = applicationContext.getBean(GameLogic.class);
        GameResponse gameResponse = new GameResponse();

        boolean isKeyExists = gameLogic.firstWinsContains( request.getFirstPlayerMove(), request.getSecondPlayerMove());

        gameResponse = isKeyExists ? decideWinner(request, gameResponse, gameLogic): sameOrInvalid(request, gameResponse, gameLogic);

        return gameResponse;
    }

    private GameResponse decideWinner(GameRequest request, GameResponse gameResponse, GameLogic gameLogic){
        boolean firstPlayerWin = gameLogic.firstWins(request.getFirstPlayerMove(), request.getSecondPlayerMove());
        gameResponse.setFirstPlayerWins(firstPlayerWin);
        gameResponse.setSecondPlayerWins(!firstPlayerWin);
        gameResponse.setWinner(firstPlayerWin ? request.getFirstPlayerName() : request.getSecondPlayerName());

        prepareWinningMessage(request, firstPlayerWin, gameResponse);
        return  gameResponse;
    }

    private GameResponse sameOrInvalid(GameRequest request, GameResponse gameResponse, GameLogic gameLogic){
        boolean same = gameLogic.isSame(request.getFirstPlayerMove(), request.getSecondPlayerMove());
        gameResponse.setFirstPlayerWins(false);
        gameResponse.setSecondPlayerWins(false);
        gameResponse.setWinner("");

        prepareSameOrInvalidMessage(request, same, gameResponse);
        return gameResponse;
    }

    private void prepareWinningMessage(GameRequest request, boolean firstPlayerWin, GameResponse gameResponse) {
        String winningMessage = " won the game";
        gameResponse.setMessage(firstPlayerWin ? request.getFirstPlayerName() + winningMessage: request.getSecondPlayerName() + winningMessage);
    }

    private void prepareSameOrInvalidMessage(GameRequest request, boolean same, GameResponse gameResponse){
        String sameMessage = request.getFirstPlayerName() + " and " + request.getSecondPlayerName() + " made same move.";
        String notFoundMessage = request.getFirstPlayerName() + " or " + request.getSecondPlayerName() + " made an invalid move";
        gameResponse.setMessage(same ? sameMessage:notFoundMessage);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
