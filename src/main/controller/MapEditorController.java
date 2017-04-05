package controller;

import model.EditorModel;
import model.map.tile.SeaTile;
import model.map.tile.Tile;
import model.map.tile.Zone;
import model.map.CubeVector;
import model.map.tile.*;
import view.MapEditorObserver;
import view.MapEditorPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: controls the cycling of tile types in map editor view
 * Responsibilities:
 *  take user input for the map editor to cycle tile types
 *  send user input to ViewModelAdapter to communicate with model
 */
public class MapEditorController extends MapEditorObserver implements KeyListener {

    private final String[] terrainTypesArray = {"Woods", "Pasture", "Rock", "Mountains", "Desert", "Sea"};
    private Vector<String> terrainTypesList = new Vector<>(Arrays.asList(terrainTypesArray));
    private final String[] riverConnectorNumbersArray = {"0", "1" , "2 straight", "2 sharp", "2 wide", "3"};
    private Vector<String> riverTypeList = new Vector<>(Arrays.asList(riverConnectorNumbersArray));

    private int hexRotation;
    private int terrainIndex;
    private int riverIndex;
    private final int hexRotationAnglePerPress = 60;


    private MapEditorPanel mapEditorPanel;

    private EditorModel mapEditorModel;

    private static final int SHIFT_KEY_CODE = 1;
    private static final int LEFT_KEY_CODE = 37;
    private static final int UP_KEY_CODE = 38;
    private static final int RIGHT_KEY_CODE = 39;
    private static final int DOWN_KEY_CODE = 40;

    public MapEditorController(MapEditorPanel mapEditorPanel, EditorModel mapEditorModel){
        this.mapEditorPanel = mapEditorPanel;
        this.mapEditorModel = mapEditorModel;

        mapEditorPanel.setControllerAsKeyListener(this);
        mapEditorPanel.attach(this);
        updateBoardInView();
    }


    public void loadMapFromFilename(String filepath) {
        this.mapEditorModel.loadMapFromFilename(filepath);
    }

    public void resetMap() {
        this.mapEditorModel.resetMap();
        this.updateBoardInView();
    }

    //cycles through terrain types with an iterator, sends the string to the correct JLabel in TileSelectionPanel
    public void cycleTerrain(){
        riverIndex = 0;
        hexRotation = 0;
        terrainIndex = (terrainIndex + 1) % terrainTypesList.size();
        mapEditorPanel.setTerrainInTileSelectionText(terrainTypesList.get(terrainIndex));   //set JLabel in View for terrain
        mapEditorPanel.setRiverConnectorsInTileSelectionText(getCurrentRiver(riverIndex));
        mapEditorPanel.setTileRotationSelectionText(hexRotation);
    }

    public void cycleTerrainBackwards(){
        riverIndex = 0;
        hexRotation = 0;
        terrainIndex -= 1;
        if(terrainIndex < 0)
            terrainIndex += terrainTypesList.size();
        mapEditorPanel.setTerrainInTileSelectionText(terrainTypesList.get(terrainIndex));
        mapEditorPanel.setRiverConnectorsInTileSelectionText(getCurrentRiver(riverIndex));
        mapEditorPanel.setTileRotationSelectionText(hexRotation);
    }
    private String getCurrentRiver(int riverIndex){
        String currentRiver = "";
        if(!mapEditorPanel.getCurrentTerrainText().equals("Sea")){  //only set river count if non-Sea terrain
            currentRiver = riverTypeList.get(riverIndex);
        }
        return currentRiver;
    }

    //cycles through river count with an iterator, sends the string to the correct JLabel in TileSelectionPanel
    public void cycleRiverCount(){
        hexRotation = 0;
        riverIndex = (riverIndex + 1) % riverTypeList.size();
        mapEditorPanel.setRiverConnectorsInTileSelectionText(getCurrentRiver(riverIndex));
        mapEditorPanel.setTileRotationSelectionText(hexRotation);
    }

    public void cycleRiverCountBackwards(){
        hexRotation = 0;
        riverIndex -= 1;
        if(riverIndex < 0)
            riverIndex += riverTypeList.size();
        mapEditorPanel.setRiverConnectorsInTileSelectionText(getCurrentRiver(riverIndex));
        mapEditorPanel.setTileRotationSelectionText(hexRotation);
    }

    public void cycleOrientationClockwise(){
        hexRotation = (hexRotation + hexRotationAnglePerPress) % 360;   //rotate 60 degress and reset at 360
        mapEditorPanel.setTileRotationSelectionText(hexRotation);
        System.out.println("class MEC: rotation" + hexRotation);
    }

