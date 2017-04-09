import model.map.CubeVector;
import model.map.tile.Tile;
import model.map.tile.WoodsTile;
import model.map.tile.nodeRepresentation.LongCurvedRiverSetup;
import model.map.tile.nodeRepresentation.SharpCurvedRiverSetup;
import model.map.tile.nodeRepresentation.StraightRiverSetup;
import org.junit.Test;
import static org.junit.Assert.*;

public class TileTest {

    @Test
    public void testToString() {

        Tile testTile1 = new WoodsTile(new CubeVector(0,0,0), new SharpCurvedRiverSetup(300));

        Tile testTile2 = new WoodsTile(new CubeVector(0,0,0), new StraightRiverSetup(240));

        Tile testTile3 = new WoodsTile(new CubeVector(0,0,0), new LongCurvedRiverSetup(300));

        assertEquals("( 1 6 )", testTile1.getNodesString());
        assertEquals("( 2 5 )", testTile2.getNodesString());
        assertEquals("( 2 6 )", testTile3.getNodesString());
    }
}
