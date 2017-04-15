package model.map.tile.nodeRepresentation.nodes.parent;


import model.map.tile.nodeRepresentation.NodeRepresentation;
import model.resources.TileStorage;

/**
 * ParentLandNode can only have children of type ChildLandNode
 * Contain TileStorage for resource work
 */
public class ParentLandNode extends ParentNode{
    private TileStorage resourceStorage;

    public ParentLandNode(NodeRepresentation nodeRepresentation) {
        super(nodeRepresentation);
        resourceStorage = new TileStorage();
    }

}
