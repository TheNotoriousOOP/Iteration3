package model.map.tile;

import model.map.CubeVector;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class Tile {

    private CubeVector location;
    private Zone[] borderZone;

    Tile(CubeVector location, Zone[] borderZone){
        this.location = location;
        this.borderZone = borderZone;
    }

    //public abstract void buildStructure(Structure target);
    //Not needed until Phase 2

}
