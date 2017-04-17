package controller;

import model.game.GameModel;
import model.map.tile.StartingTileVisitor;
import model.map.tile.Tile;
import model.utilities.ConversionUtilities;
import view.GameViewPanel;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathen on 4/16/2017.
 */
public class StartingTileController extends KeyEventHandler{
    private Tile currentTile;
    private int currentFace;

    private GameModel gameModel;
    private GameViewPanel gameViewPanel;

    //TODO find way to get rid of?
    private List<String> facesStrings = new ArrayList<>();
    private List<String> noFacesString = new ArrayList<>();
    private String selectFaceString;

    public StartingTileController(GameViewPanel gameViewPanel, GameModel gameModel) {
        this.currentFace = 1;

        this.gameModel = gameModel;
        this.gameViewPanel = gameViewPanel;

        initStrings();
    }


    @Override
    public void handle(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_ENTER:
                //selectCurrentTile(); DISABLED FOR DEMO
                break;
            case KeyEvent.VK_UP:
                decrementCurrentFace();
                break;
            case KeyEvent.VK_DOWN:
                incrementCurrentFace();
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
        updateGameViewPanelFaceString();
    }

    private void incrementCurrentFace() {
        if (currentFace >= 6) {
            currentFace = 1;
        }
        else {
            currentFace++;
        }
        updateGameViewPanelFaceString();
    }

    private void selectCurrentTile() {
        if (currentTileIsValid()){
            System.out.println("class: StartingTileController setting active player location to " + currentTile.toString());
            gameModel.setActivePlayerStartingLocation(currentTile, currentFace);
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
        currentTile = gameModel.getStartingLocation(ConversionUtilities.convertFromPointToCube(point), new StartingTileVisitor());
        updateGameViewPanelTileString();
    }

    private void updateGameViewPanelTileString() {
        if (currentTileIsValid()) {
            gameViewPanel.setCurrentTransporterString(selectFaceString);
            updateGameViewPanelFaceString();
        }
        else {
            gameViewPanel.setCurrentTransporterString("No valid tile selected.");
            updateGameViewPanelFaceString();
        }
    }

    private void updateGameViewPanelFaceString() {
        if (currentTileIsValid()) {
            gameViewPanel.setCurrentAbilitiesString(facesStrings);
            gameViewPanel.setActiveAbilityString(String.valueOf(currentFace));
        }
        else {
            gameViewPanel.setCurrentAbilitiesString(noFacesString);
            gameViewPanel.setActiveAbilityString("");
        }
    }

    private void initStrings() {
        for (int i = 1; i < 7; i++) {
            facesStrings.add(String.valueOf(i));
        }
        noFacesString.add("No face available");

        selectFaceString = "Please select a face: ";
    }
}
