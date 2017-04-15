package model.resources.resourceVisitor;

import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class RemoveResourceVisitor implements ResourceVisitor{

    private InnerResourceVisitor visitor;

    public RemoveResourceVisitor(InnerResourceVisitor visitor) {
        this.visitor = visitor;
    }

    public void visitResourceStorage(ResourceStorage storage) {
        storage.acceptToRemove(visitor);
    }
}

