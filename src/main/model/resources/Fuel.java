package model.resources;

import model.player.PlayerID;

import java.util.HashSet;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description: Represents Fuel in game
 * Responsibilities: Represent Fuel in game
 */
public class Fuel extends Resource {

    // Constructor
    public Fuel() {
        super();
    }

    // Add to storage
    public void addToStorage(ResourceStorage storage) {
        storage.addFuel(this);
    }

}
