package model.map.tile.nodeRepresentation.nodes.child;

import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

/**
 * Represents the edge of a tile
 */
public abstract class ChildNode extends Node {
    private ParentNode parentNode;
    private ChildNode neighboringTileChild;
    private boolean isComplete;
    private boolean defaultCompletionState;

    public ChildNode(ParentNode parentNode){
        this.parentNode = parentNode;
    }

    //used to determine if a linking and placement is valid
    public abstract boolean canConnectWithNeighbor(ChildNode neighbor);
    public abstract boolean canConnectWithNeighbor(ChildLandNode neighborLand);
    public abstract boolean canConnectWithNeighbor(ChildRiverNode neighborRiver);
    public abstract boolean canConnectWithNeighbor(ChildSeaNode neighborSea);


    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean getDefaultCompletionState(){return defaultCompletionState;}

    public void setDefaultCompletionState(boolean defaultCompletionState){
        this.defaultCompletionState = defaultCompletionState;
    }

    public ParentNode getParentNode() {
        return parentNode;
    }

    public ChildNode getNeighboringTileChild() {
        return neighboringTileChild;
    }

    public void setNeighboringTileChild(ChildNode neighboringTileChild) {
        this.neighboringTileChild = neighboringTileChild;
        setComplete(true);

    }

    public void removePointerToNeighbor(){
        this.neighboringTileChild = null;
        isComplete = defaultCompletionState;
    }
}
