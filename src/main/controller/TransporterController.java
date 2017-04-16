package controller;

import model.transporters.MyBidirectionalIterator;
import model.transporters.TransportManager;
import model.transporters.Transporter;

import java.awt.event.KeyEvent;

/**
 * Observes TransportManager for whenever the underlying set of Transporters has changed in order to update
 * the iterator that this controller uses
 *
 * Created by Jonathen on 4/14/2017.
 */
public class TransporterController extends KeyEventHandler implements TransportManagerObserver {
    MyBidirectionalIterator<Transporter> transporterIterator;
    AbilityController abilityController;

    public TransporterController(AbilityController abilityController, TransportManager transportManager) {
        this.abilityController = abilityController;
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

    private void cycleLeft() {
        System.out.println("class TransporterController: Cycling transporter prev...");
        //Get prev transporter
        if (transporterIterator.hasNext()) {
            transporterIterator.getCurrent().deregisterAbilityObserver(abilityController);
            updateAbilityController(transporterIterator.next());
        }
    }

    private void cycleRight() {
        System.out.println("class TransporterController: Cycling transporter next...");
        //Get next transporter
        if (transporterIterator.hasNext()) {
            transporterIterator.getCurrent().deregisterAbilityObserver(abilityController);
            updateAbilityController(transporterIterator.prev());
        }
    }

    @Override
    public void update(MyBidirectionalIterator<Transporter> transporterIterator) {
        if (transporterIterator != null) {
            updateIterator(transporterIterator);
        }
    }

    private void updateAbilityController(Transporter transporter) {
        System.out.println("class TransporterController: Updating AbilityController AbilitySet with transporter: " + transporter.toString() + " |");
        System.out.println("class TransporterController: Updating AbilityController AbilitySet with transporter's ability set :" + transporter.getAbilitySet().toString() + " |");
        transporterIterator.getCurrent().registerAbilityObserver(abilityController);
        abilityController.setAbilityIterator(transporter.getAbilitySet().iterator());
    }

    private void updateIterator(MyBidirectionalIterator<Transporter> transporterIterator) {
        System.out.println("class TransporterController: Updating my iterator and what observes it");
        if (transporterIterator.getCurrent() != null) {
            this.transporterIterator = transporterIterator;
            updateAbilityController(transporterIterator.getCurrent());
        }
    }

    //TODO remove; for testing only
    public Transporter getCurrentTransporter() {
        return transporterIterator.getCurrent();
    }
}
