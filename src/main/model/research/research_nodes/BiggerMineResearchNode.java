package model.research.research_nodes;

import model.research.research_node_observers.ResearchObserver;

/**
 * Created by TheNotoriousOOP on 4/14/2017.
 * Class Description:
 * Responsibilities:
 */
public class BiggerMineResearchNode extends ResearchNode {

    // Constructor
    public BiggerMineResearchNode(ResearchObserver observer) {
        super(observer);
    }

    // Notify observer
    public void notifyResearch() {
        getObserver().onBigMineResearched();
    }

}
