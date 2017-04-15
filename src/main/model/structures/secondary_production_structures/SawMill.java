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
public class SawMill extends SecondaryProduction {

    private final int maxBoards = 6;
    private int trunkCost = 1;

    public SawMill(ParentLandNode parentLandNode) {
        super(parentLandNode);
    }

    @Override
    public void produce(TransportStorage resourceStorage) {

    }
    @Override
    public void produce(TileStorage resourceStorage){

    }
    @Override
    public void resetExhaustion(){
        setExhausted(false);

    }
}
