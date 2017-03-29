package view;

/**
 * Created by TK on 3/28/17.
 */
public abstract class MapEditorObserver {
    public abstract void updateAdd();
    public abstract void updateRemove();
    public abstract void updateSave(String filename);
}
