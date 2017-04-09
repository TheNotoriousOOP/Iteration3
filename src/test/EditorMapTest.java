import model.map.CubeVector;
import model.map.editor.EditorMap;
import model.map.tile.*;
import model.map.tile.nodeRepresentation.*;
import model.utilities.FileUtilities;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Vector;

// Test the 'game.model.map.editor.EditorMap' class
public class EditorMapTest {

    private String[] lines = FileUtilities.loadMap("res/mapfiles/TestMap.txt");
    private EditorMap testMap;

    @Before
    public void setup() {
        testMap = new EditorMap();
    }

    // Test grid to map conversion
    @Test
    public void testMapToGridConversion() {

        // Load sample test map
        testMap.load(lines);

//          // Get tiles array
//        Tile[][] tiles = testMap.convertMapToGrid();
//
//        // Test if 0, 0, 0 tile is set at [10][10]
//        // Todo: Test more tiles
//        assert tiles[10][10].getLocation().getXCoord() == 0;
//        assert tiles[10][10].getLocation().getYCoord() == 0;
//        assert tiles[10][10].getLocation().getZCoord() == 0;

    }

    // Test map loading function
    @Test
    public void testLoad() {
        testMap.load(lines);
        assert lines.length > 0;
        assert testMap.hasThisManyTiles(lines.length -1);
    }

    // Test map saving function
    @Test
    public void testSave() {

        CubeVector vec1 = new CubeVector(0,0,0);
        CubeVector vec2 = new CubeVector(0,1,-1);
        CubeVector vec3 = new CubeVector(-1,1,0);
        CubeVector vec4 = new CubeVector(-1,0,1);
        CubeVector vec5 = new CubeVector(0,-1,1);
        CubeVector vec6 = new CubeVector(1,-1,0);
        CubeVector vec7 = new CubeVector(1,0,-1);

        testMap.addTile(new WoodsTile(vec1, new NoRiverSetup(0)));
        testMap.addTile(new PastureTile(vec2, new NoRiverSetup(0)));
        testMap.addTile(new WoodsTile(vec3, new NoRiverSetup(0)));
        testMap.addTile(new RockTile(vec4, new NoRiverSetup(0)));
        testMap.addTile(new DesertTile(vec5, new NoRiverSetup(0)));
        testMap.addTile(new SeaTile(vec6, new NoRiverSetup(0)));
        testMap.addTile(new MountainsTile(vec7, new NoRiverSetup(0)));

        String[] testMapLines = testMap.save();

        FileUtilities.saveMap("TestMap", testMapLines);

        //Map has been saved to TestMap.txt, so now we load it in

        String testMapString = "";
        String[] lines = FileUtilities.loadMap("res/mapfiles/TestMap.txt");

        //and convert the result of load map from array to one string for easy containment checks
        for(int i=0; i < lines.length; i++) {
            testMapString += lines[i] + "\n";
        }

        //Test first line of file read in
        assert lines[0].equals("7");
        //Test length of array read in
        assert lines.length == 8;
        //Make sure string formed from read-in file contains the strings corresponding to tiles above
        assert testMapString.contains( "( 0 0 0 ) woods ");
        assert testMapString.contains( "( 0 1 -1 ) pasture ");
        assert testMapString.contains( "( -1 1 0 ) woods ");
        assert testMapString.contains( "( -1 0 1 ) rock ");
        assert testMapString.contains( "( 0 -1 1 ) desert ");
        assert testMapString.contains( "( 1 -1 0 ) sea ");
        assert testMapString.contains( "( 1 0 -1 ) mountains ");

    }

    // Test map saving function where we will adjust the center of gravity
    @Test
    public void testOffsetSave() {

        CubeVector vec1 = new CubeVector(1,0,-1);
        CubeVector vec2 = new CubeVector(0,0,0);
        CubeVector vec3 = new CubeVector(-1,0,1);

        testMap.addTile(new WoodsTile(vec1, new TriRiverSetup(60)));
        testMap.addTile(new PastureTile(vec2, new SourceRiverSetup(180)));
        testMap.addTile(new WoodsTile(vec3, new LongCurvedRiverSetup(0)));

        String[] testMapLines = testMap.save();

        FileUtilities.saveMap("TestMapOffset", testMapLines);

        //Map has been saved to TestMap.txt, so now we load it in

        String[] lines = FileUtilities.loadMap("res/mapfiles/TestMapOffset.txt");

        Vector<String> mapFile = new Vector<String>();
        //and convert the result of load map from array to one string for easy containment checks
        for(int i=0; i < lines.length; i++) {
            mapFile.add(lines[i]);
        }

        // Test first line of file read in
        assertEquals("3", mapFile.get(0));
        // Test length of array read in
        assertEquals(4, mapFile.size());
        // Make sure string formed from read-in file contains the strings corresponding to tiles above
        assertEquals( "( 0 0 0 ) pasture ( 4 )", mapFile.get(1));
        assertEquals( "( -1 0 1 ) woods ( 1 3 )", mapFile.get(2));
        assertEquals( "( 1 0 -1 ) woods ( 2 4 6 )", mapFile.get(3));

    }

    @Test
    public void testConnectivity() {

        testMap.addTile(new WoodsTile(new CubeVector(0,0,0), new NoRiverSetup(0)));
        testMap.addTile(new WoodsTile(new CubeVector(0,1,-1), new NoRiverSetup(0)));
        testMap.addTile(new WoodsTile(new CubeVector(0,2,-2), new NoRiverSetup(0)));
        testMap.addTile(new WoodsTile(new CubeVector(0,3,-3), new NoRiverSetup(0)));
        testMap.addTile(new WoodsTile(new CubeVector(0,4,-4), new NoRiverSetup(0)));
        testMap.addTile(new WoodsTile(new CubeVector(-1,4,-3), new NoRiverSetup(0)));

        assert testMap.verifyConnectivity();

        testMap.addTile(new WoodsTile(new CubeVector(6,-3,-3), new NoRiverSetup(0)));

        assert !testMap.verifyConnectivity();
    }

}
