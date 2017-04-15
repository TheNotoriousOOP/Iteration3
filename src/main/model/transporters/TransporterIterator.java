package model.transporters;

import model.ability_management.ability_set.AbilitySet;

import java.util.Iterator;

/**
 * Created by Jonathen on 4/15/2017.
 */
public interface TransporterIterator extends Iterator {

    //Treating the array as a circular iterator, i.e. next of last element is first element,
    //so the collection always has a next element if it's non-empty
    @Override
    boolean hasNext();

    @Override
    Transporter next();

    Transporter prev();

    AbilitySet getCurrentAbilitySet();

    Transporter getCurrentTransporter();
}
