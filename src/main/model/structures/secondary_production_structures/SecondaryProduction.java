package model.structures.secondary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.resources.ResourceStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/13/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class SecondaryProduction extends ProductionStructure {

    private boolean isExhausted;

    public SecondaryProduction(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    abstract void produce(ResourceStorage resourceStorage);

    public boolean isExhausted() {
        return isExhausted;
    }

    public void setExhausted(boolean exhausted) {
        isExhausted = exhausted;
    }
}
