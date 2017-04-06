package model.map.tile.nodeRepresentation;

import model.map.tile.nodeRepresentation.nodes.child.ChildLandNode;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.map.tile.nodeRepresentation.nodes.child.ChildRiverNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentRiverNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 */
public class SourceRiverSetup extends NodeRepresentation {

    public SourceRiverSetup(int rotation){
        setRotation(rotation);
        setupNodesGivenRotation(rotation);
    }

    @Override
    void setupNodesGivenRotation(int rotation) {
/*//BEGIN INIT OF PARENT AND CHILDREN NODES
        //create 1 parent land
        ParentNode parentLand1 = new ParentLandNode();

        //create 6 arraylists, representing the (up to) 3 land children on each face
        //add to arraylist the 3 children

        //the face with the source only has 2 land children
        ArrayList<ChildNode> childrenOnFaceSource = new ArrayList<>(Arrays.asList(
                new ChildLandNode((ParentLandNode) parentLand1),
                new ChildLandNode((ParentLandNode) parentLand1)));

        ArrayList<ChildNode> childrenOnFaceA = new ArrayList<>(Arrays.asList(
                new ChildLandNode((ParentLandNode) parentLand1),
                new ChildLandNode((ParentLandNode) parentLand1),
                new ChildLandNode((ParentLandNode) parentLand1)));

        ArrayList<ChildNode> childrenOnFaceB = new ArrayList<>(Arrays.asList(
                new ChildLandNode((ParentLandNode) parentLand1),
                new ChildLandNode((ParentLandNode) parentLand1),
                new ChildLandNode((ParentLandNode) parentLand1)));

        ArrayList<ChildNode> childrenOnFaceC = new ArrayList<>(Arrays.asList(
                new ChildLandNode((ParentLandNode) parentLand1),
                new ChildLandNode((ParentLandNode) parentLand1),
                new ChildLandNode((ParentLandNode) parentLand1)));

        ArrayList<ChildNode> childrenOnFaceD = new ArrayList<>(Arrays.asList(
                new ChildLandNode((ParentLandNode) parentLand1),
                new ChildLandNode((ParentLandNode) parentLand1),
                new ChildLandNode((ParentLandNode) parentLand1)));

        ArrayList<ChildNode> childrenOnFaceE = new ArrayList<>(Arrays.asList(
                new ChildLandNode((ParentLandNode) parentLand1),
                new ChildLandNode((ParentLandNode) parentLand1),
                new ChildLandNode((ParentLandNode) parentLand1)));


        //add to correct mapping //create mapping of face int value, and children arraylist
        HashMap<Integer, ArrayList<ChildNode>> tmpChildrenLandNodes = new HashMap<>();

        tmpChildrenLandNodes.put(1, childrenOnFaceSource);
        tmpChildrenLandNodes.put(2, childrenOnFaceA);
        tmpChildrenLandNodes.put(3, childrenOnFaceB);
        tmpChildrenLandNodes.put(4, childrenOnFaceC);
        tmpChildrenLandNodes.put(5, childrenOnFaceD);
        tmpChildrenLandNodes.put(6, childrenOnFaceE);

        //set children for parent
        parentLand1.setChildrenNodes(tmpChildrenLandNodes);

        //create 1 parent river
        ParentNode parentRiver1 = new ParentRiverNode();

        int faceWithSource = ((rotation / 60) + 1);*/
    }
}
