package model.utilities;

import model.map.CubeVector;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 *      Determines whether tile places on EditorMap are valid or not
 * Responsibilities:
 *      Checks whether TileToBePlaced is being placed adjacent to a tile already on the map
 *      Ensures rivers of two tiles are connected
 *      Computes the center of gravity
 *      Ensures distance between 2 tiles is no larger than 21
 */
public class TileUtilities {
    public TileUtilities(){

    }
    public boolean calculateDistance(){
        return true;
    }

    public boolean doWaterSourcesMatch(){
        return true;
    }
    public CubeVector calculateCenterOfGravity(){
        return new CubeVector(0,0,0);
    }
    public boolean checkAdjcency(){
        return true;
    }
}
