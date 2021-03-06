package model.structures.primary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.resources.Fuel;
import model.resources.ResourceStorage;
import model.resources.TileStorage;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class OilRig extends PrimaryProduction {

    public OilRig(ParentNode parentNode) {
        super(parentNode);
    }

    @Override
    public void produce(TileStorage resourceStorage) {
        resourceStorage.addFuel(makeFuel());
    }
    private Fuel makeFuel(){
        return new Fuel();
    }
}
