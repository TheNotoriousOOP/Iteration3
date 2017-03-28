package controller;

import javax.swing.text.View;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */
public class KeyEventController {
    private MapEditorController mec;
    private View view;

    public KeyEventController(MapEditorController mec, View view){
        this.mec = mec;
        this.view = view;
    }
}
