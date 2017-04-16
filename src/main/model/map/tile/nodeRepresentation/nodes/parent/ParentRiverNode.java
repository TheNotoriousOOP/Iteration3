package model.map.tile.nodeRepresentation.nodes.parent;

import model.ability_management.ability.Ability;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import view.renderer.MapRenderer;

/**
 *
 */
public class ParentRiverNode extends ParentNode {
    public ParentRiverNode(NodeRepresentation nodeRepresentation) {
        super(nodeRepresentation);
    }

    @Override
    public AbilitySet getBuildAbility() {
        return getRiverBuild();
    }

    @Override
    public void render(MapRenderer r) {
        r.drawNodeInfo(this);
    }

    private AbilitySet getRiverBuild(){
        AbilitySet riverBuild = new AbilitySet();
        return riverBuild;
    }
}
