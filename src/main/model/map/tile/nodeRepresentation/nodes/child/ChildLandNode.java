package model.map.tile.nodeRepresentation.nodes.child;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

/**
 *
 */
public class ChildLandNode extends ChildNode {
    public ChildLandNode(ParentLandNode parentNode) {
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
        return false;
    }

    @Override
    public boolean canConnectWithNeighbor(ChildSeaNode neighborSea) {
        return true;
    }
}
