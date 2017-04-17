package controller;

import model.transporters.MyBidirectionalIterator;
import model.transporters.TransportManager;
import model.transporters.Transporter;
import view.GameViewPanel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Observes TransportManager for whenever the underlying set of Transporters has changed in order to update
 * the iterator that this controller uses
 *
 * Created by Jonathen on 4/14/2017.
 */
public class TransporterController extends KeyEventHandler implements TransportManagerObserver, ResourceObserver {
    private MyBidirectionalIterator<Transporter> transporterIterator;
    private AbilityController abilityController;

    private GameViewPanel gameViewPanel;
    private GameController gameController;

    public TransporterController(AbilityController abilityController, TransportManager transportManager, GameViewPanel gameViewPanel, GameController gameController) {
        this.abilityController = abilityController;
        this.gameViewPanel = gameViewPanel;
        this.gameController = gameController;

        updateIterator(transportManager.iterator());
        transportManager.addObserver(this);
    }

    @Override
    public void handle(int keyCode) throws IllegalArgumentException{
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                cycleLeft();
                break;
            case KeyEvent.VK_RIGHT:
                cycleRight();
                break;
            default:
                throw new IllegalArgumentException("class TransporterController does not recognize input: " + KeyEvent.getKeyText(keyCode));
        }
    }

    //TODO get rid of TDA with hasPrev/hasNext calls

    private void cycleLeft() {
      //  System.out.println("class TransporterController: Cycling transporter prev...");
        //Get prev transporter
        if (transporterIterator.hasPrev()) {
            transporterIterator.getCurrent().deregisterAbilityObserver(abilityController);
            transporterIterator.getCurrent().deregisterResourceObserver(this);
            updateAbilityController(transporterIterator.prev());
        }
    }

    private void cycleRight() {
      //  System.out.println("class TransporterController: Cycling transporter next...");
        //Get next transporter
        if (transporterIterator.hasNext()) {
            transporterIterator.getCurrent().deregisterAbilityObserver(abilityController);
            transporterIterator.getCurrent().deregisterResourceObserver(this);
            updateAbilityController(transporterIterator.next());
        }
    }

    //Actual underlying transporter list in model has changed
    @Override
    public void update(MyBidirectionalIterator<Transporter> transporterIterator) {
        if (transporterIterator != null) {
            updateIterator(transporterIterator);
        }
    }

    //Update resource stuff
    @Override
    public void update(Transporter transporter) {
        //This will get a message to the model in order to update the abilities of all transporters
        //Necessary since the state of resources on a tile has changed. Every transporter needs to poll the tile
        //for the new state.
        gameController.updateResourcesInModel();
        updateGameViewPanelResources(transporter);
    }

    private void updateAbilityController(Transporter transporter) {
      //  System.out.println("class TransporterController: Updating AbilityController AbilitySet with transporter: " + transporter.toString() + " |");
     //   System.out.println("class TransporterController: Updating AbilityController AbilitySet with transporter's ability set :" + transporter.getAbilitySet().toString() + " |");
        updateGameViewPanel(transporter);
        transporterIterator.getCurrent().registerAbilityObserver(abilityController);
        transporterIterator.getCurrent().registerResourceObserver(this);
        abilityController.setAbilitySet(transporter.getAbilitySet());
    }

    private void updateIterator(MyBidirectionalIterator<Transporter> transporterIterator) {
        //If the new transporter iterator has transporters, then...
        if (transporterIterator.getCurrent() != null) {
            //Stop listening to the old transporter
            transporterIterator.getCurrent().deregisterAbilityObserver(abilityController);
            transporterIterator.getCurrent().deregisterResourceObserver(this);

            //Update our iterator reference
            this.transporterIterator = transporterIterator;

            //Update the ability controller so that it is using the current transporter's ability set
            updateAbilityController(transporterIterator.getCurrent());
        }
        else { //We still want to update our transporter iterator reference
            this.transporterIterator = transporterIterator;

            //We need to remove any possible strings from the view
            clearGameViewPanel();
        }
    }

    private void updateGameViewPanel(Transporter transporter) {
        gameViewPanel.setCurrentTransporterString(transporter.toString());
        updateGameViewPanelResources(transporter);
    }

    private void clearGameViewPanel() {
        gameViewPanel.setCurrentTransporterString("");
        gameViewPanel.setResourceOnNodeString(new ArrayList<>());
        gameViewPanel.setResourceOnTransporterString(new ArrayList<>());

        //Make sure that the ability controller also clears its string
        abilityController.clearGameViewPanel();
    }

    private void updateGameViewPanelResources(Transporter transporter) {
        gameViewPanel.setResourceOnNodeString(transporter.getResourcesStringOnNode());
        gameViewPanel.setResourceOnTransporterString(transporter.getResourcesString());
    }

    //TODO remove; for testing only
    public Transporter getCurrentTransporter() {
        return transporterIterator.getCurrent();
    }
}
