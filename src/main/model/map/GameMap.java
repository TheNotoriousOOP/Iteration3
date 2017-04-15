package model.map;

import model.map.tile.Tile;
import model.map.tile.nodeRepresentation.nodes.child.ChildNode;
import model.phase.observers.PhaseObserver;
import model.utilities.ConversionUtilities;
import model.utilities.TileUtilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by TheNotoriousOOP on 4/14/2017.
 * Class Description:
 * Responsibilities:
 */
public class GameMap implements MapInterface, PhaseObserver {
    private Map<CubeVector, Tile> map;
    private TileUtilities tileUtilities;
    private final int maxDistance = 21;

    public GameMap() {
        this.map = new HashMap<CubeVector, Tile>();
        this.tileUtilities = new TileUtilities();
    }

    @Override
    public Tile getTile(CubeVector pos) {
        return null;
    }

    public void add(CubeVector position, Tile t){
        //do not allow placement of a tile if one already exists at that location
        //the addition of the very first tile is handled differently than other add operations
        if (map.isEmpty()){
            map.put(position, t);
            System.out.println("class GAMEMAP: tile to add " + t.toString());
        } else{
            //place a tile if its neighboring nodes are all matching correctly
            if (tileUtilities.canTileBePlaced(t, getNeighboringTiles(t))){
                System.out.println("class GAMEMAP: tile can be placed");
                map.put(position, t);
                //update node connectivity on Tile t and neighbors
                updateNodeConnectivity(t);
            }
        }
    }


    @Override
    public void load(String[] data) {
        ParseMap parser = new ParseMap(data);

        Iterator parserItr = parser.getIterator();
        while (parserItr.hasNext()) {
            Tile tileToLoad = (Tile) parserItr.next();
            System.out.println("class GAMEMAP: tile to be added: " + tileToLoad.toString());
            add(tileToLoad.getLocation(), tileToLoad);
            map.put(tileToLoad.getLocation(), tileToLoad);
        }

        //update the connectivity of all nodes
        for (Tile t : map.values()){
            updateNodeConnectivity(t);
        }
    }

    public void resetMap(){
        this.map.clear();
    }

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

            col = ConversionUtilities.convertFromCubeToColumn(entry.getKey());
            row = ConversionUtilities.convertFromCubeToRow(entry.getKey());


            System.out.println("class EDITORMAP: checking new method "  + entry.getKey().getXCoord() + ", " + entry.getKey().getYCoord() + ", " + entry.getKey().getZCoord() + " to " + col + ", " + row );


            // Use tile of the entry for the Tile @ the index location
            grid[col][row] = entry.getValue();
        }

        // Return grid
        return grid;
    }

    private void updateNodeConnectivity(Tile t){
        for (Tile neighborToT : getNeighboringTiles(t)){
            //update node connections
            //get ref to the map of children nodes from each tile's side
            HashMap<Integer, ChildNode> commonNodesFromTileToPlace = tileUtilities.getSharedChildrenOnSideA(t, neighborToT);
            HashMap<Integer, ChildNode> commonNodesFromNeighbor = tileUtilities.getSharedChildrenOnSideA(neighborToT, t);

            //set connection of nodes with position -1 <-> 1
            commonNodesFromNeighbor.get(-1).setNeighboringTileChild(commonNodesFromTileToPlace.get(1));
            commonNodesFromTileToPlace.get(-1).setNeighboringTileChild(commonNodesFromNeighbor.get(1));

            //set connection of nodes with position 0 <-> 0
            commonNodesFromNeighbor.get(0).setNeighboringTileChild(commonNodesFromTileToPlace.get(0));
            commonNodesFromTileToPlace.get(0).setNeighboringTileChild(commonNodesFromNeighbor.get(0));

            //set connection of nodes with position 1 <-> -1
            commonNodesFromNeighbor.get(1).setNeighboringTileChild(commonNodesFromTileToPlace.get(-1));
            commonNodesFromTileToPlace.get(1).setNeighboringTileChild(commonNodesFromNeighbor.get(-1));
        }
    }

    @Override
    public ArrayList<Tile> getNeighboringTiles(Tile t) {
        ArrayList<Tile> neighbors = new ArrayList<>();
        CubeVector north = new CubeVector(t.getLocation().getXCoord(), t.getLocation().getYCoord()+1, t.getLocation().getZCoord()-1);
        CubeVector northeast = new CubeVector(t.getLocation().getXCoord()+1, t.getLocation().getYCoord(), t.getLocation().getZCoord()-1);
        CubeVector southeast = new CubeVector(t.getLocation().getXCoord()+1, t.getLocation().getYCoord()-1, t.getLocation().getZCoord());
        CubeVector south = new CubeVector(t.getLocation().getXCoord(), t.getLocation().getYCoord()-1, t.getLocation().getZCoord()+1);
        CubeVector southwest = new CubeVector(t.getLocation().getXCoord()-1, t.getLocation().getYCoord(), t.getLocation().getZCoord()+1);
        CubeVector northwest = new CubeVector(t.getLocation().getXCoord()-1, t.getLocation().getYCoord()+1, t.getLocation().getZCoord());

        //ensure a tile exists in the proposed location before adding it to the list of neighboring tiles
        if(vectorIsInMap(north))
            neighbors.add(getTile(north));
        if(vectorIsInMap(northeast))
            neighbors.add(getTile(northeast));
        if(vectorIsInMap(southeast))
            neighbors.add(getTile(southeast));
        if(vectorIsInMap(south))
            neighbors.add(getTile(south));
        if(vectorIsInMap(southwest))
            neighbors.add(getTile(southwest));
        if(vectorIsInMap(northwest))
            neighbors.add(getTile(northwest));

        return neighbors;
    }

    private boolean vectorIsInMap(CubeVector location) {
        return map.containsKey(location);
    }

    // Notify trade phase started
    public void onTradePhaseStart() {
        // Todo: implement
    }

    // Notify production phase started
    public void onProductionPhaseStart() {
        // Todo: implement
    }

    // Notify build phase started
    public void onBuildPhaseStart() {
        // Todo: implement
    }

    // Notify movement phase started
    public void onMovementPhaseStart() {
        // Todo: implement
    }

    // Notify wonder phase started
    public void onWonderPhaseStart() {
        // Todo: implement
    }

}