package model.map.editor;

import model.map.CubeVector;
import model.map.MapInterface;
import model.map.tile.Tile;
import model.map.tile.WoodsTile;
import model.map.tile.Zone;
import model.utilities.TileUtilities;

import java.util.*;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Defines the game map as a grid of Tiles
 * Responsibilities: Storing, Accessing, and Mutating map grid of Tiles
 * Implementation: Stored as Hashmap
 */
public class EditorMap implements MapInterface {
    private final int maxDistance = 21; //no tile can be placed more than 21 away from the others
    private Map<CubeVector, Tile> map;
    private TileUtilities tileUtilities;

    public EditorMap() {
        this.map = new HashMap<CubeVector, Tile>();
        this.tileUtilities = new TileUtilities();
    }

    @Override
    public Tile getTile(CubeVector pos) {
        return map.get(pos);
    }

    @Override
    public Tile getNeighborTile(CubeVector pos, Zone bordering) {
        //May not need this anymore
        return null;
    }


    @Override
    public ArrayList<Tile> getNeighboringTiles(Tile t){
        ArrayList<Tile> neighbors = new ArrayList<Tile>();
        CubeVector north = new CubeVector(t.getLocation().getXCoord(), t.getLocation().getYCoord()+1, t.getLocation().getZCoord()-1);
        CubeVector northeast = new CubeVector(t.getLocation().getXCoord()+1, t.getLocation().getYCoord(), t.getLocation().getZCoord()-1);
        CubeVector southeast = new CubeVector(t.getLocation().getXCoord()+1, t.getLocation().getYCoord()-1, t.getLocation().getZCoord());
        CubeVector south = new CubeVector(t.getLocation().getXCoord(), t.getLocation().getYCoord()-1, t.getLocation().getZCoord()+1);
        CubeVector southwest = new CubeVector(t.getLocation().getXCoord()-1, t.getLocation().getYCoord(), t.getLocation().getZCoord()+1);
        CubeVector northwest = new CubeVector(t.getLocation().getXCoord()-1, t.getLocation().getYCoord()+1, t.getLocation().getZCoord());


        //ensure a tile exists in the proposed location before adding it to the list of neighboring tiles

        if(vectorIsInMap(north)){
            neighbors.add(getTile(north));
        }
        if(vectorIsInMap(northeast)){
            neighbors.add(getTile(northeast));
        }
        if(vectorIsInMap(southeast)){
            neighbors.add(getTile(southeast));
        }
        if(vectorIsInMap(south)){
            neighbors.add(getTile(south));
        }
        if(vectorIsInMap(southwest)){
            neighbors.add(getTile(southwest));
        }
        if(vectorIsInMap(northwest)){
            neighbors.add(getTile(northwest));
        }


        return neighbors;

    }

    //checks if a vector location exists in the map
    private boolean vectorIsInMap(CubeVector location) {
        return map.containsKey(location);
    }

    @Override
    public void load(String[] data) {





    }

    public void add(CubeVector pos, Tile t) {
        if(!isWithinMaxDistance(t)) {
            System.out.printf("class EDITORMAP: Tile Out of Bounds");
            return;
        }

        //check if the tile can be placed
        if(tileUtilities.canTileBePlaced(t, getNeighboringTiles(t))){
            map.put(pos, t);    //add tile

            //update all influenced zones to reflect a new connection
            for (Tile neighborToT : getNeighboringTiles(t)){
                Zone[] sharedZones = tileUtilities.getSharedZones(t, neighborToT);
                setMergedInWateredZones(sharedZones);
            }

        }

    }

    //updates all watered zones to be merged if adding to the map is successful
    private void setMergedInWateredZones(Zone[] sharedZones) {
        for (Zone zone : sharedZones){
            if (zone.isHasWater()){
                zone.setMerged(true);
            }
        }
    }

    public void remove(CubeVector pos) {
        map.remove(pos);
        //TODO update the neighboring zones isMerged.
        //TODO cannot currently be done with how zone is designed! BAD!!
    }

    public String[] save() {
        String[] mapString = new String[map.size()+1];
        mapString[0] = String.valueOf(map.size());

        Iterator tileItr = map.values().iterator();
        int lineIndex = 1;
        while (tileItr.hasNext()) {
            mapString[lineIndex] = tileItr.next().toString();
            lineIndex++;
        }

        return mapString;
    }

    //compare distance between tile t with every existing tile
    private boolean isWithinMaxDistance(Tile t){
        boolean distanceFlag;

        for (Tile existingTile : map.values()){
            distanceFlag = (tileUtilities.calculateDistance(t, existingTile) <= maxDistance);
            if (!distanceFlag){
                return false;
            }
        }

        return true;
    }

    /* Given list of tiles, calculate center of gravity
     * Calculations made assuming flattop hex cube coords
     *  Formula: Add up all x, y, and z values
     *              Divide the Sum(X), Sum(Y), and Sum(Z) values by # of tiles
     *              Values are now COG location vector
     */
    public CubeVector calculateCenterOfGravity() {

        Set<CubeVector> tileVectors = map.keySet();

        // Sum values
        int centerX = 0, centerY = 0, centerZ = 0;

        // Summation of each coord for all tiles
        for (CubeVector v: tileVectors) {
            centerX += v.getXCoord();
            centerY += v.getYCoord();
            centerZ += v.getZCoord();
        }

        // Divide by number of tiles
        centerX /= tileVectors.size();
        centerY /= tileVectors.size();
        centerZ /= tileVectors.size();

        return new CubeVector(centerX,centerY,centerZ);
    }

     //TODO implement for phase 2
    //checks if all tiles in the collection are accessible from any point
    //public boolean isConnected(){
    //   return true;
    //}


 /*   //TODO compare the distance with COG vector?
    private boolean boundsCheck(CubeVector pos) {
        int dis = Math.abs(pos.getXCoord()) + Math.abs(pos.getZCoord()) + Math.abs(pos.getYCoord()) / 2;
        return dis <= maxRadius;
    }*/

    //TODO Only for testing, remove after editor map loading works
    public boolean hasThisManyTiles(int numTiles) {
        return (map.size() == numTiles);
    }

    //TODO delete this after saving is tested
    public void addTile(Tile tile) {
        map.put(tile.getLocation(), tile);
    }
}
