package model.map.tile.nodeRepresentation.nodes.child;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentRiverNode;

/**
 *
 */
public class ChildRiverNode extends ChildNode {
    public ChildRiverNode(ParentRiverNode parentNode) {
        super(parentNode);
    }

    @Override
    public boolean canConnectWithNeighbor(ChildNode neighbor) {
        return neighbor.canConnectWithNeighbor(this);
    }

    @Override
    public boolean canConnectWithNeighbor(ChildLandNode neighborLand) {
        return false;
    }

    @Override
    public boolean canConnectWithNeighbor(ChildRiverNode neighborRiver) {
        return true;
    }

    @Override
    public boolean canConnectWithNeighbor(ChildSeaNode neighborSea) {
        return true;
    }

    @Override
    public boolean canTraverseTo(ChildNode childNode) {
        return childNode.canTraverseTo(this);
    }

    @Override
    public boolean canTraverseTo(ChildLandNode childLandNode) {
        return false;
    }

    @Override
    public boolean canTraverseTo(ChildRiverNode childRiverNode) {
        return true;
    }

    @Override
    public boolean canTraverseTo(ChildSeaNode childSeaNode) {
        return true;
    }
}
