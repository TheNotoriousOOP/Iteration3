package model.map.tile.nodeRepresentation.nodes.parent;

import model.ability_management.ability.Ability;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import view.renderer.MapRenderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public AbilitySet getNodeStorageAbility() {
        return new AbilitySet();
    }

    @Override
    public void render(MapRenderer r) {
        r.drawNodeInfo(this);
        if (getStructure() != null){
            getStructure().render(r);
        }
    }



    public AbilitySet getBuildRoadAbilitySet() {
        return new AbilitySet();
    }

    public List<String> getResourcesStringOnNode() {
        return new ArrayList<>(Arrays.asList(""));

    }

    private AbilitySet getRiverBuild(){
        AbilitySet riverBuild = new AbilitySet();
        return riverBuild;
    }
}
