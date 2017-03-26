package model.map.tile;

import model.map.CubeVector;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: a subclass of LandTile
 * Responsibilities:
 *  producing livestock
 *  irrigating a desert tile by replacing it with a pasture tile
 */
public class PastureTile extends LandTile {
    PastureTile(CubeVector location, Zone[] zones) {
        super(location, zones);
    }

    /*
    //copy constructor for irrigation. only needed for phase 2
    public void PastureTile(DesertTile desertToPasture){
        setLocation(desertToPasture.getLocation());
        setZones(desertToPasture.getZones());
    }
    */

}
