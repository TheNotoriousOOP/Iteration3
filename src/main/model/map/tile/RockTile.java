package model.map.tile;

import model.map.CubeVector;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Subclass of LandTile and Tile, may have river
 * Responsibilities: Build Quarry on tile for producing stones
 */
public class RockTile extends LandTile {

    public RockTile(CubeVector location, Zone[] zones) {
        super(location, zones);
    }

    @Override
    public void render(MapRenderer r) {
        r.draw(this);
    }

    @Override
    public String toString() {
        return getLocation().toString() + " rock " + getZonesString();
    }
}
