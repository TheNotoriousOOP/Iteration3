package model.structures.primary_production_structures;

import model.map.tile.nodeRepresentation.nodes.parent.ParentNode;
import model.resources.ResourceStorage;
import model.resources.TileStorage;
import model.resources.Trunks;
import model.structures.ProductionStructure;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class WoodCutter extends PrimaryProduction {

    public WoodCutter(ParentNode parentNode) {
        super(parentNode);
    }

    @Override
    public void produce(TileStorage resourceStorage) {
        resourceStorage.addTrunks(makeTrunk());
    }

    private Trunks makeTrunk(){
        return new Trunks();
    }
}
