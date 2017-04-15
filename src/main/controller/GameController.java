package controller;

import model.game.GameModel;
import view.GameViewPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jonathen on 4/14/2017.
 */
public class GameController implements KeyListener{
    GameViewPanel gameViewPanel;
    GameModel gameModel;

    AbilityController abilityController;
    TransporterController transporterController;

    //Used to map a specific key event type to a desired handler. Avoids use of CONDITIONAL LOGICCC
    Map<Integer, KeyEventHandler> keyHandlerMap;

    public GameController(GameViewPanel gameViewPanel, GameModel gameModel) {
        this.gameViewPanel = gameViewPanel;
        this.gameModel = gameModel;

        abilityController = new AbilityController();
        //TODO fix this to not violate LOD?
        //transporterController = new TransporterController(abilityController, gameModel.getPlayers()[0].getTransportManager());

        //initKeyHandlerMap();

        //TODO attach controller to view panel somehow
    }

    private void initKeyHandlerMap() {
        keyHandlerMap = new HashMap<>();
        keyHandlerMap.put(KeyEvent.VK_ENTER, abilityController);
        keyHandlerMap.put(KeyEvent.VK_UP, abilityController);
        keyHandlerMap.put(KeyEvent.VK_DOWN, abilityController);
        keyHandlerMap.put(KeyEvent.VK_LEFT, transporterController);
        keyHandlerMap.put(KeyEvent.VK_RIGHT, transporterController);
    }

    //TODO if we need more specificity, use different method call for typed/pressed/released
    @Override
    public void keyTyped(KeyEvent e) {
        //Currently don't need to do anything
    }

    @Override
    public void keyPressed(KeyEvent e) {
        deferToHandler(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Currently don't need to do anything
    }

    private void deferToHandler(KeyEvent e) {
        int key = e.getKeyCode();
        if (keyHandlerMap.containsKey(key)) {
            keyHandlerMap.get(key).handle(key);
        }
    }
}