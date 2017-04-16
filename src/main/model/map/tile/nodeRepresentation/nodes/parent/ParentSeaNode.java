package model.map.tile.nodeRepresentation.nodes.parent;

import model.ability_management.ability.build_abilities.BuildOilRigAbility;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import view.renderer.MapRenderer;

/**
 *
 */
public class ParentSeaNode extends ParentNode {
    public ParentSeaNode(NodeRepresentation nodeRepresentation) {
        super(nodeRepresentation);
    }

    @Override
    public AbilitySet getBuildAbility() {
        return getSeaBuild();
    }

    @Override
    public void render(MapRenderer r) {
        r.drawNodeInfo(this);
    }

    private AbilitySet getSeaBuild(){
        AbilitySet seaBuild = new AbilitySet();
        seaBuild.addValidAbility(new BuildOilRigAbility());
        return getSeaBuild();
    }
}
