package model.map.tile.nodeRepresentation.nodes.child;

import model.ability_management.ability.Ability;
import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.direction.ChildDirection;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

/**
 * Represents the edge of a tile
 */
public abstract class ChildNode extends Node implements Connection{
    private ParentNode parentNode;
    private ChildNode neighboringTileChild ;
    private boolean isComplete;
    private boolean defaultCompletionState;
    private ChildDirection direction;
    private boolean hasRoad;

    public ChildNode(ParentNode parentNode){
        this.parentNode = parentNode;
    }

    //setter for ability (wrapper)
    public void setDirection(ChildDirection direction) {
        if(getNeighboringTileChild() != null){
            if(canConnectWithNeighbor(getNeighboringTileChild())){
                this.direction = direction;
            }
        }
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

    public abstract boolean canBuildRoad();

    public void buildRoad(){
        if(canBuildRoad()) {
            setHasRoad(true);
            setCanBuildRoad(false);
            neighboringTileChild.setCanBuildRoad(false);
            neighboringTileChild.setHasRoad(true);
        }
    }

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
        System.out.println("set connection");
    }

    public void setHasRoad(boolean hasRoad){
        this.hasRoad = hasRoad;
    }

    public boolean hasRoad(){
        return this.hasRoad;
    }

    public void removePointerToNeighbor(){
        this.neighboringTileChild = null;
        isComplete = defaultCompletionState;
        System.out.println("removed pointer");
    }

    public ChildDirection getDirection() {
        return direction;
    }


    public Ability getAbility() {
        if(direction == null){
            return null;
        }else if (canTraverseTo(getNeighboringTileChild())){
            return direction.getAbility();
        } else{
            return null;
        }

    }

    public Ability getRoadAbility() {
        if(direction == null || !canBuildRoad()){
            return null;
        }
        return direction.getBuildRoadAbility();
    }
}
