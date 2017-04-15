package model.map.tile.nodeRepresentation.nodes.parent;


import model.map.tile.nodeRepresentation.NodeRepresentation;

/**
 * ParentLandNode can only have children of type ChildLandNode
 */
public class ParentLandNode extends ParentNode{


    public ParentLandNode(NodeRepresentation nodeRepresentation) {
        super(nodeRepresentation);
    }
}
