package model.resources.resourceVisitor;

import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public interface ResourceVisitor {
    void visitResourceStorage(ResourceStorage storage);
}
