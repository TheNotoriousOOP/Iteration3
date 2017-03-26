package model.map.editor;

import model.map.CubeVector;
import model.map.MapInterface;
import model.map.tile.Tile;
import model.map.tile.WoodsTile;
import model.map.tile.Zone;

import java.util.ArrayList;
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
        if(!boundsCheck(pos)) {
            System.out.printf("Invalid Coordinate");
            return null;
        }
        return map.get(pos);
    }

    @Override
    public Tile getNeighborTile(CubeVector pos, Zone bordering) {
        //May not need this anymore
        return null;
    }

    public ArrayList<Tile> getNeighboringTiles(Tile t){
        ArrayList<Tile> neighbors = new ArrayList<Tile>();
        CubeVector north = new CubeVector(t.getLocation().getXCoord(), t.getLocation().getYCoord()+1, t.getLocation().getZCoord()-1);
        CubeVector northeast = new CubeVector(t.getLocation().getXCoord()+1, t.getLocation().getYCoord(), t.getLocation().getZCoord()-1);
        CubeVector southeast = new CubeVector(t.getLocation().getXCoord()+1, t.getLocation().getYCoord()-1, t.getLocation().getZCoord());
        CubeVector south = new CubeVector(t.getLocation().getXCoord(), t.getLocation().getYCoord()-1, t.getLocation().getZCoord()+1);
        CubeVector southwest = new CubeVector(t.getLocation().getXCoord()-1, t.getLocation().getYCoord(), t.getLocation().getZCoord()+1);
        CubeVector northwest = new CubeVector(t.getLocation().getXCoord()-1, t.getLocation().getYCoord()+1, t.getLocation().getZCoord());
        neighbors.add(getTile(north));
        neighbors.add(getTile(northeast));
        neighbors.add(getTile(southeast));
        neighbors.add(getTile(south));
        neighbors.add(getTile(southwest));
        neighbors.add(getTile(northwest));
        return neighbors;

    }

    @Override
    public void load(String[] data) {





    }

    public void add(CubeVector pos, Tile t) {
        if(!boundsCheck(pos)) {
            System.out.printf("Invalid Coordinate");
            return;
        }
        map.put(pos, t);
    }

    public void remove(CubeVector pos) {
        map.remove(pos);
    }

    public String[] save() {
        return null;
    }

    private boolean boundsCheck(CubeVector pos) {
        int dis = Math.abs(pos.getXCoord()) + Math.abs(pos.getZCoord()) + Math.abs(pos.getYCoord()) / 2;
        return dis <= maxRadius;
    }

    //Only for testing, remove after editor map loading works
    public boolean hasThisManyTiles(int numTiles) {
        return (map.size() == numTiles);
    }
}
