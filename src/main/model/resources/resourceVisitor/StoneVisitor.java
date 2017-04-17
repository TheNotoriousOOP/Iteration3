package model.resources.resourceVisitor;

import model.resources.Stone;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class StoneVisitor implements InnerResourceVisitor {

    private Stone stone;

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
        storage.addStone(stone);
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {
        stone = storage.removeStone();
    }

    @Override
    public int visitResourceStorageToCount(ResourceStorage storage) { return storage.getStoneArrayList().size();}

    public void setStone(Stone stone) { this.stone = stone; }
    public Stone getStone() { return stone; }

}
