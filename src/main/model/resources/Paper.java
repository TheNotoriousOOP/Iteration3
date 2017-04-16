package model.resources;

/**
 *
 */
public class Paper {
    // Constructor
    public Paper() {
        super();
    }

    // Add to storage
    public void addToStorage(ResourceStorage storage) {
        storage.addPaper(this);
    }
}
