package model.map.tile.nodeRepresentation.nodes.child;

import model.ability_management.ability.Ability;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

/**
 *
 */
public class ChildLandNode extends ChildNode {

    private boolean hasRoad;

    public ChildLandNode(ParentLandNode parentNode) {
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
        return false;
    }

    @Override
    public boolean canConnectWithNeighbor(ChildSeaNode neighborSea) {
        return true;
    }

    @Override
    public boolean canTraverseTo(ChildNode childNode) {
        return childNode.canTraverseTo(this);
    }

    @Override
    public boolean canTraverseTo(ChildLandNode childLandNode) {
        return true;
    }

    @Override
    public boolean canTraverseTo(ChildRiverNode childRiverNode) {
        return false;
    }

    @Override
    public boolean canTraverseTo(ChildSeaNode childSeaNode) {
        return false;
    }

    public void buildRoad(){
        if(!hasRoad){
            setHasRoad(true);
            ((ChildLandNode)getNeighboringTileChild()).setHasRoad(true);
        }
    }

    public void setHasRoad(boolean hasRoad){
        this.hasRoad = hasRoad;
    }
}
