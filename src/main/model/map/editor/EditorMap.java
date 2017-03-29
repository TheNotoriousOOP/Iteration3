package model.map.editor;

import model.map.CubeVector;
import model.map.MapInterface;
import model.map.ParseMap;
import model.map.tile.Tile;
import model.map.tile.Zone;
import model.utilities.TileUtilities;
import view.renderer.MapRenderer;

import java.util.*;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Defines the game map as a grid of Tiles
 * Responsibilities: Storing, Accessing, and Mutating map grid of Tiles
 * Implementation: Stored as Hashmap
 */
public class EditorMap implements MapInterface {
    private final int maxDistance = 21; //no tile can be placed more than 21 away from the others
    private Map<CubeVector, Tile> map;
    private TileUtilities tileUtilities;

    public EditorMap() {

        this.map = new HashMap<CubeVector, Tile>();
        this.tileUtilities = new TileUtilities();
    }

    @Override
    public Tile getTile(CubeVector pos) {
        return map.get(pos);
    }

    @Override
    public Tile getNeighborTile(CubeVector pos, Zone bordering) {
        //May not need this anymore
        return null;
    }

    @Override
    public ArrayList<Tile> getNeighboringTiles(Tile t){
        ArrayList<Tile> neighbors = new ArrayList<Tile>();
        CubeVector north = new CubeVector(t.getLocation().getXCoord(), t.getLocation().getYCoord()+1, t.getLocation().getZCoord()-1);
        CubeVector northeast = new CubeVector(t.getLocation().getXCoord()+1, t.getLocation().getYCoord(), t.getLocation().getZCoord()-1);
        CubeVector southeast = new CubeVector(t.getLocation().getXCoord()+1, t.getLocation().getYCoord()-1, t.getLocation().getZCoord());
        CubeVector south = new CubeVector(t.getLocation().getXCoord(), t.getLocation().getYCoord()-1, t.getLocation().getZCoord()+1);
        CubeVector southwest = new CubeVector(t.getLocation().getXCoord()-1, t.getLocation().getYCoord(), t.getLocation().getZCoord()+1);
        CubeVector northwest = new CubeVector(t.getLocation().getXCoord()-1, t.getLocation().getYCoord()+1, t.getLocation().getZCoord());


        //ensure a tile exists in the proposed location before adding it to the list of neighboring tiles

        if(vectorIsInMap(north)){
            neighbors.add(getTile(north));
        }
        if(vectorIsInMap(northeast)){
            neighbors.add(getTile(northeast));
        }
        if(vectorIsInMap(southeast)){
            neighbors.add(getTile(southeast));
        }
        if(vectorIsInMap(south)){
            neighbors.add(getTile(south));
        }
        if(vectorIsInMap(southwest)){
            neighbors.add(getTile(southwest));
        }
        if(vectorIsInMap(northwest)){
            neighbors.add(getTile(northwest));
        }


        return neighbors;

    }

    //checks if a vector location exists in the map
    private boolean vectorIsInMap(CubeVector location) {
        return map.containsKey(location);
    }

    @Override
    public void load(String[] data) {
        ParseMap parser = new ParseMap(data);

        Iterator parserItr = parser.getIterator();
        while (parserItr.hasNext()) {
            Tile tileToLoad = (Tile) parserItr.next();
            System.out.println("class EDITORMAP: tile to be added: " + tileToLoad.toString());
            map.put(tileToLoad.getLocation(), tileToLoad);
        }

    }

    public void add(CubeVector pos, Tile t) {
        if(!isWithinMaxDistance(t)) {
            System.out.printf("class EDITORMAP: Tile Out of Bounds");
            return;
        }
        if(vectorIsInMap(pos))
            return;
        if(map.isEmpty()) {
            map.put(pos, t);
            System.out.println("class EDITORMAP: tile to add " + t.toString());
        }
        //check if the tile can be placed
        else {
            if (tileUtilities.canTileBePlaced(t, getNeighboringTiles(t))) {
                System.out.println("class EDITORMAP: tile to add " + t.toString());
                map.put(pos, t);    //add tile
                //update all influenced zones to reflect a new connection
                for (Tile neighborToT : getNeighboringTiles(t)) {
                    Zone[] sharedZones = tileUtilities.getSharedZones(t, neighborToT);
                    setMergedInWateredZones(sharedZones);
                }

            }
        }
    }

    //updates all watered zones to be merged if adding to the map is successful
    private void setMergedInWateredZones(Zone[] sharedZones) {
        for (Zone zone : sharedZones){
            if (zone.isHasWater()){
                zone.setMerged(true);
            }
        }
    }

    public void remove(CubeVector pos) {
        if (vectorIsInMap(pos)){
            Tile t = getTile(pos);
            for(Tile neighborTile : getNeighboringTiles(t)){
                Zone[] sharedZones = tileUtilities.getSharedZones(t, neighborTile);
                resetMergedInWaterZones(sharedZones);
            }
            map.remove(pos);
        }
    }

    private void resetMergedInWaterZones(Zone[] sharedZones){
        for (Zone zone : sharedZones){
            zone.resetIsMerged();
        }
    }

