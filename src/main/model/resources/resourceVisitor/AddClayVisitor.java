package model.resources.resourceVisitor;

import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class AddClayVisitor implements ResourceVisitor {

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
       //storage.addClay();
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {

    }
}