package model.map.tile;

import model.map.CubeVector;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: a subclass of LandTile
 * Responsibilities:
 *  can be irrigated to become a pasture tile at a certain Wonder level
 */
public class DesertTile extends LandTile{
    public DesertTile(CubeVector location, Zone[] zones) {
        super(location, zones);
    }

    /* only needed for phase 2
     * private void irrigate(){
     * }
     */
    @Override
    public String toString() {
        return getLocation().toString() + " desert " + getZonesString();
    }

    @Override
    public void render(MapRenderer r) {
        r.draw(this);
    }
}
