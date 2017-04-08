package model.map.tile.nodeRepresentation;

import model.map.tile.nodeRepresentation.nodes.child.ChildLandNode;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.map.tile.nodeRepresentation.nodes.child.ChildRiverNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentRiverNode;

import java.util.HashMap;

public class StraightRiverSetup extends NodeRepresentation {
    public StraightRiverSetup(int rotation){
        setRotation(rotation);
        setupNodesGivenRotation(rotation);
    }

    @Override
    public String getCorrectRiverImage(){
        return "STRAIGHT";
    }

    @Override
    void setupNodesGivenRotation(int rotation){
        int firstWaterFace = ((rotation / 60 ) + 1);
        int secondWaterFace = (firstWaterFace + 3) % 6;
        ParentLandNode parentLandNode1 = new ParentLandNode();
        ParentLandNode parentLandNode2 = new ParentLandNode();
        ParentRiverNode parentRiverNode = new ParentRiverNode();

        HashMap<Integer, ChildNode> childrenOnFace1 = new HashMap<>();
        childrenOnFace1.put(-1, new ChildLandNode(parentLandNode2));
        childrenOnFace1.put(0, new ChildRiverNode(parentRiverNode));
        childrenOnFace1.put(1, new ChildLandNode(parentLandNode1));

        HashMap<Integer, ChildNode> childrenOnFace2 = new HashMap<>();
        childrenOnFace2.put(-1, new ChildLandNode(parentLandNode1));
        childrenOnFace2.put(0, new ChildLandNode(parentLandNode1));
        childrenOnFace2.put(1, new ChildLandNode(parentLandNode1));

        HashMap<Integer, ChildNode> childrenOnFace3 = new HashMap<>();
        childrenOnFace3.put(-1, new ChildLandNode(parentLandNode1));
        childrenOnFace3.put(0, new ChildLandNode(parentLandNode1));
        childrenOnFace3.put(1, new ChildLandNode(parentLandNode1));

        HashMap<Integer, ChildNode> childrenOnFace4 = new HashMap<>();
        childrenOnFace4.put(-1, new ChildLandNode(parentLandNode1));
        childrenOnFace4.put(0, new ChildRiverNode(parentRiverNode));
        childrenOnFace4.put(1, new ChildLandNode(parentLandNode2));

        HashMap<Integer, ChildNode> childrenOnFace5 = new HashMap<>();
        childrenOnFace5.put(-1, new ChildLandNode(parentLandNode2));
        childrenOnFace5.put(0, new ChildLandNode(parentLandNode2));
        childrenOnFace5.put(1, new ChildLandNode(parentLandNode2));

        HashMap<Integer, ChildNode> childrenOnFace6 = new HashMap<>();
        childrenOnFace6.put(-1, new ChildLandNode(parentLandNode2));
        childrenOnFace6.put(0, new ChildLandNode(parentLandNode2));
        childrenOnFace6.put(1, new ChildLandNode(parentLandNode2));

        HashMap<Integer, HashMap<Integer, ChildNode>> tmpChildrenNodes = new HashMap<>();
        HashMap<Integer, HashMap<Integer, ChildNode>> tempChildLandNode1 = new HashMap<>();
        HashMap<Integer, HashMap<Integer, ChildNode>> tempChildLandNode2 = new HashMap<>();

        tmpChildrenNodes.put(1, childrenOnFace1);
        tmpChildrenNodes.put(2, childrenOnFace2);
        tmpChildrenNodes.put(3, childrenOnFace3);
        tmpChildrenNodes.put(4, childrenOnFace4);
        tmpChildrenNodes.put(5, childrenOnFace5);
        tmpChildrenNodes.put(6, childrenOnFace6);

        tmpChildrenNodes.get(firstWaterFace).remove(0);
        tmpChildrenNodes.get(secondWaterFace).remove(0);

        tempChildLandNode1.put(firstWaterFace, tmpChildrenNodes.get(1));
        //tempChildLandNode1.put(firstWaterFace+1, tmpChildrenNodes.getOr);
        tempChildLandNode1.put(firstWaterFace+2, tmpChildrenNodes.get(1));
        tempChildLandNode1.put(secondWaterFace, tmpChildrenNodes.get(-1));

        tempChildLandNode2.put(secondWaterFace, tmpChildrenNodes.get(1));
        //tempChildLandNode2.put(secondWaterFace+1, tmpChildrenNodes.getOr);
        tempChildLandNode2.put(secondWaterFace+2, tmpChildrenNodes.get(1));
        tempChildLandNode2.put(firstWaterFace, tmpChildrenNodes.get(-1));





    }
}
