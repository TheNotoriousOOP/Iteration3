package model.player;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.phase.observers.PhaseObserver;
import model.research.ResearchTree;
import model.research.research_node_observers.ResearchObserver;
import model.resources.resourceVisitor.*;
import model.transporters.TransportManager;
import model.transporters.Transporter;

/**
 * Created by TheNotoriousOOP on 4/13/2017.
 * Class Description:
 * Responsibilities:
 */
public class Player implements PhaseObserver, ResearchObserver {
    private PlayerID playerID;
    private TransportManager transportManager;
    private ParentLandNode startingLocation;
    private ResearchTree researchTree;

    public Player(){
        playerID = new PlayerID();
        transportManager = new TransportManager();
        researchTree = new ResearchTree(this);
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

    //POOP: Change to shuttleToStarterTile(ResourceVisitor v); ?
    public void decrementStarterTileGoods(int amount, InnerResourceVisitor visitor) {
        ResourceVisitor v = new RemoveResourceVisitor(visitor);
        for(int iii = 0; iii < amount; iii++){
            startingLocation.acceptResourceVisitor(v);
        }
    }

    // Notify the transport manager that the trade phase started
    @Override
    public void onTradePhaseStart() {
        this.transportManager.onTradePhaseStart();
    }

    // Notify the transport manager that the build phase started
    @Override
    public void onBuildPhaseStart() {
        this.transportManager.onBuildPhaseStart();
    }

    // Notify the transport manager that the production phase started
    @Override
    public void onProductionPhaseStart() {
        this.transportManager.onProductionPhaseStart();
    }

    // Notify the transport manager that the movement phase started
    @Override
    public void onMovementPhaseStart() {
        this.transportManager.onMovementPhaseStart();
    }

    // Notify the transport manager that the wonder phase started
    @Override
    public void onWonderPhaseStart() {
        this.transportManager.onWonderPhaseStart();
    }

    // Notify the truck factory has been researched
    @Override
    public void onTruckFactoryResearched() {
        this.transportManager.onTruckFactoryResearched();
    }

    // Notify the steamboat factory has been researched
    @Override
    public void onSteamBoatFactoryResearched() {}

    // Notify the rowboat factory has been researched
    @Override
    public void onRowBoatFactoryResearched() {
        this.transportManager.onRowBoatFactoryResearched();
    }

    // Notify the additional mine shaft has been researched
    @Override
    public void onAdditionalMineShaftResearched() {
        this.transportManager.onAdditionalMineShaftResearched();
    }

    // Notify the big mine has been researched
    @Override
    public void onBigMineResearched() {
        this.transportManager.onBigMineResearched();
    }

    // Notify the specialized mine has been researched
    @Override
    public void onSpecializedMineResearched() {
        this.transportManager.onSpecializedMineResearched();
    }

    // Notify the oil rig has been researched
    @Override
    public void onOilRigResearched() {
        this.transportManager.onOilRigResearched();
    }

    // Notify the light bulb has been researched
    @Override
    public void onLightBulbResearched() {
        this.transportManager.onLightBulbResearched();
    }

}
