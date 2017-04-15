package controller;

import javafx.scene.input.KeyCode;
import model.game.GameModel;
import view.GameViewPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

/**
 * Created by Jonathen on 4/14/2017.
 */
public class GameController implements KeyListener{
    GameViewPanel gameViewPanel;
    GameModel gameModel;

    AbilityController abilityController;
    TransporterController transporterController;

    //Used to map a specific key code to a desired functionality. Avoids use of CONDITIONAL LOGICCC
    Map<KeyCode, Runnable> keyCodeRunnableMap;

    public GameController(GameViewPanel gameViewPanel, GameModel gameModel) {
        this.gameViewPanel = gameViewPanel;
        this.gameModel = gameModel;

        abilityController = new AbilityController();
        transporterController = new TransporterController();

        initKeyRunnableMap();

        //TODO attach controller to view panel somehow
    }

    private void initKeyRunnableMap() {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
