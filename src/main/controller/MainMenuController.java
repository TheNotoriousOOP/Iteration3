package controller;

import model.EditorModel;
import view.MainMenuPanel;

/**
 * Created by Jonathen on 3/28/2017.
 */
public class MainMenuController {

    private MainMenuPanel mainMenuPanel;
    private EditorModel mapEditorModel;

    public MainMenuController(MainMenuPanel mainMenuPanel, EditorModel mapEditorModel) {
        this.mainMenuPanel  = mainMenuPanel;
        this.mapEditorModel = mapEditorModel;

        this.mainMenuPanel.setController(this);
    }

    public void loadMapInModel(String filePath) {
        mapEditorModel.loadMapFromFilename(filePath);
    }
}