    // Convert the map to strings for saving w/ FileUtils
    public String[] save() {

        // Tiles Count + Number of Tiles
        String[] mapString = new String[map.size() + 1];

        // Write Tile Count
        mapString[0] = String.valueOf(map.size());

        // Get COG
        CubeVector cog = calculateCenterOfGravity();
        // Find the offset of the map's COG from the (0, 0, 0) coord
        CubeVector offset = new CubeVector().subtractCubeVector(cog);


        // Setup iterator & index from past the Tile count
        Iterator tileItr = map.values().iterator();
        int lineIndex = 1;

        // Loop through and convert each tile to string
        while (tileItr.hasNext()) {

            Tile curr = (Tile) tileItr.next();

            // Compensate for origin by using the offset vector
            // and adjusting each tile's location based on that
            curr.setAdjustedLocation(offset);

            // Using the adjusted coords, map the tile to the file
            mapString[lineIndex] = curr.toString();

            // Target next index after this
            lineIndex++;

        }

        // Return map
        return mapString;
    }

    //compare distance between tile t with every existing tile
    private boolean isWithinMaxDistance(Tile t){
        boolean distanceFlag;

        for (Tile existingTile : map.values()){
            distanceFlag = (tileUtilities.calculateDistance(t, existingTile) <= maxDistance);
            if (!distanceFlag){
                return false;
            }
        }

        return true;
    }

    /* Given list of tiles, calculate center of gravity
     * Calculations made assuming flattop hex cube coords
     *  Formula: Add up all x, y, and z values
     *              Divide the Sum(X), Sum(Y), and Sum(Z) values by # of tiles
     *              Values are now COG location vector
     */
    public CubeVector calculateCenterOfGravity() {

        Set<CubeVector> tileVectors = map.keySet();

        // Sum values
        int centerX = 0, centerY = 0, centerZ = 0;

        // Summation of each coord for all tiles
        for (CubeVector v: tileVectors) {
            centerX += v.getXCoord();
            centerY += v.getYCoord();
            centerZ += v.getZCoord();
        }

        // Divide by number of tiles
        centerX /= tileVectors.size();
        centerY /= tileVectors.size();
        centerZ /= tileVectors.size();

        return new CubeVector(centerX, centerY, centerZ);
    }

    /*
     * Purpose: provide the view a way to iterate through the map
     * Called via controller, used by GUI
     * Logic:
     *  iterate through entire keyset of map
     *  convert CubeVector into x,y pair (http://www.redblobgames.com/grids/hexagons/)
     *  place corresponding map Tile into the correct indexed grid variable
     */
    public Tile[][] convertMapToGrid() {

        // Setup new grid
        Tile[][] grid = new Tile[maxDistance][maxDistance];

        // Initialize empty grid
        for (int i = 0; i < maxDistance; i++)
            for (int j = 0; j < maxDistance; j++)
                    grid[i][j] = null;

        // For each entry of the map, get the key, value pair
        for ( Map.Entry<CubeVector, Tile> entry : this.map.entrySet()) {

            //TODO change to make use of cubeVector's method to convert to Point internally
            // Use x and y values of vector for indicies
            int col = entry.getKey().getXCoord();
            int row = entry.getKey().getZCoord() - (entry.getKey().getYCoord());
            row = Math.floorDiv(row, 2);

            // Offset the col and row for maxDistance
            col += (maxDistance / 2);
            row += (maxDistance / 2);



            System.out.println("class EDITORMAP: converted "  + entry.getKey().getXCoord() + ", " + entry.getKey().getYCoord() + ", " + entry.getKey().getZCoord() + " to " + col + ", " + row );

            // Use tile of the entry for the Tile @ the index location
            grid[col][row] = entry.getValue();
        }

        // Return grid
        return grid;
    }

    //Visitor for rendering
    public void render(MapRenderer r) {
        for (Tile t : map.values()) {
            t.render(r);
        }
    }

    public void resetMap() {
        this.map.clear();
    }

     //TODO implement for phase 2
    //checks if all tiles in the collection are accessible from any point
    //public boolean isConnected(){
    //   return true;
    //}


    //TODO Only for testing, remove after editor map loading works
    public boolean hasThisManyTiles(int numTiles) {
        return (map.size() == numTiles);
    }

    //TODO delete this after saving is tested
    public void addTile(Tile tile) {
        map.put(tile.getLocation(), tile);
    }

    public boolean verifyConnectivity() {
        List<Tile> closedBody = new LinkedList<Tile>();
        Stack<Tile> openBody = new Stack<Tile>();
        Tile first = map.entrySet().iterator().next().getValue();
        openBody.add(first);
        while(!openBody.isEmpty()) {
            Tile t = openBody.pop();
            closedBody.add(t);
            List<Tile> nt = getNeighboringTiles(t);
            for(Tile tt : nt) {
                if(!closedBody.contains(tt) && !openBody.contains(tt))
                    openBody.add(tt);
            }
        }
        return closedBody.size() == map.size();
    }



}
