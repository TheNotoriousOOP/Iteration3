package model.resources;

import model.player.PlayerID;

import java.util.HashSet;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Iron extends Resource {

    // Constructor
    public Iron() {
        super();
    }

    // Add to storage
    public void addToStorage(ResourceStorage storage) {
        storage.addIron(this);
    }

}
