package model.research.research_node_observers;

public interface ResearchObservable {
    void notifyResearch();
    void attach(ResearchObserver observer);
}
