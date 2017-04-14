package model.map.tile.nodeRepresentation.nodes.child;

import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.direction.ChildDirection;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

/**
 * Represents the edge of a tile
 */
public abstract class ChildNode extends Node {
    private ParentNode parentNode;
    private ChildNode neighboringTileChild;
    private boolean isComplete;
    private boolean defaultCompletionState;
    private ChildDirection direction;

    public ChildNode(ParentNode parentNode){
        this.parentNode = parentNode;
    }

    public void setDirection(ChildDirection direction) {
        this.direction = direction;
    }

    //used to determine if a linking and placement is valid
    public abstract boolean canConnectWithNeighbor(ChildNode neighbor);
    public abstract boolean canConnectWithNeighbor(ChildLandNode neighborLand);
    public abstract boolean canConnectWithNeighbor(ChildRiverNode neighborRiver);
    public abstract boolean canConnectWithNeighbor(ChildSeaNode neighborSea);

    //used to determine if movement is allowed from the current node
    public abstract boolean canTraverseTo(ChildNode childNode);
    public abstract boolean canTraverseTo(ChildLandNode childLandNode);
    public abstract boolean canTraverseTo(ChildRiverNode childRiverNode);
    public abstract boolean canTraverseTo(ChildSeaNode childSeaNode);


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

    public ChildDirection getDirection() {
        return direction;
    }
}
