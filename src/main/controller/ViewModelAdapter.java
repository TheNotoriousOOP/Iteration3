package controller;

import model.map.editor.EditorMap;
import model.map.tile.Tile;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Links the Model to the View of the game
 * Responsibilities: Provides communication between received input and the game model
 *                   Update GUI panels w/ changes to the game model when drawn
 */
public class ViewModelAdapter {
    private EditorMap editorMap;
    private MapEditorController mapEditorController;

//    public Tile getCurrentSelectedTile(){
//    }

    public String getTileType() {
        return "";
    }

    public void setTileAtCurrentPosition(Tile tile){

    }

}

