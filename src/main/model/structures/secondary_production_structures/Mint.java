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
public class Mint extends SecondaryProduction {

    private final int maxCoin = 1;
    private int goldCost = 2;
    private int fuelCost = 1;

    public Mint(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    @Override
    void produce(TransportStorage resourceStorage) {
        //TODO implement
    }

}
