package model.map.tile.nodeRepresentation.nodes.child;

import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

/**
 * Represents the edge of a tile
 */
public abstract class ChildNode extends Node {
    private ParentNode parentNode;
    private ChildNode neighboringTileChild;

    public ChildNode(ParentNode parentNode){
        this.parentNode = parentNode;
    }

    //used to determine if a linking and placement is valid
    public abstract boolean canConnectWithNeighbor(ChildNode neighbor);//{
       // return  neighbor.canConnectWithNeighbor(this);
  //  }
    public abstract boolean canConnectWithNeighbor(ChildLandNode neighborLand);
    //TODO create ChildRiverNode and ChildSeaNode classes
   // public abstract boolean canConnectWithNeighbor(ChildRiverNode neighborRiver);
    //public abstract boolean canConnectWithNeighbor(ChildSeaNode neighborSea);




    public ParentNode getParentNode() {
        return parentNode;
    }

    public ChildNode getNeighboringTileChild() {
        return neighboringTileChild;
    }

    public void setNeighboringTileChild(ChildNode neighboringTileChild) {
        this.neighboringTileChild = neighboringTileChild;
    }
}
