package model.research.research_nodes;

/**
 * Created by TheNotoriousOOP on 4/14/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class ResearchNode {

    private boolean isResearched;

    public ResearchNode() {
        this.isResearched = false;
    }

    abstract void research();

    public boolean isResearched() {
        return isResearched;
    }

    public void setResearched(boolean researched) {
        isResearched = researched;
    }
}
