package model.player;

import model.map.tile.Tile;
import model.research.ResearchTree;
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
    private ResearchTree researchTree;

    public Player(Tile tile){
        playerID = new PlayerID();
        startingTile = tile;
        transportManager = new TransportManager();
        researchTree = new ResearchTree();
    }

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

    public ResearchTree getResearchTree() {
        return researchTree;
    }

    public void setResearchTree(ResearchTree researchTree) {
        this.researchTree = researchTree;
    }

    public PlayerID getPlayerID() {
        return playerID;
    }

    public void setPlayerID(PlayerID playerID) {
        this.playerID = playerID;
    }
}
