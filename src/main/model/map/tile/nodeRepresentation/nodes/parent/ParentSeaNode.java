package model.map.tile.nodeRepresentation.nodes.parent;

import model.ability_management.ability.build_abilities.BuildOilRigAbility;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.NodeRepresentation;

/**
 *
 */
public class ParentSeaNode extends ParentNode {
    public ParentSeaNode(NodeRepresentation nodeRepresentation, int xOffSet, int yOffSet) {
        super(nodeRepresentation, xOffSet, yOffSet);
    }

    @Override
    public AbilitySet getBuildAbility() {
        return getSeaBuild();
    }

    private AbilitySet getSeaBuild(){
        AbilitySet seaBuild = new AbilitySet();
        seaBuild.addValidAbility(new BuildOilRigAbility());
        return getSeaBuild();
    }
}
