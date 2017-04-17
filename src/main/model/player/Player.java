package model.player;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.phase.WonderPhaseMediator;
import model.phase.observers.PhaseObserver;
import model.research.PlayerResearchSettings;
import model.research.ResearchTree;
import model.research.research_node_observers.ResearchObserver;
import model.research.research_node_visitors.ResearchNodeVisitor;
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
    private ResearchTree researchTree;
    private PlayerResearchSettings settings;
    private String name;

    public Player(String name){
        playerID = new PlayerID();

        this.name = name;

        settings = new PlayerResearchSettings();
        researchTree = new ResearchTree(settings);

        transportManager = new TransportManager();

    }

    // Pass visitor to research tree to perform research on specified node
    public void research(ResearchNodeVisitor v) {
        this.researchTree.performResearch(v);
    }

    public PlayerResearchSettings getResearchSettings() { return this.settings; }

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
        this.startingLocation = node;
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
    public void onWonderPhaseStart(WonderPhaseMediator mediator) {
        this.transportManager.onWonderPhaseStart(mediator);
    }

    public String getName() {
        return name;
    }
}
