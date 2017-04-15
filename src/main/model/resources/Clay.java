package model.resources;

import model.player.PlayerID;

import java.util.HashSet;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description: Represents clay in game
 * Responsibilities: Represent clay in game
 */
public class Clay extends Resource {

    // Constructor
    public Clay() {
        super();
    }

    // Add to storage
    public void addToStorage(ResourceStorage storage) {
        storage.addClay(this);
    }

}
