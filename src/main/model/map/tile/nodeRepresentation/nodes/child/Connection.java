package model.map.tile.nodeRepresentation.nodes.child;

/**
 *
 */
public interface Connection {
    //used to determine if a linking and placement is valid
    boolean canConnectWithNeighbor(ChildNode neighbor);
    boolean canConnectWithNeighbor(ChildLandNode neighborLand);
    boolean canConnectWithNeighbor(ChildRiverNode neighborRiver);
    boolean canConnectWithNeighbor(ChildSeaNode neighborSea);

    //used to determine if movement is allowed from the current node
    boolean canTraverseTo(ChildNode childNode);
    boolean canTraverseTo(ChildLandNode childLandNode);
    boolean canTraverseTo(ChildRiverNode childRiverNode);
    boolean canTraverseTo(ChildSeaNode childSeaNode);
}
