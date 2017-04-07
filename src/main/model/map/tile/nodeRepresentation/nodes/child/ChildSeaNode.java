package model.map.tile.nodeRepresentation.nodes.child;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentSeaNode;

/**
 *
 */
public class ChildSeaNode extends ChildNode {
    public ChildSeaNode(ParentSeaNode parentNode) {
        super(parentNode);
    }

    @Override
    public boolean canConnectWithNeighbor(ChildNode neighbor) {
        return neighbor.canConnectWithNeighbor(this);
    }

    @Override
    public boolean canConnectWithNeighbor(ChildLandNode neighborLand) {
        return true;
    }

    @Override
    public boolean canConnectWithNeighbor(ChildRiverNode neighborRiver) {
        return true;
    }

    @Override
    public boolean canConnectWithNeighbor(ChildSeaNode neighborSea) {
        return true;
    }
}
