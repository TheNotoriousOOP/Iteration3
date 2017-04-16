package controller;

import view.MainMenuPanel;

/**
 *
 */
public class MainMenuController {

    private MainMenuPanel mainMenuPanel;
    private MapEditorController mapEditorController;
    private GameController gameController;

    public MainMenuController(MainMenuPanel mainMenuPanel, MapEditorController mapEditorController, GameController gameController) {
        this.mainMenuPanel  = mainMenuPanel;
        this.mapEditorController = mapEditorController;
        this.gameController = gameController;
        this.mainMenuPanel.setController(this);
    }

    public void loadMapInModel(String filePath) {
        mapEditorController.resetMap();
        mapEditorController.loadMapFromFilename(filePath);
        mapEditorController.updateBoardInView();
    }

    public void loadMapInGame(String filePath){
        gameController.resetMap();
        gameController.loadMapFromFilename(filePath);
        gameController.updateView();
    }

    public void resetMap() { mapEditorController.resetMap(); }
}
