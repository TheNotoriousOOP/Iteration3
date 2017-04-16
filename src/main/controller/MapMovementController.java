package controller;

import view.GameViewPanel;

import java.awt.event.KeyEvent;

/**
 *
 */
public class MapMovementController extends KeyEventHandler{
    GameViewPanel gameViewPanel;
    public MapMovementController(GameViewPanel gameViewPanel){
        this.gameViewPanel = gameViewPanel;
    }
    @Override
    public void handle(int keyCode){
        switch(keyCode) {
            case KeyEvent.VK_W:
                gameViewPanel.moveCameraUp();
                return;
            case KeyEvent.VK_A:
                gameViewPanel.moveCameraLeft();
                return;
            case KeyEvent.VK_S:
                gameViewPanel.moveCameraDown();
                return;
            case KeyEvent.VK_D:
                gameViewPanel.moveCameraRight();
        }
    }
}
