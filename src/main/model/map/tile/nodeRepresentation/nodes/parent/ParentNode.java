package model.map.tile.nodeRepresentation.nodes.parent;

import model.ability_management.AbilityEnum;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.child.ChildLandNode;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.phase.observers.PhaseObserver;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the center of a region of land/river
 * maps integer (of face), to children nodes corresponds to (1, 2, 3, 4, 5, 6)
 * children nodes hashmap corresponds to (-1, 0, 1)
 */
public abstract class ParentNode extends Node implements PhaseObserver{
    private HashMap<Integer, HashMap<Integer, ChildNode>> childrenNodes;
    private NodeRepresentation nodeRepresentation;
    private ArrayList<AbilityEnum> abilitiesOnNode = new ArrayList<>();

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

    @Override
    public void onMovementPhaseStart() {
        //TODO fix
        for(HashMap<Integer, ChildNode> childMapping : childrenNodes.values()){
            for(ChildNode c : childMapping.values()){
               //TODO add a check if that movement is allowed, because a childnode may not be completed
                abilitiesOnNode.add(c.getDirection().getAbilityEnum());
            }
        }


    }

    @Override
    public void onWonderPhaseStart() {
        //TODO implement
    }
}
