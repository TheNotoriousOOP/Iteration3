package model.map.tile;

import model.map.CubeVector;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Subclass of NonLandTile and Tile
 * Responsibilities: Build an oil rig and connect to tiles with rivers
 */
public class SeaTile extends NonLandTile {
    public SeaTile(CubeVector location, Zone[] zones) {
        super(location, zones);
    }

    @Override
    public String toString() {
        return getLocation().toString() + " sea " + getZonesString();
    }

    @Override
    public void render(MapRenderer r) {
        r.draw(this);
    }

}
