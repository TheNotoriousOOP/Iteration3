package controller;

import model.game.GameModel;
import model.map.tile.Tile;
import model.utilities.ConversionUtilities;
import view.GameViewPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Jonathen on 4/16/2017.
 */
public class StartingTileController extends KeyEventHandler{
    private Tile currentTile;
    private int currentFace;

    private GameModel gameModel;
    private GameViewPanel gameViewPanel;

    public StartingTileController(GameViewPanel gameViewPanel, GameModel gameModel) {
        this.currentFace = 1;

        this.gameModel = gameModel;
        this.gameViewPanel = gameViewPanel;
    }

    @Override
    public void handle(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_ENTER:
                selectCurrentTile();
                break;
            case KeyEvent.VK_UP:
                incrementCurrentFace();
                break;
            case KeyEvent.VK_DOWN:
                decrementCurrentFace();
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

    private void decrementCurrentFace() {
        if (currentFace <= 1) {
            currentFace = 6;
        }
        else {
            currentFace--;
        }
    }

    private void incrementCurrentFace() {
        if (currentFace >= 6) {
            currentFace = 1;
        }
        else {
            currentFace++;
        }
    }

    private void selectCurrentTile() {
        if (currentTileIsValid()){
            gameModel.setActivePlayerStartingLocation(currentTile, currentFace);
            //TODO move to next player
        }
    }

    private boolean currentTileIsValid() {
        return (currentTile != null);
    }

    private void highlightNorth() {
        updateSelectedCoordinate(gameViewPanel.highlightNorth());
    }

    private void highlightNorthEast() {
        updateSelectedCoordinate(gameViewPanel.highlightNorthEast());
    }
    private void highlightSouthEast() {
        updateSelectedCoordinate(gameViewPanel.highlightSouthEast());
    }

    private void highlightSouth() {
        updateSelectedCoordinate(gameViewPanel.highlightSouth());
    }

    private void highlightSouthWest() {
        updateSelectedCoordinate(gameViewPanel.highlightSouthWest());
    }

    private void highlightNorthWest() {
        updateSelectedCoordinate(gameViewPanel.highlightNorthWest());
    }

    private void updateSelectedCoordinate(Point point) {
        currentTile = gameModel.getStartingLocation(ConversionUtilities.convertFromPointToCube(point), new Point());
    }
}
