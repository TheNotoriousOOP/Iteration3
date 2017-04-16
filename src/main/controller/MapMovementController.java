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
                return;
            case KeyEvent.VK_8:
                //highlight N
                gameViewPanel.highlightNorth();
                return;
            case KeyEvent.VK_9:
                //highlight NE
                gameViewPanel.highlightNorthEast();
                return;
            case KeyEvent.VK_3:
                //highlight SE
                gameViewPanel.highlightSouthEast();
                return;
            case KeyEvent.VK_2:
                //highlight S
                gameViewPanel.highlightSouth();
                return;
            case KeyEvent.VK_1:
                //highlight SW
                gameViewPanel.highlightSouthWest();
                return;
            case KeyEvent.VK_7:
                //highlight NW
                gameViewPanel.highlightNorthWest();
                return;
        }
    }
}
