package model.transporters;

import model.ability_management.ability_set.AbilitySet;

import java.util.List;

/**
 * Created by Jonathen on 4/15/2017.
 */
public class TransporterIteratorImplementation implements TransporterIterator{
    private int currentIdx;
    private List<Transporter> transporters;

    public TransporterIteratorImplementation(List<Transporter> transporters) {
        this.transporters = transporters;
        currentIdx = 0;
    }

    //Treating the array as a circular iterator, e.g. next of last element is first element,
    //so the collection always has a next element if the collection is non-empty
    @Override
    public boolean hasNext() {
        return (transporters.size() > 0);
    }

    public boolean hasPrev() {
        return (transporters.size() > 0);
    }

    @Override
    public Transporter next() {
        if (currentIdx == (transporters.size() - 1)) { //Reset idx if it reaches the end
            currentIdx = 0;
        }
        else { //Increment otherwise
            currentIdx++;
        }
        return transporters.get(currentIdx);
    }

    @Override
    public Transporter prev() {
        if (currentIdx == 0) { //Reset idx if it reaches the beginning
            currentIdx = (transporters.size() - 1);
        }
        else { //Decrement otherwise
            currentIdx--;
        }
        return transporters.get(currentIdx);
    }

    @Override
    public AbilitySet getCurrentAbilitySet() {
        return transporters.get(currentIdx).getAbilitySet();
    }

    //TODO delete this; testing only
    @Override
    public Transporter getCurrentTransporter() { return transporters.get(currentIdx);}
}
