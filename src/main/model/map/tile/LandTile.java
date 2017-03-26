package model.map.tile;

import model.map.CubeVector;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: a subtype of tile, used for delineating between Land and NonLand
 * Responsibilities: provide standard functionality for all Tiles with Land Terrains 
 */
public abstract class LandTile extends Tile{
    LandTile(CubeVector location, Zone[] zones) {
        super(location, zones);
    }
}
