package model.map.tile;

import model.map.CubeVector;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import view.renderer.MapRenderer;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Subclass of NonLandTile and Tile
 * Responsibilities: Build an oil rig and connect to tiles with rivers
 */
public class SeaTile extends NonLandTile {
    public SeaTile(CubeVector location, NodeRepresentation nodeRepresentation) {
        super(location, nodeRepresentation);
    }

    @Override
    public String toString() {
        return getLocation().toString() + " sea " + getNodesString();
    }

    @Override
    public void render(MapRenderer r) {
        r.draw(this);
    }

}
