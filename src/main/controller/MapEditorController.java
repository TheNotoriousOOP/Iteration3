package controller;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: Handles input received from KeyEventController & ViewModelAdapter
 * Responsibilities: Reacts to input by displaying the actions on the Map Editor Panel
 */
public class MapEditorController {
    KeyEventController keyEventController;

    public void cycleTerrain(){}
    public void cycleRiverCount(){}
    public void cycleOrientation(){}
    public void save(){}
    public void exitMapEditor(){}
    public void addSelectedTile(){}
    public void removeSelectedTile(){}
    public void setKeyEventController(KeyEventController keyEventController){
        this.keyEventController = keyEventController;
    }
}

