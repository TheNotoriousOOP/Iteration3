package model.transporters;

import controller.TransportManagerObserver;
import model.ability_management.ability_set.AbilitySet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TransportManager implements Iterable<Transporter> {

    private int maxTransporters;
    private int maxSingleTypeTransporters;
    private Transporter[] transporters;
    private Transporter activeTransport;

    private List<TransportManagerObserver> observers;

    public TransportManager() {
        this.maxTransporters = 8;
        this.maxSingleTypeTransporters = 5;
        this.transporters = new Transporter[8];

        this.observers = new ArrayList<>();
    }

    public void addTransporter(Transporter t){
        //TODO implement
        notifyObservers();
    }

    public void removeTransporter(Transporter t){
        //TODO implement
        notifyObservers();
    }

    public AbilitySet getAbiltySet() {
        return activeTransport.getAbilitySet();
    }

    @Override
    public TransporterIterator iterator() {
        return new TransporterIteratorImplementation(transporters);
    }

    public void addObserver(TransportManagerObserver transportManagerObserver) {
        observers.add(transportManagerObserver);
    }

    private void notifyObservers() {
        for( TransportManagerObserver observer : observers) {
            observer.update(iterator());
        }
    }
}
