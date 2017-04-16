package model.resources.resourceVisitor;

import model.resources.Stock;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class StockVisitor implements InnerResourceVisitor {

    private Stock stock;

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
        storage.addStock(stock);
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {
        stock = storage.removeStock();
    }

    @Override
    public int visitResourceStorageToCount(ResourceStorage storage) { return storage.getStockArrayList().size();}

    public void setStock(Stock stock) { this.stock = stock; }
    public Stock getStock() { return stock; }

}
