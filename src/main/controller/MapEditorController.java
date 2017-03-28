package controller;

import model.map.tile.SeaTile;
import model.map.tile.Tile;
import model.map.tile.Zone;
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
    private final String[] riverConnectorNumbersArray = {"0", "1" , "2 straight", "2 sharp", "2 wide", "3"};
    private String currentTerrainType = "";
    private String currentRiverNumber = "";

    private int hexRotation;
    private final int hexRotationAnglePerPress = 60;

    private final ArrayList<String> terrainTypesList = new ArrayList<>(Arrays.asList(terrainTypesArray));
    private final ArrayList<String> riverConnectorNumbersList = new ArrayList<>(Arrays.asList(riverConnectorNumbersArray));

    private Iterator<String> terrainIterator;
    private Iterator<String> riverIterator;

    private MapEditorPanel mapEditorPanel;

    private static final int SHIFT_KEY_CODE = 1;
    private static final int LEFT_KEY_CODE = 37;
    private static final int UP_KEY_CODE = 38;
    private static final int RIGHT_KEY_CODE = 39;
    private static final int DOWN_KEY_CODE = 40;

    public MapEditorController(MapEditorPanel mapEditorPanel){
        terrainIterator = terrainTypesList.iterator();
        riverIterator = riverConnectorNumbersList.iterator();
        this.mapEditorPanel = mapEditorPanel;

        mapEditorPanel.setControllerAsKeyListener(this);

    }

    //cycles through terrain types with an iterator, sends the string to the correct JLabel in TileSelectionPanel
    public void cycleTerrain(){
        if (!terrainIterator.hasNext()) {
            terrainIterator = terrainTypesList.iterator();   //reset iterator to element 0
        }

        riverIterator = riverConnectorNumbersList.iterator();   //reset river iterator to start at 0 every time a new terrain is cycled to
        currentTerrainType = terrainIterator.next();
        mapEditorPanel.setTerrainInTileSelectionText(currentTerrainType);   //set JLabel in View for terrain
    }

    //cycles through river count with an iterator, sends the string to the correct JLabel in TileSelectionPanel
    public void cycleRiverCount(){
        if (!riverIterator.hasNext()){
            riverIterator = riverConnectorNumbersList.iterator();   //reset iterator to element 0
        }

        if(!currentTerrainType.equals("Sea")){  //only set river count if non-Sea terrain
            currentRiverNumber = riverIterator.next();
        } else{
            currentRiverNumber = "";    //a sea tile has no rivers
        }
        mapEditorPanel.setRiverConnectorsInTileSelectionText(currentRiverNumber);
    }

    public void cycleOrientationClockwise(){

        hexRotation = (hexRotation + hexRotationAnglePerPress) % 360;   //rotate 60 degress and reset at 360
        System.out.println("class MEC: rotatation" + hexRotation);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //TODO check for the correct keypress before cycling
    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getModifiers() == SHIFT_KEY_CODE){
            switch (e.getKeyCode()){
                case UP_KEY_CODE:
                    cycleTerrain();
                    return;
            }
        }
        switch (e.getKeyCode()){
            case RIGHT_KEY_CODE:
                cycleOrientationClockwise();
                return;
            case UP_KEY_CODE:
                cycleRiverCount();
                return;
        }

        switch (e.getKeyChar()){
            case '8':
                //highlight N
                return;
            case '9':
                //highlight NE
                return;
            case '3':
                //highlight SE
                return;
            case '2':
                //highlight S
                return;
            case '1':
                //highlight SW
                return;
            case '7':
                //highlight NW
                return;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public String getCurrentTerrainType() {
        return currentTerrainType;
    }

    public String getCurrentRiverNumber() {
        return currentRiverNumber;
    }

    public int getHexRotation() {
        return hexRotation;
    }

    public void addSelectedTile() {
        boolean[] isRiver = new boolean[6];
        int rotationOffset = getHexRotation()/60;

        switch(getCurrentRiverNumber()){
            case "1":
                isRiver[rotationOffset] = true;
                break;
            case "2 sharp":
                isRiver[rotationOffset] = true;
                rotationOffset = (rotationOffset < 5) ? rotationOffset + 1 : 0;
                isRiver[rotationOffset] = true;
                break;
            case "2 wide":
                isRiver[rotationOffset] = true;
                rotationOffset = (rotationOffset < 4) ? rotationOffset + 2 : rotationOffset - 4;
                isRiver[rotationOffset] = true;
                break;
            case "3":
                rotationOffset = (rotationOffset%2 == 1) ? 1 : 0;
                isRiver[rotationOffset] = true;
                isRiver[rotationOffset+2] = true;
                isRiver[rotationOffset+4] = true;
                break;
        }

        Zone[] zones = new Zone[6];
        //for(int iii = 0; iii < 6; iii++)
        //  zones[iii] = new Zone(isRiver[iii], false);

        Tile t;
        switch (getCurrentTerrainType()) {
            case "Woods":
                //t = new WoodsTile( location, zones);
                break;
            case "Pasture":

                break;
            case "Rock":

                break;
            case "Mountains":

                break;
            case "Desert":

                break;
            case "Sea":

                break;
        }
        //adapter.addTileAtCurrentPosition(t);

    }
}



//TODO add remaining methods from design doc
