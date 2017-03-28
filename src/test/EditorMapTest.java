import model.map.CubeVector;
import model.map.editor.EditorMap;
import model.map.tile.*;
import model.utilities.FileUtilities;
import org.junit.Before;
import org.junit.Test;

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

        // Get tiles array
        Tile[][] tiles = testMap.convertMapToGrid();

        // Test if 0, 0, 0 tile is set at [10][10]
        // Todo: Test more tiles
        assert tiles[10][10].getLocation().getXCoord() == 0;
        assert tiles[10][10].getLocation().getYCoord() == 0;
        assert tiles[10][10].getLocation().getZCoord() == 0;

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
        CubeVector vec5 = new CubeVector(0,-1,1);
        CubeVector vec6 = new CubeVector(1,-1,0);
        CubeVector vec7 = new CubeVector(1,0,-1);

        testMap.addTile(new WoodsTile(vec1, zones1));
        testMap.addTile(new PastureTile(vec2, zones3));
        testMap.addTile(new WoodsTile(vec3, zones1));
        testMap.addTile(new RockTile(vec4, zones2));
        testMap.addTile(new DesertTile(vec5, zones2));
        testMap.addTile(new SeaTile(vec6, zones1));
        testMap.addTile(new MountainsTile(vec7, zones3));

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
        assert testMapString.contains( "( 0 0 0 ) woods ( 1 4 6 )");
        assert testMapString.contains( "( 0 1 -1 ) pasture ( 1 2 3 4 5 6 )");
        assert testMapString.contains( "( -1 1 0 ) woods ( 1 4 6 )");
        assert testMapString.contains( "( -1 0 1 ) rock ");
        assert testMapString.contains( "( 0 -1 1 ) desert ");
        assert testMapString.contains( "( 1 -1 0 ) sea ( 1 4 6 )");
        assert testMapString.contains( "( 1 0 -1 ) mountains ( 1 2 3 4 5 6 )");

    }

    // Test map saving function where we will adjust the center of gravity
    @Test
    public void testOffsetSave() {

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

        CubeVector vec1 = new CubeVector(-3,1,2);
        CubeVector vec2 = new CubeVector(-2,2,0);
        CubeVector vec3 = new CubeVector(-1,0,1);

        testMap.addTile(new WoodsTile(vec1, zones1));
        testMap.addTile(new PastureTile(vec2, zones3));
        testMap.addTile(new WoodsTile(vec3, zones1));

        String[] testMapLines = testMap.save();

        FileUtilities.saveMap("TestMapOffset", testMapLines);

        //Map has been saved to TestMap.txt, so now we load it in

        String testMapString = "";
        String[] lines = FileUtilities.loadMap("res/mapfiles/TestMapOffset.txt");

        //and convert the result of load map from array to one string for easy containment checks
        for(int i=0; i < lines.length; i++) {
            testMapString += lines[i] + "\n";
        }

        // Test first line of file read in
        assert lines[0].equals("3");
        // Test length of array read in
        assert lines.length == 4;
        // Make sure string formed from read-in file contains the strings corresponding to tiles above
        assert testMapString.contains( "( -1 0 1 ) woods ( 1 4 6 )");
        assert testMapString.contains( "( 0 1 -1 ) pasture ( 1 2 3 4 5 6 )");
        assert testMapString.contains( "( 1 -1 0 ) woods ( 1 4 6 )");

    }

    @Test
    public void testConnectivity() {
        Zone[] genericZones = new Zone[6];
        genericZones[0] = new Zone(false, true);
        genericZones[1] = new Zone(false, true);
        genericZones[2] = new Zone(false, true);
        genericZones[3] = new Zone(false, true);
        genericZones[4] = new Zone(false, true);
        genericZones[5] = new Zone(false, true);

        testMap.addTile(new WoodsTile(new CubeVector(0,0,0), genericZones));
        testMap.addTile(new WoodsTile(new CubeVector(0,1,-1), genericZones));
        testMap.addTile(new WoodsTile(new CubeVector(0,2,-2), genericZones));
        testMap.addTile(new WoodsTile(new CubeVector(0,3,-3), genericZones));
        testMap.addTile(new WoodsTile(new CubeVector(0,4,-4), genericZones));
        testMap.addTile(new WoodsTile(new CubeVector(-1,4,-3), genericZones));

        assert testMap.verifyConnectivity();

        testMap.addTile(new WoodsTile(new CubeVector(6,-3,-3), genericZones));

        assert !testMap.verifyConnectivity();
    }

}
