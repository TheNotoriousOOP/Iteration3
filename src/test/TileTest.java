import model.map.CubeVector;
import model.map.tile.Tile;
import model.map.tile.WoodsTile;
import model.map.tile.Zone;
import model.map.tile.ZoneTypeEnum;
import org.junit.Test;

/**
 * Created by Jonathen on 3/26/2017.
 */
public class TileTest {

    @Test
    public void testToString() {
        Zone[] zones1 = new Zone[6];
        zones1[0] = new Zone(ZoneTypeEnum.RIVER);
        zones1[1] = new Zone(ZoneTypeEnum.TERRAIN);
        zones1[2] = new Zone(ZoneTypeEnum.TERRAIN);
        zones1[3] = new Zone(ZoneTypeEnum.RIVER);
        zones1[4] = new Zone(ZoneTypeEnum.TERRAIN);
        zones1[5] = new Zone(ZoneTypeEnum.RIVER);
        Tile testTile1 = new WoodsTile(new CubeVector(0,0,0), zones1);

        Zone[] zones2 = new Zone[6];
        zones2[0] = new Zone(ZoneTypeEnum.TERRAIN);
        zones2[1] = new Zone(ZoneTypeEnum.TERRAIN);
        zones2[2] = new Zone(ZoneTypeEnum.TERRAIN);
        zones2[3] = new Zone(ZoneTypeEnum.TERRAIN);
        zones2[4] = new Zone(ZoneTypeEnum.TERRAIN);
        zones2[5] = new Zone(ZoneTypeEnum.TERRAIN);
        Tile testTile2 = new WoodsTile(new CubeVector(0,0,0), zones2);

        Zone[] zones3 = new Zone[6];
        zones3[0] = new Zone(ZoneTypeEnum.RIVER);
        zones3[1] = new Zone(ZoneTypeEnum.RIVER);
        zones3[2] = new Zone(ZoneTypeEnum.RIVER);
        zones3[3] = new Zone(ZoneTypeEnum.RIVER);
        zones3[4] = new Zone(ZoneTypeEnum.RIVER);
        zones3[5] = new Zone(ZoneTypeEnum.RIVER);
        Tile testTile3 = new WoodsTile(new CubeVector(0,0,0), zones3);

        assert testTile1.getZonesString().equals("( 1 4 6 )");
        assert testTile2.getZonesString().equals("");
        assert testTile3.getZonesString().equals("( 1 2 3 4 5 6 )");
    }
}

