package model.transporters;

import model.phase.observers.PhaseObserver;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TransportManager implements PhaseObserver {

    private int maxTransporters;
    private int maxSingleTypeTransporters;
    private Transporter[] transporters;

    public TransportManager() {
        this.maxTransporters = 8;
        this.maxSingleTypeTransporters = 5;
        this.transporters = new Transporter[8];
    }

    public void addTransporter(Transporter t){
        //TODO implement
    }

    public void removeTransporter(Transporter t){
        //TODO implement
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
        // Todo: implement
//        for (Transporter t : transporters) { t.onMovementPhaseStart(); }
    }

    // Notify transporters that wonder phase started
    public void onWonderPhaseStart() {
        // Todo: implement
//        for (Transporter t : transporters) { t.onWonderPhaseStart(); }
    }

}
