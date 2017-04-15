package model.map;

import model.map.tile.Tile;

import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */
public interface MapInterface {

    Tile getTile(CubeVector pos);
    void load(String[] data);
    ArrayList<Tile> getNeighboringTiles(Tile t);

}
