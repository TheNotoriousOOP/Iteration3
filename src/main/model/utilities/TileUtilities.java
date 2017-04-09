package model.utilities;

import model.map.CubeVector;
import model.map.tile.Tile;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
     *  once a tile is placed, the corresponding faces MUST BE UPDATED
     */
    public boolean canTileBePlaced(Tile tileToPlace, ArrayList<Tile> surroundingTiles){
        boolean placementFlag;
        if(surroundingTiles.isEmpty()){
            return false;
        }

        //check the validity of the tile in relation to each neighbor
        for (Tile neighborTile : surroundingTiles){
            //get ref to the map of children nodes from each tile's side
            HashMap<Integer, ChildNode> commonNodesFromTileToPlace = getSharedChildrenOnSideA(tileToPlace, neighborTile);
            HashMap<Integer, ChildNode> commonNodesFromNeighbor = getSharedChildrenOnSideA(neighborTile, tileToPlace);

            //determine if child nodes are of the same type
            placementFlag = doChildNodesMatch(commonNodesFromTileToPlace.get(0), commonNodesFromNeighbor.get(0)); //key 0 refers to center of the 3 on the face
            if (!placementFlag){    //if placement is ever false
                return false;       //the proposed placement is invalid
            }
        }

        return true;
    }

    //checks the nodes to see if they can connect
    private boolean doChildNodesMatch(ChildNode childOfA, ChildNode childOfB){
        return childOfA.canConnectWithNeighbor(childOfB);
    }

    //checks 1 tile to see if all nodes are connected if needed
    public boolean isTileComplete(Tile tileToCheck){
        boolean completionFlag;

        NodeRepresentation nodeRepresentation = tileToCheck.getNodeRepresentation();

        for(int i = 1; i < 7; i++){
            for(ChildNode c : nodeRepresentation.getAllChildNodesOnFace(i).values()){
                completionFlag = c.isComplete();
                if(!completionFlag){
                    return false;
                }
            }

        }

        return true;

    }




    //two tiles are adjacent if their atomic distance is 1
    public boolean checkAdjacency(Tile tileA, Tile tileB){
        return (calculateDistance(tileA, tileB) == 1);
    }

    //returns the face number (int) of the first arg Tile's shared face with the second arg Tile
    public int getSharedHexFace(Tile tileA, Tile tileB){
        int sharedFaceOfA = 7;

        //tiles must be neighbors to determine their shared face
        if (!checkAdjacency(tileA, tileB)){
            System.out.println("class TILEUTILITIES: shared face does not exist");
            return sharedFaceOfA;
        }

        CubeVector differenceOfVectors = tileB.getLocation().subtractCubeVector(tileA.getLocation());

        if (differenceOfVectors.getXCoord() == 0 && differenceOfVectors.getYCoord() == 1 && differenceOfVectors.getZCoord() == -1){
            //tileA is S of tileB
            sharedFaceOfA = 1;
        } else if (differenceOfVectors.getXCoord() == 1 && differenceOfVectors.getYCoord() == 0 && differenceOfVectors.getZCoord() == -1){
            //tileA is SW of tileB
            sharedFaceOfA = 2;
        } else if (differenceOfVectors.getXCoord() == 1 && differenceOfVectors.getYCoord() == -1 && differenceOfVectors.getZCoord() == 0){
            //tileA is NW of tileB
            sharedFaceOfA = 3;
        } else if (differenceOfVectors.getXCoord() == 0 && differenceOfVectors.getYCoord() == -1 && differenceOfVectors.getZCoord() == 1){
            //tileA is N of tileB
            sharedFaceOfA = 4;
        } else if (differenceOfVectors.getXCoord() == -1 && differenceOfVectors.getYCoord() == 0 && differenceOfVectors.getZCoord() == 1) {
            //tileA is NE of tileB
            sharedFaceOfA = 5;
        } else if (differenceOfVectors.getXCoord() == -1 && differenceOfVectors.getYCoord() == 1 && differenceOfVectors.getZCoord() == 0) {
            //tileA is SE of tileB
            sharedFaceOfA = 6;
        }

        return sharedFaceOfA;

    }

    public HashMap<Integer, ChildNode> getSharedChildrenOnSideA(Tile sideA, Tile sideB){
        int sharedFaceOfA = getSharedHexFace(sideA, sideB);

        return  sideA.getChildNodesOnFace(sharedFaceOfA);
    }
}
