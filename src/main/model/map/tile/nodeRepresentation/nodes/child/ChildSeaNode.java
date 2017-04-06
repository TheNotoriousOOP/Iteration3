package model.map.tile.nodeRepresentation.nodes.child;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

/**
 *
 */
public class ChildSeaNode extends ChildNode {
    public ChildSeaNode(ParentNode parentNode) {
        super(parentNode);
    }

    @Override
    public boolean canConnectWithNeighbor(ChildNode neighbor) {
        return canConnectWithNeighbor(this);
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
