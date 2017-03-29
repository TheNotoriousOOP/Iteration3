package model.map.tile;

import model.map.CubeVector;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Subclass of LandTile and Tile, may have river
 * Responsibilities: Responsible for building a mine that produces gold and ore
 */
public class MountainsTile extends LandTile {
    public MountainsTile(CubeVector location, Zone[] zones) {
        super(location, zones);
    }

    @Override
    public void render(MapRenderer r) {
        r.draw(this);
    }

    @Override
    public String toString() {
        return getLocation().toString() + " mountains " + getZonesString();
    }
}
