package model.map.tile;

import model.map.CubeVector;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Subclass of LandTile and Tile, may have river
 * Responsibilities: Build SawCutter for lumber production
 */
public class WoodsTile extends LandTile {
    WoodsTile(CubeVector location, Zone[] zones) {
        super(location, zones);
    }
}
