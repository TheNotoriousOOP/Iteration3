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
    public boolean canConnectWithNeighbor(ChildLandNode neighborLand) {
        return true;
    }
}
