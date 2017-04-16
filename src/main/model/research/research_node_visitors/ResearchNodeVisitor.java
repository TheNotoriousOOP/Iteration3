package model.research.research_node_visitors;

import model.research.research_nodes.ResearchNode;

public interface ResearchNodeVisitor {
    void researchNode(ResearchNode[] nodes);
}
