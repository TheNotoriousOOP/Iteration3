package model.resources.resourceVisitor;

import model.resources.Gold;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class GoldVisitor implements InnerResourceVisitor {

    private Gold gold;

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
        storage.addGold(gold);
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {
        gold = storage.removeGold();
    }

    @Override
    public int visitResourceStorageToCount(ResourceStorage storage) { return storage.getGoldArrayList().size();}

    public void setGold(Gold gold) { this.gold = gold; }
    public Gold getGold() { return gold; }

}
