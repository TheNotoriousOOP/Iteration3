package controller;

import view.MapEditorPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: controls the cycling of tile types in map editor view
 * Responsibilities:
 *  take user input for the map editor to cycle tile types
 *  send user input to ViewModelAdapter to communicate with model
 */
public class MapEditorController implements KeyListener {

    private final String[] terrainTypesArray = {"Woods", "Pasture", "Rock", "Mountains", "Desert", "Sea"};
    private final String[] riverConnectorNumbersArray = {"0", "1" , "2 sharp", "2 wide", "3"};
    private String currentTerrainType;

    private final ArrayList<String> terrainTypesList = new ArrayList<>(Arrays.asList(terrainTypesArray));
    private final ArrayList<String> riverConnectorNumbersList = new ArrayList<>(Arrays.asList(riverConnectorNumbersArray));

    private Iterator<String> terrainIterator;
    private Iterator<String> riverIterator;

    private MapEditorPanel mapEditorPanelView;

    public MapEditorController(MapEditorPanel mapEditorPanelView){
        terrainIterator = terrainTypesList.iterator();
        riverIterator = riverConnectorNumbersList.iterator();
        this.mapEditorPanelView = mapEditorPanelView;

    }

    //cycles through terrain types with an iterator, sends the string to the correct JLabel in TileSelectionPanel
    public void cycleTerrain(){
        if (!terrainIterator.hasNext()) {
            terrainIterator = terrainTypesList.iterator();   //reset iterator to element 0
        }

        riverIterator = riverConnectorNumbersList.iterator();   //reset river iterator to start at 0 every time a new terrain is cycled to
        currentTerrainType = terrainIterator.next();
        mapEditorPanelView.setTerrainInTileSelectionText(currentTerrainType);   //set JLabel in View for terrain
    }

    //cycles through river count with an iterator, sends the string to the correct JLabel in TileSelectionPanel
    public void cycleRiverCount(){
        if (!riverIterator.hasNext()){
            riverIterator = riverConnectorNumbersList.iterator();   //reset iterator to element 0
        }

        if(!currentTerrainType.equals("Sea")){  //only set river count if non-Sea terrain
            mapEditorPanelView.setRiverConnectorsInTileSelectionText(riverIterator.next()); //set JLabel in View for river connectors
        } else{
            mapEditorPanelView.setRiverConnectorsInTileSelectionText("");   //a Sea tile has no rivers
        }
    }

    public void cycleOrientation(){

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key pressed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("key pressed");
    }
}

