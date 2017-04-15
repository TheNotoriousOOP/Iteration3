package model.transporters;

import model.ability_management.ability_set.AbilitySet;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Jonathen on 4/15/2017.
 */
public class MyBidirectionalIterator<T> implements Iterator {
    private int currentIdx;
    private List<T> myList;

    public MyBidirectionalIterator(List<T> initialList) {
        this.myList = initialList;
        currentIdx = 0;
    }

    //Treating the array as a circular iterator, e.g. next of last element is first element,
    //so the collection always has a next element if the collection is non-empty
    @Override
    public boolean hasNext() {
        return !myList.isEmpty();
    }

    public boolean hasPrev() {
        return !myList.isEmpty();
    }

    @Override
    public T next() {
        if (currentIdx == (myList.size() - 1)) { //Reset idx if it reaches the end
            currentIdx = 0;
        }
        else { //Increment otherwise
            currentIdx++;
        }
        return myList.get(currentIdx);
    }

    public T prev() {
        if (currentIdx == 0) { //Reset idx if it reaches the beginning
            currentIdx = (myList.size() - 1);
        }
        else { //Decrement otherwise
            currentIdx--;
        }
        return myList.get(currentIdx);
    }

    //TODO delete this; testing only
    public T getCurrent() { return myList.get(currentIdx);}

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
