package controller;

import model.transporters.TransporterIterator;

/**
 * Created by Jonathen on 4/15/2017.
 */
public interface TransportManagerObserver {

    void update(TransporterIterator transporterIterator);
}
