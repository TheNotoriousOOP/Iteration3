package controller;

import view.GameViewPanel;

import java.awt.event.KeyEvent;

/**
 * Created by Jonathen on 4/16/2017.
 */
public class StartingTileController extends KeyEventHandler{

    private GameViewPanel gameViewPanel;

    public StartingTileController(GameViewPanel gameViewPanel) {
        this.gameViewPanel = gameViewPanel;
    }

    @Override
    public void handle(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_ENTER:
                selectCurrentTile();
                break;
            case KeyEvent.VK_8:
                //highlight N
                highlightNorth();
                return;
            case KeyEvent.VK_9:
                //highlight NE
                highlightNorthEast();
                return;
            case KeyEvent.VK_3:
                //highlight SE
                highlightSouthEast();
                return;
            case KeyEvent.VK_2:
                //highlight S
                highlightSouth();
                return;
            case KeyEvent.VK_1:
                //highlight SW
                highlightSouthWest();
                return;
            case KeyEvent.VK_7:
                //highlight NW
                highlightNorthWest();
                return;
            default:
                throw new IllegalArgumentException("class AbilityController does not recognize input: " + KeyEvent.getKeyText(keyCode));
        }
    }

    private void selectCurrentTile() {

    }

    private void highlightNorth() {
        gameViewPanel.highlightNorth();
    }

    private void highlightNorthEast() {
        gameViewPanel.highlightNorthEast();
    }
    private void highlightSouthEast() {
        gameViewPanel.highlightSouthEast();
    }

    private void highlightSouth() {
        gameViewPanel.highlightSouth();
    }

    private void highlightSouthWest() {
        gameViewPanel.highlightSouthWest();
    }

    private void highlightNorthWest() {
        gameViewPanel.highlightNorthWest();
    }
}
