package model.map.tile.nodeRepresentation;

import model.map.tile.nodeRepresentation.nodes.child.ChildLandNode;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Node representation for a terrain without rivers, excluding Sea
 */
public class NoRiverSetup extends NodeRepresentation{

    public NoRiverSetup(int rotation) {
        setRotation(rotation);
        setupNodesGivenRotation(rotation);
    }

    @Override
    public String getCorrectRiverImage() {
        return "";
    }

    //NoRiverSetup has no faces with rivers
    @Override
    public String getRiverNodeString() {
        return "";
    }

    @Override
    void setupNodesGivenRotation(int rotation) {
        //disregard rotation with no rivers

    //BEGIN INIT OF PARENT AND CHILDREN NODES
        //create 1 parent land
        ParentNode parentLand1 = new ParentLandNode();


        //create 6 maps, representing the (up to) 3 land children on each face
        //add to map the 3 children
        HashMap<Integer, ChildNode> childrenOnFace1 = new HashMap<>();
        childrenOnFace1.put(-1,  new ChildLandNode((ParentLandNode) parentLand1));
        childrenOnFace1.put(0, new ChildLandNode((ParentLandNode)parentLand1));
        childrenOnFace1.put(1, new ChildLandNode((ParentLandNode)parentLand1));

        HashMap<Integer, ChildNode> childrenOnFace2 = new HashMap<>();
        childrenOnFace2.put(-1,  new ChildLandNode((ParentLandNode) parentLand1));
        childrenOnFace2.put(0, new ChildLandNode((ParentLandNode)parentLand1));
        childrenOnFace2.put(1, new ChildLandNode((ParentLandNode)parentLand1));

        HashMap<Integer, ChildNode> childrenOnFace3 = new HashMap<>();
        childrenOnFace3.put(-1,  new ChildLandNode((ParentLandNode) parentLand1));
        childrenOnFace3.put(0, new ChildLandNode((ParentLandNode)parentLand1));
        childrenOnFace3.put(1, new ChildLandNode((ParentLandNode)parentLand1));

        HashMap<Integer, ChildNode> childrenOnFace4 = new HashMap<>();
        childrenOnFace4.put(-1,  new ChildLandNode((ParentLandNode) parentLand1));
        childrenOnFace4.put(0, new ChildLandNode((ParentLandNode)parentLand1));
        childrenOnFace4.put(1, new ChildLandNode((ParentLandNode)parentLand1));

        HashMap<Integer, ChildNode> childrenOnFace5 = new HashMap<>();
        childrenOnFace5.put(-1,  new ChildLandNode((ParentLandNode) parentLand1));
        childrenOnFace5.put(0, new ChildLandNode((ParentLandNode)parentLand1));
        childrenOnFace5.put(1, new ChildLandNode((ParentLandNode)parentLand1));

        HashMap<Integer, ChildNode> childrenOnFace6 = new HashMap<>();
        childrenOnFace6.put(-1,  new ChildLandNode((ParentLandNode) parentLand1));
        childrenOnFace6.put(0, new ChildLandNode((ParentLandNode)parentLand1));
        childrenOnFace6.put(1, new ChildLandNode((ParentLandNode)parentLand1));



        //add to correct mapping //create mapping of face int value, and children arraylist
        HashMap<Integer, HashMap<Integer, ChildNode>> tmpChildrenNodes = new HashMap<>();

        tmpChildrenNodes.put(1, childrenOnFace1);
        tmpChildrenNodes.put(2, childrenOnFace2);
        tmpChildrenNodes.put(3, childrenOnFace3);
        tmpChildrenNodes.put(4, childrenOnFace4);
        tmpChildrenNodes.put(5, childrenOnFace5);
        tmpChildrenNodes.put(6, childrenOnFace6);

        //set children for parent
        parentLand1.setChildrenNodes(tmpChildrenNodes);

        System.out.println("class NoRiverSetup: init of parent " + parentLand1.getChildrenNodes().toString());
    //END INIT OF PARENT AND CHILDREN NODES


    //BEGIN INIT OF NODE_REPRESENTATION MAPPING
        //create 6 arraylists, representing the parent accessible from each face
        //add parent(s) to correct arraylist
        ArrayList<ParentNode> parentsAccessibleFromFace1 = new ArrayList<>(Arrays.asList(parentLand1));
        ArrayList<ParentNode> parentsAccessibleFromFace2 = new ArrayList<>(Arrays.asList(parentLand1));
        ArrayList<ParentNode> parentsAccessibleFromFace3 = new ArrayList<>(Arrays.asList(parentLand1));
        ArrayList<ParentNode> parentsAccessibleFromFace4 = new ArrayList<>(Arrays.asList(parentLand1));
        ArrayList<ParentNode> parentsAccessibleFromFace5 = new ArrayList<>(Arrays.asList(parentLand1));
        ArrayList<ParentNode> parentsAccessibleFromFace6 = new ArrayList<>(Arrays.asList(parentLand1));

        //create mapping of face int value, and accessible parent nodes
        HashMap<Integer, ArrayList<ParentNode>> tmpParentNodes = new HashMap<>();

        //add to correct mapping
        tmpParentNodes.put(1, parentsAccessibleFromFace1);
        tmpParentNodes.put(2, parentsAccessibleFromFace2);
        tmpParentNodes.put(3, parentsAccessibleFromFace3);
        tmpParentNodes.put(4, parentsAccessibleFromFace4);
        tmpParentNodes.put(5, parentsAccessibleFromFace5);
        tmpParentNodes.put(6, parentsAccessibleFromFace6);

        //set parents for node representation
        setParentMap(tmpParentNodes);
        System.out.println("class NoRiverSetup: init of rep map " + getParentMap().toString());
    //END INIT OF NODE_REPRESENTATION MAPPING

    }


}
