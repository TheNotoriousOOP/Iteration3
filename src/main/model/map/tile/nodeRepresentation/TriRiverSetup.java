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
 * Node representation for a LandTile with a TriRiver
 */
public class TriRiverSetup  extends NodeRepresentation {
    private int firstWaterFace;
    private int secondWaterFace;
    private int thirdWaterFace;

    public TriRiverSetup(int rotation){
        setRotation(rotation);
        setupNodesGivenRotation(rotation);
    }

    @Override
    public String getCorrectRiverImage(){
        return "RIVER_3";
    }

    @Override
    public String getRiverNodeString() {

        return "( " + firstStringFace() + " " + secondStringFace() + " " + thirdStringFace() + " )";
    }

    @Override
    void setupNodesGivenRotation(int rotation){
        int xOffSet1 = 30;
        int yOffSet1 = -10;

        int xOffSet2 = -30;
        int yOffSet2 = -10;

        int xOffSet3 = 0;
        int yOffSet3 = 30;




        //define the 6 distinct faces of a straight river tile, given rotation
        firstWaterFace = ((rotation / 60) + 1);
        secondWaterFace = calculateFace(firstWaterFace, 2 );
        thirdWaterFace = calculateFace(firstWaterFace, 4);
        int landFaceA = calculateFace(firstWaterFace, 1);
        int landFaceB = calculateFace(firstWaterFace, 3);
        int landFaceC = calculateFace(firstWaterFace, 5);

        //check if even, flip all of the node offset positions
        if((firstWaterFace & 1) == 0){
            xOffSet1 = -xOffSet1;
            yOffSet1 = -yOffSet1;

            xOffSet2 = -xOffSet2;
            yOffSet2 = -yOffSet2;

            xOffSet3 = -xOffSet1;
            yOffSet3 = - yOffSet3;
        }

        //create parentLandNode1
        ParentNode parentLandNode1 = new ParentLandNode(this, xOffSet1, yOffSet1);

        //fill parentLandNode Child HashMap correctly:
        //  1 face with all 3 children nodes of Land
        //  1 face with 1 child node land @-1
        //  1 face with 1 child node land @ 1

        HashMap<Integer, ChildNode> p1WaterFace1 = new HashMap<>();
        p1WaterFace1.put(1, new ChildLandNode((ParentLandNode) parentLandNode1));

        HashMap<Integer, ChildNode> p1FaceA = new HashMap<>();
        p1FaceA.put(-1, new ChildLandNode((ParentLandNode) parentLandNode1));
        p1FaceA.put(0, new ChildLandNode((ParentLandNode) parentLandNode1));
        p1FaceA.put(1, new ChildLandNode((ParentLandNode) parentLandNode1));


        HashMap<Integer, ChildNode> p1WaterFace2 = new HashMap<>();
        p1WaterFace2.put(-1, new ChildLandNode((ParentLandNode) parentLandNode1));


        HashMap<Integer, HashMap<Integer, ChildNode>> tmpChildrenNodesP1 = new HashMap<>();

        //set children to correct face value
        tmpChildrenNodesP1.put(firstWaterFace, p1WaterFace1);
        tmpChildrenNodesP1.put(landFaceA, p1FaceA);
        tmpChildrenNodesP1.put(secondWaterFace, p1WaterFace2);

        parentLandNode1.setChildrenNodes(tmpChildrenNodesP1);

        //create parentLandNode2
        ParentNode parentLandNode2 = new ParentLandNode(this, xOffSet2, yOffSet2);

        HashMap<Integer, ChildNode> p2FaceB = new HashMap<>();
        p2FaceB.put(-1, new ChildLandNode((ParentLandNode) parentLandNode2));
        p2FaceB.put(0, new ChildLandNode((ParentLandNode) parentLandNode2));
        p2FaceB.put(1, new ChildLandNode((ParentLandNode) parentLandNode2));

        HashMap<Integer, ChildNode> p2WaterFace1 = new HashMap<>();
        p2WaterFace1.put(1, new ChildLandNode((ParentLandNode) parentLandNode2));

        HashMap<Integer, ChildNode> p2WaterFace2 = new HashMap<>();
        p2WaterFace2.put(-1, new ChildLandNode((ParentLandNode) parentLandNode2));


        HashMap<Integer, HashMap<Integer, ChildNode>> tmpChildrenNodesP2 = new HashMap<>();

        //set children to correct face value

        tmpChildrenNodesP2.put(landFaceB, p2FaceB);
        tmpChildrenNodesP2.put(secondWaterFace, p2WaterFace1);
        tmpChildrenNodesP2.put(thirdWaterFace, p2WaterFace2);

        parentLandNode2.setChildrenNodes(tmpChildrenNodesP2);

        // Create parentLandNode3
        ParentNode parentLandNode3 = new ParentLandNode(this,xOffSet3, yOffSet3);

        //fill parentLandNode Child HashMap correctly:
        //  1 face with all 3 children nodes of Land
        //  1 face with 1 child node land @-1
        //  1 face with 1 child node land @ 1
        HashMap<Integer, ChildNode> p3FaceC = new HashMap<>();
        p3FaceC.put(-1, new ChildLandNode((ParentLandNode) parentLandNode3));
        p3FaceC.put(0, new ChildLandNode((ParentLandNode) parentLandNode3));
        p3FaceC.put(1, new ChildLandNode((ParentLandNode) parentLandNode3));

        HashMap<Integer, ChildNode> p3WaterFace1 = new HashMap<>();
        p3WaterFace1.put(-1, new ChildLandNode((ParentLandNode) parentLandNode3));

        HashMap<Integer, ChildNode> p3WaterFace2 = new HashMap<>();
        p3WaterFace2.put(1, new ChildLandNode((ParentLandNode) parentLandNode3));


        HashMap<Integer, HashMap<Integer, ChildNode>> tmpChildrenNodesP3 = new HashMap<>();

        //set children to correct face value

        tmpChildrenNodesP3.put(landFaceC, p3FaceC);
        tmpChildrenNodesP3.put(firstWaterFace, p3WaterFace1);
        tmpChildrenNodesP3.put(thirdWaterFace, p3WaterFace2);

        parentLandNode3.setChildrenNodes(tmpChildrenNodesP3);

        //create the 1 river parent node
        ParentNode parentRiverNode = new ParentRiverNode(this,0 ,0 );

        //fill the 2 faces the river touches
        HashMap<Integer, ChildNode> riverChildren1 = new HashMap<>();
        riverChildren1.put(0, new ChildRiverNode((ParentRiverNode) parentRiverNode));

        HashMap<Integer, ChildNode> riverChildren2 = new HashMap<>();
        riverChildren2.put(0, new ChildRiverNode((ParentRiverNode) parentRiverNode));

        HashMap<Integer, ChildNode> riverChildren3 = new HashMap<>();
        riverChildren3.put(0, new ChildRiverNode((ParentRiverNode) parentRiverNode));

        HashMap<Integer, HashMap<Integer, ChildNode>> tmpChildrenNodesRiver = new HashMap<>();

        //set children to correct face value
        tmpChildrenNodesRiver.put(firstWaterFace, riverChildren1);
        tmpChildrenNodesRiver.put(secondWaterFace, riverChildren2);
        tmpChildrenNodesRiver.put(thirdWaterFace, riverChildren3);

        parentRiverNode.setChildrenNodes(tmpChildrenNodesRiver);


        //BEGIN INIT OF NODE_REPRESENTATION MAPPING
        //create 6 arraylists, representing the parent accessible from each face
        //add parent(s) to correct arraylist
        ArrayList<ParentNode> parentsAccessibleFromFaceR1 = new ArrayList<>(Arrays.asList(parentLandNode1, parentLandNode3, parentRiverNode));
        ArrayList<ParentNode> parentsAccessibleFromFaceR2 = new ArrayList<>(Arrays.asList(parentLandNode1, parentLandNode2, parentRiverNode));
        ArrayList<ParentNode> parentsAccessibleFromFaceR3 = new ArrayList<>(Arrays.asList(parentLandNode3, parentLandNode2, parentRiverNode));
        ArrayList<ParentNode> parentsAccessibleFromFaceLA = new ArrayList<>(Arrays.asList(parentLandNode1));
        ArrayList<ParentNode> parentsAccessibleFromFaceLB = new ArrayList<>(Arrays.asList(parentLandNode2));
        ArrayList<ParentNode> parentsAccessibleFromFaceLC = new ArrayList<>(Arrays.asList(parentLandNode3));


        //create mapping of face int value, and accessible parent nodes
        HashMap<Integer, ArrayList<ParentNode>> tmpParentNodes = new HashMap<>();

        //add to correct mapping
        tmpParentNodes.put(firstWaterFace, parentsAccessibleFromFaceR1);
        tmpParentNodes.put(secondWaterFace, parentsAccessibleFromFaceR2);
        tmpParentNodes.put(thirdWaterFace, parentsAccessibleFromFaceR3);
        tmpParentNodes.put(landFaceA, parentsAccessibleFromFaceLA);
        tmpParentNodes.put(landFaceB, parentsAccessibleFromFaceLB);
        tmpParentNodes.put(landFaceC, parentsAccessibleFromFaceLC);

        //set parents for node representation
        setParentMap(tmpParentNodes);
        //END INIT OF NODE_REPRESENTATION MAPPING

        parseChildrenForDirection();

    }

    private int calculateFace(int face, int delta){
        face += delta;
        if(face >= 7){
            face -= 6;
        }
        return face;
    }

    private int firstStringFace(){
        if(firstWaterFace < secondWaterFace && firstWaterFace < thirdWaterFace)
            return firstWaterFace;
        else if(secondWaterFace < firstWaterFace && secondWaterFace < thirdWaterFace)
            return secondWaterFace;
        else
            return thirdWaterFace;
    }
    private int secondStringFace(){
        if((firstWaterFace < secondWaterFace && firstWaterFace > thirdWaterFace) || (firstWaterFace > secondWaterFace && firstWaterFace < thirdWaterFace))
            return firstWaterFace;
        else if((secondWaterFace > firstWaterFace && secondWaterFace < thirdWaterFace)||(secondWaterFace < firstWaterFace && secondWaterFace > thirdWaterFace))
            return secondWaterFace;
        else
            return thirdWaterFace;
    }
    private int thirdStringFace(){
        if(firstWaterFace > secondWaterFace && firstWaterFace > thirdWaterFace)
            return firstWaterFace;
        else if(secondWaterFace > firstWaterFace && secondWaterFace > thirdWaterFace)
            return secondWaterFace;
        else
            return thirdWaterFace;
    }

}