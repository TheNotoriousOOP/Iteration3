package controller;

import model.ability_management.ability_set.AbilitySet;
import model.transporters.TransportManager;
import model.transporters.Transporter;
import model.transporters.TransporterIterator;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * Observes TransportManager for whenever the underlying set of Transporters has changed in order to update
 * the iterator that this controller uses
 *
 * Created by Jonathen on 4/14/2017.
 */
public class TransporterController extends KeyEventHandler implements TransportManagerObserver {
    TransportManager currentTransportManager;
    TransporterIterator transporterIterator;
    AbilityController abilityController;

    public TransporterController(AbilityController abilityController, TransportManager transportManager) {
        this.abilityController = abilityController;
        this.currentTransportManager = transportManager;
        this.transporterIterator = this.currentTransportManager.iterator();

        this.currentTransportManager.addObserver(this);
        this.abilityController.setAbilitySet(currentTransportManager.getAbiltySet());
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
        //Get prev transporter ability set
        updateAbilityController(transporterIterator.next());
    }

    //Assume this class is only observing a TransportManager Observable
    //TODO better way to do this than casting? This is not structure shy
    @Override
    public void update(TransporterIterator transporterIterator) {
        updateIterator(transporterIterator);
    }

    private void cycleRight() {
        //Get next transporter ability set
        updateAbilityController(transporterIterator.prev());
    }

    private void updateAbilityController(Transporter transporter) {
        abilityController.setAbilitySet(transporter.getAbilitySet());
    }

    private void updateIterator(TransporterIterator transporterIterator) {
        this.transporterIterator = transporterIterator;
    }
}
