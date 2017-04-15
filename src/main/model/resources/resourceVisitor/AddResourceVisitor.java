package model.resources.resourceVisitor;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class AddResourceVisitor implements ResourceVisitor {

    private InnerResourceVisitor visitor;

    public AddResourceVisitor(InnerResourceVisitor visitor) {
        this.visitor = visitor;
    }

    public void visitResourceStorage(ResourceStorage storage) {
        storage.acceptToAdd(visitor);
    }
}
