package model.map.tile.nodeRepresentation;

import model.map.tile.nodeRepresentation.nodes.child.ChildLandNode;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Node representation for a terrain without rivers, excluding Sea
 */
public class NoRiverSetup extends NodeRepresentation{

    public NoRiverSetup(int rotation) {
        super(rotation);
    }

    @Override
    void setupNodesGivenRotation(int rotation) {
        //disregard rotation with no rivers

    //BEGIN INIT OF PARENT AND CHILDREN NODES
        //create 1 parent land
        ParentNode parentLand1 = new ParentLandNode();

        //create 6 children land
        ChildNode childNode1 = new ChildLandNode((ParentLandNode) parentLand1);
        ChildNode childNode2 = new ChildLandNode((ParentLandNode) parentLand1);
        ChildNode childNode3 = new ChildLandNode((ParentLandNode) parentLand1);
        ChildNode childNode4 = new ChildLandNode((ParentLandNode) parentLand1);
        ChildNode childNode5 = new ChildLandNode((ParentLandNode) parentLand1);
        ChildNode childNode6 = new ChildLandNode((ParentLandNode) parentLand1);

        //create 6 arraylists, representing the children on each face
        ArrayList<ChildNode> childrenOnFace1 = new ArrayList<>();
        ArrayList<ChildNode> childrenOnFace2 = new ArrayList<>();
        ArrayList<ChildNode> childrenOnFace3 = new ArrayList<>();
        ArrayList<ChildNode> childrenOnFace4 = new ArrayList<>();
        ArrayList<ChildNode> childrenOnFace5 = new ArrayList<>();
        ArrayList<ChildNode> childrenOnFace6 = new ArrayList<>();

        //add children to correct arraylist
        childrenOnFace1.add(childNode1);
        childrenOnFace2.add(childNode2);
        childrenOnFace3.add(childNode3);
        childrenOnFace4.add(childNode4);
        childrenOnFace5.add(childNode5);
        childrenOnFace6.add(childNode6);

        //create mapping of face int value, and children arraylist
        HashMap<Integer, ArrayList<ChildNode>> tmpChildrenNodes = new HashMap<>();

        //add to correct mapping
        tmpChildrenNodes.put(1, childrenOnFace1);
        tmpChildrenNodes.put(2, childrenOnFace2);
        tmpChildrenNodes.put(3, childrenOnFace3);
        tmpChildrenNodes.put(4, childrenOnFace4);
        tmpChildrenNodes.put(5, childrenOnFace5);
        tmpChildrenNodes.put(6, childrenOnFace6);

        //set children for parent
        parentLand1.setChildrenNodes(tmpChildrenNodes);
    //END INIT OF PARENT AND CHILDREN NODES


    //BEGIN INIT OF NODE_REPRESENTATION MAPPING
        //create 6 arraylists, representing the parent accessible from each face
        ArrayList<ParentNode> parentsAccessibleFromFace1 = new ArrayList<>();
        ArrayList<ParentNode> parentsAccessibleFromFace2 = new ArrayList<>();
        ArrayList<ParentNode> parentsAccessibleFromFace3 = new ArrayList<>();
        ArrayList<ParentNode> parentsAccessibleFromFace4 = new ArrayList<>();
        ArrayList<ParentNode> parentsAccessibleFromFace5 = new ArrayList<>();
        ArrayList<ParentNode> parentsAccessibleFromFace6 = new ArrayList<>();

        //add parent(s) to correct arraylist
        parentsAccessibleFromFace1.add(parentLand1);
        parentsAccessibleFromFace2.add(parentLand1);
        parentsAccessibleFromFace3.add(parentLand1);
        parentsAccessibleFromFace4.add(parentLand1);
        parentsAccessibleFromFace5.add(parentLand1);
        parentsAccessibleFromFace6.add(parentLand1);


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

    }
}
