package controller;

import model.ability_management.ability.Ability;
import model.game.GameModel;
import model.phase.WonderPhaseMediator;
import model.phase.observers.PhaseObserver;
import model.transporters.Transporter;
import view.GameViewPanel;
import view.SwapOrderPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jonathen on 4/14/2017.
 */
public class GameController implements KeyListener, PhaseObserver {
    GameViewPanel gameViewPanel;
    GameModel gameModel;

    AbilityController abilityController;
    TransporterController transporterController;
    MapMovementController mapMovementController;
    StartingTileController startingTileController; //Only used in first part of game to select tile

    //Used to map a specific key event type to a desired handler. Avoids use of CONDITIONAL LOGICCC (except the logic inside HashMap :^) )
    Map<Integer, KeyEventHandler> keyHandlerMap;

    public GameController(GameViewPanel gameViewPanel, GameModel gameModel) {
        this.gameViewPanel = gameViewPanel;
        this.gameModel = gameModel;

        abilityController = new AbilityController(gameViewPanel);
        mapMovementController = new MapMovementController(gameViewPanel);
        startingTileController = new StartingTileController(gameViewPanel, gameModel);
        //TODO fix this to not violate LOD? also encumbers this class with notion of player index
        transporterController = new TransporterController(abilityController, (gameModel.getPlayers())[0].getTransportManager(), gameViewPanel);

        keyHandlerMap = new HashMap<>();
        initKeyHandlerMapForGame();

        //Attach controller to its things
        gameModel.setGameController(this); //TODO change to mediator

        gameViewPanel.addKeyListenerToBoard(this);
        gameViewPanel.addControllerMediator(new GameControllerMediator(this));

    }

    public void endTurn() {
        gameModel.endTurn();
        gameViewPanel.setPlayerText(gameModel.getActivePlayerString());
        transporterController.update(gameModel.getActivePlayer().getTransportManager().iterator());
    }

    public void resetMap() {
        this.gameModel.resetMap();
        this.updateView();
    }

    public void loadMapFromFilename(String filepath) {
        gameModel.loadMapFromFilename(filepath);
    }

    public void updateView(){
        gameViewPanel.updateBoard(gameModel.getMapAsGrid());
        gameViewPanel.updateTransporters(gameModel.getAllTransporters());
    }

    private void initKeyHandlerMapForGame() {
        keyHandlerMap.put(KeyEvent.VK_ENTER, startingTileController);
        keyHandlerMap.put(KeyEvent.VK_UP, startingTileController);
        keyHandlerMap.put(KeyEvent.VK_DOWN, startingTileController);
        keyHandlerMap.put(KeyEvent.VK_1, startingTileController);
        keyHandlerMap.put(KeyEvent.VK_2, startingTileController);
        keyHandlerMap.put(KeyEvent.VK_3, startingTileController);
        keyHandlerMap.put(KeyEvent.VK_7, startingTileController);
        keyHandlerMap.put(KeyEvent.VK_8, startingTileController);
        keyHandlerMap.put(KeyEvent.VK_9, startingTileController);
        keyHandlerMap.put(KeyEvent.VK_W, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_A, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_S, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_D, mapMovementController);
    }

    public void showSwapPanel() {
        this.gameViewPanel.notifyAllObservers("SwapOrderPanel");
    }

    //TODO if we need more specificity, use different method call for typed/pressed/released
    @Override
    public void keyTyped(KeyEvent e) {
        //Currently don't need to do anything
    }

    @Override
    public void keyPressed(KeyEvent e) {
        deferToHandler(e);
        updateView();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Currently don't need to do anything
    }

    public boolean verifyMap(){
        if(gameModel.verifyMap())
            return true;
        return false;
    }
    private void deferToHandler(KeyEvent e) {
        int key = e.getKeyCode();
        if (keyHandlerMap.containsKey(key)) {
            keyHandlerMap.get(key).handle(key);
        }
        else {
            System.out.println("class GameController: Could not handle input... " + KeyEvent.getKeyText(key));
        }
    }

    //TODO delete: this is for glass testing
    public Transporter getCurrentTransporter() {
        return transporterController.getCurrentTransporter();
    }

    //TODO delete: this is for glass testing
    public Ability getCurrentAbility() {
        return abilityController.getCurrentAbility();
    }

    public void notifyInvalidMap(){
        gameViewPanel.notifyAllObservers("MainMenuPanel");
    }

