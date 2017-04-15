import controller.GameController;
import controller.MainMenuController;
import controller.MapEditorController;
import model.EditorModel;
import model.game.GameModel;
import view.PanelManager;

import javax.swing.*;
// Class to run the game
public class RunGame {

    // Startup game
    public static void main(String[] args) {

        //Init PanelManager
        PanelManager panelManager = new PanelManager();
        panelManager.setFullScreen();

        //init model(s)
        EditorModel editorModel = new EditorModel();

        //init controller(s)
        MapEditorController mapEditorController = new MapEditorController(panelManager.getMapEditorPanel(), editorModel);
        GameModel gameModel = new GameModel();
        GameController gameController = new GameController(panelManager.getGameViewPanel(), gameModel);

        MainMenuController mainMenuController = new MainMenuController(panelManager.getMainMenuPanel(), mapEditorController, gameController);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                panelManager.showScreen();
            }
        });
    }

}
