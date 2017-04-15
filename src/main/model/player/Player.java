package model.player;

import model.map.tile.Tile;
import model.phase.observers.PhaseObserver;
import model.research.TechTree;
import model.transporters.TransportManager;
import model.transporters.Transporter;

/**
 * Created by TheNotoriousOOP on 4/13/2017.
 * Class Description:
 * Responsibilities:
 */
public class Player implements PhaseObserver {
    private PlayerID playerID;
    private TransportManager transportManager;
    private Tile startingTile;
    private TechTree techTree;

    public Player(Tile tile){
        playerID = new PlayerID();
        startingTile = tile;
        transportManager = new TransportManager();
        techTree = new TechTree();
    }

    public void addTransporter(Transporter t){
        //TODO implement adding a transporter
        transportManager.addTransporter(t);
    }

    public void removeTransporter(Transporter t){
        //TODO implement removing a transporter
        transportManager.removeTransporter(t);
    }

    public void endPhase(){
        //TODO implement ending a phase to trigger all of the observers for that phase
    }

    public TransportManager getTransportManager() { return transportManager; }

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

    //POOP: Change to TileResourceVisitor?
    public void decrementStarterTileGold(int amount) {}
    public void decrementStarterTileCoin(int amount) {}
    public void decrementStarterTileStock(int amount) {}

    // Notify the transport manager that the trade phase started
    public void onTradePhaseStart() {
        this.transportManager.onTradePhaseStart();
    }

    // Notify the transport manager that the build phase started
    public void onBuildPhaseStart() {
        this.transportManager.onBuildPhaseStart();
    }

    // Notify the transport manager that the production phase started
    public void onProductionPhaseStart() {
        this.transportManager.onProductionPhaseStart();
    }

    // Notify the transport manager that the movement phase started
    public void onMovementPhaseStart() {
        this.transportManager.onMovementPhaseStart();
    }

    // Notify the transport manager that the wonder phase started
    public void onWonderPhaseStart() {
        this.transportManager.onWonderPhaseStart();
    }

}
