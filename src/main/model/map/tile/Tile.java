package model.map.tile;

import model.map.CubeVector;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import view.renderer.MapRenderer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Top of tile hierarchy for map editor and the game map
 * Responsibilities: Contain all attributes necessary across tile
 */

//TODO fix saving because zones are gone
public abstract class Tile {

    private CubeVector location;
    private NodeRepresentation nodeRepresentation;

    public Tile(CubeVector location, NodeRepresentation nodeRepresentation){
        this.location = location;
        this.nodeRepresentation = nodeRepresentation;
    }

    public CubeVector getLocation() {
        return location;
    }

    public CubeVector getAdjustedLocation(int x, int y, int z) { return this.location.offsetCubeVector(x, y, z); }

    public CubeVector getAdjustedLocation(CubeVector offset) { return this.location.offsetCubeVector(offset); }

    public void setAdjustedLocation(CubeVector offset) { this.location = this.location.offsetCubeVector(offset); }

    public void setAdjustedLocation(int x, int y, int z) { this.location = this.location.offsetCubeVector(x, y, z); }

    public void setLocation(CubeVector location) {
        this.location = location;
    }

    //uses NodeRepresentation to find nodes on the correct face
    public HashMap<Integer, ChildNode> getChildNodesOnFace(int face){
        return nodeRepresentation.getAllChildNodesOnFace(face);
    }

    //TODO remove when drawing river is better
    public int getNodeRepresentationRotation(){
        return nodeRepresentation.getRotation();
    }
    public String getNodeRepresentationRiverString(){
        return nodeRepresentation.getCorrectRiverImage();
    }

/*
    //Offset by 1 for ease of use
    public Zone getSpecificZone(int number){
        if(number < 1 || number > 6){
            System.out.println("CLASS TILE: Error with zones");
            return zones[0];
        }
        return zones[number-1];
    }

    //public abstract void buildStructure(Structure target);
    //Not needed until Phase 2

    public String getZonesString() {

        //Return null string if there are no water zones
        String zonesString = "";

        //Append faces that have water
        for (int zoneIndex = 0; zoneIndex < zones.length; zoneIndex++) {
            if (zones[zoneIndex].isHasWater()) {
                //Account for switch from index to face number
                zonesString += String.valueOf(zoneIndex+1) + " ";
            }
        }

        //Append and prepend parens if there water zones were found in loop above
        if (!zonesString.equals("")) {
            zonesString = "( " + zonesString + ")";
        }

        return zonesString;
    }*/

    public String getNodesString() {
        //returns a null string if none of the nodes have a river
        return nodeRepresentation.toString();
    }

    public abstract void render(MapRenderer r);
}
