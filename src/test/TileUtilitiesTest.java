import model.map.CubeVector;
import model.map.tile.*;
import model.utilities.TileUtilities;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

// Test 'main.model.utilites.TileUtilities'
public class TileUtilitiesTest {

    // Locations
    CubeVector locationA;
    CubeVector locationB;

    // Zone content
    Zone zone1;
    Zone zone2;
    Zone zone3;
    Zone zone4;
    Zone zone5;
    Zone zone6;
    Zone[] zones;

    // Test tiles
    WoodsTile tileA;
    DesertTile tileB;

    // Create TileUtilities tester
    TileUtilities utils = new TileUtilities();

    // Initialize
    @Before
    public void setup() {

        locationA = new CubeVector();                   // Default COG
        locationB = new CubeVector(0, 1, -1);    // Adjacent tile to the north

        zone1 = new Zone(false, false);
        zone2 = new Zone(true, false);
        zone3 = new Zone(false, false);
        zone4 = new Zone(true, false);
        zone5 = new Zone(false, false);
        zone6 = new Zone(true, false);

        zones = new Zone[]{ zone1, zone2, zone3,
                zone4, zone5, zone6 };

        tileA = new WoodsTile(locationA, zones);
        tileB = new DesertTile(locationB, zones);
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
    @Test
    public void testCenterOfGravityCalculation() {

        // Setup list of tiles
        ArrayList<Tile> tiles = new ArrayList<>();

        // Add two tiles
        tiles.add(tileA);
        tiles.add(tileB);

        // Test cog
        CubeVector cog = utils.calculateCenterOfGravity(tiles);

        // COG of adjacent tiles should be one of the tile locations
        assert cog.getXCoord() == 0;
        assert cog.getYCoord() == 0;
        assert cog.getZCoord() == 0;

        // Add third tile directly to north of the northmost tile. Tiles are now in a straight line from 0, 0, 0 north
        PastureTile tileC = new PastureTile(new CubeVector(0, 2, -2), zones);
        tiles.add(tileC);
        cog = utils.calculateCenterOfGravity(tiles);

        assert cog.getXCoord() == 0;
        assert cog.getYCoord() == 1;
        assert cog.getZCoord() == -1;

        // Move positions to triangle around 0, 0, 0
        tileA.setLocation(new CubeVector(-1, 0, 1));
        tileB.setLocation(new CubeVector(0, 1, -1));
        tileC.setLocation(new CubeVector(1, -1, 0));
        cog = utils.calculateCenterOfGravity(tiles);

        // Center should now be 0, 0, 0
        assert cog.getXCoord() == 0;
        assert cog.getYCoord() == 0;
        assert cog.getZCoord()== 0;

        // Arrange tiles in rect pattern w/ center 0, 0, 0
        MountainsTile tileD = new MountainsTile(new CubeVector(-3, 2, 1), zones);
        tiles.add(tileD);
        tileA.setLocation(new CubeVector(-3, 1, 2));
        tileB.setLocation(new CubeVector(3, -1, -2));
        tileC.setLocation(new CubeVector(3, -2, -1));
        cog = utils.calculateCenterOfGravity(tiles);

        // Center should still be 0, 0, 0
        assert cog.getXCoord() == 0;
        assert cog.getYCoord() == 0;
        assert cog.getZCoord()== 0;

        // Move COG off center
        tileA.setLocation(new CubeVector(-3, 3, 0));
        tileB.setLocation(new CubeVector(-3, 2, 1));
        tileC.setLocation(new CubeVector(3, 0, -3));
        tileD.setLocation(new CubeVector(3, -1, -2));
        cog = utils.calculateCenterOfGravity(tiles);

        // Center should now be 0, 1, -1
        assert cog.getXCoord() == 0;
        assert cog.getYCoord() == 1;
        assert cog.getZCoord()== -1;

        // Move COG off center again
        tileC.setLocation(new CubeVector(-1, 2, -1));
        tileD.setLocation(new CubeVector(-1, 1, 0));
        cog = utils.calculateCenterOfGravity(tiles);

        // Center should now be at -2, 2, 0
        assert cog.getXCoord() == -2;
        assert cog.getYCoord() == 2;
        assert cog.getZCoord() == 0;

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
