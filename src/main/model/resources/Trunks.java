package model.resources;

import model.player.PlayerID;

import java.util.HashSet;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Trunks extends Resource {

    // Constructor
    public Trunks() {
        super();
    }

    // Add to storage
    public void addToStorage(ResourceStorage storage) {
        storage.addTrunks(this);
    }

}
