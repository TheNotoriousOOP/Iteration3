package model.temple;

import model.player.PlayerID;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Monk {
    private PlayerID playerID;

    public Monk(PlayerID playerID) {
        this.playerID = playerID;
    }

    public PlayerID getPlayerID() {
        return playerID;
    }
}
