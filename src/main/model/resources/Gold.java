package model.resources;

import model.player.PlayerID;

import java.util.HashSet;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description: Represents Gold in game
 * Responsibilities: Represent Gold in game
 * Act as points at the end of the game
 */
public class Gold extends Resource {

    // Constructor
    public Gold() {
        super();
    }

    // Add to storage
    public void addToStorage(ResourceStorage storage) {
        storage.addGold(this);
    }

}
