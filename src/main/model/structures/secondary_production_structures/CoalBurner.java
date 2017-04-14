package model.structures.secondary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.resources.ResourceStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class CoalBurner extends SecondaryProduction {

    private int maxFuel;

    public CoalBurner(ParentLandNode parentLandNode) {
        super(parentLandNode);
        this.maxFuel = 6;
    }

    @Override
    void produce(ResourceStorage resourceStorage) {
        //TODO implement
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }
}
