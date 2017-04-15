package model.transporters;

import model.ability_management.ability_set.AbilitySet;

/**
 * Created by Jonathen on 4/15/2017.
 */
public class TransporterIteratorImplementation implements TransporterIterator{
    private int currentIdx;
    private Transporter[] transporters;

    public TransporterIteratorImplementation(Transporter[] transporters) {
        this.transporters = transporters;
    }

    //Treating the array as a circular iterator, e.g. next of last element is first element,
    //so the collection always has a next element if the collection is non-empty
    @Override
    public boolean hasNext() {
        return (transporters.length > 0);
    }

    public boolean hasPrev() {
        return (transporters.length > 0);
    }

    @Override
    public Transporter next() {
        if (currentIdx == (transporters.length - 1)) { //Reset idx if it reaches the end
            currentIdx = 0;
        }
        else { //Increment otherwise
            currentIdx++;
        }
        return transporters[currentIdx];
    }

    @Override
    public Transporter prev() {
        if (currentIdx == 0) { //Reset idx if it reaches the beginning
            currentIdx = (transporters.length - 1);
        }
        else { //Decrement otherwise
            currentIdx--;
        }
        return transporters[currentIdx];
    }
}
