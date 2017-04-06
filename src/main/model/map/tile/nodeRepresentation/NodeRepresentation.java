package model.map.tile.nodeRepresentation;

import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contains a mapping of tile face -> parent nodes to determine how a tile is represented
 */
public abstract class NodeRepresentation {
    private HashMap<Integer, ArrayList<ParentNode>> parentMap;

    abstract void setupNodesGivenRotation(int rotation);

    public HashMap<Integer, ArrayList<ParentNode>> getParentMap() {
        return parentMap;
    }

    public void setParentMap(HashMap<Integer, ArrayList<ParentNode>> parentMap) {
        this.parentMap = parentMap;
    }

    public ArrayList<ChildNode> getChildNodesOnFace(int face) {
        ArrayList<ParentNode> parentNodesOnFace = parentMap.get(face);
        ArrayList<ChildNode> allChildrenNodesOnFace = new ArrayList<>();

        for (ParentNode parentNode : parentNodesOnFace){
            allChildrenNodesOnFace.addAll(parentNode.getChildNodesOnFace(face));
        }
        return allChildrenNodesOnFace;
    }
}
