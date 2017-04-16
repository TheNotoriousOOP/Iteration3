package model.map.tile;

/**
 * Created by Jonathen on 4/16/2017.
 */
public class StartingTileVisitor {
    public Tile visitNode(LandTile tile) {
        return tile;
    }
    public Tile visitNode(NonLandTile tile) {
        return null;
    }
}
