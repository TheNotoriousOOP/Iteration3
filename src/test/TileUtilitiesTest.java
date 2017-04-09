import model.map.CubeVector;
import model.map.editor.EditorMap;
import model.map.tile.*;
import model.map.tile.nodeRepresentation.NoRiverSetup;
import model.utilities.TileUtilities;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

// Test 'main.model.utilites.TileUtilities'
public class TileUtilitiesTest {

    // Locations
    CubeVector locationA;
    CubeVector locationB;

    // Test tiles
    WoodsTile tileA;
    DesertTile tileB;
    PastureTile tileC;

    // Create TileUtilities tester
    TileUtilities utils = new TileUtilities();

    // Initialize
    @Before
    public void setup() {

        locationA = new CubeVector();                   // Default COG
        locationB = new CubeVector(0, 1, -1);    // Adjacent tile to the north

        tileA = new WoodsTile(locationA, new NoRiverSetup(0));
        tileB = new DesertTile(locationB, new NoRiverSetup(0));
        tileC = new PastureTile(new CubeVector(0, 2, -2), new NoRiverSetup(0));
    }

    // Test tile distance calculation
    @Test
    public void testDistanceCalculation() {

        // Get distance
        double distance = utils.calculateDistance(tileA, tileB);

        // Result should be 1
        assert distance == 1;

        // Set tile to location two spots to the north
        tileB.setLocation(new CubeVector(0, 2, -2));

        // Get distance
        distance = utils.calculateDistance(tileA, tileB);

        // Result should be 2
        assert distance == 2;

    }

    // Test center of gravity calculation
    // TODO move out of this test suite and update to test correctly; setting location here is not updating Tile references in map
    @Test
    public void testCenterOfGravityCalculation() {
//
        //// Set up map
        //EditorMap editorMap = new EditorMap();
//
        //// Add two tiles
        //editorMap.addTile(tileA);
        //editorMap.addTile(tileB);
//
        //// Test cog
        //CubeVector cog = editorMap.calculateCenterOfGravity();
//
        //// COG of adjacent tiles should be one of the tile locations
        //assert cog.getXCoord() == 0;
        //assert cog.getYCoord() == 0;
        //assert cog.getZCoord() == 0;
//
        //// Add third tile directly to north of the northmost tile. Tiles are now in a straight line from 0, 0, 0 north
        //editorMap.addTile(tileC);
        //cog = editorMap.calculateCenterOfGravity();
//
        //assert cog.getXCoord() == 0;
        //assert cog.getYCoord() == 1;
        //assert cog.getZCoord() == -1;
//
        //// Move positions to triangle around 0, 0, 0
        //tileA.setLocation(new CubeVector(-1, 0, 1));
        //tileB.setLocation(new CubeVector(0, 1, -1));
        //tileC.setLocation(new CubeVector(1, -1, 0));
        //cog = editorMap.calculateCenterOfGravity();
//
        //// Center should now be 0, 0, 0
        //assert cog.getXCoord() == 0;
        //assert cog.getYCoord() == 0;
        //assert cog.getZCoord()== 0;
//
        //// Arrange tiles in rect pattern w/ center 0, 0, 0
        //MountainsTile tileD = new MountainsTile(new CubeVector(-3, 2, 1), zones);
        //editorMap.addTile(tileD);
        //tileA.setLocation(new CubeVector(-3, 1, 2));
        //tileB.setLocation(new CubeVector(3, -1, -2));
        //tileC.setLocation(new CubeVector(3, -2, -1));
        //cog = editorMap.calculateCenterOfGravity();
//
        //// Center should still be 0, 0, 0
        //assert cog.getXCoord() == 0;
        //assert cog.getYCoord() == 0;
        //assert cog.getZCoord()== 0;
//
        //// Move COG off center
        //tileA.setLocation(new CubeVector(-3, 3, 0));
        //tileB.setLocation(new CubeVector(-3, 2, 1));
        //tileC.setLocation(new CubeVector(3, 0, -3));
        //tileD.setLocation(new CubeVector(3, -1, -2));
        //cog = editorMap.calculateCenterOfGravity();
//
        //// Center should now be 0, 1, -1
        //assert cog.getXCoord() == 0;
        //assert cog.getYCoord() == 1;
        //assert cog.getZCoord()== -1;
//
        // Move COG off center again
        //tileC.setLocation(new CubeVector(-1, 2, -1));
        //tileD.setLocation(new CubeVector(-1, 1, 0));
        //cog = editorMap.calculateCenterOfGravity();
//
        //// Center should now be at -2, 2, 0
        //assert cog.getXCoord() == -2;
        //assert cog.getYCoord() == 2;
        //assert cog.getZCoord() == 0;
//
    }

    // Test tile adjacency
    @Test
    public void testTileAdjacency() {

        // Default should be 1
        assert utils.checkAdjacency(tileA, tileB);

        // Set tiles two spaces apart
        tileB.setLocation(new CubeVector(0, 2, -2));
        assert !utils.checkAdjacency(tileA, tileB);

        // Move both tiles but keep them adjacent
        tileA.setLocation(new CubeVector(-2, 1, 1));
        tileB.setLocation(new CubeVector(-1, 0, 1));
        assert utils.checkAdjacency(tileA, tileB);

    }

}