    @Override
    public void onTradePhaseStart() {
        gameViewPanel.setPhaseText("Trade");
        updateKeyHandlerMapForTradePhase();
    }

    private void updateKeyHandlerMapForTradePhase() {
        keyHandlerMap.clear();
        keyHandlerMap.put(KeyEvent.VK_ENTER, abilityController);
        keyHandlerMap.put(KeyEvent.VK_UP, abilityController);
        keyHandlerMap.put(KeyEvent.VK_DOWN, abilityController);
        keyHandlerMap.put(KeyEvent.VK_LEFT, transporterController);
        keyHandlerMap.put(KeyEvent.VK_RIGHT, transporterController);
        keyHandlerMap.put(KeyEvent.VK_W, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_A, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_S, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_D, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_1, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_2, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_3, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_7, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_8, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_9, mapMovementController);

    }

    @Override
    public void onProductionPhaseStart() {
        gameViewPanel.setPhaseText("Production");
        updateKeyHandlerMapForProductionPhase();
    }

    private void updateKeyHandlerMapForProductionPhase() {
        keyHandlerMap.clear();
        keyHandlerMap.put(KeyEvent.VK_ENTER, abilityController);
        keyHandlerMap.put(KeyEvent.VK_UP, abilityController);
        keyHandlerMap.put(KeyEvent.VK_DOWN, abilityController);
        keyHandlerMap.put(KeyEvent.VK_LEFT, transporterController);
        keyHandlerMap.put(KeyEvent.VK_RIGHT, transporterController);
        keyHandlerMap.put(KeyEvent.VK_W, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_A, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_S, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_D, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_1, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_2, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_3, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_7, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_8, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_9, mapMovementController);
    }

    @Override
    public void onBuildPhaseStart() {
        gameViewPanel.setPhaseText("Build");
        updateKeyHandlerMapForBuildPhase();
    }

    private void updateKeyHandlerMapForBuildPhase() {
        keyHandlerMap.clear();
        keyHandlerMap.put(KeyEvent.VK_ENTER, abilityController);
        keyHandlerMap.put(KeyEvent.VK_UP, abilityController);
        keyHandlerMap.put(KeyEvent.VK_DOWN, abilityController);
        keyHandlerMap.put(KeyEvent.VK_LEFT, transporterController);
        keyHandlerMap.put(KeyEvent.VK_RIGHT, transporterController);
        keyHandlerMap.put(KeyEvent.VK_W, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_A, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_S, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_D, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_1, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_2, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_3, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_7, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_8, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_9, mapMovementController);
    }

    @Override
    public void onMovementPhaseStart() {
        gameViewPanel.setPhaseText("Movement");
        updateKeyHandlerMapForMovementPhase();
    }

    private void updateKeyHandlerMapForMovementPhase() {
        keyHandlerMap.clear();
        keyHandlerMap.put(KeyEvent.VK_ENTER, abilityController);
        keyHandlerMap.put(KeyEvent.VK_UP, abilityController);
        keyHandlerMap.put(KeyEvent.VK_DOWN, abilityController);
        keyHandlerMap.put(KeyEvent.VK_LEFT, transporterController);
        keyHandlerMap.put(KeyEvent.VK_RIGHT, transporterController);
        keyHandlerMap.put(KeyEvent.VK_W, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_A, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_S, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_D, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_1, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_2, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_3, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_7, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_8, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_9, mapMovementController);
    }

    @Override
    public void onWonderPhaseStart(WonderPhaseMediator mediator) {
        gameViewPanel.setPhaseText("Wonder");
        updateKeyHandlerMapForWonderPhase();
    }

    private void updateKeyHandlerMapForWonderPhase() {
        keyHandlerMap.clear();
        keyHandlerMap.put(KeyEvent.VK_ENTER, abilityController);
        keyHandlerMap.put(KeyEvent.VK_UP, abilityController);
        keyHandlerMap.put(KeyEvent.VK_DOWN, abilityController);
        keyHandlerMap.put(KeyEvent.VK_LEFT, transporterController);
        keyHandlerMap.put(KeyEvent.VK_RIGHT, transporterController);
        keyHandlerMap.put(KeyEvent.VK_W, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_A, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_S, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_D, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_1, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_2, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_3, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_7, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_8, mapMovementController);
        keyHandlerMap.put(KeyEvent.VK_9, mapMovementController);
    }

    public void swapPlayers() {
        this.gameModel.swapPlayerOrder();
    }
}
