package model.structures.secondary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.resources.ResourceStorage;
import model.resources.TileStorage;
import model.resources.TransportStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class StockMarket extends SecondaryProduction {

    private final int maxBonds = 6;
    private int coinCost = 2;
    private int paperCost = 1;

    public StockMarket(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    @Override
    public void produce(TransportStorage resourceStorage) {

    }
    @Override
    public void produce(TileStorage resourceStorage){

    }

}
