package model.game;

import model.map.GameMap;
import model.phase.PhaseManager;
import model.player.Player;

import java.util.Map;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class GameModel {
    private PhaseManager phaseManager;
    private Player[] players;
    private GameMap gameMap;

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
}
