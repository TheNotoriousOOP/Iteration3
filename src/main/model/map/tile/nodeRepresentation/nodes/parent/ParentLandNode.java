package model.map.tile.nodeRepresentation.nodes.parent;


import model.map.tile.nodeRepresentation.NodeRepresentation;
import model.resources.TileStorage;
import model.resources.resourceVisitor.ResourceVisitor;

/**
 * ParentLandNode can only have children of type ChildLandNode
 * Contain TileStorage for resource work
 */
public class ParentLandNode extends ParentNode{
    private TileStorage resourceStorage;

    public ParentLandNode(NodeRepresentation nodeRepresentation, int xOffSet, int yOffSet) {
        super(nodeRepresentation, xOffSet, yOffSet);
        resourceStorage = new TileStorage();
    }

    public void acceptResourceVisitor(ResourceVisitor v) {
        resourceStorage.accept(v);
    }

}
