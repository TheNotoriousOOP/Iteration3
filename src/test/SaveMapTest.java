import model.map.CubeVector;
import model.map.editor.EditorMap;
import model.map.tile.*;
import org.junit.Test;

/**
 * Created by Jonathen on 3/26/2017.
 */
public class SaveMapTest {

    @Test
    public void testSave() {
        EditorMap testMap = new EditorMap(15);

        Zone[] zones1 = new Zone[6];
        zones1[0] = new Zone(true, true);
        zones1[1] = new Zone(false, true);
        zones1[2] = new Zone(false, true);
        zones1[3] = new Zone(true, true);
        zones1[4] = new Zone(false, true);
        zones1[5] = new Zone(true, true);

        Zone[] zones2 = new Zone[6];
        zones2[0] = new Zone(false, true);
        zones2[1] = new Zone(false, true);
        zones2[2] = new Zone(false, true);
        zones2[3] = new Zone(false, true);
        zones2[4] = new Zone(false, true);
        zones2[5] = new Zone(false, true);

        Zone[] zones3 = new Zone[6];
        zones3[0] = new Zone(true, true);
        zones3[1] = new Zone(true, true);
        zones3[2] = new Zone(true, true);
        zones3[3] = new Zone(true, true);
        zones3[4] = new Zone(true, true);
        zones3[5] = new Zone(true, true);

        CubeVector vec1 = new CubeVector(0,0,0);
        CubeVector vec2 = new CubeVector(0,1,-1);
        CubeVector vec3 = new CubeVector(-1,1,0);
        CubeVector vec4 = new CubeVector(-1,0,1);
        CubeVector vec5 = new CubeVector(0,0,1);
        CubeVector vec6 = new CubeVector(1,0,0);
        CubeVector vec7 = new CubeVector(1,0,-1);

        testMap.addTile(new PastureTile(vec1, zones1));
        testMap.addTile(new PastureTile(vec2, zones3));
        testMap.addTile(new WoodsTile(vec3, zones1));
        testMap.addTile(new RockTile(vec4, zones2));
        testMap.addTile(new DesertTile(vec5, zones2));
        testMap.addTile(new SeaTile(vec6, zones1));
        testMap.addTile(new MountainsTile(vec7, zones3));

        String[] testMapLines = testMap.save();

        String testMapString = "";
        for (int i=0; i < testMapLines.length; i++) {
            testMapString += testMapLines[i] + "\n";
        }

        //Test first line
        assert testMapLines[0].equals("7");
        //Test length of array
        assert testMapLines.length == 8;
        assert testMapString.contains( "( 0 0 0 ) pasture ( 1 4 6 )");
        assert testMapString.contains( "( 0 1 -1 ) pasture ( 1 2 3 4 5 6 )");
        assert testMapString.contains( "( -1 1 0 ) woods ( 1 4 6 )");
        assert testMapString.contains( "( -1 0 1 ) rock ");
        assert testMapString.contains( "( 0 0 1 ) desert ");
        assert testMapString.contains( "( 1 0 0 ) sea ( 1 4 6 )");
        assert testMapString.contains( "( 1 0 -1 ) mountains ( 1 2 3 4 5 6 )");
    }
}
