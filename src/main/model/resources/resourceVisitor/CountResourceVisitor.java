package model.resources.resourceVisitor;

import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/16/2017.
 */
public class CountResourceVisitor implements ResourceVisitor {

    private InnerResourceVisitor visitor;
    private int amount = 0;

    public CountResourceVisitor(InnerResourceVisitor visitor) {
        this.visitor = visitor;
    }

    public void visitResourceStorage(ResourceStorage storage) {
        amount = storage.acceptToCount(visitor);
    }

    public int getAmount() { return this.amount; }
}
