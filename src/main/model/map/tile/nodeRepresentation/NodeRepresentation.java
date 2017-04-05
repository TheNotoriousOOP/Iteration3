package model.map.tile.nodeRepresentation;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contains a mapping of tile face -> parent nodes to determine how a tile is represented
 */
public abstract class NodeRepresentation {
    private HashMap<Integer, ArrayList<ParentNode>> parentMap;

    public NodeRepresentation(int rotation){
        setupNodesGivenRotation(rotation);
    }

    abstract void setupNodesGivenRotation(int rotation);

    public HashMap<Integer, ArrayList<ParentNode>> getParentMap() {
        return parentMap;
    }

    public void setParentMap(HashMap<Integer, ArrayList<ParentNode>> parentMap) {
        this.parentMap = parentMap;
    }
}
