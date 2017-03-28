package model;

import model.map.CubeVector;
import model.map.editor.EditorMap;
import model.map.tile.Tile;
import model.utilities.FileUtilities;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:   Maintains current state of the map being built by the user
 * Responsibilities:    Maintains representation of the user's map & responds to events that change the state of the map
 */
public class EditorModel {
    private EditorMap eMap;

    public EditorModel(){
        this.eMap = new EditorMap();
    }

    public void loadMapFromFilename(String filename) {
        eMap.load(FileUtilities.loadMap(filename));
    }

    public void addTileToEditorMap(CubeVector location, Tile tile){
        eMap.add(location, tile);
    }

    public void removeTileFromLocation(CubeVector location){
        eMap.remove(location);
    }


    public Tile[][] getMapAsGrid(){
        return eMap.convertMapToGrid();
    }
}

