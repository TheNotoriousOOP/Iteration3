package model.structures.secondary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.resources.ResourceStorage;
import model.resources.TileStorage;
import model.resources.TransportStorage;
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

    public abstract void produce(TransportStorage resourceStorage);
    public abstract void produce(TileStorage resourceStorage);
    public abstract void resetExhaustion();

    public boolean isExhausted() {
        return isExhausted;
    }

    public void setExhausted(boolean exhausted) {
        isExhausted = exhausted;
    }
}