    public void cycleOrientationCounterClockwise(){
        int tempRotation = (hexRotation - hexRotationAnglePerPress) % 360;
        if(tempRotation < 0)
            hexRotation = 300;
        else
            hexRotation = tempRotation;
        mapEditorPanel.setTileRotationSelectionText(hexRotation);
        System.out.println("class MEC: rotation" + hexRotation);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getModifiers() == SHIFT_KEY_CODE){
            switch (e.getKeyCode()){
                case UP_KEY_CODE:
                    cycleTerrain();
                    return;
                case DOWN_KEY_CODE:
                    cycleTerrainBackwards();
                    return;
            }
        }
        switch (e.getKeyCode()){
            case RIGHT_KEY_CODE:
                cycleOrientationClockwise();
                return;
            case LEFT_KEY_CODE:
                cycleOrientationCounterClockwise();
                return;
            case UP_KEY_CODE:
                cycleRiverCount();
                return;
            case DOWN_KEY_CODE:
                cycleRiverCountBackwards();
                return;
        }
        //Moving Camera
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                mapEditorPanel.moveCameraUp();
                return;
            case KeyEvent.VK_A:
                mapEditorPanel.moveCameraLeft();
                return;
            case KeyEvent.VK_S:
                mapEditorPanel.moveCameraDown();
                return;
            case KeyEvent.VK_D:
                mapEditorPanel.moveCameraRight();
                return;
        }
        switch (e.getKeyChar()){
            case '8':
                //highlight N
                mapEditorPanel.highlightNorth();
                return;
            case '9':
                //highlight NE
                mapEditorPanel.highlightNorthEast();
                return;
            case '3':
                //highlight SE
                mapEditorPanel.highlightSouthEast();
                return;
            case '2':
                //highlight S
                mapEditorPanel.highlightSouth();
                return;
            case '1':
                //highlight SW
                mapEditorPanel.highlightSouthWest();
                return;
            case '7':
                //highlight NW
                mapEditorPanel.highlightNorthWest();
                return;          
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //adds a tile to the selected vector highlighted by gui
    private void addTileToSelectedVector() {

        int x = mapEditorPanel.getXCoord();  //determine x position
        int y = mapEditorPanel.getYCoord();  //determine y position

        CubeVector location = new CubeVector(x,y);  //create a cubevector based on data which automatically converts to x,y,z coord

        boolean[] isRiver = new boolean[6]; //zone manipulation
        int rotationOffset = (hexRotation/60);    //zone number corresponds to the rotation angle for zero-indexed arrays

        //determine the rivered zones in rotated hex
        switch(mapEditorPanel.getCurrentRiverConnectorsText()){
            case "1":
                isRiver[rotationOffset] = true;
                break;
            case "2 straight":
                isRiver[rotationOffset] = true;
                rotationOffset = (rotationOffset + 3) % 6;
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

        //init all zones to isRiver[index] / false
        Zone[] zones = new Zone[6];
        for(int iii = 0; iii < 6; iii++){
            zones[iii] = new Zone(isRiver[iii], false);
        }


        Tile tileToBeAdded = null;


        //determine terrain to create
        switch ((mapEditorPanel.getCurrentTerrainText())) {
            case "Woods":
                tileToBeAdded = new WoodsTile(location, zones);
                break;
            case "Pasture":
                tileToBeAdded = new PastureTile(location, zones);
                break;
            case "Rock":
                tileToBeAdded = new RockTile(location, zones);
                break;
            case "Mountains":
                tileToBeAdded = new MountainsTile(location, zones);
                break;
            case "Desert":
                tileToBeAdded = new DesertTile(location, zones);
                break;
            case "Sea":
                //fill in array of zones for sea as both bools true
                for(int j = 0; j < zones.length; j++){
                    zones[j] = new Zone(true,true);
                }
                tileToBeAdded = new SeaTile(location, zones);
                break;
        }

        mapEditorModel.addTileToEditorMap(location, tileToBeAdded);

        updateBoardInView();

    }

    //removes the tile at the currently highlighted hex
    private void removeTileAtSelectedVector(){

        int x = mapEditorPanel.getXCoord();  //determine x position
        int y = mapEditorPanel.getYCoord();  //determine y position

        CubeVector location = new CubeVector(x,y);

        mapEditorModel.removeTileFromLocation(location);    //remove handles if the location exists

        updateBoardInView();

    }

    //get map in grid form from the model, pass to the view
    public void updateBoardInView(){
        mapEditorPanel.updateBoard(mapEditorModel.getMapAsGrid());
    }
    @Override
    public void updateAdd(){
        addTileToSelectedVector();
    }
    @Override
    public void updateRemove(){
        removeTileAtSelectedVector();
    }

    public void updateSave(String filename) { mapEditorModel.saveMapToFilename(filename); }
}


