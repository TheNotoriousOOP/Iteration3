import model.player.Player;
import model.research.PlayerResearchSettings;
import model.research.ResearchTree;
import model.research.research_node_visitors.*;
import model.research.research_nodes.ResearchNode;
import org.junit.Before;
import org.junit.Test;

// Test the tech tree
public class ResearchTreeTest {

    private Player player;
    private PlayerResearchSettings settings;
    private ResearchTree researchTree;

    @Before
    public void setup() {
        this.player = new Player("fuck research");
        this.settings = player.getResearchSettings();
        this.researchTree  = player.getResearchTree();
    }

    // Test researching a node sets it to researched
    @Test
    public void testResearchingNodes() {

        assert (researchTree.getResearchNodes()[0].isResearched() == false);
        assert (settings.trucksEnabled() == false);
        researchTree.performResearch(new ResearchTruckFactoryVisitor());
        assert (researchTree.getResearchNodes()[0].isResearched() == true);
        assert (settings.trucksEnabled() == true);

        assert (researchTree.getResearchNodes()[1].isResearched() == false);
        assert (settings.rowBoatsEnabled() == false);
        researchTree.performResearch(new ResearchRowBoatFactoryVisitor());
        assert (researchTree.getResearchNodes()[1].isResearched() == true);
        assert (settings.rowBoatsEnabled() == true);

        assert (researchTree.getResearchNodes()[2].isResearched() == false);
        assert (settings.steamBoatsEnabled() == false);
        researchTree.performResearch(new ResearchSteamBoatFactoryVisitor());
        assert (researchTree.getResearchNodes()[2].isResearched() == true);
        assert (settings.steamBoatsEnabled() == true);

        assert (researchTree.getResearchNodes()[3].isResearched() == false);
        assert (settings.specializedMineEnabled() == false);
        researchTree.performResearch(new ResearchSpecializedMineVisitor());
        assert (researchTree.getResearchNodes()[3].isResearched() == true);
        assert (settings.specializedMineEnabled() == true);

        assert (researchTree.getResearchNodes()[4].isResearched() == false);
        assert (settings.bigMineEnabled() == false);
        researchTree.performResearch(new ResearchBigMineVisitor());
        assert (researchTree.getResearchNodes()[4].isResearched() == true);
        assert (settings.bigMineEnabled() == true);

        assert (researchTree.getResearchNodes()[5].isResearched() == false);
        assert (settings.oilRigsEnabled() == false);
        researchTree.performResearch(new ResearchOilRigVisitor());
        assert (researchTree.getResearchNodes()[5].isResearched() == true);
        assert (settings.oilRigsEnabled() == true);

        assert (researchTree.getResearchNodes()[6].isResearched() == false);
        assert (settings.additonalMineEnabled() == false);
        researchTree.performResearch(new ResearchAdditionalMineShaftVisitor());
        assert (settings.additonalMineEnabled() == true);
        assert (researchTree.getResearchNodes()[6].isResearched() == true);

    }

}
