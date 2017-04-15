package model.map;

import model.map.tile.Tile;
import model.phase.observers.PhaseObserver;

import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 4/14/2017.
 * Class Description:
 * Responsibilities:
 */
public class GameMap implements MapInterface, PhaseObserver {

    public GameMap() {
    }

    @Override
    public Tile getTile(CubeVector pos) {
        return null;
    }

    @Override
    public void load(String[] dataa) {

    }

    @Override
    public ArrayList<Tile> getNeighboringTiles(Tile t) {
        return null;
    }

    // Notify trade phase started
    public void onTradePhaseStart() {
        // Todo: implement
    }

    // Notify production phase started
    public void onProductionPhaseStart() {
        // Todo: implement
    }

    // Notify build phase started
    public void onBuildPhaseStart() {
        // Todo: implement
    }

    // Notify movement phase started
    public void onMovementPhaseStart() {
        // Todo: implement
    }

    // Notify wonder phase started
    public void onWonderPhaseStart() {
        // Todo: implement
    }

}
