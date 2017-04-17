package model.resources.resourceVisitor;

import model.resources.Goose;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class GooseVisitor implements InnerResourceVisitor {

    private Goose goose;

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
        storage.addGoose(goose);
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {
        goose = storage.removeGoose();
    }

    @Override
    public int visitResourceStorageToCount(ResourceStorage storage) { return storage.getGooseArrayList().size();}

    public void setGoose(Goose goose) { this.goose = goose; }
    public Goose getGoose() { return goose; }

}