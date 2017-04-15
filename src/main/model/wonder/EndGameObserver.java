package model.wonder;

import model.game.GameModel;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class EndGameObserver extends WonderObserver{

    public final static int END_GAME_NUMBER = 62;

    private GameModel gameReference;

    public EndGameObserver(GameModel game) {
        super(END_GAME_NUMBER);
        this.gameReference = game;
    }

    @Override
    protected void trigger() {
        //TODO: put game end in game
        //game.end()
    }
}
