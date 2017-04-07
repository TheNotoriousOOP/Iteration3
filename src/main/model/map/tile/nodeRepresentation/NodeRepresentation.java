package model.map.tile.nodeRepresentation;

import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contains a mapping of tile face -> parent nodes to determine how a tile is represented
 */
public abstract class NodeRepresentation {
    private HashMap<Integer, ArrayList<ParentNode>> parentMap;
    private int rotation;

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getRotation() {
        return rotation;
    }

    //TODO place elsewhere? a node rep in model should not have ref to its image string?
    public abstract String getCorrectRiverImage();


    abstract void setupNodesGivenRotation(int rotation);

    public HashMap<Integer, ArrayList<ParentNode>> getParentMap() {
        return parentMap;
    }

    public void setParentMap(HashMap<Integer, ArrayList<ParentNode>> parentMap) {
        this.parentMap = parentMap;
    }

    public HashMap<Integer, ChildNode> getAllChildNodesOnFace(int face) {
        ArrayList<ParentNode> parentNodesOnFace = parentMap.get(face);
        HashMap<Integer, ChildNode> allChildrenNodesOnFace = new HashMap<>();
        //todo replace arraylists with hashmaps
        for (ParentNode parentNode : parentNodesOnFace){
            allChildrenNodesOnFace.putAll(parentNode.getChildNodesOnFace(face));
        }
        System.out.println("abs class NodeRep: children on face " + face + " are " + allChildrenNodesOnFace.toString());
        return allChildrenNodesOnFace;
    }
}
