package model.transporters;

import controller.TransportManagerObserver;
import model.ability_management.ability_set.AbilitySet;

import java.util.ArrayList;
import java.util.List;

import model.phase.observers.PhaseObserver;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TransportManager implements Iterable<Transporter>, PhaseObserver {

    private int maxTransporters;
    private int maxSingleTypeTransporters;
    private List<Transporter> transporters;

    private List<TransportManagerObserver> observers;

    public TransportManager() {
        this.maxTransporters = 8;
        this.maxSingleTypeTransporters = 5;
        this.transporters = new ArrayList<>(8);

        this.observers = new ArrayList<>();
    }

    public void addTransporter(Transporter t){
        //TODO implement
        transporters.add(t);
        notifyObservers();
    }

    public void removeTransporter(Transporter t){
        //TODO implement
        transporters.remove(t);
        notifyObservers();
    }

    @Override
    public MyBidirectionalIterator<Transporter> iterator() {
        return new MyBidirectionalIterator<>(transporters);
    }

    public void addObserver(TransportManagerObserver transportManagerObserver) {
        observers.add(transportManagerObserver);
    }

    private void notifyObservers() {
        for( TransportManagerObserver observer : observers) {
            observer.update(iterator());
        }
    }

    // Notify transporters that trade phase started
    public void onTradePhaseStart() {
        // Todo: implement
//        for (Transporter t : transporters) { t.onTradePhaseStart(); }
    }

    // Notify transporters that production phase started
    public void onProductionPhaseStart() {
        // Todo: implement
//        for (Transporter t : transporters) { t.onProductionPhaseStart(); }
    }

    // Notify transporters that build phase started
    public void onBuildPhaseStart() {
        // Todo: implement
//        for (Transporter t : transporters) { t.onBuildPhaseStart(); }
    }

    // Notify transporters that movement phase started
    public void onMovementPhaseStart() {
        // Todo: implemented
        for (Transporter t : transporters) { t.onMovementPhaseStart(); }
    }

    // Notify transporters that wonder phase started
    public void onWonderPhaseStart() {
        // Todo: implement
//        for (Transporter t : transporters) { t.onWonderPhaseStart(); }
    }

    public List<Transporter> getTransporters(){
        return this.transporters;
    }

}
