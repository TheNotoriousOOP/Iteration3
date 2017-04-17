package model.map.tile.nodeRepresentation.nodes.parent;


import model.ability_management.ability.Ability;
import model.ability_management.ability.build_abilities.*;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import model.map.tile.nodeRepresentation.nodes.child.ChildLandNode;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.resources.TileStorage;
import model.resources.resourceVisitor.ResourceVisitor;
import view.renderer.MapRenderer;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;


/**
 * ParentLandNode can only have children of type ChildLandNode
 * Contain TileStorage for resource work
 */
public class ParentLandNode extends ParentNode {
    private TileStorage resourceStorage;

    public ParentLandNode(NodeRepresentation nodeRepresentation) {
        super(nodeRepresentation);
        resourceStorage = new TileStorage();
    }

    @Override
    public AbilitySet getBuildAbility() {
        return allLandBuild();
    }

    @Override
    public AbilitySet getNodeStorageAbility() {
        return resourceStorage.getAllAbilities();
    }

    @Override
    public void render(MapRenderer r) {
        r.drawNodeInfo(this);
    }

    @Override
    public List<String> getResourcesStringOnNode() {
        return resourceStorage.getResourceStrings();
    }

    private AbilitySet allLandBuild(){
        AbilitySet allLB = new AbilitySet();
        allLB.addValidAbility(new BuildClayPitAbility());
        allLB.addValidAbility(new BuildCoalBurnerAbility());
        allLB.addValidAbility(new BuildPapermillAbility());
        allLB.addValidAbility(new BuildQuarryAbility());
        allLB.addValidAbility(new BuildRaftFactoryAbility());
        allLB.addValidAbility(new BuildRowboatFactoryAbility());
        allLB.addValidAbility(new BuildSawmillAbility());
        allLB.addValidAbility(new BuildSteamboatFactoryAbility());
        allLB.addValidAbility(new BuildStoneFactoryAbility());
        allLB.addValidAbility(new BuildTruckFactoryAbility());
        allLB.addValidAbility(new BuildWagonFactoryAbility());
        allLB.addValidAbility(new BuildWoodcutterAbility());
        return allLB;
    }


    public void buildRoad(ChildLandNode childNode){
        childNode.buildRoad();
    }

    public void acceptResourceVisitor(ResourceVisitor v) {
        resourceStorage.accept(v);
    }

    @Override
    public AbilitySet getBuildRoadAbilitySet() {
        return new AbilitySet(getAllBuildRoadPossible());
    }



    //figure out the building abilities
    private ArrayList<Ability> getAllBuildRoadPossible() {

        ArrayList<Ability> validAbilities = new ArrayList<>();

        for(HashMap<Integer, ChildNode> childMapping : getChildrenNodes().values()){ //go through each face of parent available
            for(ChildNode c : childMapping.values()){   //go through each child on that face
                if(c.getAbility() != null){
                    validAbilities.add(c.getRoadAbility()); //add ability via wrapper
                }
            }
        }

        return validAbilities;
    }

    public boolean hasChildWithRoad() {
        //check if parent node has a road
        for(HashMap<Integer, ChildNode> childLandNodes : getChildrenNodes().values()){
            for(ChildNode c : childLandNodes.values()){
                if(((ChildLandNode)c).hasRoad()) {
                    return true;
                }
            }
        }

        return false;
    }
}
