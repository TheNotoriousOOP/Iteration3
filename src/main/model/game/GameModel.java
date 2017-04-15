package model.game;

import model.map.GameMap;
import model.phase.ModelMediator;
import model.phase.PhaseManager;
import model.phase.observers.PhaseObserver;
import model.phase.visitors.PhaseNotificationVisitor;
import model.player.Player;

import java.util.Map;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class GameModel implements PhaseObserver {

    private PhaseManager phaseManager;
    private Player[] players;
    private GameMap gameMap;

    // Constructor
    public GameModel() {
        this.phaseManager = new PhaseManager(new ModelMediator(this));
        this.players = new Player[2];
        this.gameMap = new GameMap();
    }


    void iteratePhase(){
        //TODO implement
    }

    void save(){
        //TODO implement if you have time
    }

    void load(){
        //TODO implement if you have time
    }

    public PhaseManager getPhaseManager() {
        return phaseManager;
    }

    public void setPhaseManager(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void accept(PhaseNotificationVisitor v) {
        v.notifyPhase(this);
    }

    // Notify players & map of trade phase
    public void onTradePhaseStart() {
        for (Player p : players) { p.onTradePhaseStart(); }
        gameMap.onTradePhaseStart();
    }

    // Notify players & map of production phase
    public void onProductionPhaseStart() {
        for (Player p : players) { p.onProductionPhaseStart(); }
        gameMap.onProductionPhaseStart();
    }

    // Notify players & map of build phase
    public void onBuildPhaseStart() {
        for (Player p : players) { p.onBuildPhaseStart(); }
        gameMap.onBuildPhaseStart();
    }

    // Notify players & map of movement phase
    public void onMovementPhaseStart() {
        for (Player p : players) { p.onMovementPhaseStart(); }
        gameMap.onMovementPhaseStart();
    }

    // Notify players & map of movement phase
    public void onWonderPhaseStart() {
        for (Player p : players) { p.onWonderPhaseStart(); }
        gameMap.onWonderPhaseStart();
    }

}
