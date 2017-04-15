package model.map.tile;

import model.map.CubeVector;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: a subclass of LandTile
 * Responsibilities:
 *  producing livestock
 *  irrigating a desert tile by replacing it with a pasture tile
 */
public class PastureTile extends LandTile {
    public PastureTile(CubeVector location, NodeRepresentation nodeRepresentation) {
        super(location, nodeRepresentation);
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
        return getLocation().toString() + " pasture " + getNodesString();
    }

    @Override
    public void render(MapRenderer r) {
        r.draw(this);
    }
}
