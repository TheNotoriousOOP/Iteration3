package model.resources.resourceVisitor;

import model.resources.Boards;
import model.resources.ResourceStorage;

/**
 * Created by Customer-PC on 4/15/2017.
 */
public class BoardVisitor implements InnerResourceVisitor {

    private Boards boards;

    @Override
    public void visitResourceStorageToAdd(ResourceStorage storage) {
        storage.addBoards(boards);
    }

    @Override
    public void visitResourceStorageToRemove(ResourceStorage storage) {
        boards = storage.removeBoards();
    }

    @Override
    public int visitResourceStorageToCount(ResourceStorage storage) { return storage.getBoardsArrayList().size();}

    public void setBoards(Boards boards) { this.boards = boards; }
    public Boards getBoards() { return boards; }

}
