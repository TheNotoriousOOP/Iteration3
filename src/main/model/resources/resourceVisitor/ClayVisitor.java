package model.resources.resourceVisitor;

import model.resources.Clay;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class ClayVisitor implements InnerResourceVisitor {

    private Clay clay;

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
        storage.addClay(clay);
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {
        clay = storage.removeClay();
    }

    @Override
    public int visitResourceStorageToCount(ResourceStorage storage) { return storage.getClayArrayList().size();}

    public void setClay(Clay clay) { this.clay = clay; }
    public Clay getClay() { return clay; }

}