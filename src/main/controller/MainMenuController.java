package controller;

import model.EditorModel;
import view.MainMenuPanel;

/**
 *
 */
public class MainMenuController {

    private MainMenuPanel mainMenuPanel;
    private MapEditorController mapEditorController;
    private GameController gameController;

    public MainMenuController(MainMenuPanel mainMenuPanel, MapEditorController mapEditorController) {
        this.mainMenuPanel  = mainMenuPanel;
        this.mapEditorController = mapEditorController;

        this.mainMenuPanel.setController(this);
    }

    public void loadMapInModel(String filePath) {
        mapEditorController.resetMap();
        mapEditorController.loadMapFromFilename(filePath);
        mapEditorController.updateBoardInView();
    }

    public void loadMapInGame(String filePath){
        gameController.resetMap();

    }

    public void resetMap() { mapEditorController.resetMap(); }
}
