package model.map.tile.nodeRepresentation;

import model.map.tile.Tile;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.map.tile.nodeRepresentation.nodes.direction.*;
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

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    private Tile tile;

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getRotation() {
        return rotation;
    }

    //TODO place elsewhere? a node rep in model should not have ref to its image string?
    public abstract String getCorrectRiverImage();

    public abstract String getRiverNodeString();


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

        for (ParentNode parentNode : parentNodesOnFace){
            allChildrenNodesOnFace.putAll(parentNode.getChildNodesOnFace(face));
        }
        //System.out.println("abs class NodeRep: children on face " + face + " are " + allChildrenNodesOnFace.toString());
        return allChildrenNodesOnFace;
    }


    //super parsing method for setting a ChildDirection to a ChildNode
    public void parseChildrenForDirection(){
        HashMap<Integer, ChildNode> childrenOnNorth = getAllChildNodesOnFace(1);
        childrenOnNorth.get(-1).setDirection(new NorthLeft());
        childrenOnNorth.get(0).setDirection(new North());
        childrenOnNorth.get(1).setDirection(new NorthRight());

        HashMap<Integer, ChildNode> childrenOnNorthEast = getAllChildNodesOnFace(2);
        childrenOnNorthEast.get(-1).setDirection(new NorthEastLeft());
        childrenOnNorthEast.get(0).setDirection(new NorthEast());
        childrenOnNorthEast.get(1).setDirection(new NorthEastRight());

        HashMap<Integer, ChildNode> childrenOnSouthEast = getAllChildNodesOnFace(3);
        childrenOnSouthEast.get(-1).setDirection(new SouthEastLeft());
        childrenOnSouthEast.get(0).setDirection(new SouthEast());
        childrenOnSouthEast.get(1).setDirection(new SouthEastRight());

        HashMap<Integer, ChildNode> childrenOnSouth = getAllChildNodesOnFace(4);
        childrenOnSouth.get(-1).setDirection(new SouthLeft());
        childrenOnSouth.get(0).setDirection(new South());
        childrenOnSouth.get(1).setDirection(new SouthRight());

        HashMap<Integer, ChildNode> childrenOnSouthWest = getAllChildNodesOnFace(5);
        childrenOnSouthWest.get(-1).setDirection(new SouthWestLeft());
        childrenOnSouthWest.get(0).setDirection(new SouthWest());
        childrenOnSouthWest.get(1).setDirection(new SouthWestRight());

        HashMap<Integer, ChildNode> childrenOnNorthWest = getAllChildNodesOnFace(6);
        childrenOnNorthWest.get(-1).setDirection(new NorthWestLeft());
        childrenOnNorthWest.get(0).setDirection(new NorthWest());
        childrenOnNorthWest.get(1).setDirection(new NorthWestRight());
    }
}
