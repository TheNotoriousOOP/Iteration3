package model.map.tile;

import model.map.CubeVector;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: a subclass of LandTile
 * Responsibilities:
 *  producing livestock
 *  irrigating a desert tile by replacing it with a pasture tile
 */
public class PastureTile extends LandTile {
    public PastureTile(CubeVector location, Zone[] zones) {
        super(location, zones);
    }

    /*
    //copy constructor for irrigation. only needed for phase 2
    public void PastureTile(DesertTile desertToPasture){
        setLocation(desertToPasture.getLocation());
        setZones(desertToPasture.getZones());
    }
    */
    @Override
    public String toString() {
        return getLocation().toString() + " pasture " + getZonesString();
    }

    @Override
    public void render(MapRenderer r) {
        r.draw(this);
    }
}
