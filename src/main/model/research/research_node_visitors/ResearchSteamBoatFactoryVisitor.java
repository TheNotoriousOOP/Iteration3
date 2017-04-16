package model.research.research_node_visitors;

import model.research.research_nodes.ResearchNode;

public class ResearchSteamBoatFactoryVisitor implements ResearchNodeVisitor {
    public void researchNode(ResearchNode[] nodes) {
        nodes[2].research();
    }
}
