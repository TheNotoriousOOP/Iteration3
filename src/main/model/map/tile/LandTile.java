package model.map.tile;

import model.map.CubeVector;
import model.map.tile.nodeRepresentation.NodeRepresentation;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: a subtype of tile, used for delineating between Land and NonLand
 * Responsibilities: provide standard functionality for all Tiles with Land Terrains 
 */
public abstract class LandTile extends Tile{
    public LandTile(CubeVector location, NodeRepresentation nodeRepresentation) {
        super(location, nodeRepresentation);
    }

    @Override
    public Tile accept(StartingTileVisitor visitor) { return visitor.visitNode(this); }
}
