package model.resources;

import model.player.PlayerID;

import java.util.HashSet;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description: Represents boards in game
 * Responsibilities: Represent boards in game
 */
public class Boards extends Resource {

    // Constructor
    public Boards() {
        super();
    }

    // Add to storage
    public void addToStorage(ResourceStorage storage) {
        storage.addBoards(this);
    }

}
