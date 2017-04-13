package model.player;

import model.map.tile.Tile;
import model.research.TechTree;
import model.transporters.TransportManager;
import model.transporters.Transporter;

/**
 * Created by TheNotoriousOOP on 4/13/2017.
 * Class Description:
 * Responsibilities:
 */
public class Player {
    private PlayerID playerID;
    private TransportManager transportManager;
    private Tile startingTile;
    private TechTree techTree;

    void addTransporter(Transporter t){
        //TODO implement adding a transporter
    }

    void removeTransporter(Transporter t){
        //TODO implement removing a transporter
    }

    void endPhase(){
        //TODO implement ending a phase to trigger all of the observers for that phase
    }

    public TransportManager getTransportManager() {
        return transportManager;
    }

    public void setTransportManager(TransportManager transportManager) {
        this.transportManager = transportManager;
    }

    public Tile getStartingTile() {
        return startingTile;
    }

    public void setStartingTile(Tile startingTile) {
        this.startingTile = startingTile;
    }

    public TechTree getTechTree() {
        return techTree;
    }

    public void setTechTree(TechTree techTree) {
        this.techTree = techTree;
    }

    public PlayerID getPlayerID() {
        return playerID;
    }

    public void setPlayerID(PlayerID playerID) {
        this.playerID = playerID;
    }
}
