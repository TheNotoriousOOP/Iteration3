package controller;

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
public class MapEditorController {

    private final String[] terrainTypesArray = {"Woods", "Pasture", "Rock", "Mountains", "Desert", "Sea"};
    private final String[] riverConnectorNumbersArray = {"0", "1" , "2 sharp", "2 wide", "3"};

    private final ArrayList<String> terrainTypesList = new ArrayList<>(Arrays.asList(terrainTypesArray));
    private final ArrayList<String> riverConnectorNumbersList = new ArrayList<>(Arrays.asList(riverConnectorNumbersArray));

    private Iterator<String> terrainIterator;
    private Iterator<String> riverIterator;

    private KeyEventController keyEventController;

    public MapEditorController(){
        terrainIterator = terrainTypesList.iterator();
        riverIterator = riverConnectorNumbersList.iterator();

    }

    //cycles through terrain types with an iterator, sends the string to the correct JLabel in TileSelectionPanel
    public void cycleTerrain(){
        if (terrainIterator.hasNext()){
            //send terrain string to view (terrainIterator.next())
        }else{
            terrainIterator = terrainTypesList.iterator();   //reset iterator to element 0
        }
    }

    //cycles through river count with an iterator, sends the string to the correct JLabel in TileSelectionPanel
    public void cycleRiverCount(){
        if (riverIterator.hasNext()){
            //send river string to view (riverIterator.next())
        }else{
            riverIterator = riverConnectorNumbersList.iterator();   //reset iterator to element 0
        }
    }

    public void cycleOrientation(){

    }

    public void setKeyEventController(KeyEventController keyEventController){
        this.keyEventController = keyEventController;
    }

    //TODO add remaining methods from design doc
}
