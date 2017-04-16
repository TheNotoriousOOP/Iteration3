package model.resources.resourceVisitor;

import model.resources.Iron;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class IronVisitor implements InnerResourceVisitor {

    private Iron iron;

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
        storage.addIron(iron);
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {
        iron = storage.removeIron();
    }

    @Override
    public int visitResourceStorageToCount(ResourceStorage storage) { return storage.getIronArrayList().size();}

    public void setIron(Iron iron) { this.iron = iron; }
    public Iron getIron() { return iron; }

}
