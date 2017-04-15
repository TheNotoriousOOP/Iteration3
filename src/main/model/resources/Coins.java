package model.resources;

import model.player.PlayerID;

import java.util.HashSet;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description: Represents Coins in game
 * Responsibilities: Represent Coins in game
 */
public class Coins extends Resource {

    // Constructor
    public Coins() {
        super();
    }

    // Add to storage
    public void addToStorage(ResourceStorage storage) {
        storage.addCoins(this);
    }

}
