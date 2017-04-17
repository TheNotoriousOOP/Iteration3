package model.resources.resourceVisitor;

import model.resources.Paper;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/16/2017.
 */
public class PaperVisitor implements InnerResourceVisitor {

    private Paper paper;

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
        storage.addPaper(paper);
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {
        paper = storage.removePaper();
    }

    @Override
    public int visitResourceStorageToCount(ResourceStorage storage) { return storage.getPaperArrayList().size();}

    public void setPaper(Paper paper) { this.paper = paper; }
    public Paper getPaper() { return paper; }

}
