package model.transporters;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class TransportManager {

    private int maxTransporters;
    private int maxSingleTypeTransporters;
    private Transporter[] transporters;

    public TransportManager(int maxTransporters, int maxSingleTypeTransporters, Transporter[] transporters) {
        this.maxTransporters = maxTransporters;
        this.maxSingleTypeTransporters = maxSingleTypeTransporters;
        this.transporters = transporters;
    }

    public void addTransporter(Transporter t){
        //TODO implement
    }

    public void removeTransporter(Transporter t){
        //TODO implement
    }
}
