package model.structures.secondary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.resources.ResourceStorage;
import model.resources.TransportStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class CoalBurner extends SecondaryProduction {

    private final int maxFuel = 6;
    private int boardCost = 2;
    private int trunkCost = 2;
    private int eachCost = 1;

    public CoalBurner(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    @Override
    void produce(TransportStorage resourceStorage) {

    }

    public int getMaxFuel() {
        return maxFuel;
    }

}
