import javafx.scene.Parent;
import model.map.tile.nodeRepresentation.NoRiverSetup;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.resources.TileStorage;
import model.structures.primary_production_structures.ClayPit;
import org.junit.Test;
import static org.junit.Assert.*;

public class StructureTest {
    @Test
    public void testClayPit() throws Exception{
        NoRiverSetup noRiverSetup = new NoRiverSetup(0);
        ParentLandNode parentLandNode = new ParentLandNode(noRiverSetup, 1, 1);
        ClayPit clayPit = new ClayPit(parentLandNode);
        TileStorage tileStorage = new TileStorage();
        clayPit.produce(tileStorage);
        assertEquals(1, tileStorage.getSize());
    }
    @Test
    public void testMine() throws Exception{

    }
    @Test
    public void testOilRig() throws Exception{

    }
    @Test
    public void testQuarry() throws Exception{

    }
    @Test
    public void testWoodCutter() throws Exception{

    }
}
