package model.map.tile.nodeRepresentation.nodes.parent;


import model.ability_management.ability.build_abilities.*;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import model.map.tile.nodeRepresentation.nodes.child.ChildLandNode;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.resources.TileStorage;
import model.resources.resourceVisitor.ResourceVisitor;
import view.renderer.MapRenderer;

/**
 * ParentLandNode can only have children of type ChildLandNode
 * Contain TileStorage for resource work
 */
public class ParentLandNode extends ParentNode{
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
    public void render(MapRenderer r) {
        r.drawNodeInfo(this);
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

    @Override
    public void buildRoad(ChildNode childNode){
        childNode.buildRoad();
    }

    public void acceptResourceVisitor(ResourceVisitor v) {
        resourceStorage.accept(v);
    }

}
