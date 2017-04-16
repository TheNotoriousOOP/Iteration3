import javafx.scene.Parent;
import model.map.tile.nodeRepresentation.NoRiverSetup;
import model.map.tile.nodeRepresentation.NodeRepresentation;
import model.map.tile.nodeRepresentation.SeaSetup;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentSeaNode;
import model.resources.TileStorage;
import model.structures.primary_production_structures.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class StructureTest {
    @Test
    public void testClayPit() throws Exception{
        NoRiverSetup noRiverSetup = new NoRiverSetup(0);
        ParentLandNode parentLandNode = new ParentLandNode(noRiverSetup);
        ClayPit clayPit = new ClayPit(parentLandNode);
        TileStorage tileStorage = new TileStorage();
        clayPit.produce(tileStorage);
        assertEquals(1, tileStorage.getSize());
    }
    @Test
    public void testMine() throws Exception{
        NoRiverSetup noRiverSetup = new NoRiverSetup(0);
        ParentLandNode parentLandNode = new ParentLandNode(noRiverSetup);
        Mine mine = new Mine(parentLandNode);
        TileStorage tileStorage = new TileStorage();
        mine.produce(tileStorage);
        assertEquals(1, tileStorage.getSize());
        for(int i = 0; i < 10; i++){
            mine.produce(tileStorage);
        }
        // 3 gold + 3 ore in tilestorage
        assertEquals(6, tileStorage.getSize());
        mine.addSpecializedGoldShaft();
        for(int i = 0; i < 10; i++){
            mine.produce(tileStorage);
        }
        // 7 gold + 3 ore in tilestorage
        assertEquals(10, tileStorage.getSize());

        mine.addBigShaft();
        assertEquals("Gold: 5 Iron: 5",mine.prospectMine());
        mine.addSpecializedIronShaft();
        assertEquals("Gold: 5 Iron: 9",mine.prospectMine());
    }
    @Test
    public void testOilRig() throws Exception{
        SeaSetup seaSetup = new SeaSetup(0);
        ParentSeaNode parentSeaNode = new ParentSeaNode(seaSetup);
        OilRig oilRig = new OilRig(parentSeaNode);
        TileStorage tileStorage = new TileStorage();
        oilRig.produce(tileStorage);
        assertEquals(1, tileStorage.getSize());
    }
    @Test
    public void testQuarry() throws Exception{
        NoRiverSetup noRiverSetup = new NoRiverSetup(0);
        ParentLandNode parentLandNode = new ParentLandNode(noRiverSetup);
        Quarry quarry = new Quarry(parentLandNode);
        TileStorage tileStorage = new TileStorage();
        quarry.produce(tileStorage);
        assertEquals(1, tileStorage.getSize());
    }
    @Test
    public void testWoodCutter() throws Exception{
        NoRiverSetup noRiverSetup = new NoRiverSetup(0);
        ParentLandNode parentLandNode = new ParentLandNode(noRiverSetup);
        WoodCutter woodCutter = new WoodCutter(parentLandNode);
        TileStorage tileStorage = new TileStorage();
        woodCutter.produce(tileStorage);
        assertEquals(1, tileStorage.getSize());
    }
}
