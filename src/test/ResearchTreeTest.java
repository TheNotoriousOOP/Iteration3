import model.player.Player;
import model.research.ResearchTree;
import model.research.research_node_visitors.*;
import model.research.research_nodes.ResearchNode;
import org.junit.Before;
import org.junit.Test;

// Test the tech tree
public class ResearchTreeTest {

    private Player player;
    private ResearchTree researchTree;

    @Before
    public void setup() {
        this.player = new Player();
        this.researchTree  = player.getResearchTree();
    }

    // Test researching a node sets it to researched
    @Test
    public void testResearchingNodes() {

        assert (researchTree.getResearchNodes()[0].isResearched() == false);
        researchTree.performResearch(new ResearchTruckFactoryVisitor());
        assert (researchTree.getResearchNodes()[0].isResearched() == true);

        assert (researchTree.getResearchNodes()[1].isResearched() == false);
        researchTree.performResearch(new ResearchRowBoatFactoryVisitor());
        assert (researchTree.getResearchNodes()[1].isResearched() == true);

        assert (researchTree.getResearchNodes()[2].isResearched() == false);
        researchTree.performResearch(new ResearchSteamBoatFactoryVisitor());
        assert (researchTree.getResearchNodes()[2].isResearched() == true);

        assert (researchTree.getResearchNodes()[3].isResearched() == false);
        researchTree.performResearch(new ResearchSpecializedMineVisitor());
        assert (researchTree.getResearchNodes()[3].isResearched() == true);

        assert (researchTree.getResearchNodes()[4].isResearched() == false);
        researchTree.performResearch(new ResearchBigMineVisitor());
        assert (researchTree.getResearchNodes()[4].isResearched() == true);

        assert (researchTree.getResearchNodes()[5].isResearched() == false);
        researchTree.performResearch(new ResearchOilRigVisitor());
        assert (researchTree.getResearchNodes()[5].isResearched() == true);

        assert (researchTree.getResearchNodes()[6].isResearched() == false);
        researchTree.performResearch(new ResearchAdditionalMineShaftVisitor());
        assert (researchTree.getResearchNodes()[6].isResearched() == true);

    }

}
