package model.map.tile.nodeRepresentation.nodes.child;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentSeaNode;

/**
 *
 */
public class ChildSeaNode extends ChildNode {
    private boolean isConnectedToWater; //used to determine movement ability
    public ChildSeaNode(ParentSeaNode parentNode) {
        super(parentNode);
        setComplete(true);
        setDefaultCompletionState(true);
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
        isConnectedToWater = true;
        return true;
    }

    @Override
    public boolean canConnectWithNeighbor(ChildSeaNode neighborSea) {
        isConnectedToWater = true;
        return true;
    }

    public boolean isConnectedToWater() {
        return isConnectedToWater;
    }
}
