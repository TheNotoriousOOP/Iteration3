package model.research.research_nodes;

import model.research.research_node_observers.ResearchObservable;
import model.research.research_node_observers.ResearchObserver;

/**
 * Created by TheNotoriousOOP on 4/14/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class ResearchNode implements ResearchObservable {

    // Research status
    private boolean isResearched = false;
    private ResearchObserver observer;

    // Constructor
    protected ResearchNode(ResearchObserver observer) {
        attach(observer);
    }

    // Attach the observer
    public void attach(ResearchObserver observer) {
        this.observer = observer;
    }

    // Get the observer
    public ResearchObserver getObserver() {
        return this.observer;
    }

    // Research the node and notify the model that this has been unlocked for player
    public void research() {
        setResearched();
        notifyResearch();
    }

    // Check if researched
    public boolean isResearched() {
        return isResearched;
    }

    // Set the status of the node to researched
    public void setResearched() {
        this.isResearched = true;
    }

}
