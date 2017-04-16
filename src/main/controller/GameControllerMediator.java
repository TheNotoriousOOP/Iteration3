package controller;

/**
 * Created by Jonathen on 4/16/2017.
 */
public class GameControllerMediator {
    private GameController gameController;

    public GameControllerMediator(GameController gameController) {
        this.gameController = gameController;
    }

    public void endTurn() { gameController.endTurn();}
}
