import controller.MainMenuController;
import controller.MapEditorController;
import model.EditorModel;
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
        MainMenuController mainMenuController = new MainMenuController(panelManager.getMainMenuPanel(), editorModel);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                panelManager.showScreen();
            }
        });
    }

}
