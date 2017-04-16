package model.map.tile.nodeRepresentation.nodes.parent;

import model.ability_management.ability.Ability;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.NodeRepresentation;

/**
 *
 */
public class ParentRiverNode extends ParentNode {
    public ParentRiverNode(NodeRepresentation nodeRepresentation, int xOffSet, int yOffSet) {
        super(nodeRepresentation, xOffSet, yOffSet);
    }

    @Override
    public AbilitySet getBuildAbility() {
        return getRiverBuild();
    }

    private AbilitySet getRiverBuild(){
        AbilitySet riverBuild = new AbilitySet();
        return riverBuild;
    }
}
