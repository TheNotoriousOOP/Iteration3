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
 * Node representation for a LandTile with a SharpCurvedRiver
 */
public class SharpCurvedRiverSetup extends NodeRepresentation {

    private int firstWaterFace;
    private int secondWaterFace;

    public SharpCurvedRiverSetup(int rotation){
        setRotation(rotation);
        setupNodesGivenRotation(rotation);
    }

    @Override
    public String getCorrectRiverImage(){
        return "RIVER_2_U";
    }

    @Override
    public String getRiverNodeString() {
        return "( " + firstWaterFace + " " + secondWaterFace + " )";
    }

    @Override
    void setupNodesGivenRotation(int rotation){

        //define the 6 distinct faces of a straight river tile, given rotation
        firstWaterFace = ((rotation / 60) + 1);
        secondWaterFace = calculateFace(firstWaterFace, 1 );
        int landFaceA = calculateFace(firstWaterFace, 2);
        int landFaceB = calculateFace(firstWaterFace, 3);
        int landFaceX = calculateFace(firstWaterFace, 4);
        int landFaceY = calculateFace(firstWaterFace, 5);

        //create parentLandNode1
        ParentNode parentLandNode1 = new ParentLandNode();

        //fill parentLandNode Child HashMap correctly:
        //  2 faces with all 3 children nodes of Land
        //  1 face with 1 child node land @-1
        //  1 face with 1 child node land @ 1

        HashMap<Integer, ChildNode> p1WaterFace1 = new HashMap<>();
        p1WaterFace1.put(1, new ChildLandNode((ParentLandNode) parentLandNode1));

        HashMap<Integer, ChildNode> p1WaterFace2 = new HashMap<>();
        p1WaterFace2.put(-1, new ChildLandNode((ParentLandNode) parentLandNode1));

        HashMap<Integer, HashMap<Integer, ChildNode>> tmpChildrenNodesP1 = new HashMap<>();

        //set children to correct face value
        tmpChildrenNodesP1.put(firstWaterFace, p1WaterFace1);
        tmpChildrenNodesP1.put(secondWaterFace, p1WaterFace2);

        parentLandNode1.setChildrenNodes(tmpChildrenNodesP1);

        //create parentLandNode2
        ParentNode parentLandNode2 = new ParentLandNode();

        //fill parentLandNode Child HashMap correctly:
        //  4 faces with all 3 children nodes of Land
        //  1 face with 1 child node land @-1
        //  1 face with 1 child node land @ 1
        HashMap<Integer, ChildNode> p2FaceA = new HashMap<>();
        p2FaceA.put(-1, new ChildLandNode((ParentLandNode) parentLandNode2));
        p2FaceA.put(0, new ChildLandNode((ParentLandNode) parentLandNode2));
        p2FaceA.put(1, new ChildLandNode((ParentLandNode) parentLandNode2));

        HashMap<Integer, ChildNode> p2FaceB = new HashMap<>();
        p2FaceB.put(-1, new ChildLandNode((ParentLandNode) parentLandNode2));
        p2FaceB.put(0, new ChildLandNode((ParentLandNode) parentLandNode2));
        p2FaceB.put(1, new ChildLandNode((ParentLandNode) parentLandNode2));

        HashMap<Integer, ChildNode> p2FaceX = new HashMap<>();
        p2FaceX.put(-1, new ChildLandNode((ParentLandNode) parentLandNode2));
        p2FaceX.put(0, new ChildLandNode((ParentLandNode) parentLandNode2));
        p2FaceX.put(1, new ChildLandNode((ParentLandNode) parentLandNode2));

        HashMap<Integer, ChildNode> p2FaceY = new HashMap<>();
        p2FaceY.put(-1, new ChildLandNode((ParentLandNode) parentLandNode2));
        p2FaceY.put(0, new ChildLandNode((ParentLandNode) parentLandNode2));
        p2FaceY.put(1, new ChildLandNode((ParentLandNode) parentLandNode2));

        HashMap<Integer, ChildNode> p2WaterFace1 = new HashMap<>();
        p2WaterFace1.put(-1, new ChildLandNode((ParentLandNode) parentLandNode2));

        HashMap<Integer, ChildNode> p2WaterFace2 = new HashMap<>();
        p2WaterFace2.put(1, new ChildLandNode((ParentLandNode) parentLandNode2));


        HashMap<Integer, HashMap<Integer, ChildNode>> tmpChildrenNodesP2 = new HashMap<>();

        //set children to correct face value
        tmpChildrenNodesP2.put(landFaceA, p2FaceA);
        tmpChildrenNodesP2.put(landFaceB, p2FaceB);
        tmpChildrenNodesP2.put(firstWaterFace, p2WaterFace1);
        tmpChildrenNodesP2.put(landFaceX, p2FaceX);
        tmpChildrenNodesP2.put(landFaceY, p2FaceY);
        tmpChildrenNodesP2.put(secondWaterFace, p2WaterFace2);

        parentLandNode2.setChildrenNodes(tmpChildrenNodesP2);

        //create the 1 river parent node
        ParentNode parentRiverNode = new ParentRiverNode();

        //fill the 2 faces the river touches
        HashMap<Integer, ChildNode> riverChildren1 = new HashMap<>();
        riverChildren1.put(0, new ChildRiverNode((ParentRiverNode) parentRiverNode));

        HashMap<Integer, ChildNode> riverChildren2 = new HashMap<>();
        riverChildren2.put(0, new ChildRiverNode((ParentRiverNode) parentRiverNode));

        HashMap<Integer, HashMap<Integer, ChildNode>> tmpChildrenNodesRiver = new HashMap<>();

        //set children to correct face value
        tmpChildrenNodesRiver.put(firstWaterFace, riverChildren1);
        tmpChildrenNodesRiver.put(secondWaterFace, riverChildren2);

        parentRiverNode.setChildrenNodes(tmpChildrenNodesRiver);

        //BEGIN INIT OF NODE_REPRESENTATION MAPPING
        //create 6 arraylists, representing the parent accessible from each face
        //add parent(s) to correct arraylist
        ArrayList<ParentNode> parentsAccessibleFromFaceR1 = new ArrayList<>(Arrays.asList(parentLandNode1, parentLandNode2, parentRiverNode));
        ArrayList<ParentNode> parentsAccessibleFromFaceR2 = new ArrayList<>(Arrays.asList(parentLandNode1, parentLandNode2, parentRiverNode));
        ArrayList<ParentNode> parentsAccessibleFromFaceLA = new ArrayList<>(Arrays.asList(parentLandNode2));
        ArrayList<ParentNode> parentsAccessibleFromFaceLB = new ArrayList<>(Arrays.asList(parentLandNode2));
        ArrayList<ParentNode> parentsAccessibleFromFaceLX = new ArrayList<>(Arrays.asList(parentLandNode2));
        ArrayList<ParentNode> parentsAccessibleFromFaceLY = new ArrayList<>(Arrays.asList(parentLandNode2));

        //create mapping of face int value, and accessible parent nodes
        HashMap<Integer, ArrayList<ParentNode>> tmpParentNodes = new HashMap<>();

        //add to correct mapping
        tmpParentNodes.put(firstWaterFace, parentsAccessibleFromFaceR1);
        tmpParentNodes.put(secondWaterFace, parentsAccessibleFromFaceR2);
        tmpParentNodes.put(landFaceA, parentsAccessibleFromFaceLA);
        tmpParentNodes.put(landFaceB, parentsAccessibleFromFaceLB);
        tmpParentNodes.put(landFaceX, parentsAccessibleFromFaceLX);
        tmpParentNodes.put(landFaceY, parentsAccessibleFromFaceLY);


        //set parents for node representation
        setParentMap(tmpParentNodes);
        //END INIT OF NODE_REPRESENTATION MAPPING
    }

    private int calculateFace(int face, int delta){
        face += delta;
        if(face >= 7){
            face -= 6;
        }
        return face;
    }

}
