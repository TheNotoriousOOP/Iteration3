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
}
