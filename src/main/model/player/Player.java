package model.player;

import model.map.tile.Tile;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.phase.observers.PhaseObserver;
import model.research.TechTree;
import model.resources.resourceVisitor.*;
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
    private ParentLandNode startingLocation;
    private TechTree techTree;

    public Player(){
        playerID = new PlayerID();
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

    public ParentLandNode getStartingLocation() { return startingLocation; }

    public void setStartingLocation(ParentLandNode node) {
        this.startingLocation = startingLocation;
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

    //POOP: Change to shuttleToStarterTile(ResourceVisitor v); ?
    public void decrementStarterTileGoods(int amount, InnerResourceVisitor visitor) {
        ResourceVisitor v = new RemoveResourceVisitor(visitor);
        for(int iii = 0; iii < amount; iii++){
            startingLocation.acceptResourceVisitor(v);
        }
    }

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
