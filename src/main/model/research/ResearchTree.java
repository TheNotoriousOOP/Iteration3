package model.research;

import model.research.research_node_observers.ResearchObserver;
import model.research.research_node_visitors.ResearchNodeVisitor;
import model.research.research_nodes.*;

/**
 * Created by TheNotoriousOOP on 4/13/2017.
 * Class Description:
 * Responsibilities:
 */
public class ResearchTree {

    // Research nodes
    private ResearchNode[] researchTree;


    // Constructor
    public ResearchTree(ResearchObserver observer) {

        // Setup tree
        setupTree(observer);

    }

    public ResearchNode[] getResearchNodes() { return researchTree; }

    // Research the specified node
    public void performResearch(ResearchNodeVisitor v) {
        v.researchNode(getResearchNodes());
    }

    // Setup research tree nodes
    private void setupTree(ResearchObserver observer) {

        // Setup array
        researchTree = new ResearchNode[8];

        // Setup nodes
        researchTree[0] = new TruckResearchNode(observer);
        researchTree[1] = new RowboatResearchNode(observer);
        researchTree[2] = new SteamboatResearchNode(observer);
        researchTree[3] = new SpecializedMineResearchNode(observer);
        researchTree[4] = new BiggerMineResearchNode(observer);
        researchTree[5] = new OilRigResearchNode(observer);
        researchTree[6] = new AdditionalMineShaftResearchNode(observer);

    }


}
