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
    TransportManager currentTransportManager;
    MyBidirectionalIterator<Transporter> transporterIterator;
    AbilityController abilityController;

    public TransporterController(AbilityController abilityController, TransportManager transportManager) {
        this.abilityController = abilityController;
        this.currentTransportManager = transportManager;
        this.transporterIterator = this.currentTransportManager.iterator();

        this.currentTransportManager.addObserver(this);
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

    public void setCurrentTransportManager(TransportManager transportManager) {
        this.currentTransportManager = transportManager;
    }

    private void cycleLeft() {
        System.out.println("class AbilityController: Cycling transporter prev...");
        //Get prev transporter
        if (transporterIterator.hasNext()) {
            updateAbilityController(transporterIterator.next());
        }
    }

    private void cycleRight() {
        System.out.println("class AbilityController: Cycling transporter next...");
        //Get next transporter
        if (transporterIterator.hasNext()) {
            updateAbilityController(transporterIterator.prev());
        }
    }

    //Assume this class is only observing a TransportManager Observable
    //TODO better way to do this than casting? This is not structure shy
    @Override
    public void update(MyBidirectionalIterator<Transporter> transporterIterator) {
        updateIterator(transporterIterator);
    }

    private void updateAbilityController(Transporter transporter) {
        System.out.println("class TransporterController: Updating AbilityController AbilitySet with transporter " + transporter.toString());
        abilityController.setAbilityIterator(transporter.getAbilitySet().iterator());
    }

    private void updateIterator(MyBidirectionalIterator<Transporter> transporterIterator) {
        System.out.println("class TransporterController: Updating my iterator");
        this.transporterIterator = transporterIterator;
    }

    //TODO remove; for testing only
    public Transporter getCurrentTransporter() {
        return transporterIterator.getCurrent();
    }
}
