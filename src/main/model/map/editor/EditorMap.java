package model.map.editor;

import model.map.CubeVector;
import model.map.MapInterface;
import model.map.tile.Tile;
import model.map.tile.WoodsTile;
import model.map.tile.Zone;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Defines the game map as a grid of Tiles
 * Responsibilities: Storing, Accessing, and Mutating map grid of Tiles
 * Implementation: Stored as Hashmap
 */
public class EditorMap implements MapInterface {

    private int maxRadius;
    private Map<CubeVector, Tile> map;

    public EditorMap(int maxRadius) {
        if(maxRadius < 1) {
            System.out.printf("ERROR: Invalid maxRadius in EditorMap\n");
        }
        this.maxRadius = maxRadius;
        //int size = (maxRadius+1) * (maxRadius+1) * (maxRadius+1) + 1;
        this.map = new HashMap<CubeVector, Tile>();
    }

    @Override
    public Tile getTile(CubeVector pos) {
        if(!coordinateCheck(pos))
            System.out.printf("Invalid Coordinate");
        return map.get(pos);
    }

    @Override
    public Tile getNeighborTile(CubeVector pos, Zone bordering) {
        //May not need this anymore
        return null;
    }

    @Override
    public void load(String[] data) {

    }

    private boolean coordinateCheck(CubeVector pos) {
        int dis = Math.abs(pos.getXCoord()) + Math.abs(pos.getZCoord()) + Math.abs(pos.getYCoord()) / 2;
        return dis <= maxRadius;
    }

    //Only for testing, remove after editor map loading works
    public boolean hasThisManyTiles(int numTiles) {
        if (map.size() == numTiles) {
            return true;
        }
        else {
            return false;
        }
    }
}
