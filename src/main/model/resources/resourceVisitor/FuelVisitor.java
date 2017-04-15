package model.resources.resourceVisitor;

import model.resources.Fuel;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class FuelVisitor implements InnerResourceVisitor {

    private Fuel fuel;

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
        storage.addFuel(fuel);
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {
        fuel = storage.removeFuel();
    }

    public void setFuel(Fuel fuel) { this.fuel = fuel; }
    public Fuel getFuel() { return fuel; }

}
