package controller;

import model.transporters.MyBidirectionalIterator;
import model.transporters.Transporter;

/**
 * Created by Jonathen on 4/15/2017.
 */
public interface TransportManagerObserver {

    void update(MyBidirectionalIterator<Transporter> transporterIterator);
}
