package controller;

import javax.swing.text.View;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Provides key listeners and key event handlers for the game
 * Responsibilities: Take in user input for the map editor & send input to MapEditor Controller
 */
public class KeyEventController {
    private MapEditorController mec;
    private View view;

    public KeyEventController(MapEditorController mec, View view){
        this.mec = mec;
        this.view = view;
    }
}
