package model.map;

import model.map.tile.Tile;
import model.map.tile.Zone;

import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */
public interface MapInterface {

    Tile getTile(CubeVector pos);
    Tile getNeighborTile(CubeVector pos, Zone bordering);
    void load(String[] dataa);
    ArrayList<Tile> getNeighboringTiles(Tile t);

}
