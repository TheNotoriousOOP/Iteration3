package model.map.editor;

import model.map.CubeVector;
import model.map.MapInterface;
import model.map.tile.Tile;
import model.map.tile.Zone;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Defines the game map as a grid of Tiles
 * Responsibilities: Storing, Accessing, and Mutating map grid of Tiles
 */
public class EditorMap implements MapInterface {

    private int maxRadius;
    private Tile[][] map;

    public EditorMap(int maxRadius) {
        if(maxRadius < 1) {
            System.out.printf("ERROR: Invalid maxRadius in EditorMap\n");
        }

        this.maxRadius = maxRadius;
        this.map = new Tile[maxRadius*2+1][maxRadius*2+1];
    }

    @Override
    public Tile getTile(CubeVector pos) {
        return null;
    }

    @Override
    public Tile getNeighborTile(CubeVector pos, Zone bordering) {
        return null;
    }

    @Override
    public void load(String[] dataa) {

    }

    //Implementation detail
    private int cubeToOffX(CubeVector v) {
        return 0;
    }

    //Implementation detail
    private int cubeToOffY(CubeVector v) {
        return 0;
    }
}
