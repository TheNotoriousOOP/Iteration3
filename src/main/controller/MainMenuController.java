package controller;

import model.EditorModel;
import view.MainMenuPanel;

/**
 * Created by Jonathen on 3/28/2017.
 */
public class MainMenuController {

    private MainMenuPanel mainMenuPanel;
    private MapEditorController mapEditorController;

    public MainMenuController(MainMenuPanel mainMenuPanel, MapEditorController mapEditorController) {
        this.mainMenuPanel  = mainMenuPanel;
        this.mapEditorController = mapEditorController;

        this.mainMenuPanel.setController(this);
    }

    public void loadMapInModel(String filePath) {
        mapEditorController.loadMapFromFilename(filePath);
        mapEditorController.updateBoardInView();
    }

    public void resetMap() { mapEditorController.resetMap(); }
}
