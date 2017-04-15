package model.map.tile.nodeRepresentation.nodes.parent;

import model.ability_management.ability.Ability;
import model.ability_management.ability_set.AbilitySet;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.phase.observers.PhaseObserver;
import model.transporters.land_transporters.AllTerrainLandTransporter;
import model.transporters.land_transporters.RoadLandTransporter;
import model.transporters.water_transporters.WaterTransporter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the center of a region of land/river
 * maps integer (of face), to children nodes corresponds to (1, 2, 3, 4, 5, 6)
 * children nodes hashmap corresponds to (-1, 0, 1)
 */
public abstract class ParentNode extends Node implements PhaseObserver, MovementAbilityUpdater{
    private HashMap<Integer, HashMap<Integer, ChildNode>> childrenNodes;
    private NodeRepresentation nodeRepresentation;


    public ParentNode(NodeRepresentation nodeRepresentation){
        this.nodeRepresentation = nodeRepresentation;
    }

    public HashMap<Integer, HashMap<Integer, ChildNode>> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(HashMap<Integer, HashMap<Integer, ChildNode>> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }

    public NodeRepresentation getNodeRepresentation() {
        return nodeRepresentation;
    }

    public HashMap<Integer, ChildNode> getChildNodesOnFace(int face){
        return childrenNodes.get(face);
    }

    @Override
    public void onTradePhaseStart() {
        //TODO implement
    }

    @Override
    public void onProductionPhaseStart() {
        //TODO implement
    }

    @Override
    public void onBuildPhaseStart() {
        //TODO implement
    }

    //TODO remove from here, it should be done via transporter?
    @Override
    public void onMovementPhaseStart() {
        for(HashMap<Integer, ChildNode> childMapping : childrenNodes.values()){ //go through each face of parent available
            for(ChildNode c : childMapping.values()){   //go through each child on that face
                if(c.getNeighboringTileChild() != null){    //if neighboring exists
                    if(c.canTraverseTo(c.getNeighboringTileChild())){   //and neighbor is allowed to traverse to
                       //add ability via wrapper
                    }
                }
            }
        }
    }

    @Override
    public void onWonderPhaseStart() {
        //TODO implement
    }



    @Override
    public AbilitySet getMovementAbility(AllTerrainLandTransporter allT) {
        AbilitySet allTAbilitySet = new AbilitySet(getAllMovementPossible());
        allTAbilitySet.addActorToSet(allT);
        return allTAbilitySet;
    }

    //TODO check for roads, dont use method 'getAllMovementPossible'
    @Override
    public AbilitySet getMovementAbility(RoadLandTransporter rlT) {
        AbilitySet allrlTAbilitySet = new AbilitySet(getAllMovementPossible());
        allrlTAbilitySet.addActorToSet(rlT);
        return allrlTAbilitySet;
    }

    @Override
    public AbilitySet getMovementAbility(WaterTransporter waterT) {
        AbilitySet waterTAbilitySet = new AbilitySet(getAllMovementPossible());
        waterTAbilitySet.addActorToSet(waterT);
        return waterTAbilitySet;
    }

    //movement regardless of water/roads/etc. all donkeys and water transporters can call this
    private ArrayList<Ability> getAllMovementPossible(){
        ArrayList<Ability> validAbilities = new ArrayList<>();

        for(HashMap<Integer, ChildNode> childMapping : childrenNodes.values()){ //go through each face of parent available
            for(ChildNode c : childMapping.values()){   //go through each child on that face
                if(c.getAbility() != null){
                    validAbilities.add(c.getAbility()); //add ability via wrapper
                }
            }
        }

        return validAbilities;
    }


}
