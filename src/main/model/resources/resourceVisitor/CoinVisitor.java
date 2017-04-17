package model.resources.resourceVisitor;

import model.resources.Coins;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class CoinVisitor implements InnerResourceVisitor {

    private Coins coins;

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
        storage.addCoins(coins);
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {
        coins = storage.removeCoins();
    }

    @Override
    public int visitResourceStorageToCount(ResourceStorage storage) { return storage.getCoinsArrayList().size();}

    public void setCoins(Coins coins) { this.coins = coins; }
    public Coins getCoins() { return coins; }

}
