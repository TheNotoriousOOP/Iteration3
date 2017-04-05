package model.map.tile.nodeRepresentation.nodes.parent;

import model.map.tile.nodeRepresentation.nodes.Node;
import model.map.tile.nodeRepresentation.nodes.child.ChildLandNode;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the center of a region of land/river
 */
public abstract class ParentNode extends Node {
    private HashMap<Integer, ArrayList<ChildNode>> childrenNodes;

    public ParentNode(){

    }

    public HashMap<Integer, ArrayList<ChildNode>> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(HashMap<Integer, ArrayList<ChildNode>> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }
}
