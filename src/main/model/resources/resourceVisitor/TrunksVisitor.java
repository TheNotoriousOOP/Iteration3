package model.resources.resourceVisitor;

import model.resources.Trunks;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class TrunksVisitor implements InnerResourceVisitor {

    private Trunks trunks;

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
        storage.addTrunks(trunks);
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {
        trunks = storage.removeTrunks();
    }

    @Override
    public int visitResourceStorageToCount(ResourceStorage storage) { return storage.getTrunksArrayList().size();}

    public void setTrunks(Trunks trunks) { this.trunks = trunks; }
    public Trunks getTrunks() { return trunks; }

}
