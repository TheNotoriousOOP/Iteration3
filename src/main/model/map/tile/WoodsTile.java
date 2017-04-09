package model.map.tile;

import model.map.CubeVector;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Subclass of LandTile and Tile, may have river
 * Responsibilities: Build SawCutter for lumber production
 */
public class WoodsTile extends LandTile {
    public WoodsTile(CubeVector location, NodeRepresentation nodeRepresentation) {
        super(location, nodeRepresentation);
    }

    @Override
    public String toString() {
        return getLocation().toString() + " woods " + getNodesString();
    }

    @Override
    public void render(MapRenderer r) {
        r.draw(this);
    }
}
