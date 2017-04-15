package controller;

import model.game.GameModel;
import org.junit.Before;
import org.junit.Test;
import view.PanelManager;

import java.awt.event.KeyEvent;
import java.awt.Robot;


/**
 * Created by Jonathen on 4/15/2017.
 */
public class GameControllerTest {

    GameController gameController;

    //Classes that the controllers need
    PanelManager panelManager;
    GameModel gameModel;

    //Create controllers
    @Before
    public void setup() {
        panelManager = new PanelManager();
        gameModel = new GameModel();

        gameController = new GameController(panelManager.getGameViewPanel(), gameModel);
    }

    @Test
    public void keyPressed() throws Exception {
        Robot r = new Robot();
        int keyCode = KeyEvent.VK_ENTER; // the A key
        r.keyPress(keyCode);
        r.keyRelease(keyCode);
    }

}