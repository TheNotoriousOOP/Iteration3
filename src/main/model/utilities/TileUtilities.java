package model.utilities;

import model.map.CubeVector;
import model.map.tile.Tile;
import model.map.tile.Zone;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 *      Determines whether tile places on EditorMap are valid or not
 * Responsibilities:
 *      Checks whether TileToBePlaced is being placed adjacent to a tile already on the map
 *      Ensures a tile can be placed in the desired location
 *      Computes the center of gravity
 *      Calculates the distance between 2 tiles
 */
public class TileUtilities {

    // Default constructor
    public TileUtilities(){}

    /* Calculate distance between two given tiles & return it
    *  Calculation done using atomic distance
    *  Formula: max(  (a.x - b.x),
    *                   (a.y - b.y),
    *                   (a.z - b.z) )
    */
    public double calculateDistance(Tile tileA, Tile tileB) {

        // Distance between tile coords
        CubeVector vecDistance = tileA.getLocation().subtractCubeVector(tileB.getLocation());

        // Tile distance is always the max distance value of the 3 coords
        double distance = Math.max(vecDistance.getXCoord(), vecDistance.getYCoord());
        distance = Math.max(distance, vecDistance.getZCoord());

        // Return distance value
        return distance;
    }


    /*
     *  input of a Tile and its surrounding neighbors
     *  output if placement is valid
     *  once a tile is placed, the corresponding zones MUST BE UPDATED (isMerged for water)
     */
    public boolean canTileBePlaced(Tile tileToPlace, ArrayList<Tile> surroundingTiles){
        boolean placementFlag;
        if(surroundingTiles.isEmpty())
            return false;
        //check the validity of the tile in relation to each neighbor
        for (Tile neighborTile : surroundingTiles){
            Zone[] commonZones = getSharedZones(tileToPlace, neighborTile); //find the common zones between the two tiles
            placementFlag = doZonesMatch(commonZones[0], commonZones[1]);    //determine if zones match (ie river to river, sea to land, etc)
            if (!placementFlag){    //if placement is ever false
                return false;       //the proposed placement is invalid
            }
        }

        return true;
    }

    private boolean doZonesMatch(Zone zoneA, Zone zoneB){
        //a zone is merged if it has a completed water flow (either connected river or sea tile)
        if(zoneA.isMerged() || zoneB.isMerged()){
            return true;
        }

        //both zones must both have either water, or no water, for a valid placement
        return zoneA.isHasWater() == zoneB.isHasWater();
    }

    //returns the two Zones that are shared between the Tiles
    public Zone[] getSharedZones(Tile tileA, Tile tileB){
        Zone[] tmpZones = new Zone[2];

        //tiles must be neighbors to determine their shared zone
        if (!checkAdjacency(tileA, tileB)){
            System.out.println("class TILEUTILITIES: shared zone does not exist");
            return  null;
        }

        CubeVector differenceOfVectors = tileB.getLocation().subtractCubeVector(tileA.getLocation());

        //TODO replace with Tyler's to-be-implemented class to determine vector relationships
        if (differenceOfVectors.getXCoord() == 0 && differenceOfVectors.getYCoord() == 1 && differenceOfVectors.getZCoord() == -1){
            //tileA is S of tileB
            tmpZones[0] = tileA.getSpecificZone(1);
            tmpZones[1] = tileB.getSpecificZone(4);
        } else if (differenceOfVectors.getXCoord() == 1 && differenceOfVectors.getYCoord() == 0 && differenceOfVectors.getZCoord() == -1){
            //tileA is SW of tileB
            tmpZones[0] = tileA.getSpecificZone(2);
            tmpZones[1] = tileB.getSpecificZone(5);
        } else if (differenceOfVectors.getXCoord() == 1 && differenceOfVectors.getYCoord() == -1 && differenceOfVectors.getZCoord() == 0){
            //tileA is NW of tileB
            tmpZones[0] = tileA.getSpecificZone(3);
            tmpZones[1] = tileB.getSpecificZone(6);
        } else if (differenceOfVectors.getXCoord() == 0 && differenceOfVectors.getYCoord() == -1 && differenceOfVectors.getZCoord() == 1){
            //tileA is N of tileB
            tmpZones[0] = tileA.getSpecificZone(4);
            tmpZones[1] = tileB.getSpecificZone(1);
        } else if (differenceOfVectors.getXCoord() == -1 && differenceOfVectors.getYCoord() == 0 && differenceOfVectors.getZCoord() == 1) {
            //tileA is NE of tileB
            tmpZones[0] = tileA.getSpecificZone(5);
            tmpZones[1] = tileB.getSpecificZone(2);
        } else if (differenceOfVectors.getXCoord() == -1 && differenceOfVectors.getYCoord() == 1 && differenceOfVectors.getZCoord() == 0) {
            //tileA is SE of tileB
            tmpZones[0] = tileA.getSpecificZone(6);
            tmpZones[1] = tileB.getSpecificZone(3);
        }


        return tmpZones;
    }

    //two tiles are adjacent if their atomic distance is 1
    public boolean checkAdjacency(Tile tileA, Tile tileB){
        return (calculateDistance(tileA, tileB) == 1);
    }
}
