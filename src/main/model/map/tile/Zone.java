package model.map.tile;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description: represents the division of a hex tile
 * Responsibilities:
 *  for editor deliverable: only used for water matching validation
 */
public class Zone {
    private boolean hasWater;
    private boolean isMerged;

    public Zone(boolean hasWater, boolean isMerged){
        this.hasWater = hasWater;
        this.isMerged = isMerged;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public boolean isMerged() {
        return isMerged;
    }

    public void setMerged(boolean merged) {
        isMerged = merged;
    }
}
