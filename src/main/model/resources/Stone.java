package model.resources;

import model.player.PlayerID;

import java.util.HashSet;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Stone extends Resource {

    // Constructor
    public Stone() {
        super();
    }

    // Add to storage
    public void addToStorage(ResourceStorage storage) {
        storage.addStone(this);
    }

}
